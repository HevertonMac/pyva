# Caminho do arquivo: gen/test_parser.py
import sys
import os
from antlr4 import *
from antlr4.error.ErrorListener import ErrorListener

from JavythonLexer import JavythonLexer
from JavythonParser import JavythonParser
from JavythonVisitor import JavythonVisitor
from JasminCodeGenerator import JasminVisitor  # Importa o novo gerador de código


class Symbol:
    """
    Armazena informações sobre um símbolo (variável, constante ou função).
    """

    def __init__(self, name, type, is_constant=False, params_count=None, index=None):
        self.name = name
        self.type = type
        self.is_constant = is_constant
        self.params_count = params_count
        self.index = index  # Índice da variável local para Jasmin


class SymbolTable:
    """
    Gerencia os escopos e os símbolos de forma case-insensitive.
    """

    def __init__(self):
        self.scope_stack = [{}]
        self.local_var_index = 0

    def enter_scope(self):
        self.scope_stack.append({})
        self.local_var_index = 0  # Reinicia o índice para o novo escopo

    def exit_scope(self):
        if len(self.scope_stack) > 1:
            self.scope_stack.pop()

    def add_symbol(self, symbol, line):
        current_scope = self.scope_stack[-1]
        symbol_name_lower = symbol.name.lower()
        if symbol_name_lower in current_scope:
            raise Exception(f"Erro Semântico na Linha {line}: Símbolo '{symbol.name}' já foi declarado.")

        # Atribui um índice para variáveis locais
        symbol.index = self.local_var_index
        self.local_var_index += 1
        current_scope[symbol_name_lower] = symbol

    def lookup_symbol(self, name):
        name_lower = name.lower()
        for scope in reversed(self.scope_stack):
            if name_lower in scope:
                return scope[name_lower]
        return None


# A classe SemanticVisitor continua a mesma da resposta anterior, focada na análise.
# Por brevidade, não será repetida aqui. Assumimos que ela existe e funciona.
class SemanticVisitor(JavythonVisitor):
    def __init__(self):
        self.symbol_table = SymbolTable()

    def visitDeclaracao(self, ctx: JavythonParser.DeclaracaoContext):
        if ctx.ID():
            var_name = ctx.ID().getText()
            line = ctx.ID().symbol.line
            valor_ctx = ctx.valor()
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
        elif ctx.listaIds():
            var_type = ctx.tipo().getText()
            for var_id in ctx.listaIds().ID():
                var_name = var_id.getText()
                line = var_id.symbol.line
                symbol = Symbol(var_name, var_type, is_constant=False)
                self.symbol_table.add_symbol(symbol, line)
        return self.visitChildren(ctx)

    def visitAtribuicao(self, ctx: JavythonParser.AtribuicaoContext):
        var_name = ctx.ID().getText()
        line = ctx.start.line
        symbol = self.symbol_table.lookup_symbol(var_name)
        if symbol is None:
            raise Exception(f"Erro Semântico na Linha {line}: Variável '{var_name}' não declarada.")
        if symbol.is_constant:
            raise Exception(
                f"Erro Semântico na Linha {line}: Não é possível atribuir um novo valor à constante '{var_name}'.")
        return self.visitChildren(ctx)

    def visitIdExpr(self, ctx: JavythonParser.IdExprContext):
        var_name = ctx.ID().getText()
        if self.symbol_table.lookup_symbol(var_name) is None:
            line = ctx.start.line
            raise Exception(f"Erro Semântico na Linha {line}: Símbolo '{var_name}' não declarado.")
        return self.visitChildren(ctx)


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

        # --- FASE 1: ANÁLISE LÉXICA E SINTÁTICA ---
        print("\n[FASE 1: ANÁLISE LÉXICA E SINTÁTICA]")
        lexer = JavythonLexer(input_stream)
        stream = CommonTokenStream(lexer)
        parser = JavythonParser(stream)
        parser.removeErrorListeners()
        parser.addErrorListener(JavythonErrorListener())
        tree = parser.program()
        print(">>> Análise sintática concluída com sucesso!")

        # --- FASE 2: ANÁLISE SEMÂNTICA ---
        print("\n[FASE 2: ANÁLISE SEMÂNTICA]")
        semantic_visitor = SemanticVisitor()
        semantic_visitor.visit(tree)
        print(">>> Análise semântica concluída com sucesso!")

        # --- FASE 3: GERAÇÃO DE CÓDIGO INTERMEDIÁRIO (JASMIN) ---
        print("\n[FASE 3: GERAÇÃO DE CÓDIGO JASMIN]")
        # Extrai o nome do programa do nó da AST para nomear a classe
        program_name = tree.getChild(2).getText()
        jasmin_visitor = JasminVisitor(program_name)
        jasmin_visitor.visit(tree)
        jasmin_code = jasmin_visitor.get_code()

        output_filename = f"{program_name}.j"
        with open(output_filename, "w") as f:
            f.write(jasmin_code)
        print(f">>> Código Jasmin gerado e salvo em '{output_filename}'")

        # --- ETAPA 4: GERAÇÃO DA SAÍDA (AST) ---
        print("\n------------------------------------")
        print("COMPILAÇÃO BEM-SUCEDIDA")
        print("Árvore Sintática Abstrata (AST):")
        print("------------------------------------")
        # print(tree.toStringTree(recog=parser))
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