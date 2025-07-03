# Caminho do arquivo: gen/JasminCodeGenerator.py
from JavythonVisitor import JavythonVisitor
from JavythonParser import JavythonParser

type_map = {'int': 'I', 'real': 'F', 'str': 'Ljava/lang/String;', 'bool': 'I', 'void': 'V'}


class Symbol:
    def __init__(self, name, type, index=None, is_constant=False, params_types=None):
        self.name, self.type, self.index, self.is_constant, self.params_types = \
            name, type, index, is_constant, params_types if params_types else []


class SymbolTable:
    def __init__(self):
        self.scopes = [{}]
        self.var_index = 0

    def enter_scope(self):
        self.scopes.append({})

    def exit_scope(self):
        self.scopes.pop()

    def add_symbol(self, symbol):
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

    def get_code(self):
        return "\n".join(self.code)

    def new_label(self):
        self.label_count += 1
        return f"L{self.label_count}"

        # Em gen/JasminCodeGenerator.py, dentro da classe JasminVisitor

    def get_expression_type(self, ctx: JavythonParser.ExpressaoContext):
        if isinstance(ctx, JavythonParser.ParenExprContext):
            return self.get_expression_type(ctx.expressao())
        if isinstance(ctx, JavythonParser.IdExprContext):
            symbol = self.symbol_table.lookup(ctx.ID().getText())
            return symbol.type if symbol else 'void'
        if isinstance(ctx, JavythonParser.ValorExprContext):
            if ctx.valor().INT() or ctx.valor().TRUE() or ctx.valor().FALSE(): return 'int'
            if ctx.valor().REAL(): return 'real'
            if ctx.valor().STRING(): return 'str'
        if isinstance(ctx, JavythonParser.ChamadaMetodoContext):
            if ctx.ID().getText().lower() == 'fatorial': return 'int'
            if ctx.ID().getText().lower() == 'media': return 'real'
        if isinstance(ctx, (JavythonParser.AddsubExprContext, JavythonParser.MultdivExprContext)):
            type_left = self.get_expression_type(ctx.expressao(0))
            type_right = self.get_expression_type(ctx.expressao(1))
            return 'real' if type_left == 'real' or type_right == 'real' else 'int'
        return 'int'

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

    def visitProgram(self, ctx: JavythonParser.ProgramContext):
        self.code.append(f".class public {self.program_name}")
        self.code.append(".super java/lang/Object")
        self.code.append(".method public <init>()V")
        self.code.append("    aload_0\n    invokenonvirtual java/lang/Object/<init>()V\n    return")
        self.code.append(".end method\n")
        self.visitChildren(ctx)

    def visitMetodo(self, ctx: JavythonParser.MetodoContext):
        method_name = ctx.ID().getText()
        javython_return_type = ctx.tipo().getText() if ctx.tipo() else 'void'
        self.current_method_return_type = javython_return_type

        # Extrai os tipos dos parâmetros para usar na criação do símbolo
        params_javython_types = [p.tipo().getText() for p in ctx.parametros().parametro()] if ctx.parametros() else []

        # --- INÍCIO DA CORREÇÃO ---
        # Cria o símbolo da função com todas as informações necessárias.
        function_symbol = Symbol(name=method_name, type=javython_return_type, params_types=params_javython_types)

        # Adiciona o símbolo ao escopo global (o primeiro da lista, índice 0).
        self.symbol_table.scopes[0][function_symbol.name.lower()] = function_symbol
        # --- FIM DA CORREÇÃO ---

        # O resto do código continua normalmente...
        return_type = type_map[javython_return_type]
        param_signatures = [type_map[p_type] for p_type in params_javython_types]
        signature = f"({''.join(param_signatures)}){return_type}"

        self.code.append(f"\n.method public static {method_name}{signature}")
        self.code.append("    .limit stack 100\n    .limit locals 100")

        self.symbol_table.enter_scope()
        self.symbol_table.var_index = 0

        if ctx.parametros():
            for p in ctx.parametros().parametro():
                self.symbol_table.add_symbol(Symbol(p.ID().getText(), p.tipo().getText()))

        self.visit(ctx.blocoMetodo())

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

        # --- ADICIONE ESTA LINHA ---
        self.string_builder_var_index = self.symbol_table.var_index  # Reserva espaço para o StringBuilder
        self.symbol_table.var_index += 1
        # --- FIM DA ADIÇÃO ---

        self.code.append(
            "    new java/util/Scanner\n    dup\n    getstatic java/lang/System/in Ljava/io/InputStream;\n    invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V")
        self.code.append(f"   astore {self.scanner_var_index}")
        self.visitChildren(ctx)
        self.code.append("    return")
        self.code.append(".end method")
        self.symbol_table.exit_scope()

    def visitComando(self, ctx: JavythonParser.ComandoContext):
        # A maneira mais segura de identificar um "comando de expressão" é
        # verificar se o primeiro filho do nó do comando é do tipo ExpressaoContext.
        if isinstance(ctx.getChild(0), JavythonParser.ExpressaoContext):
            # 1. Visita a expressão, o que gera seu bytecode e coloca o resultado na pilha.
            self.visit(ctx.expressao())

            # 2. Determina o tipo de retorno da expressão.
            expr_type = self.get_expression_type(ctx.expressao())

            # 3. Se a expressão não for 'void', seu resultado está na pilha e DEVE ser removido.
            if expr_type != 'void':
                # A instrução 'pop' remove o valor do topo da pilha, limpando-a.
                self.code.append("    pop")
        else:
            # 4. Para todos os outros tipos de comando (if, for, atribuicao, return, etc.),
            # usamos o comportamento padrão do visitor, que é visitar os nós filhos.
            return self.visitChildren(ctx)

    def visitIfElse(self, ctx: JavythonParser.IfElseContext):
        else_label, end_label = self.new_label(), self.new_label()
        is_function_with_return = self.current_method_return_type != 'void'
        self.visit(ctx.expressao())
        self.code.append(f"    ifeq {else_label}")
        self.visit(ctx.bloco()[0])
        if is_function_with_return:
            if not self.code[-1].strip().endswith("return"): self.code.append(f"    goto {end_label}")
        else:
            self.code.append(f"    goto {end_label}")
        self.code.append(f"{else_label}:")
        if len(ctx.bloco()) > 1: self.visit(ctx.bloco()[1])
        self.code.append(f"{end_label}:")
        return None

    def visitIo(self, ctx: JavythonParser.IoContext):
        if ctx.PRINT():
            # 1. Cria um novo StringBuilder e o armazena em sua variável local dedicada.
            self.code.append("    new java/lang/StringBuilder")
            self.code.append("    dup")
            self.code.append("    invokespecial java/lang/StringBuilder/<init>()V")
            self.code.append(f"   astore {self.string_builder_var_index}")

            # 2. Itera sobre os argumentos.
            for arg in ctx.argumentos().expressao():
                # Carrega o StringBuilder da variável local.
                self.code.append(f"   aload {self.string_builder_var_index}")

                arg_type = self.get_expression_type(arg)
                if arg_type == 'void':
                    func_name = arg.ID().getText() if hasattr(arg, 'ID') else 'função'
                    raise Exception(f"Erro Semântico: A {func_name} é do tipo 'void' e não pode ser usada em um print.")

                # Coloca o valor do argumento na pilha.
                self.visit(arg)

                # Anexa o valor do argumento.
                signature = type_map.get(arg_type, 'Ljava/lang/String;')
                self.code.append(
                    f"    invokevirtual java/lang/StringBuilder/append({signature})Ljava/lang/StringBuilder;")

                # Adiciona um espaço depois do argumento.
                self.code.append("    ldc \" \"")
                self.code.append(
                    "    invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder;")

                # O resultado (referência ao StringBuilder) é desnecessário, então o removemos da pilha.
                self.code.append("    pop")

            # 3. Prepara para a impressão final.
            self.code.append("    getstatic java/lang/System/out Ljava/io/PrintStream;")
            # Carrega o StringBuilder da variável novamente.
            self.code.append(f"   aload {self.string_builder_var_index}")
            # Converte para String e imprime.
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
                        self.code.append(f"   istore {symbol.index}")
                    elif symbol.type == 'real':
                        self.code.append("    invokevirtual java/util/Scanner/nextFloat()F")
                        self.code.append(f"   fstore {symbol.index}")

        elif ctx.INPUT():
            # A lógica do input permanece a mesma
            for var_id in ctx.listaIds().ID():
                name = var_id.getText()
                symbol = self.symbol_table.lookup(name)
                if symbol:
                    self.code.append(f"   aload {self.scanner_var_index}")
                    if symbol.type == 'int':
                        self.code.append("    invokevirtual java/util/Scanner/nextInt()I")
                        self.code.append(f"   istore {symbol.index}")
                    elif symbol.type == 'real':
                        self.code.append("    invokevirtual java/util/Scanner/nextFloat()F")
                        self.code.append(f"   fstore {symbol.index}")

    def visitChamadaMetodo(self, ctx: JavythonParser.ChamadaMetodoContext):
        method_name = ctx.ID().getText()

        # Procura a função na tabela de símbolos
        symbol = self.symbol_table.lookup(method_name)
        if not symbol:
            raise Exception(f"Erro Semântico: Função '{method_name}' não foi declarada.")

        # Visita os argumentos para colocá-los na pilha
        if ctx.argumentos():
            for arg in ctx.argumentos().expressao():
                self.visit(arg)

        # Constrói a assinatura dinamicamente a partir da tabela de símbolos
        param_signatures = [type_map[p_type] for p_type in symbol.params_types]
        return_signature = type_map[symbol.type]

        signature = f"({''.join(param_signatures)}){return_signature}"

        # Gera a instrução de chamada correta
        self.code.append(f"    invokestatic {self.program_name}/{method_name}{signature}")

    def visitDeclaracao(self, ctx: JavythonParser.DeclaracaoContext):
        var_type = ctx.tipo().getText() if ctx.tipo() else 'int'
        is_const = True if ctx.ID() else False
        ids_to_process = ctx.listaIds().ID() if ctx.listaIds() else [ctx.ID()]
        for var_id in ids_to_process:
            name = var_id.getText()
            if self.symbol_table.lookup(name) is None: self.symbol_table.add_symbol(
                Symbol(name, var_type, is_constant=is_const))
        if ctx.ASSIGN():
            symbol = self.symbol_table.lookup(ids_to_process[0].getText())
            self.visit(ctx.valor())
            if symbol.type in ['int', 'bool']:
                self.code.append(f"    istore {symbol.index}")
            elif symbol.type == 'real':
                self.code.append(f"    fstore {symbol.index}")

    def visitAtribuicao(self, ctx: JavythonParser.AtribuicaoContext):
        name = ctx.ID().getText()
        symbol = self.symbol_table.lookup(name)
        expr_type = self.get_expression_type(ctx.expressao())
        self.visit(ctx.expressao())
        if symbol.type == 'real' and expr_type == 'int':
            self.code.append("    i2f")
        if symbol.type in ['int', 'bool']:
            self.code.append(f"    istore {symbol.index}")
        elif symbol.type == 'real':
            self.code.append(f"    fstore {symbol.index}")

    def visitRelacionalExpr(self, ctx: JavythonParser.RelacionalExprContext):
        # Determina o tipo das expressões da esquerda e da direita
        left_type = self.get_expression_type(ctx.expressao(0))
        right_type = self.get_expression_type(ctx.expressao(1))

        # Visita as expressões para colocar seus valores na pilha
        self.visit(ctx.expressao(0))
        self.visit(ctx.expressao(1))

        # Prepara os labels para o salto condicional
        true_label = self.new_label()
        end_label = self.new_label()
        op = ctx.getChild(1).getSymbol().type

        # Lógica de comparação para inteiros ou booleanos
        if left_type in ['int', 'bool'] and right_type in ['int', 'bool']:
            op_map = {
                JavythonParser.EQ: 'if_icmpeq', JavythonParser.NEQ: 'if_icmpne',
                JavythonParser.GT: 'if_icmpgt', JavythonParser.LT: 'if_icmplt',
                JavythonParser.GE: 'if_icmpge', JavythonParser.LE: 'if_icmple'
            }
            if op in op_map:
                self.code.append(f"    {op_map[op]} {true_label}")

        # Lógica de comparação para strings (ou outros objetos)
        elif left_type == 'str' or right_type == 'str':
            op_map = {
                JavythonParser.EQ: 'if_acmpeq',
                JavythonParser.NEQ: 'if_acmpne'
            }
            if op in op_map:
                self.code.append(f"    {op_map[op]} {true_label}")
            else:
                # Comparações como > ou < não são diretamente suportadas para strings assim
                # Poderia ser implementado com String.compareTo, mas lançamos um erro por enquanto.
                raise Exception(f"Erro Semântico: Operador relacional não suportado para strings.")

        # Lógica de comparação para reais (floats)
        elif left_type == 'real' or right_type == 'real':
            # fcmpl: empurra -1, 0, ou 1 para a pilha (se <, ==, ou >)
            self.code.append("    fcmpl")
            op_map = {
                JavythonParser.EQ: 'ifeq', JavythonParser.NEQ: 'ifne',
                JavythonParser.GT: 'ifgt', JavythonParser.LT: 'iflt',
                JavythonParser.GE: 'ifge', JavythonParser.LE: 'ifle'
            }
            if op in op_map:
                self.code.append(f"    {op_map[op]} {true_label}")

        # Bloco de código para o resultado da comparação
        # Se a condição for falsa, pula para o final
        self.code.append("    iconst_0")  # Empurra 'false' (0)
        self.code.append(f"    goto {end_label}")
        # Se a condição for verdadeira, o label acima é pulado
        self.code.append(f"{true_label}:")
        self.code.append("    iconst_1")  # Empurra 'true' (1)
        # Label final para onde ambos os caminhos convergem
        self.code.append(f"{end_label}:")

    def visitValor(self, ctx: JavythonParser.ValorContext):
        if ctx.INT():
            self.code.append(f"    ldc {ctx.INT().getText()}")
        elif ctx.REAL():
            self.code.append(f"    ldc {ctx.REAL().getText()}")
        elif ctx.STRING():
            self.code.append(f"    ldc {ctx.STRING().getText()}")

    def visitIdExpr(self, ctx: JavythonParser.IdExprContext):
        name = ctx.ID().getText()
        symbol = self.symbol_table.lookup(name)
        if symbol.type in ['int', 'bool']:
            self.code.append(f"    iload {symbol.index}")
        elif symbol.type == 'real':
            self.code.append(f"    fload {symbol.index}")