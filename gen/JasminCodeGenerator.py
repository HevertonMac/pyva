from JavythonVisitor import JavythonVisitor
from JavythonParser import JavythonParser


class Symbol:
    def __init__(self, name, type, is_constant=False, index=None):
        self.name = name
        self.type = type
        self.is_constant = is_constant
        self.index = index


class SymbolTable:
    def __init__(self):
        self.scopes = [{}]
        self.var_index = 0

    def enter_scope(self):
        self.scopes.append({})
        self.var_index = 0

    def exit_scope(self):
        self.scopes.pop()

    def add_symbol(self, symbol):
        symbol.index = self.var_index
        self.var_index += 1
        self.scopes[-1][symbol.name.lower()] = symbol

    def lookup(self, name):
        for scope in reversed(self.scopes):
            if name.lower() in scope:
                return scope[name.lower()]
        return None


class JasminVisitor(JavythonVisitor):
    def __init__(self, program_name):
        self.program_name = program_name
        self.code = []
        self.symbol_table = SymbolTable()
        self.label_count = 0

    def get_code(self):
        return "\n".join(self.code)

    def new_label(self):
        self.label_count += 1
        return f"L{self.label_count}"

    def visitProgram(self, ctx: JavythonParser.ProgramContext):
        self.code.append(f".class public {self.program_name}")
        self.code.append(".super java/lang/Object")
        self.code.append("")
        # Construtor padrão
        self.code.append(".method public <init>()V")
        self.code.append("    aload_0")
        self.code.append("    invokenonvirtual java/lang/Object/<init>()V")
        self.code.append("    return")
        self.code.append(".end method")
        self.code.append("")

        self.visitChildren(ctx)

    def visitBlocoMain(self, ctx: JavythonParser.BlocoMainContext):
        self.symbol_table.enter_scope()
        self.code.append(".method public static main([Ljava/lang/String;)V")
        self.code.append("    .limit stack 100")  # Um valor alto para simplicidade
        self.code.append("    .limit locals 100")

        self.visitChildren(ctx)

        self.code.append("    return")
        self.code.append(".end method")
        self.symbol_table.exit_scope()

    def visitDeclaracao(self, ctx: JavythonParser.DeclaracaoContext):
        if ctx.ID():  # Constante
            name = ctx.ID().getText()
            var_type = 'int'  # Simplificação, você pode expandir para outros tipos
            symbol = Symbol(name, var_type, is_constant=True)
            self.symbol_table.add_symbol(symbol)

            self.visit(ctx.valor())
            self.code.append(f"    istore {symbol.index}")

        elif ctx.listaIds():  # Variável
            var_type = ctx.tipo().getText()
            for var_id in ctx.listaIds().ID():
                name = var_id.getText()
                symbol = Symbol(name, var_type, is_constant=False)
                self.symbol_table.add_symbol(symbol)
                # Inicialização opcional
                if ctx.ASSIGN():
                    self.visit(ctx.valor())
                    self.code.append(f"    istore {symbol.index}")

    def visitAtribuicao(self, ctx: JavythonParser.AtribuicaoContext):
        name = ctx.ID().getText()
        symbol = self.symbol_table.lookup(name)

        self.visit(ctx.expressao())

        if symbol.type == 'int' or symbol.type == 'bool':
            self.code.append(f"    istore {symbol.index}")
        # Adicionar outros tipos aqui (astore para string, fstore para real, etc.)

    def visitAddsubExpr(self, ctx: JavythonParser.AddsubExprContext):
        self.visit(ctx.left)
        self.visit(ctx.right)
        op = ctx.op.type
        if op == JavythonParser.ADD:
            self.code.append("    iadd")
        elif op == JavythonParser.SUB:
            self.code.append("    isub")

    def visitMultdivExpr(self, ctx: JavythonParser.MultdivExprContext):
        self.visit(ctx.left)
        self.visit(ctx.right)
        op = ctx.op.type
        if op == JavythonParser.MUL:
            self.code.append("    imul")
        elif op == JavythonParser.DIV:
            self.code.append("    idiv")

    def visitValorExpr(self, ctx: JavythonParser.ValorExprContext):
        self.visit(ctx.valor())

    def visitValor(self, ctx: JavythonParser.ValorContext):
        if ctx.INT():
            val = ctx.INT().getText()
            self.code.append(f"    ldc {val}")
        elif ctx.STRING():
            val = ctx.STRING().getText()
            self.code.append(f"    ldc {val}")
        elif ctx.TRUE():
            self.code.append("    iconst_1")  # true
        elif ctx.FALSE():
            self.code.append("    iconst_0")  # false

    def visitIdExpr(self, ctx: JavythonParser.IdExprContext):
        name = ctx.ID().getText()
        symbol = self.symbol_table.lookup(name)
        if symbol.type == 'int' or symbol.type == 'bool':
            self.code.append(f"    iload {symbol.index}")

    def visitIo(self, ctx: JavythonParser.IoContext):
        if ctx.PRINT():
            self.code.append("    getstatic java/lang/System/out Ljava/io/PrintStream;")
            # Visita a expressão a ser impressa
            arg_expr = ctx.argumentos().expressao(0)
            self.visit(arg_expr)

            # Determina o tipo da expressão para chamar o println correto
            # Esta parte é simplificada. Uma análise de tipo completa seria necessária aqui.
            # Assumindo int por enquanto.
            self.code.append("    invokevirtual java/io/PrintStream/println(I)V")

    def visitIfElse(self, ctx: JavythonParser.IfElseContext):
        else_label = self.new_label()
        end_label = self.new_label()

        # Condição
        self.visit(ctx.expressao())
        self.code.append(f"    ifeq {else_label}")  # Se a condição for falsa (0), pula para o else

        # Bloco IF
        for cmd in ctx.LBRACE(0).parentCtx.comando():
            self.visit(cmd)
        self.code.append(f"    goto {end_label}")

        # Bloco ELSE
        self.code.append(f"{else_label}:")
        if ctx.ELSE():
            for cmd in ctx.LBRACE(1).parentCtx.comando():
                self.visit(cmd)

        # Fim
        self.code.append(f"{end_label}:")