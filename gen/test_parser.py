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

    
    def getValorType(self, valor_ctx: JavythonParser.ValorContext):
        """Analisa um contexto 'valor' e retorna seu tipo como string."""
        if valor_ctx.INT():
            return 'int'
        if valor_ctx.REAL():
            return 'real'
        if valor_ctx.STRING():
            return 'str'
        if valor_ctx.TRUE() or valor_ctx.FALSE():
            return 'bool'
        return None # Caso não seja nenhum dos tipos conhecidos

# Versão CORRETA e DEFINITIVA de visitDeclaracao

def visitDeclaracao(self, ctx: JavythonParser.DeclaracaoContext):
    # Caso: ID ASSIGN valor (constante com tipo inferido)
    if ctx.ID() and not ctx.listaIds():
        const_name = ctx.ID().getText()
        line = ctx.ID().symbol.line
        valor_ctx = ctx.valor()
        
        # 1. Inferir o tipo UMA ÚNICA VEZ usando o método auxiliar.
        const_type = self.getValorType(valor_ctx)
        
        # 2. Criar e adicionar o símbolo UMA ÚNICA VEZ.
        symbol = Symbol(const_name, const_type, is_constant=True)
        self.symbol_table.add_symbol(symbol, line)

    # Caso: listaIds COLON tipo (ASSIGN valor)? (variáveis)
    elif ctx.listaIds():
        var_type_declarado = ctx.tipo().getText().lower()

        if ctx.ASSIGN() and len(ctx.listaIds().ID()) > 1:
            raise Exception(f"Erro Semântico na Linha {ctx.start.line}: A inicialização só é permitida para uma variável por declaração.")

        # Se houver atribuição, verifica a compatibilidade de tipos.
        if ctx.ASSIGN():
            valor_atribuido_ctx = ctx.valor()
            tipo_valor_atribuido = self.getValorType(valor_atribuido_ctx)
            
            if var_type_declarado != tipo_valor_atribuido:
                line = ctx.start.line
                raise Exception(
                    f"Erro Semântico na Linha {line}: Incompatibilidade de tipos. "
                    f"A variável '{ctx.listaIds().ID()[0].getText()}' do tipo '{var_type_declarado}' "
                    f"não pode ser inicializada com um valor do tipo '{tipo_valor_atribuido}'."
                )

        # Adiciona as variáveis (sem valor inicial, pois isso é feito na atribuição)
        for var_id in ctx.listaIds().ID():
            var_name = var_id.getText()
            line = var_id.symbol.line
            symbol = Symbol(var_name, var_type_declarado, is_constant=False)
            self.symbol_table.add_symbol(symbol, line)
            
    # Impede a visita dupla dos filhos, como já havíamos corrigido.
    return None
                

    def visitAtribuicao(self, ctx: JavythonParser.AtribuicaoContext):
        var_name = ctx.ID().getText()
        line = ctx.start.line
        symbol = self.symbol_table.lookup_symbol(var_name)
        if symbol is None:
            raise Exception(f"Erro Semântico na Linha {line}: Variável '{var_name}' não declarada.")
        if symbol.is_constant:
            raise Exception(f"Erro Semântico na Linha {line}: Não é possível atribuir um novo valor à constante '{var_name}'.")

        # Verifica o tipo da expressão que está sendo atribuída
        tipo_expressao = self.visit(ctx.expressao())
        
        if symbol.type != tipo_expressao:
            raise Exception(
                f"Erro Semântico na Linha {line}: Incompatibilidade de tipos. "
                f"A variável '{var_name}' é do tipo '{symbol.type}', "
                f"mas está recebendo uma expressão do tipo '{tipo_expressao}'."
            )
            
        return None

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
                f"Erro Semântico na Linha {line}: Não é possível alterar o valor da constante '{var_name}'.")
        return self.visitChildren(ctx)
    
    def visitValorExpr(self, ctx: JavythonParser.ValorExprContext):
        
        return self.getValorType(ctx.valor())

    def visitIdExpr(self, ctx: JavythonParser.IdExprContext):
        var_name = ctx.ID().getText()
        symbol = self.symbol_table.lookup_symbol(var_name)
        if symbol is None:
            line = ctx.start.line
            raise Exception(f"Erro Semântico na Linha {line}: Símbolo '{var_name}' não declarado.")
        # Retorna o tipo do símbolo encontrado na tabela
        return symbol.type
    
    def visitParenExpr(self, ctx: JavythonParser.ParenExprContext):
        # O tipo de uma expressão entre parênteses é o tipo da expressão interna
        return self.visit(ctx.expressao())
    
    def visitAddsubExpr(self, ctx: JavythonParser.AddsubExprContext):
        # 1. Visita recursivamente os filhos para obter seus tipos
        tipo_esq = self.visit(ctx.left)
        tipo_dir = self.visit(ctx.right)
        line = ctx.start.line

        # [cite_start]2. Verifica a regra semântica: '+' e '-' aplicam-se a int e real [cite: 98]
        tipos_validos = ['int', 'real']
        if tipo_esq not in tipos_validos or tipo_dir not in tipos_validos:
            raise Exception(
                f"Erro Semântico na Linha {line}: Operador '{ctx.op.text}' "
                f"não pode ser aplicado aos tipos '{tipo_esq}' e '{tipo_dir}'."
            )
        
        # 3. Determina o tipo do resultado (promoção de tipo)
        if tipo_esq == 'real' or tipo_dir == 'real':
            return 'real'
        else:
            return 'int'


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