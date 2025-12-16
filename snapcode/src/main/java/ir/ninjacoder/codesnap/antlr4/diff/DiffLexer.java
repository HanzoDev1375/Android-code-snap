// Generated from /storage/emulated/0/apk/DiffLexer.g4 by ANTLR 4.13.2
package ir.ninjacoder.codesnap.antlr4.diff;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({
  "all",
  "warnings",
  "unchecked",
  "unused",
  "cast",
  "CheckReturnValue",
  "this-escape"
})
public class DiffLexer extends Lexer {
  static {
    RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int DIFF = 1,
      INDEX = 2,
      OLD_FILE = 3,
      NEW_FILE = 4,
      HUNK_HEADER = 5,
      ADDED_LINE = 6,
      REMOVED_LINE = 7,
      CONTEXT_LINE = 8,
      NO_NEWLINE = 9,
      NEWLINE = 10,
      WS = 11;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  private static String[] makeRuleNames() {
    return new String[] {
      "DIFF", "INDEX", "OLD_FILE", "NEW_FILE", "HUNK_HEADER", "ADDED_LINE",
      "REMOVED_LINE", "CONTEXT_LINE", "NO_NEWLINE", "HEX", "INT", "FILE_PATH",
      "NEWLINE", "WS"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {};
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "DIFF",
      "INDEX",
      "OLD_FILE",
      "NEW_FILE",
      "HUNK_HEADER",
      "ADDED_LINE",
      "REMOVED_LINE",
      "CONTEXT_LINE",
      "NO_NEWLINE",
      "NEWLINE",
      "WS"
    };
  }

  private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated public static final String[] tokenNames;

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

  public DiffLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @Override
  public String getGrammarFileName() {
    return "DiffLexer.g4";
  }

  @Override
  public String[] getRuleNames() {
    return ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return _serializedATN;
  }

  @Override
  public String[] getChannelNames() {
    return channelNames;
  }

  @Override
  public String[] getModeNames() {
    return modeNames;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public static final String _serializedATN =
      "\u0004\u0000\u000b\u00a5\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"
          + "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"
          + "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"
          + "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"
          + "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000"
          + "\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"
          + "\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"
          + "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"
          + "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"
          + "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"
          + "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"
          + "\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"
          + "\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004M\b\u0004\u0001\u0004"
          + "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004T\b\u0004"
          + "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"
          + "\u0005\u0005\\\b\u0005\n\u0005\f\u0005_\t\u0005\u0001\u0006\u0001\u0006"
          + "\u0005\u0006c\b\u0006\n\u0006\f\u0006f\t\u0006\u0001\u0007\u0001\u0007"
          + "\u0005\u0007j\b\u0007\n\u0007\f\u0007m\t\u0007\u0001\b\u0001\b\u0001\b"
          + "\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"
          + "\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"
          + "\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0004"
          + "\t\u008c\b\t\u000b\t\f\t\u008d\u0001\n\u0004\n\u0091\b\n\u000b\n\f\n\u0092"
          + "\u0001\u000b\u0004\u000b\u0096\b\u000b\u000b\u000b\f\u000b\u0097\u0001"
          + "\f\u0003\f\u009b\b\f\u0001\f\u0001\f\u0001\r\u0004\r\u00a0\b\r\u000b\r"
          + "\f\r\u00a1\u0001\r\u0001\r\u0000\u0000\u000e\u0001\u0001\u0003\u0002\u0005"
          + "\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\u0000"
          + "\u0015\u0000\u0017\u0000\u0019\n\u001b\u000b\u0001\u0000\u0004\u0002\u0000"
          + "\n\n\r\r\u0003\u000009AFaf\u0001\u000009\u0002\u0000\t\t  \u00ab\u0000"
          + "\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"
          + "\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"
          + "\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"
          + "\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"
          + "\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"
          + "\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003)\u0001"
          + "\u0000\u0000\u0000\u00056\u0001\u0000\u0000\u0000\u0007=\u0001\u0000\u0000"
          + "\u0000\tD\u0001\u0000\u0000\u0000\u000bY\u0001\u0000\u0000\u0000\r`\u0001"
          + "\u0000\u0000\u0000\u000fg\u0001\u0000\u0000\u0000\u0011n\u0001\u0000\u0000"
          + "\u0000\u0013\u008b\u0001\u0000\u0000\u0000\u0015\u0090\u0001\u0000\u0000"
          + "\u0000\u0017\u0095\u0001\u0000\u0000\u0000\u0019\u009a\u0001\u0000\u0000"
          + "\u0000\u001b\u009f\u0001\u0000\u0000\u0000\u001d\u001e\u0005d\u0000\u0000"
          + "\u001e\u001f\u0005i\u0000\u0000\u001f \u0005f\u0000\u0000 !\u0005f\u0000"
          + "\u0000!\"\u0001\u0000\u0000\u0000\"#\u0005 \u0000\u0000#$\u0005-\u0000"
          + "\u0000$%\u0005-\u0000\u0000%&\u0005g\u0000\u0000&\'\u0005i\u0000\u0000"
          + "\'(\u0005t\u0000\u0000(\u0002\u0001\u0000\u0000\u0000)*\u0005i\u0000\u0000"
          + "*+\u0005n\u0000\u0000+,\u0005d\u0000\u0000,-\u0005e\u0000\u0000-.\u0005"
          + "x\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0005 \u0000\u000001\u0003\u0013"
          + "\t\u000012\u0005.\u0000\u000023\u0005.\u0000\u000034\u0001\u0000\u0000"
          + "\u000045\u0003\u0013\t\u00005\u0004\u0001\u0000\u0000\u000067\u0005-\u0000"
          + "\u000078\u0005-\u0000\u000089\u0005-\u0000\u00009:\u0001\u0000\u0000\u0000"
          + ":;\u0005 \u0000\u0000;<\u0003\u0017\u000b\u0000<\u0006\u0001\u0000\u0000"
          + "\u0000=>\u0005+\u0000\u0000>?\u0005+\u0000\u0000?@\u0005+\u0000\u0000"
          + "@A\u0001\u0000\u0000\u0000AB\u0005 \u0000\u0000BC\u0003\u0017\u000b\u0000"
          + "C\b\u0001\u0000\u0000\u0000DE\u0005@\u0000\u0000EF\u0005@\u0000\u0000"
          + "FG\u0001\u0000\u0000\u0000GH\u0005 \u0000\u0000HI\u0005-\u0000\u0000I"
          + "L\u0003\u0015\n\u0000JK\u0005,\u0000\u0000KM\u0003\u0015\n\u0000LJ\u0001"
          + "\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"
          + "NO\u0005 \u0000\u0000OP\u0005+\u0000\u0000PS\u0003\u0015\n\u0000QR\u0005"
          + ",\u0000\u0000RT\u0003\u0015\n\u0000SQ\u0001\u0000\u0000\u0000ST\u0001"
          + "\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0005 \u0000\u0000VW\u0005"
          + "@\u0000\u0000WX\u0005@\u0000\u0000X\n\u0001\u0000\u0000\u0000Y]\u0005"
          + "+\u0000\u0000Z\\\b\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001"
          + "\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000"
          + "^\f\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`d\u0005-\u0000\u0000"
          + "ac\b\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000"
          + "db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u000e\u0001\u0000"
          + "\u0000\u0000fd\u0001\u0000\u0000\u0000gk\u0005 \u0000\u0000hj\b\u0000"
          + "\u0000\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000\u0000ki\u0001"
          + "\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000l\u0010\u0001\u0000\u0000"
          + "\u0000mk\u0001\u0000\u0000\u0000no\u0005\\\u0000\u0000op\u0005 \u0000"
          + "\u0000pq\u0005N\u0000\u0000qr\u0005o\u0000\u0000rs\u0005 \u0000\u0000"
          + "st\u0005n\u0000\u0000tu\u0005e\u0000\u0000uv\u0005w\u0000\u0000vw\u0005"
          + "l\u0000\u0000wx\u0005i\u0000\u0000xy\u0005n\u0000\u0000yz\u0005e\u0000"
          + "\u0000z{\u0005 \u0000\u0000{|\u0005a\u0000\u0000|}\u0005t\u0000\u0000"
          + "}~\u0005 \u0000\u0000~\u007f\u0005e\u0000\u0000\u007f\u0080\u0005n\u0000"
          + "\u0000\u0080\u0081\u0005d\u0000\u0000\u0081\u0082\u0005 \u0000\u0000\u0082"
          + "\u0083\u0005o\u0000\u0000\u0083\u0084\u0005f\u0000\u0000\u0084\u0085\u0005"
          + " \u0000\u0000\u0085\u0086\u0005f\u0000\u0000\u0086\u0087\u0005i\u0000"
          + "\u0000\u0087\u0088\u0005l\u0000\u0000\u0088\u0089\u0005e\u0000\u0000\u0089"
          + "\u0012\u0001\u0000\u0000\u0000\u008a\u008c\u0007\u0001\u0000\u0000\u008b"
          + "\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d"
          + "\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e"
          + "\u0014\u0001\u0000\u0000\u0000\u008f\u0091\u0007\u0002\u0000\u0000\u0090"
          + "\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092"
          + "\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093"
          + "\u0016\u0001\u0000\u0000\u0000\u0094\u0096\b\u0000\u0000\u0000\u0095\u0094"
          + "\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0095"
          + "\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0018"
          + "\u0001\u0000\u0000\u0000\u0099\u009b\u0005\r\u0000\u0000\u009a\u0099\u0001"
          + "\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0001"
          + "\u0000\u0000\u0000\u009c\u009d\u0005\n\u0000\u0000\u009d\u001a\u0001\u0000"
          + "\u0000\u0000\u009e\u00a0\u0007\u0003\u0000\u0000\u009f\u009e\u0001\u0000"
          + "\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000"
          + "\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"
          + "\u0000\u0000\u00a3\u00a4\u0006\r\u0000\u0000\u00a4\u001c\u0001\u0000\u0000"
          + "\u0000\u000b\u0000LS]dk\u008d\u0092\u0097\u009a\u00a1\u0001\u0006\u0000"
          + "\u0000";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
