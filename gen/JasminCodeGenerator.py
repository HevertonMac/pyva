# Caminho do arquivo: gen/JasminCodeGenerator.py
from JavythonVisitor import JavythonVisitor
from JavythonParser import JavythonParser

type_map = {'int': 'I', 'real': 'F', 'str': 'Ljava/lang/String;', 'bool': 'I', 'void': 'V'}


class Symbol:
    def __init__(self, name, type, index=None, is_constant=False, params_types=None, is_global=False):
        self.name, self.type, self.index, self.is_constant, self.params_types, self.is_global = \
            name, type, index, is_constant, params_types if params_types else [], is_global


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
        if not symbol.is_global:
            symbol.index = self.var_index
            self.var_index += 1
        self.scopes[-1][symbol.name.lower()] = symbol

    def lookup(self, name):
        for scope in reversed(self.scopes):
            if name.lower() in scope: return scope[name.lower()]
        return None


class JasminVisitor(JavythonVisitor):
    def __init__(self, program_name):
        self.program_name = program_name
        self.code = []
        self.symbol_table = SymbolTable()
        self.label_count = 0
        self.current_method_return_type = None
        self.scanner_var_index = -1
        self.string_builder_var_index = -1

    def get_code(self):
        return "\n".join(self.code)

    def new_label(self):
        self.label_count += 1
        return f"L{self.label_count}"

    def get_expression_type(self, ctx: JavythonParser.ExpressaoContext):
        if ctx is None: return 'void'
        if isinstance(ctx, JavythonParser.ParenExprContext):
            return self.get_expression_type(ctx.expressao())
        if isinstance(ctx, JavythonParser.IdExprContext):
            symbol = self.symbol_table.lookup(ctx.ID().getText())
            return symbol.type if symbol else 'void'
        if isinstance(ctx, JavythonParser.ValorExprContext):
            if ctx.valor().INT() or ctx.valor().TRUE() or ctx.valor().FALSE(): return 'int'
            if ctx.valor().REAL(): return 'real'
            if ctx.valor().STRING(): return 'str'
        if isinstance(ctx, JavythonParser.ChamadaExprContext):
            symbol = self.symbol_table.lookup(ctx.chamadaMetodo().ID().getText())
            return symbol.type if symbol else 'void'
        if isinstance(ctx, (JavythonParser.AddsubExprContext, JavythonParser.MultdivExprContext)):
            type_left = self.get_expression_type(ctx.expressao(0))
            type_right = self.get_expression_type(ctx.expressao(1))
            return 'real' if type_left == 'real' or type_right == 'real' else 'int'
        if isinstance(ctx, JavythonParser.PostfixExprContext):
            return self.get_expression_type(ctx.expressao())
        return 'int'

    def visitProgram(self, ctx: JavythonParser.ProgramContext):
        self.code.append(f".class public {self.program_name}")
        self.code.append(".super java/lang/Object")

        if ctx.decIds():
            self.code.append("")
            self.visitDecIds(ctx.decIds(), is_global_context=True)

        self.code.append("\n.method public <init>()V")
        self.code.append("    aload_0\n    invokenonvirtual java/lang/Object/<init>()V\n    return")
        self.code.append(".end method\n")

        for child in ctx.children:
            if isinstance(child, (JavythonParser.MetodoContext, JavythonParser.BlocoMainContext)):
                self.visit(child)

    def visitDecIds(self, ctx: JavythonParser.DecIdsContext, is_global_context=False):
        if is_global_context:
            for declaracao_ctx in ctx.declaracao():
                var_type_ctx = declaracao_ctx.tipo()
                if var_type_ctx:
                    var_type = var_type_ctx.getText()
                    jasmin_type = type_map[var_type]
                    for var_id in declaracao_ctx.listaIds().ID():
                        var_name = var_id.getText()
                        self.symbol_table.add_symbol(Symbol(var_name, var_type, is_global=True))
                        self.code.append(f".field public static {var_name} {jasmin_type}")
        else:
            self.visitChildren(ctx)

    def visitAtribuicao(self, ctx: JavythonParser.AtribuicaoContext):
        name = ctx.ID().getText()
        symbol = self.symbol_table.lookup(name)
        expr_type = self.get_expression_type(ctx.expressao())

        self.visit(ctx.expressao())

        if symbol.type == 'real' and expr_type == 'int':
            self.code.append("    i2f")

        if symbol.is_global:
            jasmin_type = type_map[symbol.type]
            self.code.append(f"    putstatic {self.program_name}/{symbol.name} {jasmin_type}")
        else:
            if symbol.type in ['int', 'bool']:
                self.code.append(f"    istore {symbol.index}")
            elif symbol.type == 'real':
                self.code.append(f"    fstore {symbol.index}")
            else:  # string
                self.code.append(f"    astore {symbol.index}")

    def visitIdExpr(self, ctx: JavythonParser.IdExprContext):
        name = ctx.ID().getText()
        symbol = self.symbol_table.lookup(name)

        if symbol.is_global:
            jasmin_type = type_map[symbol.type]
            self.code.append(f"    getstatic {self.program_name}/{symbol.name} {jasmin_type}")
        else:
            if symbol.type in ['int', 'bool']:
                self.code.append(f"    iload {symbol.index}")
            elif symbol.type == 'real':
                self.code.append(f"    fload {symbol.index}")
            else:  # string
                self.code.append(f"    aload {symbol.index}")

    def visitDeclaracao(self, ctx: JavythonParser.DeclaracaoContext):
        if ctx.listaIds():
            var_type = ctx.tipo().getText()
            for var_id in ctx.listaIds().ID():
                name = var_id.getText()
                if self.symbol_table.lookup(name) is None:
                    self.symbol_table.add_symbol(Symbol(name, var_type, is_global=False))
        elif ctx.ID():
            name = ctx.ID().getText()
            valor_ctx = ctx.valor()
            if valor_ctx.INT():
                var_type = 'int'
            elif valor_ctx.REAL():
                var_type = 'real'
            elif valor_ctx.STRING():
                var_type = 'str'
            else:
                var_type = 'bool'
            if self.symbol_table.lookup(name) is None:
                self.symbol_table.add_symbol(Symbol(name, var_type, is_global=False))
            symbol = self.symbol_table.lookup(name)
            self.visit(valor_ctx)
            if var_type in ['int', 'bool']:
                self.code.append(f"    istore {symbol.index}")
            elif var_type == 'real':
                self.code.append(f"    fstore {symbol.index}")
            else:
                self.code.append(f"    astore {symbol.index}")

    def visitAddsubExpr(self, ctx: JavythonParser.AddsubExprContext):
        type_left = self.get_expression_type(ctx.expressao(0))
        type_right = self.get_expression_type(ctx.expressao(1))
        is_float_op = type_left == 'real' or type_right == 'real'
        op_char = 'f' if is_float_op else 'i'

        self.visit(ctx.expressao(0))
        if type_left == 'int' and is_float_op: self.code.append("    i2f")

        self.visit(ctx.expressao(1))
        if type_right == 'int' and is_float_op: self.code.append("    i2f")

        op_code = "add" if ctx.getChild(1).getSymbol().type == JavythonParser.ADD else "sub"
        self.code.append(f"    {op_char}{op_code}")

    def visitMultdivExpr(self, ctx: JavythonParser.MultdivExprContext):
        type_left = self.get_expression_type(ctx.expressao(0))
        type_right = self.get_expression_type(ctx.expressao(1))
        is_float_op = type_left == 'real' or type_right == 'real'
        op_char = 'f' if is_float_op else 'i'

        self.visit(ctx.expressao(0))
        if type_left == 'int' and is_float_op: self.code.append("    i2f")

        self.visit(ctx.expressao(1))
        if type_right == 'int' and is_float_op: self.code.append("    i2f")

        op_code = "mul" if ctx.getChild(1).getSymbol().type == JavythonParser.MUL else "div"
        self.code.append(f"    {op_char}{op_code}")

    def visitMetodo(self, ctx: JavythonParser.MetodoContext):
        method_name = ctx.ID().getText()
        javython_return_type = ctx.tipo().getText() if ctx.tipo() else 'void'
        self.current_method_return_type = javython_return_type

        params_javython_types = [p.tipo().getText() for p in ctx.parametros().parametro()] if ctx.parametros() else []
        function_symbol = Symbol(name=method_name, type=javython_return_type, params_types=params_javython_types,
                                 is_global=True)
        self.symbol_table.scopes[0][function_symbol.name.lower()] = function_symbol

        return_type = type_map[javython_return_type]
        param_signatures = [type_map[p_type] for p_type in params_javython_types]
        signature = f"({''.join(param_signatures)}){return_type}"

        self.code.append(f"\n.method public static {method_name}{signature}")
        self.code.append("    .limit stack 100\n    .limit locals 100")

        self.symbol_table.enter_scope()

        if ctx.parametros():
            for p in ctx.parametros().parametro():
                self.symbol_table.add_symbol(Symbol(p.ID().getText(), p.tipo().getText()))

        self.scanner_var_index = self.symbol_table.var_index
        self.symbol_table.var_index += 1
        self.string_builder_var_index = self.symbol_table.var_index
        self.symbol_table.var_index += 1
        self.code.append(
            f"    new java/util/Scanner\n    dup\n    getstatic java/lang/System/in Ljava/io/InputStream;\n    invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V\n    astore {self.scanner_var_index}")

        self.visit(ctx.blocoMetodo())

        if not self.code[-1].strip().startswith(("ireturn", "freturn", "areturn", "return")):
            if javython_return_type == 'void':
                self.code.append("    return")

        self.code.append(".end method")
        self.symbol_table.exit_scope()
        self.current_method_return_type = None
        return None

    def visitBlocoMain(self, ctx: JavythonParser.BlocoMainContext):
        self.symbol_table.enter_scope()
        self.symbol_table.var_index = 1
        self.code.append("\n.method public static main([Ljava/lang/String;)V")
        self.code.append("    .limit stack 100\n    .limit locals 100")

        self.scanner_var_index = self.symbol_table.var_index
        self.symbol_table.var_index += 1
        self.string_builder_var_index = self.symbol_table.var_index
        self.symbol_table.var_index += 1
        self.code.append(
            f"    new java/util/Scanner\n    dup\n    getstatic java/lang/System/in Ljava/io/InputStream;\n    invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V\n    astore {self.scanner_var_index}")

        self.visitChildren(ctx)

        self.code.append("    return")
        self.code.append(".end method")
        self.symbol_table.exit_scope()

    def visitComando(self, ctx: JavythonParser.ComandoContext):
        if ctx.RETURN():
            if ctx.expressao():
                self.visit(ctx.expressao())
                expr_type = self.get_expression_type(ctx.expressao())
                if expr_type in ['int', 'bool']:
                    self.code.append("    ireturn")
                elif expr_type == 'real':
                    self.code.append("    freturn")
                else:
                    self.code.append("    areturn")
            else:
                self.code.append("    return")
            return

        if isinstance(ctx.getChild(0), JavythonParser.ExpressaoContext):
            self.visit(ctx.expressao())
            expr_type = self.get_expression_type(ctx.expressao())
            if expr_type != 'void':
                self.code.append("    pop")
        else:
            return self.visitChildren(ctx)

    def visitIfElse(self, ctx: JavythonParser.IfElseContext):
        else_label, end_label = self.new_label(), self.new_label()
        self.visit(ctx.expressao())
        self.code.append(f"    ifeq {else_label}")
        self.visit(ctx.bloco(0))

        if not self.code[-1].strip().startswith(("goto", "return", "ireturn", "freturn")):
            self.code.append(f"    goto {end_label}")

        self.code.append(f"{else_label}:")
        if len(ctx.bloco()) > 1:
            self.visit(ctx.bloco(1))

        self.code.append(f"{end_label}:")
        return None

    def visitForLoop(self, ctx: JavythonParser.ForLoopContext):
        start_label = self.new_label()
        end_label = self.new_label()

        if ctx.atribuicao(0):
            self.visit(ctx.atribuicao(0))

        self.code.append(f"{start_label}:")

        if ctx.expressao(0):
            self.visit(ctx.expressao(0))
            self.code.append(f"    ifeq {end_label}")

        self.visit(ctx.bloco())

        update_expr = None
        # A lógica para encontrar a expressão de atualização é mantida por enquanto
        if len(ctx.expressao()) > 1:
            update_expr = ctx.expressao(1)
        elif len(ctx.atribuicao()) > 1:
            update_expr = ctx.atribuicao(1)

        if update_expr:
            self.visit(update_expr)
            # --- CORREÇÃO APLICADA AQUI ---
            # Uma atribuição (AtribuicaoContext) não deixa um valor na pilha.
            # Só adicionamos 'pop' se a atualização for uma EXPRESSÃO (ExpressaoContext)
            # que retorna um valor.
            if isinstance(update_expr, JavythonParser.ExpressaoContext):
                if self.get_expression_type(update_expr) != 'void':
                    self.code.append("    pop")

        self.code.append(f"    goto {start_label}")
        self.code.append(f"{end_label}:")
        return None

    # --- CORREÇÃO PRINCIPAL AQUI ---
    def visitPostfixExpr(self, ctx: JavythonParser.PostfixExprContext):
        if not isinstance(ctx.expressao(), JavythonParser.IdExprContext):
            raise Exception("Operador de incremento/decremento só pode ser aplicado a variáveis.")

        name = ctx.expressao().ID().getText()
        symbol = self.symbol_table.lookup(name)

        is_int = symbol.type in ['int', 'bool']
        prefix = 'i' if is_int else 'f'

        # Define as instruções corretas (local vs. global)
        if symbol.is_global:
            load_op, store_op = "getstatic", "putstatic"
            operand = f"{self.program_name}/{name} {type_map[symbol.type]}"
        else:
            load_op, store_op = (f"{prefix}load", f"{prefix}store")
            operand = symbol.index

        # Lógica:
        # 1. Carrega o valor original e o duplica. Uma cópia fica na pilha como resultado da expressão.
        # 2. A outra cópia é usada para o cálculo.
        # 3. O novo valor é armazenado de volta.
        self.code.append(f"    {load_op} {operand}")
        self.code.append(f"    dup")
        self.code.append(f"    fconst_1" if not is_int else "    iconst_1")
        op = "add" if ctx.INC() else "sub"
        self.code.append(f"    {prefix}{op}")
        self.code.append(f"    {store_op} {operand}")

    def visitIo(self, ctx: JavythonParser.IoContext):
        if ctx.PRINT():
            self.code.append("    getstatic java/lang/System/out Ljava/io/PrintStream;")
            self.code.append("    new java/lang/StringBuilder")
            self.code.append("    dup")
            self.code.append("    invokespecial java/lang/StringBuilder/<init>()V")

            for arg in ctx.argumentos().expressao():
                self.visit(arg)
                arg_type = self.get_expression_type(arg)
                if arg_type == 'void':
                    func_name = 'função'
                    if hasattr(arg, 'chamadaMetodo') and arg.chamadaMetodo() and arg.chamadaMetodo().ID():
                        func_name = arg.chamadaMetodo().ID().getText()
                    raise Exception(
                        f"Erro Semântico: A função '{func_name}' é do tipo 'void' e não pode ser usada em um print.")

                signature = type_map.get(arg_type, 'Ljava/lang/String;')
                self.code.append(
                    f"    invokevirtual java/lang/StringBuilder/append({signature})Ljava/lang/StringBuilder;")

            self.code.append("    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;")
            self.code.append("    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V")

        elif ctx.INPUT():
            for var_id in ctx.listaIds().ID():
                name = var_id.getText()
                symbol = self.symbol_table.lookup(name)
                if symbol:
                    self.code.append(f"   aload {self.scanner_var_index}")
                    if symbol.type == 'int':
                        self.code.append("    invokevirtual java/util/Scanner/nextInt()I")
                        if symbol.is_global:
                            self.code.append(f"   putstatic {self.program_name}/{symbol.name} I")
                        else:
                            self.code.append(f"   istore {symbol.index}")
                    elif symbol.type == 'real':
                        self.code.append("    invokevirtual java/util/Scanner/nextFloat()F")
                        if symbol.is_global:
                            self.code.append(f"   putstatic {self.program_name}/{symbol.name} F")
                        else:
                            self.code.append(f"   fstore {symbol.index}")

    def visitChamadaMetodo(self, ctx: JavythonParser.ChamadaMetodoContext):
        method_name = ctx.ID().getText()
        symbol = self.symbol_table.lookup(method_name)
        if not symbol:
            raise Exception(f"Erro Semântico: Função '{method_name}' não foi declarada.")

        if ctx.argumentos():
            for arg in ctx.argumentos().expressao():
                self.visit(arg)

        param_signatures = [type_map[p_type] for p_type in symbol.params_types]
        return_signature = type_map[symbol.type]
        signature = f"({''.join(param_signatures)}){return_signature}"
        self.code.append(f"    invokestatic {self.program_name}/{method_name}{signature}")

    def visitRelacionalExpr(self, ctx: JavythonParser.RelacionalExprContext):
        left_type = self.get_expression_type(ctx.expressao(0))
        right_type = self.get_expression_type(ctx.expressao(1))
        is_float_op = left_type == 'real' or right_type == 'real'

        self.visit(ctx.expressao(0))
        if left_type == 'int' and is_float_op: self.code.append("    i2f")

        self.visit(ctx.expressao(1))
        if right_type == 'int' and is_float_op: self.code.append("    i2f")

        true_label, end_label = self.new_label(), self.new_label()
        op = ctx.getChild(1).getSymbol().type

        op_map = {}
        if is_float_op:
            self.code.append("    fcmpl")
            op_map = {JavythonParser.EQ: 'ifeq', JavythonParser.NEQ: 'ifne', JavythonParser.GT: 'ifgt',
                      JavythonParser.LT: 'iflt', JavythonParser.GE: 'ifge', JavythonParser.LE: 'ifle'}
        elif left_type == 'str':
            op_map = {JavythonParser.EQ: 'if_acmpeq', JavythonParser.NEQ: 'if_acmpne'}
        else:
            op_map = {JavythonParser.EQ: 'if_icmpeq', JavythonParser.NEQ: 'if_icmpne', JavythonParser.GT: 'if_icmpgt',
                      JavythonParser.LT: 'if_icmplt', JavythonParser.GE: 'if_icmpge', JavythonParser.LE: 'if_icmple'}

        if op in op_map:
            self.code.append(f"    {op_map[op]} {true_label}")
        else:
            raise Exception(
                f"Erro Semântico: Operador relacional '{ctx.getChild(1).getText()}' não suportado para os tipos.")

        self.code.append("    iconst_0")
        self.code.append(f"    goto {end_label}")
        self.code.append(f"{true_label}:")
        self.code.append("    iconst_1")
        self.code.append(f"{end_label}:")

    def visitValor(self, ctx: JavythonParser.ValorContext):
        if ctx.INT():
            self.code.append(f"    ldc {ctx.INT().getText()}")
        elif ctx.REAL():
            self.code.append(f"    ldc {ctx.REAL().getText()}")
        elif ctx.STRING():
            self.code.append(f"    ldc {ctx.STRING().getText()}")
        elif ctx.TRUE():
            self.code.append(f"    iconst_1")
        elif ctx.FALSE():
            self.code.append(f"    iconst_0")

    def visitWhileLoop(self, ctx: JavythonParser.WhileLoopContext):
        start_label = self.new_label()
        end_label = self.new_label()

        self.code.append(f"{start_label}:")
        # Visita a expressão condicional do while
        self.visit(ctx.expressao())
        # Se a condição for falsa (igual a 0), salta para o final do laço
        self.code.append(f"    ifeq {end_label}")

        # Visita o bloco de código dentro do while
        self.visit(ctx.bloco())
        # Volta para o início do laço para reavaliar a condição
        self.code.append(f"    goto {start_label}")

        # Rótulo de fim do laço
        self.code.append(f"{end_label}:")
        return None