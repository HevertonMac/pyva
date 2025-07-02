# Caminho do arquivo: gen/test_parser.py
import sys
from antlr4 import *
from antlr4.error.ErrorListener import ErrorListener

from JavythonLexer import JavythonLexer
from JavythonParser import JavythonParser
from JavythonVisitor import JavythonVisitor


class Symbol:
    """
    Armazena informações sobre um símbolo (variável, constante ou função).
    """
    def __init__(self, name, type, is_constant=False, params_count=None):
        self.name = name
        self.type = type
        self.is_constant = is_constant
        self.params_count = params_count


class SymbolTable:
    """
    Gerencia os escopos e os símbolos de forma case-insensitive.
    """
    def __init__(self):
        self.scope_stack = [{}]

    def enter_scope(self):
        self.scope_stack.append({})

    def exit_scope(self):
        if len(self.scope_stack) > 1:
            self.scope_stack.pop()

    def add_symbol(self, symbol, line):
        """Adiciona um símbolo ao escopo atual, convertendo o nome para minúsculas."""
        current_scope = self.scope_stack[-1]
        symbol_name_lower = symbol.name.lower()
        if symbol_name_lower in current_scope:
            raise Exception(f"Erro Semântico na Linha {line}: Símbolo '{symbol.name}' já foi declarado neste escopo.")
        current_scope[symbol_name_lower] = symbol

    def lookup_symbol(self, name):
        """Busca por um símbolo em todos os escopos, de forma case-insensitive."""
        name_lower = name.lower()
        for scope in reversed(self.scope_stack):
            if name_lower in scope:
                return scope[name_lower]
        return None


class SemanticVisitor(JavythonVisitor):
    """
    Aplica as regras semânticas, como verificação de tipos, escopos e constantes.
    """
    def __init__(self):
        self.symbol_table = SymbolTable()

    def visitDeclaracao(self, ctx: JavythonParser.DeclaracaoContext):
        # Caso: ID ASSIGN valor (constante por padrão)
        if ctx.ID():
            var_name = ctx.ID().getText()
            line = ctx.ID().symbol.line
            valor_ctx = ctx.valor()

            # Inferir tipo do valor
            var_type = None
            if valor_ctx.INT():
                var_type = 'int'
            elif valor_ctx.REAL():
                var_type = 'real'
            elif valor_ctx.STRING():
                var_type = 'str'
            elif valor_ctx.TRUE() or valor_ctx.FALSE():
                var_type = 'bool'

            symbol = Symbol(var_name, var_type, is_constant=True)
            self.symbol_table.add_symbol(symbol, line)

        # Caso: listaIds COLON tipo (variáveis)
        elif ctx.listaIds():
            var_type = ctx.tipo().getText()
            for var_id in ctx.listaIds().ID():
                var_name = var_id.getText()
                line = var_id.symbol.line
                symbol = Symbol(var_name, var_type, is_constant=False)
                self.symbol_table.add_symbol(symbol, line)
                # Lidar com atribuição opcional para variáveis
                if ctx.ASSIGN():
                    # (Opcional) Adicionar verificação de tipo da atribuição aqui
                    pass

        return self.visitChildren(ctx)

    def visitAtribuicao(self, ctx: JavythonParser.AtribuicaoContext):
        var_name = ctx.ID().getText()
        line = ctx.start.line
        symbol = self.symbol_table.lookup_symbol(var_name)

        if symbol is None:
            raise Exception(f"Erro Semântico na Linha {line}: Variável '{var_name}' não declarada.")

        if symbol.is_constant:
            raise Exception(f"Erro Semântico na Linha {line}: Não é possível atribuir um novo valor à constante '{var_name}'.")

        # (Opcional) Adicionar verificação de tipo da expressão atribuída
        return self.visitChildren(ctx)

    def visitMetodo(self, ctx: JavythonParser.MetodoContext):
        method_name = ctx.ID().getText()
        return_type = ctx.tipo().getText() if ctx.tipo() else ctx.VOID().getText()
        line = ctx.ID().symbol.line
        num_params = len(ctx.parametros().parametro()) if ctx.parametros() else 0

        # Adiciona o símbolo da função ao escopo pai (global) de forma case-insensitive
        symbol = Symbol(method_name, return_type, params_count=num_params)
        self.symbol_table.add_symbol(symbol, line)

        self.symbol_table.enter_scope()
        if ctx.parametros():
            for param in ctx.parametros().parametro():
                param_type = param.tipo().getText()
                param_name = param.ID().getText()
                line = param.ID().symbol.line
                param_symbol = Symbol(param_name, param_type)
                self.symbol_table.add_symbol(param_symbol, line)

        self.visitChildren(ctx.blocoMetodo())
        self.symbol_table.exit_scope()

    def visitChamadaMetodo(self, ctx: JavythonParser.ChamadaMetodoContext):
        method_name = ctx.ID().getText()
        line = ctx.start.line
        method_symbol = self.symbol_table.lookup_symbol(method_name)

        if method_symbol is None:
            raise Exception(f"Erro Semântico na Linha {line}: Método '{method_name}' não declarado.")

        if method_symbol.params_count is None:
            raise Exception(f"Erro Semântico na Linha {line}: '{method_name}' não é uma função.")

        num_args = len(ctx.argumentos().expressao()) if ctx.argumentos() else 0

        if num_args != method_symbol.params_count:
            raise Exception(
                f"Erro Semântico na Linha {line}: Número incorreto de argumentos para o método '{method_name}'. "
                f"Esperado: {method_symbol.params_count}, Fornecido: {num_args}.")

        return self.visitChildren(ctx)

    def visitIdExpr(self, ctx: JavythonParser.IdExprContext):
        var_name = ctx.ID().getText()
        if self.symbol_table.lookup_symbol(var_name) is None:
            line = ctx.start.line
            raise Exception(f"Erro Semântico na Linha {line}: Símbolo '{var_name}' não declarado.")
        return self.visitChildren(ctx)

    def visitForLoop(self, ctx: JavythonParser.ForLoopContext):
        self.symbol_table.enter_scope()
        self.visitChildren(ctx)
        self.symbol_table.exit_scope()

    def visitBlocoMain(self, ctx: JavythonParser.BlocoMainContext):
        self.symbol_table.enter_scope()
        self.visitChildren(ctx)
        self.symbol_table.exit_scope()

class JavythonErrorListener(ErrorListener):
    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        raise Exception(f"Erro de Sintaxe na Linha {line}:{column} -> {msg}")

def main():
    try:
        if len(sys.argv) < 2:
            print("ERRO: Modo de uso: python test_parser.py <nome_do_arquivo.jy>")
            sys.exit(1)

        input_file = sys.argv[1]
        print(f">>> Lendo o arquivo de entrada: {input_file}")
        input_stream = FileStream(input_file, encoding='utf-8')

        print("\n[FASE 1: ANÁLISE LÉXICA E SINTÁTICA]")
        lexer = JavythonLexer(input_stream)
        stream = CommonTokenStream(lexer)
        parser = JavythonParser(stream)
        parser.removeErrorListeners()
        parser.addErrorListener(JavythonErrorListener())
        tree = parser.program()
        print(">>> Análise sintática concluída com sucesso!")

        print("\n[FASE 2: ANÁLISE SEMÂNTICA]")
        semantic_visitor = SemanticVisitor()
        semantic_visitor.visit(tree)
        print(">>> Análise semântica concluída com sucesso!")

        print("\n------------------------------------")
        print("COMPILAÇÃO BEM-SUCEDIDA")
        print("Árvore Sintática Abstrata (AST):")
        print("------------------------------------")
        print(tree.toStringTree(recog=parser))
        print("------------------------------------")

    except FileNotFoundError:
        print(f"\nERRO: O arquivo '{input_file}' não foi encontrado.")
    except Exception as e:
        print("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        print("ERRO DE COMPILAÇÃO ENCONTRADO:")
        print(f">>> {e}")
        print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")

if __name__ == '__main__':
    main()