import sys
import os
from antlr4 import *
from antlr4.error.ErrorListener import ErrorListener

from JavythonLexer import JavythonLexer
from JavythonParser import JavythonParser
from JavythonVisitor import JavythonVisitor
from JasminCodeGenerator import JasminVisitor


class Symbol:
    def __init__(self, name, type, is_constant=False, params_count=None, params_types=None):
        self.name = name
        self.type = type
        self.is_constant = is_constant
        self.params_count = params_count
        self.params_types = params_types if params_types is not None else []


class SymbolTable:
    def __init__(self):
        self.scope_stack = [{}]

    def enter_scope(self):
        self.scope_stack.append({})

    def exit_scope(self):
        if len(self.scope_stack) > 1:
            self.scope_stack.pop()

    def add_symbol(self, symbol, line):
        current_scope = self.scope_stack[-1]
        symbol_name_lower = symbol.name.lower()
        if symbol_name_lower in current_scope:
            raise Exception(f"Erro Semântico na Linha {line}: Símbolo '{symbol.name}' já foi declarado neste escopo.")
        current_scope[symbol_name_lower] = symbol

    def lookup_symbol(self, name):
        name_lower = name.lower()
        for scope in reversed(self.scope_stack):
            if name_lower in scope:
                return scope[name_lower]
        return None


class SemanticVisitor(JavythonVisitor):
    def __init__(self):
        self.symbol_table = SymbolTable()

    def visitMetodo(self, ctx: JavythonParser.MetodoContext):
        method_name = ctx.ID().getText()
        return_type = ctx.tipo().getText() if ctx.tipo() else 'void'
        line = ctx.ID().symbol.line

        params_types = []
        num_params = 0
        if ctx.parametros():
            num_params = len(ctx.parametros().parametro())
            for p in ctx.parametros().parametro():
                params_types.append(p.tipo().getText())

        # Adiciona a função ao escopo PAI (antes de entrar no novo escopo)
        method_symbol = Symbol(method_name, return_type, params_count=num_params, params_types=params_types)
        self.symbol_table.add_symbol(method_symbol, line)

        # Entra no escopo da função
        self.symbol_table.enter_scope()

        # Adiciona os parâmetros ao NOVO escopo
        if ctx.parametros():
            for param in ctx.parametros().parametro():
                param_name = param.ID().getText()
                param_type = param.tipo().getText()
                param_line = param.ID().symbol.line
                param_symbol = Symbol(param_name, param_type)
                self.symbol_table.add_symbol(param_symbol, param_line)

        # Visita o corpo da função
        self.visit(ctx.blocoMetodo())

        # Sai do escopo da função
        self.symbol_table.exit_scope()
        return None  # Evita que os filhos sejam visitados novamente

    def visitBlocoMetodo(self, ctx: JavythonParser.BlocoMetodoContext):
        # Apenas visita os filhos (decIds e comandos)
        return self.visitChildren(ctx)

    def visitDeclaracao(self, ctx: JavythonParser.DeclaracaoContext):
        # Declaração de constante
        if ctx.ID():
            var_name = ctx.ID().getText()
            line = ctx.ID().symbol.line
            # Inferir tipo (simplificado)
            var_type = 'int' if ctx.valor().INT() else 'real' if ctx.valor().REAL() else 'str'
            symbol = Symbol(var_name, var_type, is_constant=True)
            self.symbol_table.add_symbol(symbol, line)
        # Declaração de variável
        elif ctx.listaIds():
            var_type = ctx.tipo().getText()
            for var_id in ctx.listaIds().ID():
                var_name = var_id.getText()
                line = var_id.symbol.line
                symbol = Symbol(var_name, var_type)
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
                f"Erro Semântico na Linha {line}: Não é possível alterar o valor da constante '{var_name}'.")
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

        print("\n[FASE 3: GERAÇÃO DE CÓDIGO JASMIN]")
        program_name = tree.getChild(2).getText()
        jasmin_visitor = JasminVisitor(program_name)
        jasmin_visitor.visit(tree)
        jasmin_code = jasmin_visitor.get_code()

        output_filename = f"{program_name}.j"
        with open(output_filename, "w") as f:
            f.write(jasmin_code)
        print(f">>> Código Jasmin gerado e salvo em '{output_filename}'")

        print("\n------------------------------------")
        print("COMPILAÇÃO BEM-SUCEDIDA")
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