import sys
from antlr4 import *
from antlr4.error.ErrorListener import ErrorListener

from JavythonLexer import JavythonLexer
from JavythonParser import JavythonParser
from JavythonVisitor import JavythonVisitor


class Symbol:
    """
    Uma estrutura de dados simples para armazenar informações sobre um símbolo
    (neste caso, o nome e o tipo de uma variável ou função).
    """

    def __init__(self, name, type):
        self.name = name
        self.type = type


class SymbolTable:
    """
    Gerencia os escopos e os símbolos declarados. Usa uma pilha para controlar
    os escopos, permitindo a declaração de variáveis locais em funções
    sem conflitar com variáveis globais.
    """

    def __init__(self):
        # A pilha de escopos, onde cada escopo é um dicionário.
        self.scope_stack = [{}]

    def enter_scope(self):
        """Cria um novo escopo no topo da pilha."""
        self.scope_stack.append({})

    def exit_scope(self):
        """Remove o escopo atual (topo da pilha)."""
        if len(self.scope_stack) > 1:
            self.scope_stack.pop()

    def add_symbol(self, symbol, line):
        """
        Adiciona um símbolo ao escopo atual, verificando se já não existe.
        Lança um erro de redeclaração caso o símbolo já tenha sido declarado.
        """
        current_scope = self.scope_stack[-1]
        if symbol.name in current_scope:
            raise Exception(f"Erro Semântico na Linha {line}: Símbolo '{symbol.name}' já foi declarado neste escopo.")
        current_scope[symbol.name] = symbol

    def lookup_symbol(self, name):
        """
        Procura por um símbolo na pilha de escopos, do mais interno
        para o mais externo.
        """
        for scope in reversed(self.scope_stack):
            if name in scope:
                return scope[name]
        return None


class SemanticVisitor(JavythonVisitor):
    """
    Percorre a árvore sintática para aplicar as regras semânticas da linguagem.
    Verifica a declaração de variáveis, o uso correto e os escopos.
    """

    def __init__(self):
        self.symbol_table = SymbolTable()

    def visitMetodo(self, ctx: JavythonParser.MetodoContext):
        self.symbol_table.enter_scope()
        if ctx.parametros():
            for param in ctx.parametros().parametro():
                param_type = param.tipo().getText()
                param_name = param.ID().getText()
                line = param.ID().symbol.line
                symbol = Symbol(param_name, param_type)
                self.symbol_table.add_symbol(symbol, line)
        self.visitChildren(ctx)
        self.symbol_table.exit_scope()

    def visitBlocoMain(self, ctx: JavythonParser.BlocoMainContext):
        self.symbol_table.enter_scope()
        self.visitChildren(ctx)
        self.symbol_table.exit_scope()

    def visitDeclaracao(self, ctx: JavythonParser.DeclaracaoContext):
        if ctx.tipo():
            var_type = ctx.tipo().getText()
            for var_id in ctx.listaIds().ID():
                var_name = var_id.getText()
                line = var_id.symbol.line
                symbol = Symbol(var_name, var_type)
                self.symbol_table.add_symbol(symbol, line)
        return self.visitChildren(ctx)

    def visitIdExpr(self, ctx: JavythonParser.IdExprContext):
        var_name = ctx.ID().getText()
        if self.symbol_table.lookup_symbol(var_name) is None:
            line = ctx.start.line
            raise Exception(f"Erro Semântico na Linha {line}: Variável '{var_name}' não declarada.")
        return self.visitChildren(ctx)

    def visitAtribuicao(self, ctx: JavythonParser.AtribuicaoContext):
        var_name = ctx.ID().getText()
        if self.symbol_table.lookup_symbol(var_name) is None:
            line = ctx.start.line
            raise Exception(f"Erro Semântico na Linha {line}: Variável '{var_name}' não declarada.")
        return self.visitChildren(ctx)


class JavythonErrorListener(ErrorListener):
    """
    Substitui o listener de erros padrão do ANTLR para fornecer mensagens
    de erro de sintaxe claras, incluindo a linha e a coluna.
    """

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        raise Exception(f"Erro de Sintaxe na Linha {line}:{column} -> {msg}")


def main():
    """
    Para executar use o comando no terminal: python test_parser.py codigo.jy
    Ponto de entrada do compilador. Orquestra o pipeline:
    Argumento -> Arquivo -> Lexer -> Parser -> Visitor -> Saída/Erro.
    """
    try:
        # --- ETAPA 1: CONFIGURAÇÃO DA ENTRADA A PARTIR DE ARGUMENTO ---
        # Verificar se o argumento da linha de comando foi fornecido.
        if len(sys.argv) < 2:
            print("ERRO: Modo de uso: python test_parser.py <nome_do_arquivo.jy>")
            sys.exit(1)

        # Modificação: Pegar o nome do arquivo do primeiro argumento.
        input_file = sys.argv[1]
        print(f">>> Lendo o arquivo de entrada: {input_file}")

        # Modificação: Usar FileStream para ler o arquivo especificado.
        input_stream = FileStream(input_file, encoding='utf-8')

        # --- ETAPA 2: PIPELINE DO ANTLR (ANÁLISE LÉXICA E SINTÁTICA) ---
        print("\n[FASE 1: ANÁLISE LÉXICA E SINTÁTICA]")

        lexer = JavythonLexer(input_stream)
        stream = CommonTokenStream(lexer)
        parser = JavythonParser(stream)

        parser.removeErrorListeners()
        parser.addErrorListener(JavythonErrorListener())

        tree = parser.program()
        print(">>> Análise sintática concluída com sucesso!")

        # --- ETAPA 3: ANÁLISE SEMÂNTICA ---
        print("\n[FASE 2: ANÁLISE SEMÂNTICA]")
        semantic_visitor = SemanticVisitor()
        semantic_visitor.visit(tree)
        print(">>> Análise semântica concluída com sucesso!")

        # --- ETAPA 4: GERAÇÃO DA SAÍDA (AST) ---
        print("\n------------------------------------")
        print("COMPILAÇÃO BEM-SUCEDIDA")
        print("Árvore Sintática Abstrata (AST):")
        print("------------------------------------")
        print(tree.toStringTree(recog=parser))
        print("------------------------------------")

    except FileNotFoundError:
        # Erro adicionado para caso o arquivo não seja encontrado
        print(f"\nERRO: O arquivo '{input_file}' não foi encontrado.")

    except Exception as e:
        print("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        print("ERRO DE COMPILAÇÃO ENCONTRADO:")
        print(f">>> {e}")
        print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")


# Bloco padrão para tornar o script executável
if __name__ == '__main__':
    main()