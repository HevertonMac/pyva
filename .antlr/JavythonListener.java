// Generated from c:/Users/gutop/Downloads/Trab_Final +correções/Trab_Final/Javython.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavythonParser}.
 */
public interface JavythonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(JavythonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(JavythonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#decIds}.
	 * @param ctx the parse tree
	 */
	void enterDecIds(JavythonParser.DecIdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#decIds}.
	 * @param ctx the parse tree
	 */
	void exitDecIds(JavythonParser.DecIdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(JavythonParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(JavythonParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#listaIds}.
	 * @param ctx the parse tree
	 */
	void enterListaIds(JavythonParser.ListaIdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#listaIds}.
	 * @param ctx the parse tree
	 */
	void exitListaIds(JavythonParser.ListaIdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(JavythonParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(JavythonParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(JavythonParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(JavythonParser.ValorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#metodo}.
	 * @param ctx the parse tree
	 */
	void enterMetodo(JavythonParser.MetodoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#metodo}.
	 * @param ctx the parse tree
	 */
	void exitMetodo(JavythonParser.MetodoContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(JavythonParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(JavythonParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(JavythonParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(JavythonParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#blocoMetodo}.
	 * @param ctx the parse tree
	 */
	void enterBlocoMetodo(JavythonParser.BlocoMetodoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#blocoMetodo}.
	 * @param ctx the parse tree
	 */
	void exitBlocoMetodo(JavythonParser.BlocoMetodoContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#blocoMain}.
	 * @param ctx the parse tree
	 */
	void enterBlocoMain(JavythonParser.BlocoMainContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#blocoMain}.
	 * @param ctx the parse tree
	 */
	void exitBlocoMain(JavythonParser.BlocoMainContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(JavythonParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(JavythonParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(JavythonParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(JavythonParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unariaExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterUnariaExpr(JavythonParser.UnariaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unariaExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitUnariaExpr(JavythonParser.UnariaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multdivExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterMultdivExpr(JavythonParser.MultdivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multdivExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitMultdivExpr(JavythonParser.MultdivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valorExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterValorExpr(JavythonParser.ValorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valorExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitValorExpr(JavythonParser.ValorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addsubExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterAddsubExpr(JavythonParser.AddsubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addsubExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitAddsubExpr(JavythonParser.AddsubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(JavythonParser.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(JavythonParser.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code chamadaExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterChamadaExpr(JavythonParser.ChamadaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code chamadaExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitChamadaExpr(JavythonParser.ChamadaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relacionalExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterRelacionalExpr(JavythonParser.RelacionalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relacionalExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitRelacionalExpr(JavythonParser.RelacionalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(JavythonParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(JavythonParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(JavythonParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link JavythonParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(JavythonParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#chamadaMetodo}.
	 * @param ctx the parse tree
	 */
	void enterChamadaMetodo(JavythonParser.ChamadaMetodoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#chamadaMetodo}.
	 * @param ctx the parse tree
	 */
	void exitChamadaMetodo(JavythonParser.ChamadaMetodoContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(JavythonParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(JavythonParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(JavythonParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(JavythonParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(JavythonParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(JavythonParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(JavythonParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(JavythonParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavythonParser#io}.
	 * @param ctx the parse tree
	 */
	void enterIo(JavythonParser.IoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavythonParser#io}.
	 * @param ctx the parse tree
	 */
	void exitIo(JavythonParser.IoContext ctx);
}