# Generated from C:/Users/hever/OneDrive/Desktop/Trab_Final/Javython.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .JavythonParser import JavythonParser
else:
    from JavythonParser import JavythonParser

# This class defines a complete generic visitor for a parse tree produced by JavythonParser.

class JavythonVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by JavythonParser#program.
    def visitProgram(self, ctx:JavythonParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#bloco.
    def visitBloco(self, ctx:JavythonParser.BlocoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#blocoMetodo.
    def visitBlocoMetodo(self, ctx:JavythonParser.BlocoMetodoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#blocoMain.
    def visitBlocoMain(self, ctx:JavythonParser.BlocoMainContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#metodo.
    def visitMetodo(self, ctx:JavythonParser.MetodoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#parametros.
    def visitParametros(self, ctx:JavythonParser.ParametrosContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#parametro.
    def visitParametro(self, ctx:JavythonParser.ParametroContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#decIds.
    def visitDecIds(self, ctx:JavythonParser.DecIdsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#declaracao.
    def visitDeclaracao(self, ctx:JavythonParser.DeclaracaoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#listaIds.
    def visitListaIds(self, ctx:JavythonParser.ListaIdsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#tipo.
    def visitTipo(self, ctx:JavythonParser.TipoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#valor.
    def visitValor(self, ctx:JavythonParser.ValorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#comando.
    def visitComando(self, ctx:JavythonParser.ComandoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#ifElse.
    def visitIfElse(self, ctx:JavythonParser.IfElseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#whileLoop.
    def visitWhileLoop(self, ctx:JavythonParser.WhileLoopContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#forLoop.
    def visitForLoop(self, ctx:JavythonParser.ForLoopContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#io.
    def visitIo(self, ctx:JavythonParser.IoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#atribuicao.
    def visitAtribuicao(self, ctx:JavythonParser.AtribuicaoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#chamadaMetodo.
    def visitChamadaMetodo(self, ctx:JavythonParser.ChamadaMetodoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#argumentos.
    def visitArgumentos(self, ctx:JavythonParser.ArgumentosContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#unariaExpr.
    def visitUnariaExpr(self, ctx:JavythonParser.UnariaExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#multdivExpr.
    def visitMultdivExpr(self, ctx:JavythonParser.MultdivExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#valorExpr.
    def visitValorExpr(self, ctx:JavythonParser.ValorExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#addsubExpr.
    def visitAddsubExpr(self, ctx:JavythonParser.AddsubExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#postfixExpr.
    def visitPostfixExpr(self, ctx:JavythonParser.PostfixExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#chamadaExpr.
    def visitChamadaExpr(self, ctx:JavythonParser.ChamadaExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#relacionalExpr.
    def visitRelacionalExpr(self, ctx:JavythonParser.RelacionalExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#parenExpr.
    def visitParenExpr(self, ctx:JavythonParser.ParenExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#idExpr.
    def visitIdExpr(self, ctx:JavythonParser.IdExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by JavythonParser#logicaExpr.
    def visitLogicaExpr(self, ctx:JavythonParser.LogicaExprContext):
        return self.visitChildren(ctx)



del JavythonParser