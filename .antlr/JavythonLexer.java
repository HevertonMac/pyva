// Generated from c:/Users/gutop/Downloads/Trab_Final +corre��es/Trab_Final/Javython.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JavythonLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "PROGRAM", "MAIN", "END", "RETURN", "PRINT", "INPUT", "IF", "ELSE", 
			"WHILE", "FOR", "BREAK", "VOID", "BOOL_TYPE", "INT_TYPE", "REAL_TYPE", 
			"STR_TYPE", "TRUE", "FALSE", "ADD", "SUB", "MUL", "DIV", "INC", "DEC", 
			"ASSIGN", "EQ", "NEQ", "GT", "LT", "NOT", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "COLON", "SEMICOLON", "COMMA", "STRING", "REAL", "INT", "ID", 
			"WS", "LINE_COMMENT"
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


	public JavythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Javython.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000,\u011a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0005"+
		"&\u00eb\b&\n&\f&\u00ee\t&\u0001&\u0001&\u0001\'\u0004\'\u00f3\b\'\u000b"+
		"\'\f\'\u00f4\u0001\'\u0001\'\u0004\'\u00f9\b\'\u000b\'\f\'\u00fa\u0001"+
		"(\u0004(\u00fe\b(\u000b(\f(\u00ff\u0001)\u0001)\u0005)\u0104\b)\n)\f)"+
		"\u0107\t)\u0001*\u0004*\u010a\b*\u000b*\f*\u010b\u0001*\u0001*\u0001+"+
		"\u0001+\u0001+\u0001+\u0005+\u0114\b+\n+\f+\u0117\t+\u0001+\u0001+\u0000"+
		"\u0000,\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\""+
		"E#G$I%K&M\'O(Q)S*U+W,\u0001\u0000\u001b\u0002\u0000DDdd\u0002\u0000EE"+
		"ee\u0002\u0000CCcc\u0002\u0000IIii\u0002\u0000SSss\u0002\u0000PPpp\u0002"+
		"\u0000RRrr\u0002\u0000OOoo\u0002\u0000GGgg\u0002\u0000AAaa\u0002\u0000"+
		"MMmm\u0002\u0000NNnn\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000FFff\u0002"+
		"\u0000LLll\u0002\u0000WWww\u0002\u0000HHhh\u0002\u0000BBbb\u0002\u0000"+
		"KKkk\u0002\u0000VVvv\u0001\u0000\"\"\u0001\u000009\u0003\u0000AZ__az\u0004"+
		"\u000009AZ__az\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u0120\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000"+
		"\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u0000"+
		"5\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001"+
		"\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000"+
		"\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000"+
		"C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001"+
		"\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000"+
		"\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000"+
		"Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001"+
		"\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0001Y\u0001\u0000\u0000"+
		"\u0000\u0003`\u0001\u0000\u0000\u0000\u0005h\u0001\u0000\u0000\u0000\u0007"+
		"m\u0001\u0000\u0000\u0000\tq\u0001\u0000\u0000\u0000\u000bx\u0001\u0000"+
		"\u0000\u0000\r~\u0001\u0000\u0000\u0000\u000f\u0084\u0001\u0000\u0000"+
		"\u0000\u0011\u0087\u0001\u0000\u0000\u0000\u0013\u008c\u0001\u0000\u0000"+
		"\u0000\u0015\u0092\u0001\u0000\u0000\u0000\u0017\u0096\u0001\u0000\u0000"+
		"\u0000\u0019\u009c\u0001\u0000\u0000\u0000\u001b\u00a1\u0001\u0000\u0000"+
		"\u0000\u001d\u00a6\u0001\u0000\u0000\u0000\u001f\u00aa\u0001\u0000\u0000"+
		"\u0000!\u00af\u0001\u0000\u0000\u0000#\u00b3\u0001\u0000\u0000\u0000%"+
		"\u00b8\u0001\u0000\u0000\u0000\'\u00be\u0001\u0000\u0000\u0000)\u00c0"+
		"\u0001\u0000\u0000\u0000+\u00c2\u0001\u0000\u0000\u0000-\u00c4\u0001\u0000"+
		"\u0000\u0000/\u00c6\u0001\u0000\u0000\u00001\u00c9\u0001\u0000\u0000\u0000"+
		"3\u00cc\u0001\u0000\u0000\u00005\u00ce\u0001\u0000\u0000\u00007\u00d1"+
		"\u0001\u0000\u0000\u00009\u00d4\u0001\u0000\u0000\u0000;\u00d6\u0001\u0000"+
		"\u0000\u0000=\u00d8\u0001\u0000\u0000\u0000?\u00da\u0001\u0000\u0000\u0000"+
		"A\u00dc\u0001\u0000\u0000\u0000C\u00de\u0001\u0000\u0000\u0000E\u00e0"+
		"\u0001\u0000\u0000\u0000G\u00e2\u0001\u0000\u0000\u0000I\u00e4\u0001\u0000"+
		"\u0000\u0000K\u00e6\u0001\u0000\u0000\u0000M\u00e8\u0001\u0000\u0000\u0000"+
		"O\u00f2\u0001\u0000\u0000\u0000Q\u00fd\u0001\u0000\u0000\u0000S\u0101"+
		"\u0001\u0000\u0000\u0000U\u0109\u0001\u0000\u0000\u0000W\u010f\u0001\u0000"+
		"\u0000\u0000YZ\u0007\u0000\u0000\u0000Z[\u0007\u0001\u0000\u0000[\\\u0007"+
		"\u0002\u0000\u0000\\]\u0007\u0003\u0000\u0000]^\u0007\u0000\u0000\u0000"+
		"^_\u0007\u0004\u0000\u0000_\u0002\u0001\u0000\u0000\u0000`a\u0007\u0005"+
		"\u0000\u0000ab\u0007\u0006\u0000\u0000bc\u0007\u0007\u0000\u0000cd\u0007"+
		"\b\u0000\u0000de\u0007\u0006\u0000\u0000ef\u0007\t\u0000\u0000fg\u0007"+
		"\n\u0000\u0000g\u0004\u0001\u0000\u0000\u0000hi\u0007\n\u0000\u0000ij"+
		"\u0007\t\u0000\u0000jk\u0007\u0003\u0000\u0000kl\u0007\u000b\u0000\u0000"+
		"l\u0006\u0001\u0000\u0000\u0000mn\u0007\u0001\u0000\u0000no\u0007\u000b"+
		"\u0000\u0000op\u0007\u0000\u0000\u0000p\b\u0001\u0000\u0000\u0000qr\u0007"+
		"\u0006\u0000\u0000rs\u0007\u0001\u0000\u0000st\u0007\f\u0000\u0000tu\u0007"+
		"\r\u0000\u0000uv\u0007\u0006\u0000\u0000vw\u0007\u000b\u0000\u0000w\n"+
		"\u0001\u0000\u0000\u0000xy\u0007\u0005\u0000\u0000yz\u0007\u0006\u0000"+
		"\u0000z{\u0007\u0003\u0000\u0000{|\u0007\u000b\u0000\u0000|}\u0007\f\u0000"+
		"\u0000}\f\u0001\u0000\u0000\u0000~\u007f\u0007\u0003\u0000\u0000\u007f"+
		"\u0080\u0007\u000b\u0000\u0000\u0080\u0081\u0007\u0005\u0000\u0000\u0081"+
		"\u0082\u0007\r\u0000\u0000\u0082\u0083\u0007\f\u0000\u0000\u0083\u000e"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0007\u0003\u0000\u0000\u0085\u0086"+
		"\u0007\u000e\u0000\u0000\u0086\u0010\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0007\u0001\u0000\u0000\u0088\u0089\u0007\u000f\u0000\u0000\u0089\u008a"+
		"\u0007\u0004\u0000\u0000\u008a\u008b\u0007\u0001\u0000\u0000\u008b\u0012"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0007\u0010\u0000\u0000\u008d\u008e"+
		"\u0007\u0011\u0000\u0000\u008e\u008f\u0007\u0003\u0000\u0000\u008f\u0090"+
		"\u0007\u000f\u0000\u0000\u0090\u0091\u0007\u0001\u0000\u0000\u0091\u0014"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0007\u000e\u0000\u0000\u0093\u0094"+
		"\u0007\u0007\u0000\u0000\u0094\u0095\u0007\u0006\u0000\u0000\u0095\u0016"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0007\u0012\u0000\u0000\u0097\u0098"+
		"\u0007\u0006\u0000\u0000\u0098\u0099\u0007\u0001\u0000\u0000\u0099\u009a"+
		"\u0007\t\u0000\u0000\u009a\u009b\u0007\u0013\u0000\u0000\u009b\u0018\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0007\u0014\u0000\u0000\u009d\u009e\u0007"+
		"\u0007\u0000\u0000\u009e\u009f\u0007\u0003\u0000\u0000\u009f\u00a0\u0007"+
		"\u0000\u0000\u0000\u00a0\u001a\u0001\u0000\u0000\u0000\u00a1\u00a2\u0007"+
		"\u0012\u0000\u0000\u00a2\u00a3\u0007\u0007\u0000\u0000\u00a3\u00a4\u0007"+
		"\u0007\u0000\u0000\u00a4\u00a5\u0007\u000f\u0000\u0000\u00a5\u001c\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0007\u0003\u0000\u0000\u00a7\u00a8\u0007"+
		"\u000b\u0000\u0000\u00a8\u00a9\u0007\f\u0000\u0000\u00a9\u001e\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0007\u0006\u0000\u0000\u00ab\u00ac\u0007\u0001"+
		"\u0000\u0000\u00ac\u00ad\u0007\t\u0000\u0000\u00ad\u00ae\u0007\u000f\u0000"+
		"\u0000\u00ae \u0001\u0000\u0000\u0000\u00af\u00b0\u0007\u0004\u0000\u0000"+
		"\u00b0\u00b1\u0007\f\u0000\u0000\u00b1\u00b2\u0007\u0006\u0000\u0000\u00b2"+
		"\"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0007\f\u0000\u0000\u00b4\u00b5"+
		"\u0007\u0006\u0000\u0000\u00b5\u00b6\u0007\r\u0000\u0000\u00b6\u00b7\u0007"+
		"\u0001\u0000\u0000\u00b7$\u0001\u0000\u0000\u0000\u00b8\u00b9\u0007\u000e"+
		"\u0000\u0000\u00b9\u00ba\u0007\t\u0000\u0000\u00ba\u00bb\u0007\u000f\u0000"+
		"\u0000\u00bb\u00bc\u0007\u0004\u0000\u0000\u00bc\u00bd\u0007\u0001\u0000"+
		"\u0000\u00bd&\u0001\u0000\u0000\u0000\u00be\u00bf\u0005+\u0000\u0000\u00bf"+
		"(\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005-\u0000\u0000\u00c1*\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0005*\u0000\u0000\u00c3,\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c5\u0005/\u0000\u0000\u00c5.\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0005+\u0000\u0000\u00c7\u00c8\u0005+\u0000\u0000\u00c80\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0005-\u0000\u0000\u00ca\u00cb\u0005-\u0000"+
		"\u0000\u00cb2\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005=\u0000\u0000\u00cd"+
		"4\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005=\u0000\u0000\u00cf\u00d0\u0005"+
		"=\u0000\u0000\u00d06\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005!\u0000"+
		"\u0000\u00d2\u00d3\u0005=\u0000\u0000\u00d38\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d5\u0005>\u0000\u0000\u00d5:\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005"+
		"<\u0000\u0000\u00d7<\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005!\u0000"+
		"\u0000\u00d9>\u0001\u0000\u0000\u0000\u00da\u00db\u0005(\u0000\u0000\u00db"+
		"@\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005)\u0000\u0000\u00ddB\u0001"+
		"\u0000\u0000\u0000\u00de\u00df\u0005{\u0000\u0000\u00dfD\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e1\u0005}\u0000\u0000\u00e1F\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0005:\u0000\u0000\u00e3H\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005"+
		";\u0000\u0000\u00e5J\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005,\u0000"+
		"\u0000\u00e7L\u0001\u0000\u0000\u0000\u00e8\u00ec\u0005\"\u0000\u0000"+
		"\u00e9\u00eb\b\u0015\u0000\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\"\u0000\u0000\u00f0N"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f3\u0007\u0016\u0000\u0000\u00f2\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f8\u0005.\u0000\u0000\u00f7\u00f9\u0007"+
		"\u0016\u0000\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fbP\u0001\u0000\u0000\u0000\u00fc\u00fe\u0007\u0016"+
		"\u0000\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000"+
		"\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000"+
		"\u0000\u0000\u0100R\u0001\u0000\u0000\u0000\u0101\u0105\u0007\u0017\u0000"+
		"\u0000\u0102\u0104\u0007\u0018\u0000\u0000\u0103\u0102\u0001\u0000\u0000"+
		"\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000"+
		"\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106T\u0001\u0000\u0000\u0000"+
		"\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u010a\u0007\u0019\u0000\u0000"+
		"\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000"+
		"\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000"+
		"\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010e\u0006*\u0000\u0000\u010e"+
		"V\u0001\u0000\u0000\u0000\u010f\u0110\u0005/\u0000\u0000\u0110\u0111\u0005"+
		"/\u0000\u0000\u0111\u0115\u0001\u0000\u0000\u0000\u0112\u0114\b\u001a"+
		"\u0000\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000"+
		"\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000"+
		"\u0000\u0000\u0116\u0118\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000"+
		"\u0000\u0000\u0118\u0119\u0006+\u0000\u0000\u0119X\u0001\u0000\u0000\u0000"+
		"\b\u0000\u00ec\u00f4\u00fa\u00ff\u0105\u010b\u0115\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}