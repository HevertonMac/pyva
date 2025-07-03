# Generated from C:/Users/gutop/Downloads/Trab_Final +correções/Trab_Final/Javython.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .JavythonParser import JavythonParser
else:
    from JavythonParser import JavythonParser

# This class defines a complete listener for a parse tree produced by JavythonParser.
class JavythonListener(ParseTreeListener):

    # Enter a parse tree produced by JavythonParser#program.
    def enterProgram(self, ctx:JavythonParser.ProgramContext):
        pass

    # Exit a parse tree produced by JavythonParser#program.
    def exitProgram(self, ctx:JavythonParser.ProgramContext):
        pass


    # Enter a parse tree produced by JavythonParser#decIds.
    def enterDecIds(self, ctx:JavythonParser.DecIdsContext):
        pass

    # Exit a parse tree produced by JavythonParser#decIds.
    def exitDecIds(self, ctx:JavythonParser.DecIdsContext):
        pass


    # Enter a parse tree produced by JavythonParser#declaracao.
    def enterDeclaracao(self, ctx:JavythonParser.DeclaracaoContext):
        pass

    # Exit a parse tree produced by JavythonParser#declaracao.
    def exitDeclaracao(self, ctx:JavythonParser.DeclaracaoContext):
        pass


    # Enter a parse tree produced by JavythonParser#listaIds.
    def enterListaIds(self, ctx:JavythonParser.ListaIdsContext):
        pass

    # Exit a parse tree produced by JavythonParser#listaIds.
    def exitListaIds(self, ctx:JavythonParser.ListaIdsContext):
        pass


    # Enter a parse tree produced by JavythonParser#tipo.
    def enterTipo(self, ctx:JavythonParser.TipoContext):
        pass

    # Exit a parse tree produced by JavythonParser#tipo.
    def exitTipo(self, ctx:JavythonParser.TipoContext):
        pass


    # Enter a parse tree produced by JavythonParser#valor.
    def enterValor(self, ctx:JavythonParser.ValorContext):
        pass

    # Exit a parse tree produced by JavythonParser#valor.
    def exitValor(self, ctx:JavythonParser.ValorContext):
        pass


    # Enter a parse tree produced by JavythonParser#metodo.
    def enterMetodo(self, ctx:JavythonParser.MetodoContext):
        pass

    # Exit a parse tree produced by JavythonParser#metodo.
    def exitMetodo(self, ctx:JavythonParser.MetodoContext):
        pass


    # Enter a parse tree produced by JavythonParser#parametros.
    def enterParametros(self, ctx:JavythonParser.ParametrosContext):
        pass

    # Exit a parse tree produced by JavythonParser#parametros.
    def exitParametros(self, ctx:JavythonParser.ParametrosContext):
        pass


    # Enter a parse tree produced by JavythonParser#parametro.
    def enterParametro(self, ctx:JavythonParser.ParametroContext):
        pass

    # Exit a parse tree produced by JavythonParser#parametro.
    def exitParametro(self, ctx:JavythonParser.ParametroContext):
        pass


    # Enter a parse tree produced by JavythonParser#blocoMetodo.
    def enterBlocoMetodo(self, ctx:JavythonParser.BlocoMetodoContext):
        pass

    # Exit a parse tree produced by JavythonParser#blocoMetodo.
    def exitBlocoMetodo(self, ctx:JavythonParser.BlocoMetodoContext):
        pass


    # Enter a parse tree produced by JavythonParser#blocoMain.
    def enterBlocoMain(self, ctx:JavythonParser.BlocoMainContext):
        pass

    # Exit a parse tree produced by JavythonParser#blocoMain.
    def exitBlocoMain(self, ctx:JavythonParser.BlocoMainContext):
        pass


    # Enter a parse tree produced by JavythonParser#comando.
    def enterComando(self, ctx:JavythonParser.ComandoContext):
        pass

    # Exit a parse tree produced by JavythonParser#comando.
    def exitComando(self, ctx:JavythonParser.ComandoContext):
        pass


    # Enter a parse tree produced by JavythonParser#atribuicao.
    def enterAtribuicao(self, ctx:JavythonParser.AtribuicaoContext):
        pass

    # Exit a parse tree produced by JavythonParser#atribuicao.
    def exitAtribuicao(self, ctx:JavythonParser.AtribuicaoContext):
        pass


    # Enter a parse tree produced by JavythonParser#unariaExpr.
    def enterUnariaExpr(self, ctx:JavythonParser.UnariaExprContext):
        pass

    # Exit a parse tree produced by JavythonParser#unariaExpr.
    def exitUnariaExpr(self, ctx:JavythonParser.UnariaExprContext):
        pass


    # Enter a parse tree produced by JavythonParser#multdivExpr.
    def enterMultdivExpr(self, ctx:JavythonParser.MultdivExprContext):
        pass

    # Exit a parse tree produced by JavythonParser#multdivExpr.
    def exitMultdivExpr(self, ctx:JavythonParser.MultdivExprContext):
        pass


    # Enter a parse tree produced by JavythonParser#valorExpr.
    def enterValorExpr(self, ctx:JavythonParser.ValorExprContext):
        pass

    # Exit a parse tree produced by JavythonParser#valorExpr.
    def exitValorExpr(self, ctx:JavythonParser.ValorExprContext):
        pass


    # Enter a parse tree produced by JavythonParser#addsubExpr.
    def enterAddsubExpr(self, ctx:JavythonParser.AddsubExprContext):
        pass

    # Exit a parse tree produced by JavythonParser#addsubExpr.
    def exitAddsubExpr(self, ctx:JavythonParser.AddsubExprContext):
        pass


    # Enter a parse tree produced by JavythonParser#postfixExpr.
    def enterPostfixExpr(self, ctx:JavythonParser.PostfixExprContext):
        pass

    # Exit a parse tree produced by JavythonParser#postfixExpr.
    def exitPostfixExpr(self, ctx:JavythonParser.PostfixExprContext):
        pass


    # Enter a parse tree produced by JavythonParser#chamadaExpr.
    def enterChamadaExpr(self, ctx:JavythonParser.ChamadaExprContext):
        pass

    # Exit a parse tree produced by JavythonParser#chamadaExpr.
    def exitChamadaExpr(self, ctx:JavythonParser.ChamadaExprContext):
        pass


    # Enter a parse tree produced by JavythonParser#relacionalExpr.
    def enterRelacionalExpr(self, ctx:JavythonParser.RelacionalExprContext):
        pass

    # Exit a parse tree produced by JavythonParser#relacionalExpr.
    def exitRelacionalExpr(self, ctx:JavythonParser.RelacionalExprContext):
        pass


    # Enter a parse tree produced by JavythonParser#parenExpr.
    def enterParenExpr(self, ctx:JavythonParser.ParenExprContext):
        pass

    # Exit a parse tree produced by JavythonParser#parenExpr.
    def exitParenExpr(self, ctx:JavythonParser.ParenExprContext):
        pass


    # Enter a parse tree produced by JavythonParser#idExpr.
    def enterIdExpr(self, ctx:JavythonParser.IdExprContext):
        pass

    # Exit a parse tree produced by JavythonParser#idExpr.
    def exitIdExpr(self, ctx:JavythonParser.IdExprContext):
        pass


    # Enter a parse tree produced by JavythonParser#chamadaMetodo.
    def enterChamadaMetodo(self, ctx:JavythonParser.ChamadaMetodoContext):
        pass

    # Exit a parse tree produced by JavythonParser#chamadaMetodo.
    def exitChamadaMetodo(self, ctx:JavythonParser.ChamadaMetodoContext):
        pass


    # Enter a parse tree produced by JavythonParser#argumentos.
    def enterArgumentos(self, ctx:JavythonParser.ArgumentosContext):
        pass

    # Exit a parse tree produced by JavythonParser#argumentos.
    def exitArgumentos(self, ctx:JavythonParser.ArgumentosContext):
        pass


    # Enter a parse tree produced by JavythonParser#ifElse.
    def enterIfElse(self, ctx:JavythonParser.IfElseContext):
        pass

    # Exit a parse tree produced by JavythonParser#ifElse.
    def exitIfElse(self, ctx:JavythonParser.IfElseContext):
        pass


    # Enter a parse tree produced by JavythonParser#whileLoop.
    def enterWhileLoop(self, ctx:JavythonParser.WhileLoopContext):
        pass

    # Exit a parse tree produced by JavythonParser#whileLoop.
    def exitWhileLoop(self, ctx:JavythonParser.WhileLoopContext):
        pass


    # Enter a parse tree produced by JavythonParser#forLoop.
    def enterForLoop(self, ctx:JavythonParser.ForLoopContext):
        pass

    # Exit a parse tree produced by JavythonParser#forLoop.
    def exitForLoop(self, ctx:JavythonParser.ForLoopContext):
        pass


    # Enter a parse tree produced by JavythonParser#io.
    def enterIo(self, ctx:JavythonParser.IoContext):
        pass

    # Exit a parse tree produced by JavythonParser#io.
    def exitIo(self, ctx:JavythonParser.IoContext):
        pass



del JavythonParser