// Generated from c:/Users/gutop/Downloads/Trab_Final +correções/Trab_Final/Javython.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JavythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, PROGRAM=2, MAIN=3, END=4, RETURN=5, PRINT=6, INPUT=7, IF=8, ELSE=9, 
		WHILE=10, FOR=11, BREAK=12, VOID=13, BOOL_TYPE=14, INT_TYPE=15, REAL_TYPE=16, 
		STR_TYPE=17, TRUE=18, FALSE=19, ADD=20, SUB=21, MUL=22, DIV=23, INC=24, 
		DEC=25, ASSIGN=26, EQ=27, NEQ=28, GT=29, LT=30, NOT=31, LPAREN=32, RPAREN=33, 
		LBRACE=34, RBRACE=35, COLON=36, SEMICOLON=37, COMMA=38, STRING=39, REAL=40, 
		INT=41, ID=42, WS=43, LINE_COMMENT=44;
	public static final int
		RULE_program = 0, RULE_decIds = 1, RULE_declaracao = 2, RULE_listaIds = 3, 
		RULE_tipo = 4, RULE_valor = 5, RULE_metodo = 6, RULE_parametros = 7, RULE_parametro = 8, 
		RULE_blocoMetodo = 9, RULE_blocoMain = 10, RULE_comando = 11, RULE_atribuicao = 12, 
		RULE_expressao = 13, RULE_chamadaMetodo = 14, RULE_argumentos = 15, RULE_ifElse = 16, 
		RULE_whileLoop = 17, RULE_forLoop = 18, RULE_io = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decIds", "declaracao", "listaIds", "tipo", "valor", "metodo", 
			"parametros", "parametro", "blocoMetodo", "blocoMain", "comando", "atribuicao", 
			"expressao", "chamadaMetodo", "argumentos", "ifElse", "whileLoop", "forLoop", 
			"io"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'decIds'", "'program'", "'main'", "'end'", "'return'", "'print'", 
			"'input'", "'if'", "'else'", "'while'", "'for'", "'break'", "'void'", 
			"'bool'", "'int'", "'real'", "'str'", "'true'", "'false'", "'+'", "'-'", 
			"'*'", "'/'", "'++'", "'--'", "'='", "'=='", "'!='", "'>'", "'<'", "'!'", 
			"'('", "')'", "'{'", "'}'", "':'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "PROGRAM", "MAIN", "END", "RETURN", "PRINT", "INPUT", "IF", 
			"ELSE", "WHILE", "FOR", "BREAK", "VOID", "BOOL_TYPE", "INT_TYPE", "REAL_TYPE", 
			"STR_TYPE", "TRUE", "FALSE", "ADD", "SUB", "MUL", "DIV", "INC", "DEC", 
			"ASSIGN", "EQ", "NEQ", "GT", "LT", "NOT", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "COLON", "SEMICOLON", "COMMA", "STRING", "REAL", "INT", "ID", 
			"WS", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Javython.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(JavythonParser.PROGRAM, 0); }
		public TerminalNode COLON() { return getToken(JavythonParser.COLON, 0); }
		public TerminalNode ID() { return getToken(JavythonParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(JavythonParser.SEMICOLON, 0); }
		public DecIdsContext decIds() {
			return getRuleContext(DecIdsContext.class,0);
		}
		public BlocoMainContext blocoMain() {
			return getRuleContext(BlocoMainContext.class,0);
		}
		public TerminalNode END() { return getToken(JavythonParser.END, 0); }
		public List<MetodoContext> metodo() {
			return getRuleContexts(MetodoContext.class);
		}
		public MetodoContext metodo(int i) {
			return getRuleContext(MetodoContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(PROGRAM);
			setState(41);
			match(COLON);
			setState(42);
			match(ID);
			setState(43);
			match(SEMICOLON);
			setState(44);
			decIds();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 253952L) != 0)) {
				{
				{
				setState(45);
				metodo();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			blocoMain();
			setState(52);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecIdsContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(JavythonParser.COLON, 0); }
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(JavythonParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(JavythonParser.SEMICOLON, i);
		}
		public DecIdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decIds; }
	}

	public final DecIdsContext decIds() throws RecognitionException {
		DecIdsContext _localctx = new DecIdsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decIds);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__0);
			setState(55);
			match(COLON);
			setState(59); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(56);
					declaracao();
					setState(57);
					match(SEMICOLON);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(61); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoContext extends ParserRuleContext {
		public ListaIdsContext listaIds() {
			return getRuleContext(ListaIdsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(JavythonParser.COLON, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavythonParser.ASSIGN, 0); }
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public TerminalNode ID() { return getToken(JavythonParser.ID, 0); }
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		int _la;
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				listaIds();
				setState(64);
				match(COLON);
				setState(65);
				tipo();
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(66);
					match(ASSIGN);
					setState(67);
					valor();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(ID);
				setState(71);
				match(ASSIGN);
				setState(72);
				valor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListaIdsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(JavythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JavythonParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavythonParser.COMMA, i);
		}
		public ListaIdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaIds; }
	}

	public final ListaIdsContext listaIds() throws RecognitionException {
		ListaIdsContext _localctx = new ListaIdsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_listaIds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(ID);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(76);
				match(COMMA);
				setState(77);
				match(ID);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT_TYPE() { return getToken(JavythonParser.INT_TYPE, 0); }
		public TerminalNode REAL_TYPE() { return getToken(JavythonParser.REAL_TYPE, 0); }
		public TerminalNode STR_TYPE() { return getToken(JavythonParser.STR_TYPE, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(JavythonParser.BOOL_TYPE, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValorContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(JavythonParser.INT, 0); }
		public TerminalNode REAL() { return getToken(JavythonParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(JavythonParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(JavythonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(JavythonParser.FALSE, 0); }
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_valor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3848291483648L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MetodoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JavythonParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(JavythonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavythonParser.RPAREN, 0); }
		public BlocoMetodoContext blocoMetodo() {
			return getRuleContext(BlocoMetodoContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode VOID() { return getToken(JavythonParser.VOID, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public MetodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metodo; }
	}

	public final MetodoContext metodo() throws RecognitionException {
		MetodoContext _localctx = new MetodoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_metodo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL_TYPE:
			case INT_TYPE:
			case REAL_TYPE:
			case STR_TYPE:
				{
				setState(87);
				tipo();
				}
				break;
			case VOID:
				{
				setState(88);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(91);
			match(ID);
			setState(92);
			match(LPAREN);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) {
				{
				setState(93);
				parametros();
				}
			}

			setState(96);
			match(RPAREN);
			setState(97);
			blocoMetodo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavythonParser.COMMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			parametro();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(100);
				match(COMMA);
				setState(101);
				parametro();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(JavythonParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			tipo();
			setState(108);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoMetodoContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(JavythonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavythonParser.RBRACE, 0); }
		public DecIdsContext decIds() {
			return getRuleContext(DecIdsContext.class,0);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public BlocoMetodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocoMetodo; }
	}

	public final BlocoMetodoContext blocoMetodo() throws RecognitionException {
		BlocoMetodoContext _localctx = new BlocoMetodoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blocoMetodo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(LBRACE);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(111);
				decIds();
				}
			}

			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8252782550496L) != 0)) {
				{
				{
				setState(114);
				comando();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoMainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(JavythonParser.MAIN, 0); }
		public TerminalNode COLON() { return getToken(JavythonParser.COLON, 0); }
		public DecIdsContext decIds() {
			return getRuleContext(DecIdsContext.class,0);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public BlocoMainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocoMain; }
	}

	public final BlocoMainContext blocoMain() throws RecognitionException {
		BlocoMainContext _localctx = new BlocoMainContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_blocoMain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(MAIN);
			setState(123);
			match(COLON);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(124);
				decIds();
				}
			}

			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8252782550496L) != 0)) {
				{
				{
				setState(127);
				comando();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(JavythonParser.SEMICOLON, 0); }
		public ChamadaMetodoContext chamadaMetodo() {
			return getRuleContext(ChamadaMetodoContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public IoContext io() {
			return getRuleContext(IoContext.class,0);
		}
		public IfElseContext ifElse() {
			return getRuleContext(IfElseContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(JavythonParser.RETURN, 0); }
		public TerminalNode BREAK() { return getToken(JavythonParser.BREAK, 0); }
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comando);
		int _la;
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				atribuicao();
				setState(134);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				chamadaMetodo();
				setState(137);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				expressao(0);
				setState(140);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				io();
				setState(143);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(145);
				ifElse();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(146);
				whileLoop();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				forLoop();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(148);
				match(RETURN);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8252782542848L) != 0)) {
					{
					setState(149);
					expressao(0);
					}
				}

				setState(152);
				match(SEMICOLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(153);
				match(BREAK);
				setState(154);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtribuicaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JavythonParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(JavythonParser.ASSIGN, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(ID);
			setState(158);
			match(ASSIGN);
			setState(159);
			expressao(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoContext extends ParserRuleContext {
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
	 
		public ExpressaoContext() { }
		public void copyFrom(ExpressaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnariaExprContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode SUB() { return getToken(JavythonParser.SUB, 0); }
		public TerminalNode NOT() { return getToken(JavythonParser.NOT, 0); }
		public UnariaExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultdivExprContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode MUL() { return getToken(JavythonParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(JavythonParser.DIV, 0); }
		public MultdivExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValorExprContext extends ExpressaoContext {
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public ValorExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddsubExprContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode ADD() { return getToken(JavythonParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(JavythonParser.SUB, 0); }
		public AddsubExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExprContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode INC() { return getToken(JavythonParser.INC, 0); }
		public TerminalNode DEC() { return getToken(JavythonParser.DEC, 0); }
		public PostfixExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChamadaExprContext extends ExpressaoContext {
		public ChamadaMetodoContext chamadaMetodo() {
			return getRuleContext(ChamadaMetodoContext.class,0);
		}
		public ChamadaExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelacionalExprContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode EQ() { return getToken(JavythonParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(JavythonParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(JavythonParser.GT, 0); }
		public TerminalNode LT() { return getToken(JavythonParser.LT, 0); }
		public RelacionalExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExpressaoContext {
		public TerminalNode LPAREN() { return getToken(JavythonParser.LPAREN, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavythonParser.RPAREN, 0); }
		public ParenExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExpressaoContext {
		public TerminalNode ID() { return getToken(JavythonParser.ID, 0); }
		public IdExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		return expressao(0);
	}

	private ExpressaoContext expressao(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, _parentState);
		ExpressaoContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expressao, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new UnariaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(162);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(163);
				expressao(9);
				}
				break;
			case 2:
				{
				_localctx = new ChamadaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				chamadaMetodo();
				}
				break;
			case 3:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new ValorExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				valor();
				}
				break;
			case 5:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(LPAREN);
				setState(168);
				expressao(0);
				setState(169);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(184);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MultdivExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(173);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(174);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(175);
						expressao(5);
						}
						break;
					case 2:
						{
						_localctx = new AddsubExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(176);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(177);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(178);
						expressao(4);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(179);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(180);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2013265920L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(181);
						expressao(3);
						}
						break;
					case 4:
						{
						_localctx = new PostfixExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(182);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(183);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChamadaMetodoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JavythonParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(JavythonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavythonParser.RPAREN, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ChamadaMetodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamadaMetodo; }
	}

	public final ChamadaMetodoContext chamadaMetodo() throws RecognitionException {
		ChamadaMetodoContext _localctx = new ChamadaMetodoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_chamadaMetodo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(ID);
			setState(190);
			match(LPAREN);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8252782542848L) != 0)) {
				{
				setState(191);
				argumentos();
				}
			}

			setState(194);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavythonParser.COMMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			expressao(0);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(197);
				match(COMMA);
				setState(198);
				expressao(0);
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfElseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(JavythonParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(JavythonParser.LPAREN, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavythonParser.RPAREN, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(JavythonParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(JavythonParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(JavythonParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(JavythonParser.RBRACE, i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(JavythonParser.ELSE, 0); }
		public IfElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElse; }
	}

	public final IfElseContext ifElse() throws RecognitionException {
		IfElseContext _localctx = new IfElseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifElse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(IF);
			setState(205);
			match(LPAREN);
			setState(206);
			expressao(0);
			setState(207);
			match(RPAREN);
			setState(208);
			match(LBRACE);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8252782550496L) != 0)) {
				{
				{
				setState(209);
				comando();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			match(RBRACE);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(216);
				match(ELSE);
				setState(217);
				match(LBRACE);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8252782550496L) != 0)) {
					{
					{
					setState(218);
					comando();
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(224);
				match(RBRACE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(JavythonParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(JavythonParser.LPAREN, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavythonParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(JavythonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavythonParser.RBRACE, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(WHILE);
			setState(228);
			match(LPAREN);
			setState(229);
			expressao(0);
			setState(230);
			match(RPAREN);
			setState(231);
			match(LBRACE);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8252782550496L) != 0)) {
				{
				{
				setState(232);
				comando();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(JavythonParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(JavythonParser.LPAREN, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(JavythonParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(JavythonParser.SEMICOLON, i);
		}
		public TerminalNode RPAREN() { return getToken(JavythonParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(JavythonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavythonParser.RBRACE, 0); }
		public List<AtribuicaoContext> atribuicao() {
			return getRuleContexts(AtribuicaoContext.class);
		}
		public AtribuicaoContext atribuicao(int i) {
			return getRuleContext(AtribuicaoContext.class,i);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(FOR);
			setState(241);
			match(LPAREN);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(242);
				atribuicao();
				}
			}

			setState(245);
			match(SEMICOLON);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8252782542848L) != 0)) {
				{
				setState(246);
				expressao(0);
				}
			}

			setState(249);
			match(SEMICOLON);
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(250);
				expressao(0);
				}
				break;
			case 2:
				{
				setState(251);
				atribuicao();
				}
				break;
			}
			setState(254);
			match(RPAREN);
			setState(255);
			match(LBRACE);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8252782550496L) != 0)) {
				{
				{
				setState(256);
				comando();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(262);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IoContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(JavythonParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(JavythonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavythonParser.RPAREN, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode INPUT() { return getToken(JavythonParser.INPUT, 0); }
		public ListaIdsContext listaIds() {
			return getRuleContext(ListaIdsContext.class,0);
		}
		public IoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_io; }
	}

	public final IoContext io() throws RecognitionException {
		IoContext _localctx = new IoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_io);
		int _la;
		try {
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(PRINT);
				setState(265);
				match(LPAREN);
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8252782542848L) != 0)) {
					{
					setState(266);
					argumentos();
					}
				}

				setState(269);
				match(RPAREN);
				}
				break;
			case INPUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				match(INPUT);
				setState(271);
				match(LPAREN);
				setState(272);
				listaIds();
				setState(273);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expressao_sempred((ExpressaoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u0116\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000/\b\u0000\n\u0000\f\u00002\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0004\u0001<\b\u0001\u000b\u0001\f\u0001=\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002E\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002J\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003O\b\u0003\n\u0003\f\u0003R\t"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0003\u0006Z\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006_\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007g\b\u0007\n\u0007\f\u0007j\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\tq\b\t\u0001\t\u0005\tt\b\t\n"+
		"\t\f\tw\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n~\b\n\u0001"+
		"\n\u0005\n\u0081\b\n\n\n\f\n\u0084\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u0097\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u009c\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00ac\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00b9\b\r\n\r\f\r\u00bc"+
		"\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00c1\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00c8"+
		"\b\u000f\n\u000f\f\u000f\u00cb\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00d3\b\u0010\n\u0010"+
		"\f\u0010\u00d6\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u00dc\b\u0010\n\u0010\f\u0010\u00df\t\u0010\u0001\u0010\u0003"+
		"\u0010\u00e2\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u00ea\b\u0011\n\u0011\f\u0011\u00ed\t\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00f4\b\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00f8\b\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00fd\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u0102\b\u0012\n\u0012\f\u0012\u0105\t\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u010c\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u0114\b\u0013\u0001\u0013\u0000\u0001\u001a\u0014"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&\u0000\u0007\u0001\u0000\u000e\u0011\u0002\u0000\u0012"+
		"\u0013\')\u0002\u0000\u0015\u0015\u001f\u001f\u0001\u0000\u0016\u0017"+
		"\u0001\u0000\u0014\u0015\u0001\u0000\u001b\u001e\u0001\u0000\u0018\u0019"+
		"\u012b\u0000(\u0001\u0000\u0000\u0000\u00026\u0001\u0000\u0000\u0000\u0004"+
		"I\u0001\u0000\u0000\u0000\u0006K\u0001\u0000\u0000\u0000\bS\u0001\u0000"+
		"\u0000\u0000\nU\u0001\u0000\u0000\u0000\fY\u0001\u0000\u0000\u0000\u000e"+
		"c\u0001\u0000\u0000\u0000\u0010k\u0001\u0000\u0000\u0000\u0012n\u0001"+
		"\u0000\u0000\u0000\u0014z\u0001\u0000\u0000\u0000\u0016\u009b\u0001\u0000"+
		"\u0000\u0000\u0018\u009d\u0001\u0000\u0000\u0000\u001a\u00ab\u0001\u0000"+
		"\u0000\u0000\u001c\u00bd\u0001\u0000\u0000\u0000\u001e\u00c4\u0001\u0000"+
		"\u0000\u0000 \u00cc\u0001\u0000\u0000\u0000\"\u00e3\u0001\u0000\u0000"+
		"\u0000$\u00f0\u0001\u0000\u0000\u0000&\u0113\u0001\u0000\u0000\u0000("+
		")\u0005\u0002\u0000\u0000)*\u0005$\u0000\u0000*+\u0005*\u0000\u0000+,"+
		"\u0005%\u0000\u0000,0\u0003\u0002\u0001\u0000-/\u0003\f\u0006\u0000.-"+
		"\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u000020\u0001\u0000"+
		"\u0000\u000034\u0003\u0014\n\u000045\u0005\u0004\u0000\u00005\u0001\u0001"+
		"\u0000\u0000\u000067\u0005\u0001\u0000\u00007;\u0005$\u0000\u000089\u0003"+
		"\u0004\u0002\u00009:\u0005%\u0000\u0000:<\u0001\u0000\u0000\u0000;8\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000>\u0003\u0001\u0000\u0000\u0000?@\u0003\u0006"+
		"\u0003\u0000@A\u0005$\u0000\u0000AD\u0003\b\u0004\u0000BC\u0005\u001a"+
		"\u0000\u0000CE\u0003\n\u0005\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000"+
		"\u0000\u0000EJ\u0001\u0000\u0000\u0000FG\u0005*\u0000\u0000GH\u0005\u001a"+
		"\u0000\u0000HJ\u0003\n\u0005\u0000I?\u0001\u0000\u0000\u0000IF\u0001\u0000"+
		"\u0000\u0000J\u0005\u0001\u0000\u0000\u0000KP\u0005*\u0000\u0000LM\u0005"+
		"&\u0000\u0000MO\u0005*\u0000\u0000NL\u0001\u0000\u0000\u0000OR\u0001\u0000"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000Q\u0007"+
		"\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000ST\u0007\u0000\u0000"+
		"\u0000T\t\u0001\u0000\u0000\u0000UV\u0007\u0001\u0000\u0000V\u000b\u0001"+
		"\u0000\u0000\u0000WZ\u0003\b\u0004\u0000XZ\u0005\r\u0000\u0000YW\u0001"+
		"\u0000\u0000\u0000YX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000"+
		"[\\\u0005*\u0000\u0000\\^\u0005 \u0000\u0000]_\u0003\u000e\u0007\u0000"+
		"^]\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000"+
		"\u0000`a\u0005!\u0000\u0000ab\u0003\u0012\t\u0000b\r\u0001\u0000\u0000"+
		"\u0000ch\u0003\u0010\b\u0000de\u0005&\u0000\u0000eg\u0003\u0010\b\u0000"+
		"fd\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000hi\u0001\u0000\u0000\u0000i\u000f\u0001\u0000\u0000\u0000jh\u0001"+
		"\u0000\u0000\u0000kl\u0003\b\u0004\u0000lm\u0005*\u0000\u0000m\u0011\u0001"+
		"\u0000\u0000\u0000np\u0005\"\u0000\u0000oq\u0003\u0002\u0001\u0000po\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qu\u0001\u0000\u0000\u0000"+
		"rt\u0003\u0016\u000b\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000"+
		"\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000xy\u0005#\u0000\u0000y\u0013\u0001"+
		"\u0000\u0000\u0000z{\u0005\u0003\u0000\u0000{}\u0005$\u0000\u0000|~\u0003"+
		"\u0002\u0001\u0000}|\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u0082\u0001\u0000\u0000\u0000\u007f\u0081\u0003\u0016\u000b\u0000\u0080"+
		"\u007f\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083"+
		"\u0015\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0003\u0018\f\u0000\u0086\u0087\u0005%\u0000\u0000\u0087\u009c"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0003\u001c\u000e\u0000\u0089\u008a"+
		"\u0005%\u0000\u0000\u008a\u009c\u0001\u0000\u0000\u0000\u008b\u008c\u0003"+
		"\u001a\r\u0000\u008c\u008d\u0005%\u0000\u0000\u008d\u009c\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0003&\u0013\u0000\u008f\u0090\u0005%\u0000\u0000"+
		"\u0090\u009c\u0001\u0000\u0000\u0000\u0091\u009c\u0003 \u0010\u0000\u0092"+
		"\u009c\u0003\"\u0011\u0000\u0093\u009c\u0003$\u0012\u0000\u0094\u0096"+
		"\u0005\u0005\u0000\u0000\u0095\u0097\u0003\u001a\r\u0000\u0096\u0095\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0001"+
		"\u0000\u0000\u0000\u0098\u009c\u0005%\u0000\u0000\u0099\u009a\u0005\f"+
		"\u0000\u0000\u009a\u009c\u0005%\u0000\u0000\u009b\u0085\u0001\u0000\u0000"+
		"\u0000\u009b\u0088\u0001\u0000\u0000\u0000\u009b\u008b\u0001\u0000\u0000"+
		"\u0000\u009b\u008e\u0001\u0000\u0000\u0000\u009b\u0091\u0001\u0000\u0000"+
		"\u0000\u009b\u0092\u0001\u0000\u0000\u0000\u009b\u0093\u0001\u0000\u0000"+
		"\u0000\u009b\u0094\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000"+
		"\u0000\u009c\u0017\u0001\u0000\u0000\u0000\u009d\u009e\u0005*\u0000\u0000"+
		"\u009e\u009f\u0005\u001a\u0000\u0000\u009f\u00a0\u0003\u001a\r\u0000\u00a0"+
		"\u0019\u0001\u0000\u0000\u0000\u00a1\u00a2\u0006\r\uffff\uffff\u0000\u00a2"+
		"\u00a3\u0007\u0002\u0000\u0000\u00a3\u00ac\u0003\u001a\r\t\u00a4\u00ac"+
		"\u0003\u001c\u000e\u0000\u00a5\u00ac\u0005*\u0000\u0000\u00a6\u00ac\u0003"+
		"\n\u0005\u0000\u00a7\u00a8\u0005 \u0000\u0000\u00a8\u00a9\u0003\u001a"+
		"\r\u0000\u00a9\u00aa\u0005!\u0000\u0000\u00aa\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ab\u00a1\u0001\u0000\u0000\u0000\u00ab\u00a4\u0001\u0000\u0000"+
		"\u0000\u00ab\u00a5\u0001\u0000\u0000\u0000\u00ab\u00a6\u0001\u0000\u0000"+
		"\u0000\u00ab\u00a7\u0001\u0000\u0000\u0000\u00ac\u00ba\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\n\u0004\u0000\u0000\u00ae\u00af\u0007\u0003\u0000\u0000"+
		"\u00af\u00b9\u0003\u001a\r\u0005\u00b0\u00b1\n\u0003\u0000\u0000\u00b1"+
		"\u00b2\u0007\u0004\u0000\u0000\u00b2\u00b9\u0003\u001a\r\u0004\u00b3\u00b4"+
		"\n\u0002\u0000\u0000\u00b4\u00b5\u0007\u0005\u0000\u0000\u00b5\u00b9\u0003"+
		"\u001a\r\u0003\u00b6\u00b7\n\u0001\u0000\u0000\u00b7\u00b9\u0007\u0006"+
		"\u0000\u0000\u00b8\u00ad\u0001\u0000\u0000\u0000\u00b8\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b3\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u001b\u0001\u0000"+
		"\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00be\u0005*\u0000"+
		"\u0000\u00be\u00c0\u0005 \u0000\u0000\u00bf\u00c1\u0003\u001e\u000f\u0000"+
		"\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005!\u0000\u0000\u00c3"+
		"\u001d\u0001\u0000\u0000\u0000\u00c4\u00c9\u0003\u001a\r\u0000\u00c5\u00c6"+
		"\u0005&\u0000\u0000\u00c6\u00c8\u0003\u001a\r\u0000\u00c7\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u001f\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"\b\u0000\u0000\u00cd\u00ce\u0005 \u0000\u0000\u00ce\u00cf\u0003\u001a"+
		"\r\u0000\u00cf\u00d0\u0005!\u0000\u0000\u00d0\u00d4\u0005\"\u0000\u0000"+
		"\u00d1\u00d3\u0003\u0016\u000b\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00e1\u0005#\u0000\u0000\u00d8"+
		"\u00d9\u0005\t\u0000\u0000\u00d9\u00dd\u0005\"\u0000\u0000\u00da\u00dc"+
		"\u0003\u0016\u000b\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u00df"+
		"\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0001\u0000\u0000\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00dd"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e2\u0005#\u0000\u0000\u00e1\u00d8\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2!\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e4\u0005\n\u0000\u0000\u00e4\u00e5\u0005 \u0000"+
		"\u0000\u00e5\u00e6\u0003\u001a\r\u0000\u00e6\u00e7\u0005!\u0000\u0000"+
		"\u00e7\u00eb\u0005\"\u0000\u0000\u00e8\u00ea\u0003\u0016\u000b\u0000\u00e9"+
		"\u00e8\u0001\u0000\u0000\u0000\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb"+
		"\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ee\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\u0005#\u0000\u0000\u00ef#\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005"+
		"\u000b\u0000\u0000\u00f1\u00f3\u0005 \u0000\u0000\u00f2\u00f4\u0003\u0018"+
		"\f\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f7\u0005%\u0000\u0000"+
		"\u00f6\u00f8\u0003\u001a\r\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f8\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fc\u0005%\u0000\u0000\u00fa\u00fd\u0003\u001a\r\u0000\u00fb\u00fd"+
		"\u0003\u0018\f\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001"+
		"\u0000\u0000\u0000\u00fe\u00ff\u0005!\u0000\u0000\u00ff\u0103\u0005\""+
		"\u0000\u0000\u0100\u0102\u0003\u0016\u000b\u0000\u0101\u0100\u0001\u0000"+
		"\u0000\u0000\u0102\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0106\u0001\u0000"+
		"\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0106\u0107\u0005#\u0000"+
		"\u0000\u0107%\u0001\u0000\u0000\u0000\u0108\u0109\u0005\u0006\u0000\u0000"+
		"\u0109\u010b\u0005 \u0000\u0000\u010a\u010c\u0003\u001e\u000f\u0000\u010b"+
		"\u010a\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c"+
		"\u010d\u0001\u0000\u0000\u0000\u010d\u0114\u0005!\u0000\u0000\u010e\u010f"+
		"\u0005\u0007\u0000\u0000\u010f\u0110\u0005 \u0000\u0000\u0110\u0111\u0003"+
		"\u0006\u0003\u0000\u0111\u0112\u0005!\u0000\u0000\u0112\u0114\u0001\u0000"+
		"\u0000\u0000\u0113\u0108\u0001\u0000\u0000\u0000\u0113\u010e\u0001\u0000"+
		"\u0000\u0000\u0114\'\u0001\u0000\u0000\u0000\u001d0=DIPY^hpu}\u0082\u0096"+
		"\u009b\u00ab\u00b8\u00ba\u00c0\u00c9\u00d4\u00dd\u00e1\u00eb\u00f3\u00f7"+
		"\u00fc\u0103\u010b\u0113";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}