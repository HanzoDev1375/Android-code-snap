// Generated from /storage/emulated/0/cdm/ZigParser.g4 by ANTLR 4.13.2
package ir.ninjacoder.codesnap.antlr4.zig;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ZigParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADDRSPACE=1, ALIGN=2, ALLOWZERO=3, AND=4, ANYFRAME=5, ANYTYPE=6, ASM=7, 
		BREAK=8, CALLCONV=9, CATCH=10, COMPTIME=11, CONST=12, CONTINUE=13, DEFER=14, 
		ELSE=15, ENUM=16, ERRDEFER=17, ERROR=18, EXPORT=19, EXTERN=20, FN=21, 
		FOR=22, IF=23, INLINE=24, LINKSECTION=25, NOALIAS=26, NOINLINE=27, NOSUSPEND=28, 
		OPAQUE=29, OR=30, ORELSE=31, PACKED=32, PUB=33, RESUME=34, RETURN=35, 
		STRUCT=36, SUSPEND=37, SWITCH=38, TEST=39, THREADLOCAL=40, TRY=41, UNION=42, 
		UNREACHABLE=43, VAR=44, VOLATILE=45, WHILE=46, WHITESPACE=47, AMPERSAND=48, 
		AMPERSANDEQUAL=49, ASTERISK=50, ASTERISK2=51, ASTERISKEQUAL=52, ASTERISKPERCENT=53, 
		ASTERISKPERCENTEQUAL=54, ASTERISKPIPE=55, ASTERISKPIPEEQUAL=56, CARET=57, 
		CARETEQUAL=58, COLON=59, COMMA=60, DOT=61, DOT2=62, DOT3=63, DOTASTERISK=64, 
		DOTQUESTIONMARK=65, EQUAL=66, EQUALEQUAL=67, EQUALRARROW=68, EXCLAMATIONMARK=69, 
		EXCLAMATIONMARKEQUAL=70, LARROW=71, LARROW2=72, LARROW2EQUAL=73, LARROW2PIPE=74, 
		LARROW2PIPEEQUAL=75, LARROWEQUAL=76, LBRACE=77, LBRACKET=78, LPAREN=79, 
		MINUS=80, MINUSEQUAL=81, MINUSPERCENT=82, MINUSPERCENTEQUAL=83, MINUSPIPE=84, 
		MINUSPIPEEQUAL=85, MINUSRARROW=86, PERCENT=87, PERCENTEQUAL=88, PIPE=89, 
		PIPE2=90, PIPEEQUAL=91, PLUS=92, PLUS2=93, PLUSEQUAL=94, PLUSPERCENT=95, 
		PLUSPERCENTEQUAL=96, PLUSPIPE=97, PLUSPIPEEQUAL=98, LETTERC=99, QUESTIONMARK=100, 
		RARROW=101, RARROW2=102, RARROW2EQUAL=103, RARROWEQUAL=104, RBRACE=105, 
		RBRACKET=106, RPAREN=107, SEMICOLON=108, SLASH=109, SLASHEQUAL=110, TILDE=111, 
		Container_doc_comment=112, Doc_comment=113, Line_comment=114, IDENTIFIER=115, 
		STRINGLITERAL=116, CHAR_LITERAL=117, FLOAT=118, INTEGER=119, BUILTINIDENTIFIER=120;
	public static final int
		RULE_root = 0, RULE_container_members = 1, RULE_container_declaration = 2, 
		RULE_test_decl = 3, RULE_comptime_decl = 4, RULE_decl = 5, RULE_fn_proto = 6, 
		RULE_var_decl_proto = 7, RULE_global_var_decl = 8, RULE_container_field = 9, 
		RULE_statement = 10, RULE_comptime_statement = 11, RULE_if_statement = 12, 
		RULE_labeled_statement = 13, RULE_loop_statement = 14, RULE_for_statement = 15, 
		RULE_while_statement = 16, RULE_block_expr_statement = 17, RULE_block_expr = 18, 
		RULE_var_decl_expr_statement = 19, RULE_assign_expr = 20, RULE_simple_assign_expr = 21, 
		RULE_expr = 22, RULE_bool_or_expr = 23, RULE_bool_and_expr = 24, RULE_compare_expr = 25, 
		RULE_bitwise_expr = 26, RULE_bit_shift_expr = 27, RULE_addition_expr = 28, 
		RULE_multiply_expr = 29, RULE_prefix_expr = 30, RULE_primary_expr = 31, 
		RULE_if_expr = 32, RULE_block = 33, RULE_loop_expr = 34, RULE_for_expr = 35, 
		RULE_while_expr = 36, RULE_curly_suffix_expr = 37, RULE_init_list = 38, 
		RULE_type_expr = 39, RULE_error_union_expr = 40, RULE_suffix_expr = 41, 
		RULE_primary_type_expr = 42, RULE_container_decl = 43, RULE_error_set_decl = 44, 
		RULE_grouped_expr = 45, RULE_if_type_expr = 46, RULE_labeled_type_expr = 47, 
		RULE_loop_type_expr = 48, RULE_for_type_expr = 49, RULE_while_type_expr = 50, 
		RULE_switch_expr = 51, RULE_asm_expr = 52, RULE_asm_output = 53, RULE_asm_output_item = 54, 
		RULE_asm_input = 55, RULE_asm_input_item = 56, RULE_asm_clobbers = 57, 
		RULE_break_label = 58, RULE_block_label = 59, RULE_field_init = 60, RULE_while_continue_expr = 61, 
		RULE_link_section = 62, RULE_addr_space = 63, RULE_call_conv = 64, RULE_param_decl = 65, 
		RULE_param_type = 66, RULE_if_prefix = 67, RULE_while_prefix = 68, RULE_for_prefix = 69, 
		RULE_payload = 70, RULE_ptr_payload = 71, RULE_ptr_index_payload = 72, 
		RULE_ptr_list_payload = 73, RULE_switch_prong = 74, RULE_switch_case = 75, 
		RULE_switch_item = 76, RULE_for_arguments_list = 77, RULE_for_item = 78, 
		RULE_assign_op = 79, RULE_compare_op = 80, RULE_bitwise_op = 81, RULE_bit_shift_op = 82, 
		RULE_addition_op = 83, RULE_multiply_op = 84, RULE_prefix_op = 85, RULE_prefix_type_op = 86, 
		RULE_suffix_op = 87, RULE_fn_call_arguments = 88, RULE_slice_type_start = 89, 
		RULE_ptr_type_start = 90, RULE_array_type_start = 91, RULE_container_decl_auto = 92, 
		RULE_container_decl_type = 93, RULE_byte_align = 94, RULE_identifier_list = 95, 
		RULE_switch_prong_list = 96, RULE_asm_output_list = 97, RULE_asm_input_list = 98, 
		RULE_param_decl_list = 99, RULE_expr_list = 100;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "container_members", "container_declaration", "test_decl", "comptime_decl", 
			"decl", "fn_proto", "var_decl_proto", "global_var_decl", "container_field", 
			"statement", "comptime_statement", "if_statement", "labeled_statement", 
			"loop_statement", "for_statement", "while_statement", "block_expr_statement", 
			"block_expr", "var_decl_expr_statement", "assign_expr", "simple_assign_expr", 
			"expr", "bool_or_expr", "bool_and_expr", "compare_expr", "bitwise_expr", 
			"bit_shift_expr", "addition_expr", "multiply_expr", "prefix_expr", "primary_expr", 
			"if_expr", "block", "loop_expr", "for_expr", "while_expr", "curly_suffix_expr", 
			"init_list", "type_expr", "error_union_expr", "suffix_expr", "primary_type_expr", 
			"container_decl", "error_set_decl", "grouped_expr", "if_type_expr", "labeled_type_expr", 
			"loop_type_expr", "for_type_expr", "while_type_expr", "switch_expr", 
			"asm_expr", "asm_output", "asm_output_item", "asm_input", "asm_input_item", 
			"asm_clobbers", "break_label", "block_label", "field_init", "while_continue_expr", 
			"link_section", "addr_space", "call_conv", "param_decl", "param_type", 
			"if_prefix", "while_prefix", "for_prefix", "payload", "ptr_payload", 
			"ptr_index_payload", "ptr_list_payload", "switch_prong", "switch_case", 
			"switch_item", "for_arguments_list", "for_item", "assign_op", "compare_op", 
			"bitwise_op", "bit_shift_op", "addition_op", "multiply_op", "prefix_op", 
			"prefix_type_op", "suffix_op", "fn_call_arguments", "slice_type_start", 
			"ptr_type_start", "array_type_start", "container_decl_auto", "container_decl_type", 
			"byte_align", "identifier_list", "switch_prong_list", "asm_output_list", 
			"asm_input_list", "param_decl_list", "expr_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'addrspace'", "'align'", "'allowzero'", "'and'", "'anyframe'", 
			"'anytype'", "'asm'", "'break'", "'callconv'", "'catch'", "'comptime'", 
			"'const'", "'continue'", "'defer'", "'else'", "'enum'", "'errdefer'", 
			"'error'", "'export'", "'extern'", "'fn'", "'for'", "'if'", "'inline'", 
			"'linksection'", "'noalias'", "'noinline'", "'nosuspend'", "'opaque'", 
			"'or'", "'orelse'", "'packed'", "'pub'", "'resume'", "'return'", "'struct'", 
			"'suspend'", "'switch'", "'test'", "'threadlocal'", "'try'", "'union'", 
			"'unreachable'", "'var'", "'volatile'", "'while'", null, "'&'", "'&='", 
			"'*'", "'**'", "'*='", "'*%'", "'*%='", "'*|'", "'*|='", "'^'", "'^='", 
			"':'", "','", "'.'", "'..'", "'...'", "'.*'", "'.?'", "'='", "'=='", 
			"'=>'", "'!'", "'!='", "'<'", "'<<'", "'<<='", "'<<|'", "'<<|='", "'<='", 
			"'{'", "'['", "'('", "'-'", "'-='", "'-%'", "'-%='", "'-|'", "'-|='", 
			"'->'", "'%'", "'%='", "'|'", "'||'", "'|='", "'+'", "'++'", "'+='", 
			"'+%'", "'+%='", "'+|'", "'+|='", "'c'", "'?'", "'>'", "'>>'", "'>>='", 
			"'>='", "'}'", "']'", "')'", "';'", "'/'", "'/='", "'~'", null, null, 
			null, null, null, null, null, null, "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADDRSPACE", "ALIGN", "ALLOWZERO", "AND", "ANYFRAME", "ANYTYPE", 
			"ASM", "BREAK", "CALLCONV", "CATCH", "COMPTIME", "CONST", "CONTINUE", 
			"DEFER", "ELSE", "ENUM", "ERRDEFER", "ERROR", "EXPORT", "EXTERN", "FN", 
			"FOR", "IF", "INLINE", "LINKSECTION", "NOALIAS", "NOINLINE", "NOSUSPEND", 
			"OPAQUE", "OR", "ORELSE", "PACKED", "PUB", "RESUME", "RETURN", "STRUCT", 
			"SUSPEND", "SWITCH", "TEST", "THREADLOCAL", "TRY", "UNION", "UNREACHABLE", 
			"VAR", "VOLATILE", "WHILE", "WHITESPACE", "AMPERSAND", "AMPERSANDEQUAL", 
			"ASTERISK", "ASTERISK2", "ASTERISKEQUAL", "ASTERISKPERCENT", "ASTERISKPERCENTEQUAL", 
			"ASTERISKPIPE", "ASTERISKPIPEEQUAL", "CARET", "CARETEQUAL", "COLON", 
			"COMMA", "DOT", "DOT2", "DOT3", "DOTASTERISK", "DOTQUESTIONMARK", "EQUAL", 
			"EQUALEQUAL", "EQUALRARROW", "EXCLAMATIONMARK", "EXCLAMATIONMARKEQUAL", 
			"LARROW", "LARROW2", "LARROW2EQUAL", "LARROW2PIPE", "LARROW2PIPEEQUAL", 
			"LARROWEQUAL", "LBRACE", "LBRACKET", "LPAREN", "MINUS", "MINUSEQUAL", 
			"MINUSPERCENT", "MINUSPERCENTEQUAL", "MINUSPIPE", "MINUSPIPEEQUAL", "MINUSRARROW", 
			"PERCENT", "PERCENTEQUAL", "PIPE", "PIPE2", "PIPEEQUAL", "PLUS", "PLUS2", 
			"PLUSEQUAL", "PLUSPERCENT", "PLUSPERCENTEQUAL", "PLUSPIPE", "PLUSPIPEEQUAL", 
			"LETTERC", "QUESTIONMARK", "RARROW", "RARROW2", "RARROW2EQUAL", "RARROWEQUAL", 
			"RBRACE", "RBRACKET", "RPAREN", "SEMICOLON", "SLASH", "SLASHEQUAL", "TILDE", 
			"Container_doc_comment", "Doc_comment", "Line_comment", "IDENTIFIER", 
			"STRINGLITERAL", "CHAR_LITERAL", "FLOAT", "INTEGER", "BUILTINIDENTIFIER"
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
	public String getGrammarFileName() { return "ZigParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ZigParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public Container_membersContext container_members() {
			return getRuleContext(Container_membersContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ZigParser.EOF, 0); }
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			container_members();
			setState(203);
			match(EOF);
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
	public static class Container_membersContext extends ParserRuleContext {
		public List<Container_fieldContext> container_field() {
			return getRuleContexts(Container_fieldContext.class);
		}
		public Container_fieldContext container_field(int i) {
			return getRuleContext(Container_fieldContext.class,i);
		}
		public TerminalNode Container_doc_comment() { return getToken(ZigParser.Container_doc_comment, 0); }
		public List<Container_declarationContext> container_declaration() {
			return getRuleContexts(Container_declarationContext.class);
		}
		public Container_declarationContext container_declaration(int i) {
			return getRuleContext(Container_declarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public Container_membersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_container_members; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterContainer_members(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitContainer_members(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitContainer_members(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Container_membersContext container_members() throws RecognitionException {
		Container_membersContext _localctx = new Container_membersContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_container_members);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Container_doc_comment) {
				{
				setState(205);
				match(Container_doc_comment);
				}
			}

			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(208);
					container_declaration();
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(214);
					container_field();
					setState(215);
					match(COMMA);
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(222);
				container_field();
				}
				break;
			case 2:
				{
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 19250198091776L) != 0) || _la==Doc_comment) {
					{
					{
					setState(223);
					container_declaration();
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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
	public static class Container_declarationContext extends ParserRuleContext {
		public Test_declContext test_decl() {
			return getRuleContext(Test_declContext.class,0);
		}
		public Comptime_declContext comptime_decl() {
			return getRuleContext(Comptime_declContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public TerminalNode Doc_comment() { return getToken(ZigParser.Doc_comment, 0); }
		public TerminalNode PUB() { return getToken(ZigParser.PUB, 0); }
		public Container_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_container_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterContainer_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitContainer_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitContainer_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Container_declarationContext container_declaration() throws RecognitionException {
		Container_declarationContext _localctx = new Container_declarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_container_declaration);
		int _la;
		try {
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEST:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				test_decl();
				}
				break;
			case COMPTIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				comptime_decl();
				}
				break;
			case CONST:
			case EXPORT:
			case EXTERN:
			case FN:
			case INLINE:
			case NOINLINE:
			case PUB:
			case THREADLOCAL:
			case VAR:
			case Doc_comment:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Doc_comment) {
					{
					setState(233);
					match(Doc_comment);
					}
				}

				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUB) {
					{
					setState(236);
					match(PUB);
					}
				}

				setState(239);
				decl();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Test_declContext extends ParserRuleContext {
		public TerminalNode TEST() { return getToken(ZigParser.TEST, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode STRINGLITERAL() { return getToken(ZigParser.STRINGLITERAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public Test_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterTest_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitTest_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitTest_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_declContext test_decl() throws RecognitionException {
		Test_declContext _localctx = new Test_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_test_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(TEST);
			setState(243);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRINGLITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(244);
			block();
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
	public static class Comptime_declContext extends ParserRuleContext {
		public TerminalNode COMPTIME() { return getToken(ZigParser.COMPTIME, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Comptime_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comptime_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterComptime_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitComptime_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitComptime_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comptime_declContext comptime_decl() throws RecognitionException {
		Comptime_declContext _localctx = new Comptime_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_comptime_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(COMPTIME);
			setState(247);
			block();
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
	public static class DeclContext extends ParserRuleContext {
		public Fn_protoContext fn_proto() {
			return getRuleContext(Fn_protoContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ZigParser.SEMICOLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EXPORT() { return getToken(ZigParser.EXPORT, 0); }
		public TerminalNode EXTERN() { return getToken(ZigParser.EXTERN, 0); }
		public TerminalNode INLINE() { return getToken(ZigParser.INLINE, 0); }
		public TerminalNode NOINLINE() { return getToken(ZigParser.NOINLINE, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(ZigParser.STRINGLITERAL, 0); }
		public Global_var_declContext global_var_decl() {
			return getRuleContext(Global_var_declContext.class,0);
		}
		public TerminalNode THREADLOCAL() { return getToken(ZigParser.THREADLOCAL, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decl);
		int _la;
		try {
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EXPORT:
					{
					setState(249);
					match(EXPORT);
					}
					break;
				case EXTERN:
					{
					setState(250);
					match(EXTERN);
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==STRINGLITERAL) {
						{
						setState(251);
						match(STRINGLITERAL);
						}
					}

					}
					break;
				case INLINE:
					{
					setState(254);
					match(INLINE);
					}
					break;
				case NOINLINE:
					{
					setState(255);
					match(NOINLINE);
					}
					break;
				case FN:
					break;
				default:
					break;
				}
				setState(258);
				fn_proto();
				setState(261);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEMICOLON:
					{
					setState(259);
					match(SEMICOLON);
					}
					break;
				case LBRACE:
					{
					setState(260);
					block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EXPORT:
					{
					setState(263);
					match(EXPORT);
					}
					break;
				case EXTERN:
					{
					setState(264);
					match(EXTERN);
					setState(265);
					match(STRINGLITERAL);
					}
					break;
				case CONST:
				case THREADLOCAL:
				case VAR:
					break;
				default:
					break;
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THREADLOCAL) {
					{
					setState(268);
					match(THREADLOCAL);
					}
				}

				setState(271);
				global_var_decl();
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
	public static class Fn_protoContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(ZigParser.FN, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public Param_decl_listContext param_decl_list() {
			return getRuleContext(Param_decl_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public Byte_alignContext byte_align() {
			return getRuleContext(Byte_alignContext.class,0);
		}
		public Addr_spaceContext addr_space() {
			return getRuleContext(Addr_spaceContext.class,0);
		}
		public Link_sectionContext link_section() {
			return getRuleContext(Link_sectionContext.class,0);
		}
		public Call_convContext call_conv() {
			return getRuleContext(Call_convContext.class,0);
		}
		public TerminalNode EXCLAMATIONMARK() { return getToken(ZigParser.EXCLAMATIONMARK, 0); }
		public Fn_protoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fn_proto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterFn_proto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitFn_proto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitFn_proto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fn_protoContext fn_proto() throws RecognitionException {
		Fn_protoContext _localctx = new Fn_protoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fn_proto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(FN);
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(275);
				match(IDENTIFIER);
				}
			}

			setState(278);
			match(LPAREN);
			setState(279);
			param_decl_list();
			setState(280);
			match(RPAREN);
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALIGN) {
				{
				setState(281);
				byte_align();
				}
			}

			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADDRSPACE) {
				{
				setState(284);
				addr_space();
				}
			}

			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LINKSECTION) {
				{
				setState(287);
				link_section();
				}
			}

			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CALLCONV) {
				{
				setState(290);
				call_conv();
				}
			}

			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLAMATIONMARK) {
				{
				setState(293);
				match(EXCLAMATIONMARK);
				}
			}

			setState(296);
			type_expr();
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
	public static class Var_decl_protoContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public TerminalNode CONST() { return getToken(ZigParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(ZigParser.VAR, 0); }
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public Byte_alignContext byte_align() {
			return getRuleContext(Byte_alignContext.class,0);
		}
		public Addr_spaceContext addr_space() {
			return getRuleContext(Addr_spaceContext.class,0);
		}
		public Link_sectionContext link_section() {
			return getRuleContext(Link_sectionContext.class,0);
		}
		public Var_decl_protoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl_proto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterVar_decl_proto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitVar_decl_proto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitVar_decl_proto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_decl_protoContext var_decl_proto() throws RecognitionException {
		Var_decl_protoContext _localctx = new Var_decl_protoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_decl_proto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_la = _input.LA(1);
			if ( !(_la==CONST || _la==VAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(299);
			match(IDENTIFIER);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(300);
				match(COLON);
				setState(301);
				type_expr();
				}
			}

			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALIGN) {
				{
				setState(304);
				byte_align();
				}
			}

			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADDRSPACE) {
				{
				setState(307);
				addr_space();
				}
			}

			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LINKSECTION) {
				{
				setState(310);
				link_section();
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
	public static class Global_var_declContext extends ParserRuleContext {
		public Var_decl_protoContext var_decl_proto() {
			return getRuleContext(Var_decl_protoContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ZigParser.SEMICOLON, 0); }
		public TerminalNode EQUAL() { return getToken(ZigParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Global_var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterGlobal_var_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitGlobal_var_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitGlobal_var_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_var_declContext global_var_decl() throws RecognitionException {
		Global_var_declContext _localctx = new Global_var_declContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_global_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			var_decl_proto();
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(314);
				match(EQUAL);
				setState(315);
				expr();
				}
			}

			setState(318);
			match(SEMICOLON);
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
	public static class Container_fieldContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public TerminalNode Doc_comment() { return getToken(ZigParser.Doc_comment, 0); }
		public TerminalNode COMPTIME() { return getToken(ZigParser.COMPTIME, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public Byte_alignContext byte_align() {
			return getRuleContext(Byte_alignContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(ZigParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Container_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_container_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterContainer_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitContainer_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitContainer_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Container_fieldContext container_field() throws RecognitionException {
		Container_fieldContext _localctx = new Container_fieldContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_container_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Doc_comment) {
				{
				setState(320);
				match(Doc_comment);
				}
			}

			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(323);
				match(COMPTIME);
				}
				break;
			}
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(326);
				match(IDENTIFIER);
				setState(327);
				match(COLON);
				}
				break;
			}
			setState(330);
			type_expr();
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALIGN) {
				{
				setState(331);
				byte_align();
				}
			}

			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(334);
				match(EQUAL);
				setState(335);
				expr();
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
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode COMPTIME() { return getToken(ZigParser.COMPTIME, 0); }
		public Comptime_statementContext comptime_statement() {
			return getRuleContext(Comptime_statementContext.class,0);
		}
		public TerminalNode NOSUSPEND() { return getToken(ZigParser.NOSUSPEND, 0); }
		public Block_expr_statementContext block_expr_statement() {
			return getRuleContext(Block_expr_statementContext.class,0);
		}
		public TerminalNode SUSPEND() { return getToken(ZigParser.SUSPEND, 0); }
		public TerminalNode DEFER() { return getToken(ZigParser.DEFER, 0); }
		public TerminalNode ERRDEFER() { return getToken(ZigParser.ERRDEFER, 0); }
		public PayloadContext payload() {
			return getRuleContext(PayloadContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Labeled_statementContext labeled_statement() {
			return getRuleContext(Labeled_statementContext.class,0);
		}
		public Var_decl_expr_statementContext var_decl_expr_statement() {
			return getRuleContext(Var_decl_expr_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				match(COMPTIME);
				setState(339);
				comptime_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				match(NOSUSPEND);
				setState(341);
				block_expr_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(342);
				match(SUSPEND);
				setState(343);
				block_expr_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(344);
				match(DEFER);
				setState(345);
				block_expr_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(346);
				match(ERRDEFER);
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PIPE) {
					{
					setState(347);
					payload();
					}
				}

				setState(350);
				block_expr_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(351);
				if_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(352);
				labeled_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(353);
				var_decl_expr_statement();
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
	public static class Comptime_statementContext extends ParserRuleContext {
		public Block_exprContext block_expr() {
			return getRuleContext(Block_exprContext.class,0);
		}
		public Var_decl_expr_statementContext var_decl_expr_statement() {
			return getRuleContext(Var_decl_expr_statementContext.class,0);
		}
		public Comptime_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comptime_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterComptime_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitComptime_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitComptime_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comptime_statementContext comptime_statement() throws RecognitionException {
		Comptime_statementContext _localctx = new Comptime_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comptime_statement);
		try {
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				block_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				var_decl_expr_statement();
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
	public static class If_statementContext extends ParserRuleContext {
		public If_prefixContext if_prefix() {
			return getRuleContext(If_prefixContext.class,0);
		}
		public Block_exprContext block_expr() {
			return getRuleContext(Block_exprContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(ZigParser.ELSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public PayloadContext payload() {
			return getRuleContext(PayloadContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ZigParser.SEMICOLON, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_if_statement);
		int _la;
		try {
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(360);
				if_prefix();
				setState(361);
				block_expr();
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(362);
					match(ELSE);
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PIPE) {
						{
						setState(363);
						payload();
						}
					}

					setState(366);
					statement();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				if_prefix();
				setState(370);
				assign_expr();
				setState(377);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEMICOLON:
					{
					setState(371);
					match(SEMICOLON);
					}
					break;
				case ELSE:
					{
					setState(372);
					match(ELSE);
					setState(374);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PIPE) {
						{
						setState(373);
						payload();
						}
					}

					setState(376);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
	public static class Labeled_statementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Loop_statementContext loop_statement() {
			return getRuleContext(Loop_statementContext.class,0);
		}
		public Switch_exprContext switch_expr() {
			return getRuleContext(Switch_exprContext.class,0);
		}
		public Block_labelContext block_label() {
			return getRuleContext(Block_labelContext.class,0);
		}
		public Labeled_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeled_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterLabeled_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitLabeled_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitLabeled_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Labeled_statementContext labeled_statement() throws RecognitionException {
		Labeled_statementContext _localctx = new Labeled_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_labeled_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(381);
				block_label();
				}
			}

			setState(387);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(384);
				block();
				}
				break;
			case FOR:
			case INLINE:
			case WHILE:
				{
				setState(385);
				loop_statement();
				}
				break;
			case SWITCH:
				{
				setState(386);
				switch_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Loop_statementContext extends ParserRuleContext {
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public TerminalNode INLINE() { return getToken(ZigParser.INLINE, 0); }
		public Loop_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterLoop_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitLoop_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitLoop_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_statementContext loop_statement() throws RecognitionException {
		Loop_statementContext _localctx = new Loop_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_loop_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE) {
				{
				setState(389);
				match(INLINE);
				}
			}

			setState(394);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(392);
				for_statement();
				}
				break;
			case WHILE:
				{
				setState(393);
				while_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class For_statementContext extends ParserRuleContext {
		public For_prefixContext for_prefix() {
			return getRuleContext(For_prefixContext.class,0);
		}
		public Block_exprContext block_expr() {
			return getRuleContext(Block_exprContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(ZigParser.ELSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ZigParser.SEMICOLON, 0); }
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitFor_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitFor_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_for_statement);
		int _la;
		try {
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				for_prefix();
				setState(397);
				block_expr();
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(398);
					match(ELSE);
					setState(399);
					statement();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				for_prefix();
				setState(403);
				assign_expr();
				{
				setState(404);
				match(SEMICOLON);
				setState(405);
				match(ELSE);
				setState(406);
				statement();
				}
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
	public static class While_statementContext extends ParserRuleContext {
		public While_prefixContext while_prefix() {
			return getRuleContext(While_prefixContext.class,0);
		}
		public Block_exprContext block_expr() {
			return getRuleContext(Block_exprContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(ZigParser.ELSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public PayloadContext payload() {
			return getRuleContext(PayloadContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ZigParser.SEMICOLON, 0); }
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitWhile_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitWhile_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_while_statement);
		int _la;
		try {
			setState(429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				while_prefix();
				setState(411);
				block_expr();
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(412);
					match(ELSE);
					setState(414);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PIPE) {
						{
						setState(413);
						payload();
						}
					}

					setState(416);
					statement();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				while_prefix();
				setState(420);
				assign_expr();
				setState(427);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEMICOLON:
					{
					setState(421);
					match(SEMICOLON);
					}
					break;
				case ELSE:
					{
					setState(422);
					match(ELSE);
					setState(424);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PIPE) {
						{
						setState(423);
						payload();
						}
					}

					setState(426);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
	public static class Block_expr_statementContext extends ParserRuleContext {
		public Block_exprContext block_expr() {
			return getRuleContext(Block_exprContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ZigParser.SEMICOLON, 0); }
		public Block_expr_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_expr_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBlock_expr_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBlock_expr_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBlock_expr_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_expr_statementContext block_expr_statement() throws RecognitionException {
		Block_expr_statementContext _localctx = new Block_expr_statementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_block_expr_statement);
		try {
			setState(435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
				block_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(432);
				assign_expr();
				setState(433);
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
	public static class Block_exprContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Block_labelContext block_label() {
			return getRuleContext(Block_labelContext.class,0);
		}
		public Block_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBlock_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBlock_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBlock_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_exprContext block_expr() throws RecognitionException {
		Block_exprContext _localctx = new Block_exprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_block_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(437);
				block_label();
				}
			}

			setState(440);
			block();
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
	public static class Var_decl_expr_statementContext extends ParserRuleContext {
		public List<Var_decl_protoContext> var_decl_proto() {
			return getRuleContexts(Var_decl_protoContext.class);
		}
		public Var_decl_protoContext var_decl_proto(int i) {
			return getRuleContext(Var_decl_protoContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(ZigParser.EQUAL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(ZigParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
		public Var_decl_expr_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl_expr_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterVar_decl_expr_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitVar_decl_expr_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitVar_decl_expr_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_decl_expr_statementContext var_decl_expr_statement() throws RecognitionException {
		Var_decl_expr_statementContext _localctx = new Var_decl_expr_statementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_var_decl_expr_statement);
		int _la;
		try {
			setState(477);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(442);
				var_decl_proto();
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(443);
					match(COMMA);
					setState(446);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CONST:
					case VAR:
						{
						setState(444);
						var_decl_proto();
						}
						break;
					case ANYFRAME:
					case ASM:
					case BREAK:
					case COMPTIME:
					case CONTINUE:
					case ENUM:
					case ERROR:
					case EXTERN:
					case FN:
					case FOR:
					case IF:
					case INLINE:
					case NOSUSPEND:
					case OPAQUE:
					case PACKED:
					case RESUME:
					case RETURN:
					case STRUCT:
					case SWITCH:
					case TRY:
					case UNION:
					case UNREACHABLE:
					case WHILE:
					case AMPERSAND:
					case ASTERISK:
					case ASTERISK2:
					case DOT:
					case EXCLAMATIONMARK:
					case LBRACE:
					case LBRACKET:
					case LPAREN:
					case MINUS:
					case MINUSPERCENT:
					case QUESTIONMARK:
					case TILDE:
					case IDENTIFIER:
					case STRINGLITERAL:
					case CHAR_LITERAL:
					case FLOAT:
					case INTEGER:
					case BUILTINIDENTIFIER:
						{
						setState(445);
						expr();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(452);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(453);
				match(EQUAL);
				setState(454);
				expr();
				setState(455);
				match(SEMICOLON);
				}
				break;
			case ANYFRAME:
			case ASM:
			case BREAK:
			case COMPTIME:
			case CONTINUE:
			case ENUM:
			case ERROR:
			case EXTERN:
			case FN:
			case FOR:
			case IF:
			case INLINE:
			case NOSUSPEND:
			case OPAQUE:
			case PACKED:
			case RESUME:
			case RETURN:
			case STRUCT:
			case SWITCH:
			case TRY:
			case UNION:
			case UNREACHABLE:
			case WHILE:
			case AMPERSAND:
			case ASTERISK:
			case ASTERISK2:
			case DOT:
			case EXCLAMATIONMARK:
			case LBRACE:
			case LBRACKET:
			case LPAREN:
			case MINUS:
			case MINUSPERCENT:
			case QUESTIONMARK:
			case TILDE:
			case IDENTIFIER:
			case STRINGLITERAL:
			case CHAR_LITERAL:
			case FLOAT:
			case INTEGER:
			case BUILTINIDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(457);
				expr();
				setState(473);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AMPERSANDEQUAL:
				case ASTERISKEQUAL:
				case ASTERISKPERCENTEQUAL:
				case ASTERISKPIPEEQUAL:
				case CARETEQUAL:
				case EQUAL:
				case LARROW2EQUAL:
				case LARROW2PIPEEQUAL:
				case MINUSEQUAL:
				case MINUSPERCENTEQUAL:
				case MINUSPIPEEQUAL:
				case PERCENTEQUAL:
				case PIPEEQUAL:
				case PLUSEQUAL:
				case PLUSPERCENTEQUAL:
				case PLUSPIPEEQUAL:
				case RARROW2EQUAL:
				case SLASHEQUAL:
					{
					setState(458);
					assign_op();
					setState(459);
					expr();
					}
					break;
				case COMMA:
					{
					setState(466); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(461);
						match(COMMA);
						setState(464);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case CONST:
						case VAR:
							{
							setState(462);
							var_decl_proto();
							}
							break;
						case ANYFRAME:
						case ASM:
						case BREAK:
						case COMPTIME:
						case CONTINUE:
						case ENUM:
						case ERROR:
						case EXTERN:
						case FN:
						case FOR:
						case IF:
						case INLINE:
						case NOSUSPEND:
						case OPAQUE:
						case PACKED:
						case RESUME:
						case RETURN:
						case STRUCT:
						case SWITCH:
						case TRY:
						case UNION:
						case UNREACHABLE:
						case WHILE:
						case AMPERSAND:
						case ASTERISK:
						case ASTERISK2:
						case DOT:
						case EXCLAMATIONMARK:
						case LBRACE:
						case LBRACKET:
						case LPAREN:
						case MINUS:
						case MINUSPERCENT:
						case QUESTIONMARK:
						case TILDE:
						case IDENTIFIER:
						case STRINGLITERAL:
						case CHAR_LITERAL:
						case FLOAT:
						case INTEGER:
						case BUILTINIDENTIFIER:
							{
							setState(463);
							expr();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						}
						setState(468); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==COMMA );
					setState(470);
					match(EQUAL);
					setState(471);
					expr();
					}
					break;
				case SEMICOLON:
					break;
				default:
					break;
				}
				setState(475);
				match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Assign_exprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(ZigParser.EQUAL, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAssign_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAssign_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			expr();
			setState(492);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AMPERSANDEQUAL:
			case ASTERISKEQUAL:
			case ASTERISKPERCENTEQUAL:
			case ASTERISKPIPEEQUAL:
			case CARETEQUAL:
			case EQUAL:
			case LARROW2EQUAL:
			case LARROW2PIPEEQUAL:
			case MINUSEQUAL:
			case MINUSPERCENTEQUAL:
			case MINUSPIPEEQUAL:
			case PERCENTEQUAL:
			case PIPEEQUAL:
			case PLUSEQUAL:
			case PLUSPERCENTEQUAL:
			case PLUSPIPEEQUAL:
			case RARROW2EQUAL:
			case SLASHEQUAL:
				{
				setState(480);
				assign_op();
				setState(481);
				expr();
				}
				break;
			case COMMA:
				{
				setState(485); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(483);
					match(COMMA);
					setState(484);
					expr();
					}
					}
					setState(487); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(489);
				match(EQUAL);
				setState(490);
				expr();
				}
				break;
			case ELSE:
			case RPAREN:
			case SEMICOLON:
				break;
			default:
				break;
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
	public static class Simple_assign_exprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
		public Simple_assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterSimple_assign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitSimple_assign_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitSimple_assign_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_assign_exprContext simple_assign_expr() throws RecognitionException {
		Simple_assign_exprContext _localctx = new Simple_assign_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_simple_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			expr();
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & 2324601317617697449L) != 0)) {
				{
				setState(495);
				assign_op();
				setState(496);
				expr();
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
	public static class ExprContext extends ParserRuleContext {
		public Bool_or_exprContext bool_or_expr() {
			return getRuleContext(Bool_or_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			bool_or_expr();
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
	public static class Bool_or_exprContext extends ParserRuleContext {
		public List<Bool_and_exprContext> bool_and_expr() {
			return getRuleContexts(Bool_and_exprContext.class);
		}
		public Bool_and_exprContext bool_and_expr(int i) {
			return getRuleContext(Bool_and_exprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(ZigParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ZigParser.OR, i);
		}
		public Bool_or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBool_or_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBool_or_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBool_or_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_or_exprContext bool_or_expr() throws RecognitionException {
		Bool_or_exprContext _localctx = new Bool_or_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_bool_or_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			bool_and_expr();
			setState(507);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(503);
					match(OR);
					setState(504);
					bool_and_expr();
					}
					} 
				}
				setState(509);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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
	public static class Bool_and_exprContext extends ParserRuleContext {
		public List<Compare_exprContext> compare_expr() {
			return getRuleContexts(Compare_exprContext.class);
		}
		public Compare_exprContext compare_expr(int i) {
			return getRuleContext(Compare_exprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(ZigParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ZigParser.AND, i);
		}
		public Bool_and_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBool_and_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBool_and_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBool_and_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_and_exprContext bool_and_expr() throws RecognitionException {
		Bool_and_exprContext _localctx = new Bool_and_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bool_and_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			compare_expr();
			setState(515);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(511);
					match(AND);
					setState(512);
					compare_expr();
					}
					} 
				}
				setState(517);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
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
	public static class Compare_exprContext extends ParserRuleContext {
		public List<Bitwise_exprContext> bitwise_expr() {
			return getRuleContexts(Bitwise_exprContext.class);
		}
		public Bitwise_exprContext bitwise_expr(int i) {
			return getRuleContext(Bitwise_exprContext.class,i);
		}
		public Compare_opContext compare_op() {
			return getRuleContext(Compare_opContext.class,0);
		}
		public Compare_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterCompare_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitCompare_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitCompare_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compare_exprContext compare_expr() throws RecognitionException {
		Compare_exprContext _localctx = new Compare_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_compare_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			bitwise_expr();
			setState(522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(519);
				compare_op();
				setState(520);
				bitwise_expr();
				}
				break;
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
	public static class Bitwise_exprContext extends ParserRuleContext {
		public List<Bit_shift_exprContext> bit_shift_expr() {
			return getRuleContexts(Bit_shift_exprContext.class);
		}
		public Bit_shift_exprContext bit_shift_expr(int i) {
			return getRuleContext(Bit_shift_exprContext.class,i);
		}
		public List<Bitwise_opContext> bitwise_op() {
			return getRuleContexts(Bitwise_opContext.class);
		}
		public Bitwise_opContext bitwise_op(int i) {
			return getRuleContext(Bitwise_opContext.class,i);
		}
		public Bitwise_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBitwise_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBitwise_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBitwise_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_exprContext bitwise_expr() throws RecognitionException {
		Bitwise_exprContext _localctx = new Bitwise_exprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_bitwise_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			bit_shift_expr();
			setState(530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(525);
					bitwise_op();
					setState(526);
					bit_shift_expr();
					}
					} 
				}
				setState(532);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
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
	public static class Bit_shift_exprContext extends ParserRuleContext {
		public List<Addition_exprContext> addition_expr() {
			return getRuleContexts(Addition_exprContext.class);
		}
		public Addition_exprContext addition_expr(int i) {
			return getRuleContext(Addition_exprContext.class,i);
		}
		public List<Bit_shift_opContext> bit_shift_op() {
			return getRuleContexts(Bit_shift_opContext.class);
		}
		public Bit_shift_opContext bit_shift_op(int i) {
			return getRuleContext(Bit_shift_opContext.class,i);
		}
		public Bit_shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_shift_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBit_shift_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBit_shift_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBit_shift_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bit_shift_exprContext bit_shift_expr() throws RecognitionException {
		Bit_shift_exprContext _localctx = new Bit_shift_exprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_bit_shift_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			addition_expr();
			setState(539);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(534);
					bit_shift_op();
					setState(535);
					addition_expr();
					}
					} 
				}
				setState(541);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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
	public static class Addition_exprContext extends ParserRuleContext {
		public List<Multiply_exprContext> multiply_expr() {
			return getRuleContexts(Multiply_exprContext.class);
		}
		public Multiply_exprContext multiply_expr(int i) {
			return getRuleContext(Multiply_exprContext.class,i);
		}
		public List<Addition_opContext> addition_op() {
			return getRuleContexts(Addition_opContext.class);
		}
		public Addition_opContext addition_op(int i) {
			return getRuleContext(Addition_opContext.class,i);
		}
		public Addition_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addition_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAddition_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAddition_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAddition_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Addition_exprContext addition_expr() throws RecognitionException {
		Addition_exprContext _localctx = new Addition_exprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_addition_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			multiply_expr();
			setState(548);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(543);
					addition_op();
					setState(544);
					multiply_expr();
					}
					} 
				}
				setState(550);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
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
	public static class Multiply_exprContext extends ParserRuleContext {
		public List<Prefix_exprContext> prefix_expr() {
			return getRuleContexts(Prefix_exprContext.class);
		}
		public Prefix_exprContext prefix_expr(int i) {
			return getRuleContext(Prefix_exprContext.class,i);
		}
		public List<Multiply_opContext> multiply_op() {
			return getRuleContexts(Multiply_opContext.class);
		}
		public Multiply_opContext multiply_op(int i) {
			return getRuleContext(Multiply_opContext.class,i);
		}
		public Multiply_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiply_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterMultiply_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitMultiply_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitMultiply_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiply_exprContext multiply_expr() throws RecognitionException {
		Multiply_exprContext _localctx = new Multiply_exprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_multiply_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			prefix_expr();
			setState(557);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(552);
					multiply_op();
					setState(553);
					prefix_expr();
					}
					} 
				}
				setState(559);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
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
	public static class Prefix_exprContext extends ParserRuleContext {
		public Primary_exprContext primary_expr() {
			return getRuleContext(Primary_exprContext.class,0);
		}
		public List<Prefix_opContext> prefix_op() {
			return getRuleContexts(Prefix_opContext.class);
		}
		public Prefix_opContext prefix_op(int i) {
			return getRuleContext(Prefix_opContext.class,i);
		}
		public Prefix_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterPrefix_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitPrefix_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitPrefix_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_exprContext prefix_expr() throws RecognitionException {
		Prefix_exprContext _localctx = new Prefix_exprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_prefix_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TRY || _la==AMPERSAND || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 4398046521345L) != 0)) {
				{
				{
				setState(560);
				prefix_op();
				}
				}
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(566);
			primary_expr();
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
	public static class Primary_exprContext extends ParserRuleContext {
		public Asm_exprContext asm_expr() {
			return getRuleContext(Asm_exprContext.class,0);
		}
		public If_exprContext if_expr() {
			return getRuleContext(If_exprContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(ZigParser.BREAK, 0); }
		public Break_labelContext break_label() {
			return getRuleContext(Break_labelContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COMPTIME() { return getToken(ZigParser.COMPTIME, 0); }
		public TerminalNode NOSUSPEND() { return getToken(ZigParser.NOSUSPEND, 0); }
		public TerminalNode CONTINUE() { return getToken(ZigParser.CONTINUE, 0); }
		public TerminalNode RESUME() { return getToken(ZigParser.RESUME, 0); }
		public TerminalNode RETURN() { return getToken(ZigParser.RETURN, 0); }
		public Loop_exprContext loop_expr() {
			return getRuleContext(Loop_exprContext.class,0);
		}
		public Block_labelContext block_label() {
			return getRuleContext(Block_labelContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Curly_suffix_exprContext curly_suffix_expr() {
			return getRuleContext(Curly_suffix_exprContext.class,0);
		}
		public Primary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterPrimary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitPrimary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitPrimary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_exprContext primary_expr() throws RecognitionException {
		Primary_exprContext _localctx = new Primary_exprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_primary_expr);
		int _la;
		try {
			setState(600);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(568);
				asm_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(569);
				if_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(570);
				match(BREAK);
				setState(572);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(571);
					break_label();
					}
					break;
				}
				setState(575);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					setState(574);
					expr();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(577);
				match(COMPTIME);
				setState(578);
				expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(579);
				match(NOSUSPEND);
				setState(580);
				expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(581);
				match(CONTINUE);
				setState(583);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(582);
					break_label();
					}
					break;
				}
				setState(586);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(585);
					expr();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(588);
				match(RESUME);
				setState(589);
				expr();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(590);
				match(RETURN);
				setState(592);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(591);
					expr();
					}
					break;
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(595);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(594);
					block_label();
					}
				}

				setState(597);
				loop_expr();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(598);
				block();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(599);
				curly_suffix_expr();
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
	public static class If_exprContext extends ParserRuleContext {
		public If_prefixContext if_prefix() {
			return getRuleContext(If_prefixContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ZigParser.ELSE, 0); }
		public PayloadContext payload() {
			return getRuleContext(PayloadContext.class,0);
		}
		public If_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterIf_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitIf_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitIf_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_exprContext if_expr() throws RecognitionException {
		If_exprContext _localctx = new If_exprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_if_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			if_prefix();
			setState(603);
			expr();
			setState(609);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(604);
				match(ELSE);
				setState(606);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PIPE) {
					{
					setState(605);
					payload();
					}
				}

				setState(608);
				expr();
				}
				break;
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ZigParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ZigParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			match(LBRACE);
			setState(615);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2309606075713157536L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 4437631077199617L) != 0)) {
				{
				{
				setState(612);
				statement();
				}
				}
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(618);
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
	public static class Loop_exprContext extends ParserRuleContext {
		public For_exprContext for_expr() {
			return getRuleContext(For_exprContext.class,0);
		}
		public While_exprContext while_expr() {
			return getRuleContext(While_exprContext.class,0);
		}
		public TerminalNode INLINE() { return getToken(ZigParser.INLINE, 0); }
		public Loop_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterLoop_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitLoop_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitLoop_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_exprContext loop_expr() throws RecognitionException {
		Loop_exprContext _localctx = new Loop_exprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_loop_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE) {
				{
				setState(620);
				match(INLINE);
				}
			}

			setState(625);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(623);
				for_expr();
				}
				break;
			case WHILE:
				{
				setState(624);
				while_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class For_exprContext extends ParserRuleContext {
		public For_prefixContext for_prefix() {
			return getRuleContext(For_prefixContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ZigParser.ELSE, 0); }
		public For_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterFor_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitFor_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitFor_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_exprContext for_expr() throws RecognitionException {
		For_exprContext _localctx = new For_exprContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_for_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			for_prefix();
			setState(628);
			expr();
			setState(631);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				{
				setState(629);
				match(ELSE);
				setState(630);
				expr();
				}
				break;
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
	public static class While_exprContext extends ParserRuleContext {
		public While_prefixContext while_prefix() {
			return getRuleContext(While_prefixContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ZigParser.ELSE, 0); }
		public PayloadContext payload() {
			return getRuleContext(PayloadContext.class,0);
		}
		public While_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterWhile_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitWhile_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitWhile_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_exprContext while_expr() throws RecognitionException {
		While_exprContext _localctx = new While_exprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_while_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			while_prefix();
			setState(634);
			expr();
			setState(640);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				{
				setState(635);
				match(ELSE);
				setState(637);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PIPE) {
					{
					setState(636);
					payload();
					}
				}

				setState(639);
				expr();
				}
				break;
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
	public static class Curly_suffix_exprContext extends ParserRuleContext {
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public Init_listContext init_list() {
			return getRuleContext(Init_listContext.class,0);
		}
		public Curly_suffix_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_curly_suffix_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterCurly_suffix_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitCurly_suffix_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitCurly_suffix_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Curly_suffix_exprContext curly_suffix_expr() throws RecognitionException {
		Curly_suffix_exprContext _localctx = new Curly_suffix_exprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_curly_suffix_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
			type_expr();
			setState(644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(643);
				init_list();
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
	public static class Init_listContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ZigParser.LBRACE, 0); }
		public List<Field_initContext> field_init() {
			return getRuleContexts(Field_initContext.class);
		}
		public Field_initContext field_init(int i) {
			return getRuleContext(Field_initContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(ZigParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Init_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterInit_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitInit_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitInit_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_listContext init_list() throws RecognitionException {
		Init_listContext _localctx = new Init_listContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_init_list);
		int _la;
		try {
			int _alt;
			setState(676);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(646);
				match(LBRACE);
				setState(647);
				field_init();
				setState(652);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(648);
						match(COMMA);
						setState(649);
						field_init();
						}
						} 
					}
					setState(654);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
				}
				setState(656);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(655);
					match(COMMA);
					}
				}

				setState(658);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(660);
				match(LBRACE);
				setState(661);
				expr();
				setState(666);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(662);
						match(COMMA);
						setState(663);
						expr();
						}
						} 
					}
					setState(668);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				}
				setState(670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(669);
					match(COMMA);
					}
				}

				setState(672);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(674);
				match(LBRACE);
				setState(675);
				match(RBRACE);
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
	public static class Type_exprContext extends ParserRuleContext {
		public Error_union_exprContext error_union_expr() {
			return getRuleContext(Error_union_exprContext.class,0);
		}
		public List<Prefix_type_opContext> prefix_type_op() {
			return getRuleContexts(Prefix_type_opContext.class);
		}
		public Prefix_type_opContext prefix_type_op(int i) {
			return getRuleContext(Prefix_type_opContext.class,i);
		}
		public Type_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterType_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitType_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitType_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_exprContext type_expr() throws RecognitionException {
		Type_exprContext _localctx = new Type_exprContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_type_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(681);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(678);
					prefix_type_op();
					}
					} 
				}
				setState(683);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			}
			setState(684);
			error_union_expr();
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
	public static class Error_union_exprContext extends ParserRuleContext {
		public Suffix_exprContext suffix_expr() {
			return getRuleContext(Suffix_exprContext.class,0);
		}
		public TerminalNode EXCLAMATIONMARK() { return getToken(ZigParser.EXCLAMATIONMARK, 0); }
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public Error_union_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_union_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterError_union_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitError_union_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitError_union_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Error_union_exprContext error_union_expr() throws RecognitionException {
		Error_union_exprContext _localctx = new Error_union_exprContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_error_union_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			suffix_expr();
			setState(689);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				{
				setState(687);
				match(EXCLAMATIONMARK);
				setState(688);
				type_expr();
				}
				break;
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
	public static class Suffix_exprContext extends ParserRuleContext {
		public Primary_type_exprContext primary_type_expr() {
			return getRuleContext(Primary_type_exprContext.class,0);
		}
		public List<Suffix_opContext> suffix_op() {
			return getRuleContexts(Suffix_opContext.class);
		}
		public Suffix_opContext suffix_op(int i) {
			return getRuleContext(Suffix_opContext.class,i);
		}
		public List<Fn_call_argumentsContext> fn_call_arguments() {
			return getRuleContexts(Fn_call_argumentsContext.class);
		}
		public Fn_call_argumentsContext fn_call_arguments(int i) {
			return getRuleContext(Fn_call_argumentsContext.class,i);
		}
		public Suffix_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterSuffix_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitSuffix_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitSuffix_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Suffix_exprContext suffix_expr() throws RecognitionException {
		Suffix_exprContext _localctx = new Suffix_exprContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_suffix_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			primary_type_expr();
			setState(696);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(694);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case DOT:
					case DOTASTERISK:
					case DOTQUESTIONMARK:
					case LBRACKET:
						{
						setState(692);
						suffix_op();
						}
						break;
					case LPAREN:
						{
						setState(693);
						fn_call_arguments();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(698);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
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
	public static class Primary_type_exprContext extends ParserRuleContext {
		public TerminalNode BUILTINIDENTIFIER() { return getToken(ZigParser.BUILTINIDENTIFIER, 0); }
		public Fn_call_argumentsContext fn_call_arguments() {
			return getRuleContext(Fn_call_argumentsContext.class,0);
		}
		public TerminalNode CHAR_LITERAL() { return getToken(ZigParser.CHAR_LITERAL, 0); }
		public Container_declContext container_decl() {
			return getRuleContext(Container_declContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ZigParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public Init_listContext init_list() {
			return getRuleContext(Init_listContext.class,0);
		}
		public Error_set_declContext error_set_decl() {
			return getRuleContext(Error_set_declContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(ZigParser.FLOAT, 0); }
		public Fn_protoContext fn_proto() {
			return getRuleContext(Fn_protoContext.class,0);
		}
		public Grouped_exprContext grouped_expr() {
			return getRuleContext(Grouped_exprContext.class,0);
		}
		public Labeled_type_exprContext labeled_type_expr() {
			return getRuleContext(Labeled_type_exprContext.class,0);
		}
		public If_type_exprContext if_type_expr() {
			return getRuleContext(If_type_exprContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(ZigParser.INTEGER, 0); }
		public TerminalNode COMPTIME() { return getToken(ZigParser.COMPTIME, 0); }
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public TerminalNode ERROR() { return getToken(ZigParser.ERROR, 0); }
		public TerminalNode ANYFRAME() { return getToken(ZigParser.ANYFRAME, 0); }
		public TerminalNode UNREACHABLE() { return getToken(ZigParser.UNREACHABLE, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(ZigParser.STRINGLITERAL, 0); }
		public Primary_type_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_type_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterPrimary_type_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitPrimary_type_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitPrimary_type_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_type_exprContext primary_type_expr() throws RecognitionException {
		Primary_type_exprContext _localctx = new Primary_type_exprContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_primary_type_expr);
		try {
			setState(723);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(699);
				match(BUILTINIDENTIFIER);
				setState(700);
				fn_call_arguments();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(701);
				match(CHAR_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(702);
				container_decl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(703);
				match(DOT);
				setState(704);
				match(IDENTIFIER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(705);
				match(DOT);
				setState(706);
				init_list();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(707);
				error_set_decl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(708);
				match(FLOAT);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(709);
				fn_proto();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(710);
				grouped_expr();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(711);
				labeled_type_expr();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(712);
				match(IDENTIFIER);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(713);
				if_type_expr();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(714);
				match(INTEGER);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(715);
				match(COMPTIME);
				setState(716);
				type_expr();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(717);
				match(ERROR);
				setState(718);
				match(DOT);
				setState(719);
				match(IDENTIFIER);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(720);
				match(ANYFRAME);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(721);
				match(UNREACHABLE);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(722);
				match(STRINGLITERAL);
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
	public static class Container_declContext extends ParserRuleContext {
		public Container_decl_autoContext container_decl_auto() {
			return getRuleContext(Container_decl_autoContext.class,0);
		}
		public TerminalNode EXTERN() { return getToken(ZigParser.EXTERN, 0); }
		public TerminalNode PACKED() { return getToken(ZigParser.PACKED, 0); }
		public Container_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_container_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterContainer_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitContainer_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitContainer_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Container_declContext container_decl() throws RecognitionException {
		Container_declContext _localctx = new Container_declContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_container_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(726);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTERN || _la==PACKED) {
				{
				setState(725);
				_la = _input.LA(1);
				if ( !(_la==EXTERN || _la==PACKED) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(728);
			container_decl_auto();
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
	public static class Error_set_declContext extends ParserRuleContext {
		public TerminalNode ERROR() { return getToken(ZigParser.ERROR, 0); }
		public TerminalNode LBRACE() { return getToken(ZigParser.LBRACE, 0); }
		public Identifier_listContext identifier_list() {
			return getRuleContext(Identifier_listContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ZigParser.RBRACE, 0); }
		public Error_set_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_set_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterError_set_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitError_set_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitError_set_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Error_set_declContext error_set_decl() throws RecognitionException {
		Error_set_declContext _localctx = new Error_set_declContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_error_set_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			match(ERROR);
			setState(731);
			match(LBRACE);
			setState(732);
			identifier_list();
			setState(733);
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
	public static class Grouped_exprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Grouped_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouped_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterGrouped_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitGrouped_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitGrouped_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Grouped_exprContext grouped_expr() throws RecognitionException {
		Grouped_exprContext _localctx = new Grouped_exprContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_grouped_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			match(LPAREN);
			setState(736);
			expr();
			setState(737);
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
	public static class If_type_exprContext extends ParserRuleContext {
		public If_prefixContext if_prefix() {
			return getRuleContext(If_prefixContext.class,0);
		}
		public List<Type_exprContext> type_expr() {
			return getRuleContexts(Type_exprContext.class);
		}
		public Type_exprContext type_expr(int i) {
			return getRuleContext(Type_exprContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ZigParser.ELSE, 0); }
		public PayloadContext payload() {
			return getRuleContext(PayloadContext.class,0);
		}
		public If_type_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_type_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterIf_type_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitIf_type_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitIf_type_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_type_exprContext if_type_expr() throws RecognitionException {
		If_type_exprContext _localctx = new If_type_exprContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_if_type_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			if_prefix();
			setState(740);
			type_expr();
			setState(746);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				{
				setState(741);
				match(ELSE);
				setState(743);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PIPE) {
					{
					setState(742);
					payload();
					}
				}

				setState(745);
				type_expr();
				}
				break;
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
	public static class Labeled_type_exprContext extends ParserRuleContext {
		public Block_labelContext block_label() {
			return getRuleContext(Block_labelContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Loop_type_exprContext loop_type_expr() {
			return getRuleContext(Loop_type_exprContext.class,0);
		}
		public Switch_exprContext switch_expr() {
			return getRuleContext(Switch_exprContext.class,0);
		}
		public Labeled_type_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeled_type_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterLabeled_type_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitLabeled_type_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitLabeled_type_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Labeled_type_exprContext labeled_type_expr() throws RecognitionException {
		Labeled_type_exprContext _localctx = new Labeled_type_exprContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_labeled_type_expr);
		int _la;
		try {
			setState(759);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(748);
				block_label();
				setState(749);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(752);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(751);
					block_label();
					}
				}

				setState(754);
				loop_type_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(756);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(755);
					block_label();
					}
				}

				setState(758);
				switch_expr();
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
	public static class Loop_type_exprContext extends ParserRuleContext {
		public For_type_exprContext for_type_expr() {
			return getRuleContext(For_type_exprContext.class,0);
		}
		public While_type_exprContext while_type_expr() {
			return getRuleContext(While_type_exprContext.class,0);
		}
		public TerminalNode INLINE() { return getToken(ZigParser.INLINE, 0); }
		public Loop_type_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_type_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterLoop_type_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitLoop_type_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitLoop_type_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_type_exprContext loop_type_expr() throws RecognitionException {
		Loop_type_exprContext _localctx = new Loop_type_exprContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_loop_type_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE) {
				{
				setState(761);
				match(INLINE);
				}
			}

			setState(766);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				{
				setState(764);
				for_type_expr();
				}
				break;
			case WHILE:
				{
				setState(765);
				while_type_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class For_type_exprContext extends ParserRuleContext {
		public For_prefixContext for_prefix() {
			return getRuleContext(For_prefixContext.class,0);
		}
		public List<Type_exprContext> type_expr() {
			return getRuleContexts(Type_exprContext.class);
		}
		public Type_exprContext type_expr(int i) {
			return getRuleContext(Type_exprContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ZigParser.ELSE, 0); }
		public For_type_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_type_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterFor_type_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitFor_type_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitFor_type_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_type_exprContext for_type_expr() throws RecognitionException {
		For_type_exprContext _localctx = new For_type_exprContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_for_type_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			for_prefix();
			setState(769);
			type_expr();
			setState(772);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(770);
				match(ELSE);
				setState(771);
				type_expr();
				}
				break;
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
	public static class While_type_exprContext extends ParserRuleContext {
		public While_prefixContext while_prefix() {
			return getRuleContext(While_prefixContext.class,0);
		}
		public List<Type_exprContext> type_expr() {
			return getRuleContexts(Type_exprContext.class);
		}
		public Type_exprContext type_expr(int i) {
			return getRuleContext(Type_exprContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ZigParser.ELSE, 0); }
		public PayloadContext payload() {
			return getRuleContext(PayloadContext.class,0);
		}
		public While_type_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_type_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterWhile_type_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitWhile_type_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitWhile_type_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_type_exprContext while_type_expr() throws RecognitionException {
		While_type_exprContext _localctx = new While_type_exprContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_while_type_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
			while_prefix();
			setState(775);
			type_expr();
			setState(781);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(776);
				match(ELSE);
				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PIPE) {
					{
					setState(777);
					payload();
					}
				}

				setState(780);
				type_expr();
				}
				break;
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
	public static class Switch_exprContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(ZigParser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(ZigParser.LBRACE, 0); }
		public Switch_prong_listContext switch_prong_list() {
			return getRuleContext(Switch_prong_listContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ZigParser.RBRACE, 0); }
		public Switch_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterSwitch_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitSwitch_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitSwitch_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_exprContext switch_expr() throws RecognitionException {
		Switch_exprContext _localctx = new Switch_exprContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_switch_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			match(SWITCH);
			setState(784);
			match(LPAREN);
			setState(785);
			expr();
			setState(786);
			match(RPAREN);
			setState(787);
			match(LBRACE);
			setState(788);
			switch_prong_list();
			setState(789);
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
	public static class Asm_exprContext extends ParserRuleContext {
		public TerminalNode ASM() { return getToken(ZigParser.ASM, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public TerminalNode VOLATILE() { return getToken(ZigParser.VOLATILE, 0); }
		public Asm_outputContext asm_output() {
			return getRuleContext(Asm_outputContext.class,0);
		}
		public Asm_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAsm_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAsm_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAsm_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asm_exprContext asm_expr() throws RecognitionException {
		Asm_exprContext _localctx = new Asm_exprContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_asm_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			match(ASM);
			setState(793);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VOLATILE) {
				{
				setState(792);
				match(VOLATILE);
				}
			}

			setState(795);
			match(LPAREN);
			setState(796);
			expr();
			setState(798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(797);
				asm_output();
				}
			}

			setState(800);
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
	public static class Asm_outputContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public Asm_output_listContext asm_output_list() {
			return getRuleContext(Asm_output_listContext.class,0);
		}
		public Asm_inputContext asm_input() {
			return getRuleContext(Asm_inputContext.class,0);
		}
		public Asm_outputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAsm_output(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAsm_output(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAsm_output(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asm_outputContext asm_output() throws RecognitionException {
		Asm_outputContext _localctx = new Asm_outputContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_asm_output);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
			match(COLON);
			setState(803);
			asm_output_list();
			setState(805);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(804);
				asm_input();
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
	public static class Asm_output_itemContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(ZigParser.LBRACKET, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(ZigParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ZigParser.IDENTIFIER, i);
		}
		public TerminalNode RBRACKET() { return getToken(ZigParser.RBRACKET, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(ZigParser.STRINGLITERAL, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public TerminalNode RARROW() { return getToken(ZigParser.RARROW, 0); }
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public Asm_output_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_output_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAsm_output_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAsm_output_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAsm_output_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asm_output_itemContext asm_output_item() throws RecognitionException {
		Asm_output_itemContext _localctx = new Asm_output_itemContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_asm_output_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(807);
			match(LBRACKET);
			setState(808);
			match(IDENTIFIER);
			setState(809);
			match(RBRACKET);
			setState(810);
			match(STRINGLITERAL);
			setState(811);
			match(LPAREN);
			setState(815);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RARROW:
				{
				setState(812);
				match(RARROW);
				setState(813);
				type_expr();
				}
				break;
			case IDENTIFIER:
				{
				setState(814);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(817);
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
	public static class Asm_inputContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public Asm_input_listContext asm_input_list() {
			return getRuleContext(Asm_input_listContext.class,0);
		}
		public Asm_clobbersContext asm_clobbers() {
			return getRuleContext(Asm_clobbersContext.class,0);
		}
		public Asm_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAsm_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAsm_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAsm_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asm_inputContext asm_input() throws RecognitionException {
		Asm_inputContext _localctx = new Asm_inputContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_asm_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(819);
			match(COLON);
			setState(820);
			asm_input_list();
			setState(822);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(821);
				asm_clobbers();
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
	public static class Asm_input_itemContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(ZigParser.LBRACKET, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public TerminalNode RBRACKET() { return getToken(ZigParser.RBRACKET, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(ZigParser.STRINGLITERAL, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Asm_input_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_input_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAsm_input_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAsm_input_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAsm_input_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asm_input_itemContext asm_input_item() throws RecognitionException {
		Asm_input_itemContext _localctx = new Asm_input_itemContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_asm_input_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(824);
			match(LBRACKET);
			setState(825);
			match(IDENTIFIER);
			setState(826);
			match(RBRACKET);
			setState(827);
			match(STRINGLITERAL);
			setState(828);
			match(LPAREN);
			setState(829);
			expr();
			setState(830);
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
	public static class Asm_clobbersContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Asm_clobbersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_clobbers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAsm_clobbers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAsm_clobbers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAsm_clobbers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asm_clobbersContext asm_clobbers() throws RecognitionException {
		Asm_clobbersContext _localctx = new Asm_clobbersContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_asm_clobbers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(832);
			match(COLON);
			setState(833);
			expr();
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
	public static class Break_labelContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public Break_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBreak_label(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBreak_label(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBreak_label(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_labelContext break_label() throws RecognitionException {
		Break_labelContext _localctx = new Break_labelContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_break_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(835);
			match(COLON);
			setState(836);
			match(IDENTIFIER);
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
	public static class Block_labelContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public Block_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBlock_label(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBlock_label(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBlock_label(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_labelContext block_label() throws RecognitionException {
		Block_labelContext _localctx = new Block_labelContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_block_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(838);
			match(IDENTIFIER);
			setState(839);
			match(COLON);
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
	public static class Field_initContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ZigParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(ZigParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Field_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterField_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitField_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitField_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_initContext field_init() throws RecognitionException {
		Field_initContext _localctx = new Field_initContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_field_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
			match(DOT);
			setState(842);
			match(IDENTIFIER);
			setState(843);
			match(EQUAL);
			setState(844);
			expr();
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
	public static class While_continue_exprContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public While_continue_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_continue_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterWhile_continue_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitWhile_continue_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitWhile_continue_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_continue_exprContext while_continue_expr() throws RecognitionException {
		While_continue_exprContext _localctx = new While_continue_exprContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_while_continue_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(846);
			match(COLON);
			setState(847);
			match(LPAREN);
			setState(848);
			assign_expr();
			setState(849);
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
	public static class Link_sectionContext extends ParserRuleContext {
		public TerminalNode LINKSECTION() { return getToken(ZigParser.LINKSECTION, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Link_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_link_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterLink_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitLink_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitLink_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Link_sectionContext link_section() throws RecognitionException {
		Link_sectionContext _localctx = new Link_sectionContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_link_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(851);
			match(LINKSECTION);
			setState(852);
			match(LPAREN);
			setState(853);
			expr();
			setState(854);
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
	public static class Addr_spaceContext extends ParserRuleContext {
		public TerminalNode ADDRSPACE() { return getToken(ZigParser.ADDRSPACE, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Addr_spaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addr_space; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAddr_space(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAddr_space(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAddr_space(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Addr_spaceContext addr_space() throws RecognitionException {
		Addr_spaceContext _localctx = new Addr_spaceContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_addr_space);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(856);
			match(ADDRSPACE);
			setState(857);
			match(LPAREN);
			setState(858);
			expr();
			setState(859);
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
	public static class Call_convContext extends ParserRuleContext {
		public TerminalNode CALLCONV() { return getToken(ZigParser.CALLCONV, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Call_convContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_conv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterCall_conv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitCall_conv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitCall_conv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_convContext call_conv() throws RecognitionException {
		Call_convContext _localctx = new Call_convContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_call_conv);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(861);
			match(CALLCONV);
			setState(862);
			match(LPAREN);
			setState(863);
			expr();
			setState(864);
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
	public static class Param_declContext extends ParserRuleContext {
		public Param_typeContext param_type() {
			return getRuleContext(Param_typeContext.class,0);
		}
		public TerminalNode Doc_comment() { return getToken(ZigParser.Doc_comment, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public TerminalNode NOALIAS() { return getToken(ZigParser.NOALIAS, 0); }
		public TerminalNode COMPTIME() { return getToken(ZigParser.COMPTIME, 0); }
		public TerminalNode DOT3() { return getToken(ZigParser.DOT3, 0); }
		public Param_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterParam_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitParam_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitParam_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_declContext param_decl() throws RecognitionException {
		Param_declContext _localctx = new Param_declContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_param_decl);
		int _la;
		try {
			setState(878);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ANYFRAME:
			case ANYTYPE:
			case COMPTIME:
			case ENUM:
			case ERROR:
			case EXTERN:
			case FN:
			case FOR:
			case IF:
			case INLINE:
			case NOALIAS:
			case OPAQUE:
			case PACKED:
			case STRUCT:
			case SWITCH:
			case UNION:
			case UNREACHABLE:
			case WHILE:
			case ASTERISK:
			case ASTERISK2:
			case DOT:
			case LBRACKET:
			case LPAREN:
			case QUESTIONMARK:
			case Doc_comment:
			case IDENTIFIER:
			case STRINGLITERAL:
			case CHAR_LITERAL:
			case FLOAT:
			case INTEGER:
			case BUILTINIDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(867);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Doc_comment) {
					{
					setState(866);
					match(Doc_comment);
					}
				}

				setState(870);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
				case 1:
					{
					setState(869);
					_la = _input.LA(1);
					if ( !(_la==COMPTIME || _la==NOALIAS) ) {
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
				setState(874);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					{
					setState(872);
					match(IDENTIFIER);
					setState(873);
					match(COLON);
					}
					break;
				}
				setState(876);
				param_type();
				}
				break;
			case DOT3:
				enterOuterAlt(_localctx, 2);
				{
				setState(877);
				match(DOT3);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Param_typeContext extends ParserRuleContext {
		public TerminalNode ANYTYPE() { return getToken(ZigParser.ANYTYPE, 0); }
		public Type_exprContext type_expr() {
			return getRuleContext(Type_exprContext.class,0);
		}
		public Param_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterParam_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitParam_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitParam_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_typeContext param_type() throws RecognitionException {
		Param_typeContext _localctx = new Param_typeContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_param_type);
		try {
			setState(882);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ANYTYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(880);
				match(ANYTYPE);
				}
				break;
			case ANYFRAME:
			case COMPTIME:
			case ENUM:
			case ERROR:
			case EXTERN:
			case FN:
			case FOR:
			case IF:
			case INLINE:
			case OPAQUE:
			case PACKED:
			case STRUCT:
			case SWITCH:
			case UNION:
			case UNREACHABLE:
			case WHILE:
			case ASTERISK:
			case ASTERISK2:
			case DOT:
			case LBRACKET:
			case LPAREN:
			case QUESTIONMARK:
			case IDENTIFIER:
			case STRINGLITERAL:
			case CHAR_LITERAL:
			case FLOAT:
			case INTEGER:
			case BUILTINIDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(881);
				type_expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class If_prefixContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ZigParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Ptr_payloadContext ptr_payload() {
			return getRuleContext(Ptr_payloadContext.class,0);
		}
		public If_prefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterIf_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitIf_prefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitIf_prefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_prefixContext if_prefix() throws RecognitionException {
		If_prefixContext _localctx = new If_prefixContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_if_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			match(IF);
			setState(885);
			match(LPAREN);
			setState(886);
			expr();
			setState(887);
			match(RPAREN);
			setState(889);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PIPE) {
				{
				setState(888);
				ptr_payload();
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
	public static class While_prefixContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ZigParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Ptr_payloadContext ptr_payload() {
			return getRuleContext(Ptr_payloadContext.class,0);
		}
		public While_continue_exprContext while_continue_expr() {
			return getRuleContext(While_continue_exprContext.class,0);
		}
		public While_prefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterWhile_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitWhile_prefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitWhile_prefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_prefixContext while_prefix() throws RecognitionException {
		While_prefixContext _localctx = new While_prefixContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_while_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(891);
			match(WHILE);
			setState(892);
			match(LPAREN);
			setState(893);
			expr();
			setState(894);
			match(RPAREN);
			setState(896);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PIPE) {
				{
				setState(895);
				ptr_payload();
				}
			}

			setState(899);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(898);
				while_continue_expr();
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
	public static class For_prefixContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ZigParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public For_arguments_listContext for_arguments_list() {
			return getRuleContext(For_arguments_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Ptr_list_payloadContext ptr_list_payload() {
			return getRuleContext(Ptr_list_payloadContext.class,0);
		}
		public For_prefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterFor_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitFor_prefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitFor_prefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_prefixContext for_prefix() throws RecognitionException {
		For_prefixContext _localctx = new For_prefixContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_for_prefix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			match(FOR);
			setState(902);
			match(LPAREN);
			setState(903);
			for_arguments_list();
			setState(904);
			match(RPAREN);
			setState(905);
			ptr_list_payload();
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
	public static class PayloadContext extends ParserRuleContext {
		public List<TerminalNode> PIPE() { return getTokens(ZigParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(ZigParser.PIPE, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public PayloadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_payload; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterPayload(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitPayload(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitPayload(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PayloadContext payload() throws RecognitionException {
		PayloadContext _localctx = new PayloadContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_payload);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(907);
			match(PIPE);
			setState(908);
			match(IDENTIFIER);
			setState(909);
			match(PIPE);
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
	public static class Ptr_payloadContext extends ParserRuleContext {
		public List<TerminalNode> PIPE() { return getTokens(ZigParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(ZigParser.PIPE, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public TerminalNode ASTERISK() { return getToken(ZigParser.ASTERISK, 0); }
		public Ptr_payloadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptr_payload; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterPtr_payload(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitPtr_payload(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitPtr_payload(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ptr_payloadContext ptr_payload() throws RecognitionException {
		Ptr_payloadContext _localctx = new Ptr_payloadContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_ptr_payload);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(911);
			match(PIPE);
			setState(913);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASTERISK) {
				{
				setState(912);
				match(ASTERISK);
				}
			}

			setState(915);
			match(IDENTIFIER);
			setState(916);
			match(PIPE);
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
	public static class Ptr_index_payloadContext extends ParserRuleContext {
		public List<TerminalNode> PIPE() { return getTokens(ZigParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(ZigParser.PIPE, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ZigParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ZigParser.IDENTIFIER, i);
		}
		public TerminalNode ASTERISK() { return getToken(ZigParser.ASTERISK, 0); }
		public TerminalNode COMMA() { return getToken(ZigParser.COMMA, 0); }
		public Ptr_index_payloadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptr_index_payload; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterPtr_index_payload(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitPtr_index_payload(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitPtr_index_payload(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ptr_index_payloadContext ptr_index_payload() throws RecognitionException {
		Ptr_index_payloadContext _localctx = new Ptr_index_payloadContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_ptr_index_payload);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
			match(PIPE);
			setState(920);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASTERISK) {
				{
				setState(919);
				match(ASTERISK);
				}
			}

			setState(922);
			match(IDENTIFIER);
			setState(925);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(923);
				match(COMMA);
				setState(924);
				match(IDENTIFIER);
				}
			}

			setState(927);
			match(PIPE);
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
	public static class Ptr_list_payloadContext extends ParserRuleContext {
		public List<TerminalNode> PIPE() { return getTokens(ZigParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(ZigParser.PIPE, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ZigParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ZigParser.IDENTIFIER, i);
		}
		public List<TerminalNode> ASTERISK() { return getTokens(ZigParser.ASTERISK); }
		public TerminalNode ASTERISK(int i) {
			return getToken(ZigParser.ASTERISK, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public Ptr_list_payloadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptr_list_payload; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterPtr_list_payload(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitPtr_list_payload(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitPtr_list_payload(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ptr_list_payloadContext ptr_list_payload() throws RecognitionException {
		Ptr_list_payloadContext _localctx = new Ptr_list_payloadContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_ptr_list_payload);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(929);
			match(PIPE);
			setState(931);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASTERISK) {
				{
				setState(930);
				match(ASTERISK);
				}
			}

			setState(933);
			match(IDENTIFIER);
			setState(941);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(934);
					match(COMMA);
					setState(936);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ASTERISK) {
						{
						setState(935);
						match(ASTERISK);
						}
					}

					setState(938);
					match(IDENTIFIER);
					}
					} 
				}
				setState(943);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
			}
			setState(945);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(944);
				match(COMMA);
				}
			}

			setState(947);
			match(PIPE);
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
	public static class Switch_prongContext extends ParserRuleContext {
		public Switch_caseContext switch_case() {
			return getRuleContext(Switch_caseContext.class,0);
		}
		public TerminalNode EQUALRARROW() { return getToken(ZigParser.EQUALRARROW, 0); }
		public Simple_assign_exprContext simple_assign_expr() {
			return getRuleContext(Simple_assign_exprContext.class,0);
		}
		public TerminalNode INLINE() { return getToken(ZigParser.INLINE, 0); }
		public Ptr_index_payloadContext ptr_index_payload() {
			return getRuleContext(Ptr_index_payloadContext.class,0);
		}
		public Switch_prongContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_prong; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterSwitch_prong(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitSwitch_prong(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitSwitch_prong(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_prongContext switch_prong() throws RecognitionException {
		Switch_prongContext _localctx = new Switch_prongContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_switch_prong);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(950);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				{
				setState(949);
				match(INLINE);
				}
				break;
			}
			setState(952);
			switch_case();
			setState(953);
			match(EQUALRARROW);
			setState(955);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PIPE) {
				{
				setState(954);
				ptr_index_payload();
				}
			}

			setState(957);
			simple_assign_expr();
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
	public static class Switch_caseContext extends ParserRuleContext {
		public List<Switch_itemContext> switch_item() {
			return getRuleContexts(Switch_itemContext.class);
		}
		public Switch_itemContext switch_item(int i) {
			return getRuleContext(Switch_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public TerminalNode ELSE() { return getToken(ZigParser.ELSE, 0); }
		public Switch_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_case; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterSwitch_case(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitSwitch_case(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitSwitch_case(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_caseContext switch_case() throws RecognitionException {
		Switch_caseContext _localctx = new Switch_caseContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_switch_case);
		int _la;
		try {
			int _alt;
			setState(971);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ANYFRAME:
			case ASM:
			case BREAK:
			case COMPTIME:
			case CONTINUE:
			case ENUM:
			case ERROR:
			case EXTERN:
			case FN:
			case FOR:
			case IF:
			case INLINE:
			case NOSUSPEND:
			case OPAQUE:
			case PACKED:
			case RESUME:
			case RETURN:
			case STRUCT:
			case SWITCH:
			case TRY:
			case UNION:
			case UNREACHABLE:
			case WHILE:
			case AMPERSAND:
			case ASTERISK:
			case ASTERISK2:
			case DOT:
			case EXCLAMATIONMARK:
			case LBRACE:
			case LBRACKET:
			case LPAREN:
			case MINUS:
			case MINUSPERCENT:
			case QUESTIONMARK:
			case TILDE:
			case IDENTIFIER:
			case STRINGLITERAL:
			case CHAR_LITERAL:
			case FLOAT:
			case INTEGER:
			case BUILTINIDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(959);
				switch_item();
				setState(964);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(960);
						match(COMMA);
						setState(961);
						switch_item();
						}
						} 
					}
					setState(966);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
				}
				setState(968);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(967);
					match(COMMA);
					}
				}

				}
				break;
			case ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(970);
				match(ELSE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Switch_itemContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOT3() { return getToken(ZigParser.DOT3, 0); }
		public Switch_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterSwitch_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitSwitch_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitSwitch_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_itemContext switch_item() throws RecognitionException {
		Switch_itemContext _localctx = new Switch_itemContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_switch_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(973);
			expr();
			setState(976);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT3) {
				{
				setState(974);
				match(DOT3);
				setState(975);
				expr();
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
	public static class For_arguments_listContext extends ParserRuleContext {
		public List<For_itemContext> for_item() {
			return getRuleContexts(For_itemContext.class);
		}
		public For_itemContext for_item(int i) {
			return getRuleContext(For_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public For_arguments_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_arguments_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterFor_arguments_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitFor_arguments_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitFor_arguments_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_arguments_listContext for_arguments_list() throws RecognitionException {
		For_arguments_listContext _localctx = new For_arguments_listContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_for_arguments_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			for_item();
			setState(983);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(979);
					match(COMMA);
					setState(980);
					for_item();
					}
					} 
				}
				setState(985);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			}
			setState(987);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(986);
				match(COMMA);
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
	public static class For_itemContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOT2() { return getToken(ZigParser.DOT2, 0); }
		public For_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterFor_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitFor_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitFor_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_itemContext for_item() throws RecognitionException {
		For_itemContext _localctx = new For_itemContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_for_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(989);
			expr();
			setState(994);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT2) {
				{
				setState(990);
				match(DOT2);
				setState(992);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2309588346088008096L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 4437631077199617L) != 0)) {
					{
					setState(991);
					expr();
					}
				}

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
	public static class Assign_opContext extends ParserRuleContext {
		public TerminalNode ASTERISKEQUAL() { return getToken(ZigParser.ASTERISKEQUAL, 0); }
		public TerminalNode ASTERISKPIPEEQUAL() { return getToken(ZigParser.ASTERISKPIPEEQUAL, 0); }
		public TerminalNode SLASHEQUAL() { return getToken(ZigParser.SLASHEQUAL, 0); }
		public TerminalNode PERCENTEQUAL() { return getToken(ZigParser.PERCENTEQUAL, 0); }
		public TerminalNode PLUSEQUAL() { return getToken(ZigParser.PLUSEQUAL, 0); }
		public TerminalNode PLUSPIPEEQUAL() { return getToken(ZigParser.PLUSPIPEEQUAL, 0); }
		public TerminalNode MINUSEQUAL() { return getToken(ZigParser.MINUSEQUAL, 0); }
		public TerminalNode MINUSPIPEEQUAL() { return getToken(ZigParser.MINUSPIPEEQUAL, 0); }
		public TerminalNode LARROW2EQUAL() { return getToken(ZigParser.LARROW2EQUAL, 0); }
		public TerminalNode LARROW2PIPEEQUAL() { return getToken(ZigParser.LARROW2PIPEEQUAL, 0); }
		public TerminalNode RARROW2EQUAL() { return getToken(ZigParser.RARROW2EQUAL, 0); }
		public TerminalNode AMPERSANDEQUAL() { return getToken(ZigParser.AMPERSANDEQUAL, 0); }
		public TerminalNode CARETEQUAL() { return getToken(ZigParser.CARETEQUAL, 0); }
		public TerminalNode PIPEEQUAL() { return getToken(ZigParser.PIPEEQUAL, 0); }
		public TerminalNode ASTERISKPERCENTEQUAL() { return getToken(ZigParser.ASTERISKPERCENTEQUAL, 0); }
		public TerminalNode PLUSPERCENTEQUAL() { return getToken(ZigParser.PLUSPERCENTEQUAL, 0); }
		public TerminalNode MINUSPERCENTEQUAL() { return getToken(ZigParser.MINUSPERCENTEQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(ZigParser.EQUAL, 0); }
		public Assign_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAssign_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAssign_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAssign_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_opContext assign_op() throws RecognitionException {
		Assign_opContext _localctx = new Assign_opContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_assign_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(996);
			_la = _input.LA(1);
			if ( !(((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & 2324601317617697449L) != 0)) ) {
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
	public static class Compare_opContext extends ParserRuleContext {
		public TerminalNode EQUALEQUAL() { return getToken(ZigParser.EQUALEQUAL, 0); }
		public TerminalNode EXCLAMATIONMARKEQUAL() { return getToken(ZigParser.EXCLAMATIONMARKEQUAL, 0); }
		public TerminalNode LARROW() { return getToken(ZigParser.LARROW, 0); }
		public TerminalNode RARROW() { return getToken(ZigParser.RARROW, 0); }
		public TerminalNode LARROWEQUAL() { return getToken(ZigParser.LARROWEQUAL, 0); }
		public TerminalNode RARROWEQUAL() { return getToken(ZigParser.RARROWEQUAL, 0); }
		public Compare_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterCompare_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitCompare_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitCompare_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compare_opContext compare_op() throws RecognitionException {
		Compare_opContext _localctx = new Compare_opContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_compare_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(998);
			_la = _input.LA(1);
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 154618823193L) != 0)) ) {
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
	public static class Bitwise_opContext extends ParserRuleContext {
		public TerminalNode AMPERSAND() { return getToken(ZigParser.AMPERSAND, 0); }
		public TerminalNode CARET() { return getToken(ZigParser.CARET, 0); }
		public TerminalNode PIPE() { return getToken(ZigParser.PIPE, 0); }
		public TerminalNode ORELSE() { return getToken(ZigParser.ORELSE, 0); }
		public TerminalNode CATCH() { return getToken(ZigParser.CATCH, 0); }
		public PayloadContext payload() {
			return getRuleContext(PayloadContext.class,0);
		}
		public Bitwise_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBitwise_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBitwise_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBitwise_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_opContext bitwise_op() throws RecognitionException {
		Bitwise_opContext _localctx = new Bitwise_opContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_bitwise_op);
		int _la;
		try {
			setState(1008);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AMPERSAND:
				enterOuterAlt(_localctx, 1);
				{
				setState(1000);
				match(AMPERSAND);
				}
				break;
			case CARET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1001);
				match(CARET);
				}
				break;
			case PIPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1002);
				match(PIPE);
				}
				break;
			case ORELSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1003);
				match(ORELSE);
				}
				break;
			case CATCH:
				enterOuterAlt(_localctx, 5);
				{
				setState(1004);
				match(CATCH);
				setState(1006);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PIPE) {
					{
					setState(1005);
					payload();
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class Bit_shift_opContext extends ParserRuleContext {
		public TerminalNode LARROW2() { return getToken(ZigParser.LARROW2, 0); }
		public TerminalNode RARROW2() { return getToken(ZigParser.RARROW2, 0); }
		public TerminalNode LARROW2PIPE() { return getToken(ZigParser.LARROW2PIPE, 0); }
		public Bit_shift_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_shift_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterBit_shift_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitBit_shift_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitBit_shift_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bit_shift_opContext bit_shift_op() throws RecognitionException {
		Bit_shift_opContext _localctx = new Bit_shift_opContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_bit_shift_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1010);
			_la = _input.LA(1);
			if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 1073741829L) != 0)) ) {
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
	public static class Addition_opContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ZigParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ZigParser.MINUS, 0); }
		public TerminalNode PLUS2() { return getToken(ZigParser.PLUS2, 0); }
		public TerminalNode PLUSPERCENT() { return getToken(ZigParser.PLUSPERCENT, 0); }
		public TerminalNode MINUSPERCENT() { return getToken(ZigParser.MINUSPERCENT, 0); }
		public TerminalNode PLUSPIPE() { return getToken(ZigParser.PLUSPIPE, 0); }
		public TerminalNode MINUSPIPE() { return getToken(ZigParser.MINUSPIPE, 0); }
		public Addition_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addition_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAddition_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAddition_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAddition_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Addition_opContext addition_op() throws RecognitionException {
		Addition_opContext _localctx = new Addition_opContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_addition_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1012);
			_la = _input.LA(1);
			if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & 176149L) != 0)) ) {
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
	public static class Multiply_opContext extends ParserRuleContext {
		public TerminalNode PIPE2() { return getToken(ZigParser.PIPE2, 0); }
		public TerminalNode ASTERISK() { return getToken(ZigParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(ZigParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(ZigParser.PERCENT, 0); }
		public TerminalNode ASTERISK2() { return getToken(ZigParser.ASTERISK2, 0); }
		public TerminalNode ASTERISKPERCENT() { return getToken(ZigParser.ASTERISKPERCENT, 0); }
		public TerminalNode ASTERISKPIPE() { return getToken(ZigParser.ASTERISKPIPE, 0); }
		public Multiply_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiply_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterMultiply_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitMultiply_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitMultiply_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiply_opContext multiply_op() throws RecognitionException {
		Multiply_opContext _localctx = new Multiply_opContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_multiply_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1014);
			_la = _input.LA(1);
			if ( !(((((_la - 50)) & ~0x3f) == 0 && ((1L << (_la - 50)) & 576461989254004779L) != 0)) ) {
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
	public static class Prefix_opContext extends ParserRuleContext {
		public TerminalNode EXCLAMATIONMARK() { return getToken(ZigParser.EXCLAMATIONMARK, 0); }
		public TerminalNode MINUS() { return getToken(ZigParser.MINUS, 0); }
		public TerminalNode TILDE() { return getToken(ZigParser.TILDE, 0); }
		public TerminalNode MINUSPERCENT() { return getToken(ZigParser.MINUSPERCENT, 0); }
		public TerminalNode AMPERSAND() { return getToken(ZigParser.AMPERSAND, 0); }
		public TerminalNode TRY() { return getToken(ZigParser.TRY, 0); }
		public Prefix_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterPrefix_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitPrefix_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitPrefix_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_opContext prefix_op() throws RecognitionException {
		Prefix_opContext _localctx = new Prefix_opContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_prefix_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1016);
			_la = _input.LA(1);
			if ( !(_la==TRY || _la==AMPERSAND || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 4398046521345L) != 0)) ) {
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
	public static class Prefix_type_opContext extends ParserRuleContext {
		public TerminalNode QUESTIONMARK() { return getToken(ZigParser.QUESTIONMARK, 0); }
		public TerminalNode ANYFRAME() { return getToken(ZigParser.ANYFRAME, 0); }
		public TerminalNode MINUSRARROW() { return getToken(ZigParser.MINUSRARROW, 0); }
		public Slice_type_startContext slice_type_start() {
			return getRuleContext(Slice_type_startContext.class,0);
		}
		public Ptr_type_startContext ptr_type_start() {
			return getRuleContext(Ptr_type_startContext.class,0);
		}
		public Array_type_startContext array_type_start() {
			return getRuleContext(Array_type_startContext.class,0);
		}
		public Prefix_type_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_type_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterPrefix_type_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitPrefix_type_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitPrefix_type_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_type_opContext prefix_type_op() throws RecognitionException {
		Prefix_type_opContext _localctx = new Prefix_type_opContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_prefix_type_op);
		try {
			setState(1024);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1018);
				match(QUESTIONMARK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1019);
				match(ANYFRAME);
				setState(1020);
				match(MINUSRARROW);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1021);
				slice_type_start();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1022);
				ptr_type_start();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1023);
				array_type_start();
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
	public static class Suffix_opContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(ZigParser.LBRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(ZigParser.RBRACKET, 0); }
		public TerminalNode DOT2() { return getToken(ZigParser.DOT2, 0); }
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public TerminalNode DOT() { return getToken(ZigParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ZigParser.IDENTIFIER, 0); }
		public TerminalNode DOTASTERISK() { return getToken(ZigParser.DOTASTERISK, 0); }
		public TerminalNode DOTQUESTIONMARK() { return getToken(ZigParser.DOTQUESTIONMARK, 0); }
		public Suffix_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterSuffix_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitSuffix_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitSuffix_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Suffix_opContext suffix_op() throws RecognitionException {
		Suffix_opContext _localctx = new Suffix_opContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_suffix_op);
		int _la;
		try {
			setState(1046);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(1026);
				match(LBRACKET);
				setState(1027);
				expr();
				setState(1038);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT2) {
					{
					setState(1028);
					match(DOT2);
					setState(1036);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
					case 1:
						{
						setState(1030);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2309588346088008096L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 4437631077199617L) != 0)) {
							{
							setState(1029);
							expr();
							}
						}

						setState(1034);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COLON) {
							{
							setState(1032);
							match(COLON);
							setState(1033);
							expr();
							}
						}

						}
						break;
					}
					}
				}

				setState(1040);
				match(RBRACKET);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1042);
				match(DOT);
				setState(1043);
				match(IDENTIFIER);
				}
				break;
			case DOTASTERISK:
				enterOuterAlt(_localctx, 3);
				{
				setState(1044);
				match(DOTASTERISK);
				}
				break;
			case DOTQUESTIONMARK:
				enterOuterAlt(_localctx, 4);
				{
				setState(1045);
				match(DOTQUESTIONMARK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Fn_call_argumentsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Fn_call_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fn_call_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterFn_call_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitFn_call_arguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitFn_call_arguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fn_call_argumentsContext fn_call_arguments() throws RecognitionException {
		Fn_call_argumentsContext _localctx = new Fn_call_argumentsContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_fn_call_arguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1048);
			match(LPAREN);
			setState(1049);
			expr_list();
			setState(1050);
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
	public static class Slice_type_startContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(ZigParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ZigParser.RBRACKET, 0); }
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Slice_type_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice_type_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterSlice_type_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitSlice_type_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitSlice_type_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Slice_type_startContext slice_type_start() throws RecognitionException {
		Slice_type_startContext _localctx = new Slice_type_startContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_slice_type_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1052);
			match(LBRACKET);
			setState(1055);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1053);
				match(COLON);
				setState(1054);
				expr();
				}
			}

			setState(1057);
			match(RBRACKET);
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
	public static class Ptr_type_startContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(ZigParser.ASTERISK, 0); }
		public TerminalNode ASTERISK2() { return getToken(ZigParser.ASTERISK2, 0); }
		public TerminalNode LBRACKET() { return getToken(ZigParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ZigParser.RBRACKET, 0); }
		public TerminalNode LETTERC() { return getToken(ZigParser.LETTERC, 0); }
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Ptr_type_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptr_type_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterPtr_type_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitPtr_type_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitPtr_type_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ptr_type_startContext ptr_type_start() throws RecognitionException {
		Ptr_type_startContext _localctx = new Ptr_type_startContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_ptr_type_start);
		try {
			setState(1069);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
				enterOuterAlt(_localctx, 1);
				{
				setState(1059);
				match(ASTERISK);
				}
				break;
			case ASTERISK2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1060);
				match(ASTERISK2);
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(1061);
				match(LBRACKET);
				setState(1062);
				match(ASTERISK);
				setState(1066);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LETTERC:
					{
					setState(1063);
					match(LETTERC);
					}
					break;
				case COLON:
					{
					setState(1064);
					match(COLON);
					setState(1065);
					expr();
					}
					break;
				case RBRACKET:
					break;
				default:
					break;
				}
				setState(1068);
				match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Array_type_startContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(ZigParser.LBRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(ZigParser.RBRACKET, 0); }
		public TerminalNode COLON() { return getToken(ZigParser.COLON, 0); }
		public Array_type_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterArray_type_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitArray_type_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitArray_type_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_type_startContext array_type_start() throws RecognitionException {
		Array_type_startContext _localctx = new Array_type_startContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_array_type_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1071);
			match(LBRACKET);
			setState(1072);
			expr();
			setState(1075);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1073);
				match(COLON);
				setState(1074);
				expr();
				}
			}

			setState(1077);
			match(RBRACKET);
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
	public static class Container_decl_autoContext extends ParserRuleContext {
		public Container_decl_typeContext container_decl_type() {
			return getRuleContext(Container_decl_typeContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ZigParser.LBRACE, 0); }
		public Container_membersContext container_members() {
			return getRuleContext(Container_membersContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ZigParser.RBRACE, 0); }
		public Container_decl_autoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_container_decl_auto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterContainer_decl_auto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitContainer_decl_auto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitContainer_decl_auto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Container_decl_autoContext container_decl_auto() throws RecognitionException {
		Container_decl_autoContext _localctx = new Container_decl_autoContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_container_decl_auto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1079);
			container_decl_type();
			setState(1080);
			match(LBRACE);
			setState(1081);
			container_members();
			setState(1082);
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
	public static class Container_decl_typeContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(ZigParser.STRUCT, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(ZigParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(ZigParser.LPAREN, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ZigParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(ZigParser.RPAREN, i);
		}
		public TerminalNode OPAQUE() { return getToken(ZigParser.OPAQUE, 0); }
		public TerminalNode ENUM() { return getToken(ZigParser.ENUM, 0); }
		public TerminalNode UNION() { return getToken(ZigParser.UNION, 0); }
		public Container_decl_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_container_decl_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterContainer_decl_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitContainer_decl_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitContainer_decl_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Container_decl_typeContext container_decl_type() throws RecognitionException {
		Container_decl_typeContext _localctx = new Container_decl_typeContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_container_decl_type);
		int _la;
		try {
			setState(1114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRUCT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1084);
				match(STRUCT);
				setState(1089);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(1085);
					match(LPAREN);
					setState(1086);
					expr();
					setState(1087);
					match(RPAREN);
					}
				}

				}
				break;
			case OPAQUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1091);
				match(OPAQUE);
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(1092);
				match(ENUM);
				setState(1097);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(1093);
					match(LPAREN);
					setState(1094);
					expr();
					setState(1095);
					match(RPAREN);
					}
				}

				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(1099);
				match(UNION);
				setState(1112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(1100);
					match(LPAREN);
					setState(1109);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
					case 1:
						{
						setState(1101);
						match(ENUM);
						setState(1106);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LPAREN) {
							{
							setState(1102);
							match(LPAREN);
							setState(1103);
							expr();
							setState(1104);
							match(RPAREN);
							}
						}

						}
						break;
					case 2:
						{
						setState(1108);
						expr();
						}
						break;
					}
					setState(1111);
					match(RPAREN);
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class Byte_alignContext extends ParserRuleContext {
		public TerminalNode ALIGN() { return getToken(ZigParser.ALIGN, 0); }
		public TerminalNode LPAREN() { return getToken(ZigParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ZigParser.RPAREN, 0); }
		public Byte_alignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_byte_align; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterByte_align(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitByte_align(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitByte_align(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Byte_alignContext byte_align() throws RecognitionException {
		Byte_alignContext _localctx = new Byte_alignContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_byte_align);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1116);
			match(ALIGN);
			setState(1117);
			match(LPAREN);
			setState(1118);
			expr();
			setState(1119);
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
	public static class Identifier_listContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ZigParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ZigParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public List<TerminalNode> Doc_comment() { return getTokens(ZigParser.Doc_comment); }
		public TerminalNode Doc_comment(int i) {
			return getToken(ZigParser.Doc_comment, i);
		}
		public Identifier_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterIdentifier_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitIdentifier_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitIdentifier_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Identifier_listContext identifier_list() throws RecognitionException {
		Identifier_listContext _localctx = new Identifier_listContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_identifier_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1122);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Doc_comment) {
						{
						setState(1121);
						match(Doc_comment);
						}
					}

					setState(1124);
					match(IDENTIFIER);
					setState(1125);
					match(COMMA);
					}
					} 
				}
				setState(1130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
			}
			setState(1135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Doc_comment || _la==IDENTIFIER) {
				{
				setState(1132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Doc_comment) {
					{
					setState(1131);
					match(Doc_comment);
					}
				}

				setState(1134);
				match(IDENTIFIER);
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
	public static class Switch_prong_listContext extends ParserRuleContext {
		public List<Switch_prongContext> switch_prong() {
			return getRuleContexts(Switch_prongContext.class);
		}
		public Switch_prongContext switch_prong(int i) {
			return getRuleContext(Switch_prongContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public Switch_prong_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_prong_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterSwitch_prong_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitSwitch_prong_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitSwitch_prong_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_prong_listContext switch_prong_list() throws RecognitionException {
		Switch_prong_listContext _localctx = new Switch_prong_listContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_switch_prong_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1137);
					switch_prong();
					setState(1138);
					match(COMMA);
					}
					} 
				}
				setState(1144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
			}
			setState(1146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2309588346088040864L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 4437631077199617L) != 0)) {
				{
				setState(1145);
				switch_prong();
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
	public static class Asm_output_listContext extends ParserRuleContext {
		public List<Asm_output_itemContext> asm_output_item() {
			return getRuleContexts(Asm_output_itemContext.class);
		}
		public Asm_output_itemContext asm_output_item(int i) {
			return getRuleContext(Asm_output_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public Asm_output_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_output_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAsm_output_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAsm_output_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAsm_output_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asm_output_listContext asm_output_list() throws RecognitionException {
		Asm_output_listContext _localctx = new Asm_output_listContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_asm_output_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1148);
					asm_output_item();
					setState(1149);
					match(COMMA);
					}
					} 
				}
				setState(1155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
			}
			setState(1157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(1156);
				asm_output_item();
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
	public static class Asm_input_listContext extends ParserRuleContext {
		public List<Asm_input_itemContext> asm_input_item() {
			return getRuleContexts(Asm_input_itemContext.class);
		}
		public Asm_input_itemContext asm_input_item(int i) {
			return getRuleContext(Asm_input_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public Asm_input_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asm_input_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterAsm_input_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitAsm_input_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitAsm_input_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Asm_input_listContext asm_input_list() throws RecognitionException {
		Asm_input_listContext _localctx = new Asm_input_listContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_asm_input_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1164);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1159);
					asm_input_item();
					setState(1160);
					match(COMMA);
					}
					} 
				}
				setState(1166);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
			}
			setState(1168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(1167);
				asm_input_item();
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
	public static class Param_decl_listContext extends ParserRuleContext {
		public List<Param_declContext> param_decl() {
			return getRuleContexts(Param_declContext.class);
		}
		public Param_declContext param_decl(int i) {
			return getRuleContext(Param_declContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public Param_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterParam_decl_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitParam_decl_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitParam_decl_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_decl_listContext param_decl_list() throws RecognitionException {
		Param_decl_listContext _localctx = new Param_decl_listContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_param_decl_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1170);
					param_decl();
					setState(1171);
					match(COMMA);
					}
					} 
				}
				setState(1177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			}
			setState(1179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6914067416507676576L) != 0) || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 8693018001411L) != 0)) {
				{
				setState(1178);
				param_decl();
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
	public static class Expr_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ZigParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZigParser.COMMA, i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZigParserListener ) ((ZigParserListener)listener).exitExpr_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZigParserVisitor ) return ((ZigParserVisitor<? extends T>)visitor).visitExpr_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_expr_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,165,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1181);
					expr();
					setState(1182);
					match(COMMA);
					}
					} 
				}
				setState(1188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,165,_ctx);
			}
			setState(1190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2309588346088008096L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 4437631077199617L) != 0)) {
				{
				setState(1189);
				expr();
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

	public static final String _serializedATN =
		"\u0004\u0001x\u04a9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"+
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"+
		"_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007c\u0002"+
		"d\u0007d\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0003\u0001\u00cf"+
		"\b\u0001\u0001\u0001\u0005\u0001\u00d2\b\u0001\n\u0001\f\u0001\u00d5\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u00da\b\u0001\n"+
		"\u0001\f\u0001\u00dd\t\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u00e1"+
		"\b\u0001\n\u0001\f\u0001\u00e4\t\u0001\u0003\u0001\u00e6\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00eb\b\u0002\u0001\u0002\u0003"+
		"\u0002\u00ee\b\u0002\u0001\u0002\u0003\u0002\u00f1\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00fd\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0101\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u0106\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u010b\b\u0005\u0001\u0005\u0003\u0005\u010e\b\u0005\u0001\u0005\u0003"+
		"\u0005\u0111\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u0115\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u011b\b\u0006"+
		"\u0001\u0006\u0003\u0006\u011e\b\u0006\u0001\u0006\u0003\u0006\u0121\b"+
		"\u0006\u0001\u0006\u0003\u0006\u0124\b\u0006\u0001\u0006\u0003\u0006\u0127"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u012f\b\u0007\u0001\u0007\u0003\u0007\u0132\b\u0007"+
		"\u0001\u0007\u0003\u0007\u0135\b\u0007\u0001\u0007\u0003\u0007\u0138\b"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u013d\b\b\u0001\b\u0001\b\u0001"+
		"\t\u0003\t\u0142\b\t\u0001\t\u0003\t\u0145\b\t\u0001\t\u0001\t\u0003\t"+
		"\u0149\b\t\u0001\t\u0001\t\u0003\t\u014d\b\t\u0001\t\u0001\t\u0003\t\u0151"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u015d\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0163"+
		"\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u0167\b\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0003\f\u016d\b\f\u0001\f\u0003\f\u0170\b\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u0177\b\f\u0001\f\u0003\f\u017a\b\f"+
		"\u0003\f\u017c\b\f\u0001\r\u0003\r\u017f\b\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u0184\b\r\u0001\u000e\u0003\u000e\u0187\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u018b\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u0191\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u0199\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u019f\b\u0010\u0001\u0010\u0003\u0010"+
		"\u01a2\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u01a9\b\u0010\u0001\u0010\u0003\u0010\u01ac\b\u0010\u0003"+
		"\u0010\u01ae\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u01b4\b\u0011\u0001\u0012\u0003\u0012\u01b7\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u01bf\b\u0013\u0005\u0013\u01c1\b\u0013\n\u0013\f\u0013\u01c4\t\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u01d1\b\u0013\u0004\u0013\u01d3\b\u0013\u000b\u0013\f\u0013\u01d4\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u01da\b\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u01de\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u01e6\b\u0014\u000b\u0014\f"+
		"\u0014\u01e7\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u01ed\b\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u01f3\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u01fa\b\u0017\n\u0017\f\u0017\u01fd\t\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0005\u0018\u0202\b\u0018\n\u0018\f\u0018\u0205\t\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u020b\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0211\b\u001a\n\u001a"+
		"\f\u001a\u0214\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0005\u001b\u021a\b\u001b\n\u001b\f\u001b\u021d\t\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0223\b\u001c\n\u001c\f\u001c"+
		"\u0226\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d"+
		"\u022c\b\u001d\n\u001d\f\u001d\u022f\t\u001d\u0001\u001e\u0005\u001e\u0232"+
		"\b\u001e\n\u001e\f\u001e\u0235\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u023d\b\u001f\u0001\u001f"+
		"\u0003\u001f\u0240\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0003\u001f\u0248\b\u001f\u0001\u001f\u0003\u001f"+
		"\u024b\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u0251\b\u001f\u0001\u001f\u0003\u001f\u0254\b\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0003\u001f\u0259\b\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0003 \u025f\b \u0001 \u0003 \u0262\b \u0001!\u0001!\u0005!\u0266\b"+
		"!\n!\f!\u0269\t!\u0001!\u0001!\u0001\"\u0003\"\u026e\b\"\u0001\"\u0001"+
		"\"\u0003\"\u0272\b\"\u0001#\u0001#\u0001#\u0001#\u0003#\u0278\b#\u0001"+
		"$\u0001$\u0001$\u0001$\u0003$\u027e\b$\u0001$\u0003$\u0281\b$\u0001%\u0001"+
		"%\u0003%\u0285\b%\u0001&\u0001&\u0001&\u0001&\u0005&\u028b\b&\n&\f&\u028e"+
		"\t&\u0001&\u0003&\u0291\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005"+
		"&\u0299\b&\n&\f&\u029c\t&\u0001&\u0003&\u029f\b&\u0001&\u0001&\u0001&"+
		"\u0001&\u0003&\u02a5\b&\u0001\'\u0005\'\u02a8\b\'\n\'\f\'\u02ab\t\'\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001(\u0003(\u02b2\b(\u0001)\u0001)\u0001)\u0005"+
		")\u02b7\b)\n)\f)\u02ba\t)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u02d4\b*\u0001"+
		"+\u0003+\u02d7\b+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		"-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0003.\u02e8\b.\u0001"+
		".\u0003.\u02eb\b.\u0001/\u0001/\u0001/\u0001/\u0003/\u02f1\b/\u0001/\u0001"+
		"/\u0003/\u02f5\b/\u0001/\u0003/\u02f8\b/\u00010\u00030\u02fb\b0\u0001"+
		"0\u00010\u00030\u02ff\b0\u00011\u00011\u00011\u00011\u00031\u0305\b1\u0001"+
		"2\u00012\u00012\u00012\u00032\u030b\b2\u00012\u00032\u030e\b2\u00013\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00013\u00014\u00014\u00034\u031a"+
		"\b4\u00014\u00014\u00014\u00034\u031f\b4\u00014\u00014\u00015\u00015\u0001"+
		"5\u00035\u0326\b5\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00036\u0330\b6\u00016\u00016\u00017\u00017\u00017\u00037\u0337\b7\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00019\u00019\u0001"+
		"9\u0001:\u0001:\u0001:\u0001;\u0001;\u0001;\u0001<\u0001<\u0001<\u0001"+
		"<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001"+
		">\u0001>\u0001?\u0001?\u0001?\u0001?\u0001?\u0001@\u0001@\u0001@\u0001"+
		"@\u0001@\u0001A\u0003A\u0364\bA\u0001A\u0003A\u0367\bA\u0001A\u0001A\u0003"+
		"A\u036b\bA\u0001A\u0001A\u0003A\u036f\bA\u0001B\u0001B\u0003B\u0373\b"+
		"B\u0001C\u0001C\u0001C\u0001C\u0001C\u0003C\u037a\bC\u0001D\u0001D\u0001"+
		"D\u0001D\u0001D\u0003D\u0381\bD\u0001D\u0003D\u0384\bD\u0001E\u0001E\u0001"+
		"E\u0001E\u0001E\u0001E\u0001F\u0001F\u0001F\u0001F\u0001G\u0001G\u0003"+
		"G\u0392\bG\u0001G\u0001G\u0001G\u0001H\u0001H\u0003H\u0399\bH\u0001H\u0001"+
		"H\u0001H\u0003H\u039e\bH\u0001H\u0001H\u0001I\u0001I\u0003I\u03a4\bI\u0001"+
		"I\u0001I\u0001I\u0003I\u03a9\bI\u0001I\u0005I\u03ac\bI\nI\fI\u03af\tI"+
		"\u0001I\u0003I\u03b2\bI\u0001I\u0001I\u0001J\u0003J\u03b7\bJ\u0001J\u0001"+
		"J\u0001J\u0003J\u03bc\bJ\u0001J\u0001J\u0001K\u0001K\u0001K\u0005K\u03c3"+
		"\bK\nK\fK\u03c6\tK\u0001K\u0003K\u03c9\bK\u0001K\u0003K\u03cc\bK\u0001"+
		"L\u0001L\u0001L\u0003L\u03d1\bL\u0001M\u0001M\u0001M\u0005M\u03d6\bM\n"+
		"M\fM\u03d9\tM\u0001M\u0003M\u03dc\bM\u0001N\u0001N\u0001N\u0003N\u03e1"+
		"\bN\u0003N\u03e3\bN\u0001O\u0001O\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0003Q\u03ef\bQ\u0003Q\u03f1\bQ\u0001R\u0001R\u0001S\u0001"+
		"S\u0001T\u0001T\u0001U\u0001U\u0001V\u0001V\u0001V\u0001V\u0001V\u0001"+
		"V\u0003V\u0401\bV\u0001W\u0001W\u0001W\u0001W\u0003W\u0407\bW\u0001W\u0001"+
		"W\u0003W\u040b\bW\u0003W\u040d\bW\u0003W\u040f\bW\u0001W\u0001W\u0001"+
		"W\u0001W\u0001W\u0001W\u0003W\u0417\bW\u0001X\u0001X\u0001X\u0001X\u0001"+
		"Y\u0001Y\u0001Y\u0003Y\u0420\bY\u0001Y\u0001Y\u0001Z\u0001Z\u0001Z\u0001"+
		"Z\u0001Z\u0001Z\u0001Z\u0003Z\u042b\bZ\u0001Z\u0003Z\u042e\bZ\u0001[\u0001"+
		"[\u0001[\u0001[\u0003[\u0434\b[\u0001[\u0001[\u0001\\\u0001\\\u0001\\"+
		"\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001]\u0001]\u0003]\u0442\b]\u0001"+
		"]\u0001]\u0001]\u0001]\u0001]\u0001]\u0003]\u044a\b]\u0001]\u0001]\u0001"+
		"]\u0001]\u0001]\u0001]\u0001]\u0003]\u0453\b]\u0001]\u0003]\u0456\b]\u0001"+
		"]\u0003]\u0459\b]\u0003]\u045b\b]\u0001^\u0001^\u0001^\u0001^\u0001^\u0001"+
		"_\u0003_\u0463\b_\u0001_\u0001_\u0005_\u0467\b_\n_\f_\u046a\t_\u0001_"+
		"\u0003_\u046d\b_\u0001_\u0003_\u0470\b_\u0001`\u0001`\u0001`\u0005`\u0475"+
		"\b`\n`\f`\u0478\t`\u0001`\u0003`\u047b\b`\u0001a\u0001a\u0001a\u0005a"+
		"\u0480\ba\na\fa\u0483\ta\u0001a\u0003a\u0486\ba\u0001b\u0001b\u0001b\u0005"+
		"b\u048b\bb\nb\fb\u048e\tb\u0001b\u0003b\u0491\bb\u0001c\u0001c\u0001c"+
		"\u0005c\u0496\bc\nc\fc\u0499\tc\u0001c\u0003c\u049c\bc\u0001d\u0001d\u0001"+
		"d\u0005d\u04a1\bd\nd\fd\u04a4\td\u0001d\u0003d\u04a7\bd\u0001d\u0000\u0000"+
		"e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"+
		"\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u0000"+
		"\n\u0001\u0000st\u0002\u0000\f\f,,\u0002\u0000\u0014\u0014  \u0002\u0000"+
		"\u000b\u000b\u001a\u001a\u0012\u000011446688::BBIIKKQQSSUUXX[[^^``bbg"+
		"gnn\u0005\u0000CCFGLLeehh\u0003\u0000HHJJff\u0006\u0000PPRRTT\\]__aa\u0006"+
		"\u0000235577WWZZmm\u0006\u0000))00EEPPRRoo\u051f\u0000\u00ca\u0001\u0000"+
		"\u0000\u0000\u0002\u00ce\u0001\u0000\u0000\u0000\u0004\u00f0\u0001\u0000"+
		"\u0000\u0000\u0006\u00f2\u0001\u0000\u0000\u0000\b\u00f6\u0001\u0000\u0000"+
		"\u0000\n\u0110\u0001\u0000\u0000\u0000\f\u0112\u0001\u0000\u0000\u0000"+
		"\u000e\u012a\u0001\u0000\u0000\u0000\u0010\u0139\u0001\u0000\u0000\u0000"+
		"\u0012\u0141\u0001\u0000\u0000\u0000\u0014\u0162\u0001\u0000\u0000\u0000"+
		"\u0016\u0166\u0001\u0000\u0000\u0000\u0018\u017b\u0001\u0000\u0000\u0000"+
		"\u001a\u017e\u0001\u0000\u0000\u0000\u001c\u0186\u0001\u0000\u0000\u0000"+
		"\u001e\u0198\u0001\u0000\u0000\u0000 \u01ad\u0001\u0000\u0000\u0000\""+
		"\u01b3\u0001\u0000\u0000\u0000$\u01b6\u0001\u0000\u0000\u0000&\u01dd\u0001"+
		"\u0000\u0000\u0000(\u01df\u0001\u0000\u0000\u0000*\u01ee\u0001\u0000\u0000"+
		"\u0000,\u01f4\u0001\u0000\u0000\u0000.\u01f6\u0001\u0000\u0000\u00000"+
		"\u01fe\u0001\u0000\u0000\u00002\u0206\u0001\u0000\u0000\u00004\u020c\u0001"+
		"\u0000\u0000\u00006\u0215\u0001\u0000\u0000\u00008\u021e\u0001\u0000\u0000"+
		"\u0000:\u0227\u0001\u0000\u0000\u0000<\u0233\u0001\u0000\u0000\u0000>"+
		"\u0258\u0001\u0000\u0000\u0000@\u025a\u0001\u0000\u0000\u0000B\u0263\u0001"+
		"\u0000\u0000\u0000D\u026d\u0001\u0000\u0000\u0000F\u0273\u0001\u0000\u0000"+
		"\u0000H\u0279\u0001\u0000\u0000\u0000J\u0282\u0001\u0000\u0000\u0000L"+
		"\u02a4\u0001\u0000\u0000\u0000N\u02a9\u0001\u0000\u0000\u0000P\u02ae\u0001"+
		"\u0000\u0000\u0000R\u02b3\u0001\u0000\u0000\u0000T\u02d3\u0001\u0000\u0000"+
		"\u0000V\u02d6\u0001\u0000\u0000\u0000X\u02da\u0001\u0000\u0000\u0000Z"+
		"\u02df\u0001\u0000\u0000\u0000\\\u02e3\u0001\u0000\u0000\u0000^\u02f7"+
		"\u0001\u0000\u0000\u0000`\u02fa\u0001\u0000\u0000\u0000b\u0300\u0001\u0000"+
		"\u0000\u0000d\u0306\u0001\u0000\u0000\u0000f\u030f\u0001\u0000\u0000\u0000"+
		"h\u0317\u0001\u0000\u0000\u0000j\u0322\u0001\u0000\u0000\u0000l\u0327"+
		"\u0001\u0000\u0000\u0000n\u0333\u0001\u0000\u0000\u0000p\u0338\u0001\u0000"+
		"\u0000\u0000r\u0340\u0001\u0000\u0000\u0000t\u0343\u0001\u0000\u0000\u0000"+
		"v\u0346\u0001\u0000\u0000\u0000x\u0349\u0001\u0000\u0000\u0000z\u034e"+
		"\u0001\u0000\u0000\u0000|\u0353\u0001\u0000\u0000\u0000~\u0358\u0001\u0000"+
		"\u0000\u0000\u0080\u035d\u0001\u0000\u0000\u0000\u0082\u036e\u0001\u0000"+
		"\u0000\u0000\u0084\u0372\u0001\u0000\u0000\u0000\u0086\u0374\u0001\u0000"+
		"\u0000\u0000\u0088\u037b\u0001\u0000\u0000\u0000\u008a\u0385\u0001\u0000"+
		"\u0000\u0000\u008c\u038b\u0001\u0000\u0000\u0000\u008e\u038f\u0001\u0000"+
		"\u0000\u0000\u0090\u0396\u0001\u0000\u0000\u0000\u0092\u03a1\u0001\u0000"+
		"\u0000\u0000\u0094\u03b6\u0001\u0000\u0000\u0000\u0096\u03cb\u0001\u0000"+
		"\u0000\u0000\u0098\u03cd\u0001\u0000\u0000\u0000\u009a\u03d2\u0001\u0000"+
		"\u0000\u0000\u009c\u03dd\u0001\u0000\u0000\u0000\u009e\u03e4\u0001\u0000"+
		"\u0000\u0000\u00a0\u03e6\u0001\u0000\u0000\u0000\u00a2\u03f0\u0001\u0000"+
		"\u0000\u0000\u00a4\u03f2\u0001\u0000\u0000\u0000\u00a6\u03f4\u0001\u0000"+
		"\u0000\u0000\u00a8\u03f6\u0001\u0000\u0000\u0000\u00aa\u03f8\u0001\u0000"+
		"\u0000\u0000\u00ac\u0400\u0001\u0000\u0000\u0000\u00ae\u0416\u0001\u0000"+
		"\u0000\u0000\u00b0\u0418\u0001\u0000\u0000\u0000\u00b2\u041c\u0001\u0000"+
		"\u0000\u0000\u00b4\u042d\u0001\u0000\u0000\u0000\u00b6\u042f\u0001\u0000"+
		"\u0000\u0000\u00b8\u0437\u0001\u0000\u0000\u0000\u00ba\u045a\u0001\u0000"+
		"\u0000\u0000\u00bc\u045c\u0001\u0000\u0000\u0000\u00be\u0468\u0001\u0000"+
		"\u0000\u0000\u00c0\u0476\u0001\u0000\u0000\u0000\u00c2\u0481\u0001\u0000"+
		"\u0000\u0000\u00c4\u048c\u0001\u0000\u0000\u0000\u00c6\u0497\u0001\u0000"+
		"\u0000\u0000\u00c8\u04a2\u0001\u0000\u0000\u0000\u00ca\u00cb\u0003\u0002"+
		"\u0001\u0000\u00cb\u00cc\u0005\u0000\u0000\u0001\u00cc\u0001\u0001\u0000"+
		"\u0000\u0000\u00cd\u00cf\u0005p\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d2\u0003\u0004\u0002\u0000\u00d1\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00db\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d7\u0003\u0012\t\u0000"+
		"\u00d7\u00d8\u0005<\u0000\u0000\u00d8\u00da\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d6\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\u00e5\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de"+
		"\u00e6\u0003\u0012\t\u0000\u00df\u00e1\u0003\u0004\u0002\u0000\u00e0\u00df"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00de"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e2\u0001\u0000\u0000\u0000\u00e6\u0003"+
		"\u0001\u0000\u0000\u0000\u00e7\u00f1\u0003\u0006\u0003\u0000\u00e8\u00f1"+
		"\u0003\b\u0004\u0000\u00e9\u00eb\u0005q\u0000\u0000\u00ea\u00e9\u0001"+
		"\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ee\u0005!\u0000\u0000\u00ed\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f1\u0003\n\u0005\u0000\u00f0\u00e7\u0001\u0000\u0000"+
		"\u0000\u00f0\u00e8\u0001\u0000\u0000\u0000\u00f0\u00ea\u0001\u0000\u0000"+
		"\u0000\u00f1\u0005\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\'\u0000\u0000"+
		"\u00f3\u00f4\u0007\u0000\u0000\u0000\u00f4\u00f5\u0003B!\u0000\u00f5\u0007"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005\u000b\u0000\u0000\u00f7\u00f8"+
		"\u0003B!\u0000\u00f8\t\u0001\u0000\u0000\u0000\u00f9\u0101\u0005\u0013"+
		"\u0000\u0000\u00fa\u00fc\u0005\u0014\u0000\u0000\u00fb\u00fd\u0005t\u0000"+
		"\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000"+
		"\u0000\u00fd\u0101\u0001\u0000\u0000\u0000\u00fe\u0101\u0005\u0018\u0000"+
		"\u0000\u00ff\u0101\u0005\u001b\u0000\u0000\u0100\u00f9\u0001\u0000\u0000"+
		"\u0000\u0100\u00fa\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000"+
		"\u0000\u0100\u00ff\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000"+
		"\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0105\u0003\f\u0006\u0000"+
		"\u0103\u0106\u0005l\u0000\u0000\u0104\u0106\u0003B!\u0000\u0105\u0103"+
		"\u0001\u0000\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106\u0111"+
		"\u0001\u0000\u0000\u0000\u0107\u010b\u0005\u0013\u0000\u0000\u0108\u0109"+
		"\u0005\u0014\u0000\u0000\u0109\u010b\u0005t\u0000\u0000\u010a\u0107\u0001"+
		"\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001"+
		"\u0000\u0000\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c\u010e\u0005"+
		"(\u0000\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000"+
		"\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0111\u0003\u0010"+
		"\b\u0000\u0110\u0100\u0001\u0000\u0000\u0000\u0110\u010a\u0001\u0000\u0000"+
		"\u0000\u0111\u000b\u0001\u0000\u0000\u0000\u0112\u0114\u0005\u0015\u0000"+
		"\u0000\u0113\u0115\u0005s\u0000\u0000\u0114\u0113\u0001\u0000\u0000\u0000"+
		"\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000"+
		"\u0116\u0117\u0005O\u0000\u0000\u0117\u0118\u0003\u00c6c\u0000\u0118\u011a"+
		"\u0005k\u0000\u0000\u0119\u011b\u0003\u00bc^\u0000\u011a\u0119\u0001\u0000"+
		"\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011d\u0001\u0000"+
		"\u0000\u0000\u011c\u011e\u0003~?\u0000\u011d\u011c\u0001\u0000\u0000\u0000"+
		"\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u0120\u0001\u0000\u0000\u0000"+
		"\u011f\u0121\u0003|>\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0120\u0121"+
		"\u0001\u0000\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u0124"+
		"\u0003\u0080@\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0123\u0124\u0001"+
		"\u0000\u0000\u0000\u0124\u0126\u0001\u0000\u0000\u0000\u0125\u0127\u0005"+
		"E\u0000\u0000\u0126\u0125\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000"+
		"\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u0129\u0003N\'"+
		"\u0000\u0129\r\u0001\u0000\u0000\u0000\u012a\u012b\u0007\u0001\u0000\u0000"+
		"\u012b\u012e\u0005s\u0000\u0000\u012c\u012d\u0005;\u0000\u0000\u012d\u012f"+
		"\u0003N\'\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012e\u012f\u0001"+
		"\u0000\u0000\u0000\u012f\u0131\u0001\u0000\u0000\u0000\u0130\u0132\u0003"+
		"\u00bc^\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000"+
		"\u0000\u0000\u0132\u0134\u0001\u0000\u0000\u0000\u0133\u0135\u0003~?\u0000"+
		"\u0134\u0133\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000"+
		"\u0135\u0137\u0001\u0000\u0000\u0000\u0136\u0138\u0003|>\u0000\u0137\u0136"+
		"\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u000f"+
		"\u0001\u0000\u0000\u0000\u0139\u013c\u0003\u000e\u0007\u0000\u013a\u013b"+
		"\u0005B\u0000\u0000\u013b\u013d\u0003,\u0016\u0000\u013c\u013a\u0001\u0000"+
		"\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000"+
		"\u0000\u0000\u013e\u013f\u0005l\u0000\u0000\u013f\u0011\u0001\u0000\u0000"+
		"\u0000\u0140\u0142\u0005q\u0000\u0000\u0141\u0140\u0001\u0000\u0000\u0000"+
		"\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0144\u0001\u0000\u0000\u0000"+
		"\u0143\u0145\u0005\u000b\u0000\u0000\u0144\u0143\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000\u0000\u0000"+
		"\u0146\u0147\u0005s\u0000\u0000\u0147\u0149\u0005;\u0000\u0000\u0148\u0146"+
		"\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a"+
		"\u0001\u0000\u0000\u0000\u014a\u014c\u0003N\'\u0000\u014b\u014d\u0003"+
		"\u00bc^\u0000\u014c\u014b\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000"+
		"\u0000\u0000\u014d\u0150\u0001\u0000\u0000\u0000\u014e\u014f\u0005B\u0000"+
		"\u0000\u014f\u0151\u0003,\u0016\u0000\u0150\u014e\u0001\u0000\u0000\u0000"+
		"\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0013\u0001\u0000\u0000\u0000"+
		"\u0152\u0153\u0005\u000b\u0000\u0000\u0153\u0163\u0003\u0016\u000b\u0000"+
		"\u0154\u0155\u0005\u001c\u0000\u0000\u0155\u0163\u0003\"\u0011\u0000\u0156"+
		"\u0157\u0005%\u0000\u0000\u0157\u0163\u0003\"\u0011\u0000\u0158\u0159"+
		"\u0005\u000e\u0000\u0000\u0159\u0163\u0003\"\u0011\u0000\u015a\u015c\u0005"+
		"\u0011\u0000\u0000\u015b\u015d\u0003\u008cF\u0000\u015c\u015b\u0001\u0000"+
		"\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000"+
		"\u0000\u0000\u015e\u0163\u0003\"\u0011\u0000\u015f\u0163\u0003\u0018\f"+
		"\u0000\u0160\u0163\u0003\u001a\r\u0000\u0161\u0163\u0003&\u0013\u0000"+
		"\u0162\u0152\u0001\u0000\u0000\u0000\u0162\u0154\u0001\u0000\u0000\u0000"+
		"\u0162\u0156\u0001\u0000\u0000\u0000\u0162\u0158\u0001\u0000\u0000\u0000"+
		"\u0162\u015a\u0001\u0000\u0000\u0000\u0162\u015f\u0001\u0000\u0000\u0000"+
		"\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0161\u0001\u0000\u0000\u0000"+
		"\u0163\u0015\u0001\u0000\u0000\u0000\u0164\u0167\u0003$\u0012\u0000\u0165"+
		"\u0167\u0003&\u0013\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0165"+
		"\u0001\u0000\u0000\u0000\u0167\u0017\u0001\u0000\u0000\u0000\u0168\u0169"+
		"\u0003\u0086C\u0000\u0169\u016f\u0003$\u0012\u0000\u016a\u016c\u0005\u000f"+
		"\u0000\u0000\u016b\u016d\u0003\u008cF\u0000\u016c\u016b\u0001\u0000\u0000"+
		"\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000"+
		"\u0000\u016e\u0170\u0003\u0014\n\u0000\u016f\u016a\u0001\u0000\u0000\u0000"+
		"\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u017c\u0001\u0000\u0000\u0000"+
		"\u0171\u0172\u0003\u0086C\u0000\u0172\u0179\u0003(\u0014\u0000\u0173\u017a"+
		"\u0005l\u0000\u0000\u0174\u0176\u0005\u000f\u0000\u0000\u0175\u0177\u0003"+
		"\u008cF\u0000\u0176\u0175\u0001\u0000\u0000\u0000\u0176\u0177\u0001\u0000"+
		"\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u0178\u017a\u0003\u0014"+
		"\n\u0000\u0179\u0173\u0001\u0000\u0000\u0000\u0179\u0174\u0001\u0000\u0000"+
		"\u0000\u017a\u017c\u0001\u0000\u0000\u0000\u017b\u0168\u0001\u0000\u0000"+
		"\u0000\u017b\u0171\u0001\u0000\u0000\u0000\u017c\u0019\u0001\u0000\u0000"+
		"\u0000\u017d\u017f\u0003v;\u0000\u017e\u017d\u0001\u0000\u0000\u0000\u017e"+
		"\u017f\u0001\u0000\u0000\u0000\u017f\u0183\u0001\u0000\u0000\u0000\u0180"+
		"\u0184\u0003B!\u0000\u0181\u0184\u0003\u001c\u000e\u0000\u0182\u0184\u0003"+
		"f3\u0000\u0183\u0180\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000"+
		"\u0000\u0183\u0182\u0001\u0000\u0000\u0000\u0184\u001b\u0001\u0000\u0000"+
		"\u0000\u0185\u0187\u0005\u0018\u0000\u0000\u0186\u0185\u0001\u0000\u0000"+
		"\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u018a\u0001\u0000\u0000"+
		"\u0000\u0188\u018b\u0003\u001e\u000f\u0000\u0189\u018b\u0003 \u0010\u0000"+
		"\u018a\u0188\u0001\u0000\u0000\u0000\u018a\u0189\u0001\u0000\u0000\u0000"+
		"\u018b\u001d\u0001\u0000\u0000\u0000\u018c\u018d\u0003\u008aE\u0000\u018d"+
		"\u0190\u0003$\u0012\u0000\u018e\u018f\u0005\u000f\u0000\u0000\u018f\u0191"+
		"\u0003\u0014\n\u0000\u0190\u018e\u0001\u0000\u0000\u0000\u0190\u0191\u0001"+
		"\u0000\u0000\u0000\u0191\u0199\u0001\u0000\u0000\u0000\u0192\u0193\u0003"+
		"\u008aE\u0000\u0193\u0194\u0003(\u0014\u0000\u0194\u0195\u0005l\u0000"+
		"\u0000\u0195\u0196\u0005\u000f\u0000\u0000\u0196\u0197\u0003\u0014\n\u0000"+
		"\u0197\u0199\u0001\u0000\u0000\u0000\u0198\u018c\u0001\u0000\u0000\u0000"+
		"\u0198\u0192\u0001\u0000\u0000\u0000\u0199\u001f\u0001\u0000\u0000\u0000"+
		"\u019a\u019b\u0003\u0088D\u0000\u019b\u01a1\u0003$\u0012\u0000\u019c\u019e"+
		"\u0005\u000f\u0000\u0000\u019d\u019f\u0003\u008cF\u0000\u019e\u019d\u0001"+
		"\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u01a0\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a2\u0003\u0014\n\u0000\u01a1\u019c\u0001\u0000"+
		"\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2\u01ae\u0001\u0000"+
		"\u0000\u0000\u01a3\u01a4\u0003\u0088D\u0000\u01a4\u01ab\u0003(\u0014\u0000"+
		"\u01a5\u01ac\u0005l\u0000\u0000\u01a6\u01a8\u0005\u000f\u0000\u0000\u01a7"+
		"\u01a9\u0003\u008cF\u0000\u01a8\u01a7\u0001\u0000\u0000\u0000\u01a8\u01a9"+
		"\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01ac"+
		"\u0003\u0014\n\u0000\u01ab\u01a5\u0001\u0000\u0000\u0000\u01ab\u01a6\u0001"+
		"\u0000\u0000\u0000\u01ac\u01ae\u0001\u0000\u0000\u0000\u01ad\u019a\u0001"+
		"\u0000\u0000\u0000\u01ad\u01a3\u0001\u0000\u0000\u0000\u01ae!\u0001\u0000"+
		"\u0000\u0000\u01af\u01b4\u0003$\u0012\u0000\u01b0\u01b1\u0003(\u0014\u0000"+
		"\u01b1\u01b2\u0005l\u0000\u0000\u01b2\u01b4\u0001\u0000\u0000\u0000\u01b3"+
		"\u01af\u0001\u0000\u0000\u0000\u01b3\u01b0\u0001\u0000\u0000\u0000\u01b4"+
		"#\u0001\u0000\u0000\u0000\u01b5\u01b7\u0003v;\u0000\u01b6\u01b5\u0001"+
		"\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001"+
		"\u0000\u0000\u0000\u01b8\u01b9\u0003B!\u0000\u01b9%\u0001\u0000\u0000"+
		"\u0000\u01ba\u01c2\u0003\u000e\u0007\u0000\u01bb\u01be\u0005<\u0000\u0000"+
		"\u01bc\u01bf\u0003\u000e\u0007\u0000\u01bd\u01bf\u0003,\u0016\u0000\u01be"+
		"\u01bc\u0001\u0000\u0000\u0000\u01be\u01bd\u0001\u0000\u0000\u0000\u01bf"+
		"\u01c1\u0001\u0000\u0000\u0000\u01c0\u01bb\u0001\u0000\u0000\u0000\u01c1"+
		"\u01c4\u0001\u0000\u0000\u0000\u01c2\u01c0\u0001\u0000\u0000\u0000\u01c2"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c5\u0001\u0000\u0000\u0000\u01c4"+
		"\u01c2\u0001\u0000\u0000\u0000\u01c5\u01c6\u0005B\u0000\u0000\u01c6\u01c7"+
		"\u0003,\u0016\u0000\u01c7\u01c8\u0005l\u0000\u0000\u01c8\u01de\u0001\u0000"+
		"\u0000\u0000\u01c9\u01d9\u0003,\u0016\u0000\u01ca\u01cb\u0003\u009eO\u0000"+
		"\u01cb\u01cc\u0003,\u0016\u0000\u01cc\u01da\u0001\u0000\u0000\u0000\u01cd"+
		"\u01d0\u0005<\u0000\u0000\u01ce\u01d1\u0003\u000e\u0007\u0000\u01cf\u01d1"+
		"\u0003,\u0016\u0000\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d0\u01cf\u0001"+
		"\u0000\u0000\u0000\u01d1\u01d3\u0001\u0000\u0000\u0000\u01d2\u01cd\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001"+
		"\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000\u01d5\u01d6\u0001"+
		"\u0000\u0000\u0000\u01d6\u01d7\u0005B\u0000\u0000\u01d7\u01d8\u0003,\u0016"+
		"\u0000\u01d8\u01da\u0001\u0000\u0000\u0000\u01d9\u01ca\u0001\u0000\u0000"+
		"\u0000\u01d9\u01d2\u0001\u0000\u0000\u0000\u01d9\u01da\u0001\u0000\u0000"+
		"\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01dc\u0005l\u0000\u0000"+
		"\u01dc\u01de\u0001\u0000\u0000\u0000\u01dd\u01ba\u0001\u0000\u0000\u0000"+
		"\u01dd\u01c9\u0001\u0000\u0000\u0000\u01de\'\u0001\u0000\u0000\u0000\u01df"+
		"\u01ec\u0003,\u0016\u0000\u01e0\u01e1\u0003\u009eO\u0000\u01e1\u01e2\u0003"+
		",\u0016\u0000\u01e2\u01ed\u0001\u0000\u0000\u0000\u01e3\u01e4\u0005<\u0000"+
		"\u0000\u01e4\u01e6\u0003,\u0016\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000"+
		"\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000"+
		"\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000"+
		"\u01e9\u01ea\u0005B\u0000\u0000\u01ea\u01eb\u0003,\u0016\u0000\u01eb\u01ed"+
		"\u0001\u0000\u0000\u0000\u01ec\u01e0\u0001\u0000\u0000\u0000\u01ec\u01e5"+
		"\u0001\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed)\u0001"+
		"\u0000\u0000\u0000\u01ee\u01f2\u0003,\u0016\u0000\u01ef\u01f0\u0003\u009e"+
		"O\u0000\u01f0\u01f1\u0003,\u0016\u0000\u01f1\u01f3\u0001\u0000\u0000\u0000"+
		"\u01f2\u01ef\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000\u0000\u0000"+
		"\u01f3+\u0001\u0000\u0000\u0000\u01f4\u01f5\u0003.\u0017\u0000\u01f5-"+
		"\u0001\u0000\u0000\u0000\u01f6\u01fb\u00030\u0018\u0000\u01f7\u01f8\u0005"+
		"\u001e\u0000\u0000\u01f8\u01fa\u00030\u0018\u0000\u01f9\u01f7\u0001\u0000"+
		"\u0000\u0000\u01fa\u01fd\u0001\u0000\u0000\u0000\u01fb\u01f9\u0001\u0000"+
		"\u0000\u0000\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc/\u0001\u0000\u0000"+
		"\u0000\u01fd\u01fb\u0001\u0000\u0000\u0000\u01fe\u0203\u00032\u0019\u0000"+
		"\u01ff\u0200\u0005\u0004\u0000\u0000\u0200\u0202\u00032\u0019\u0000\u0201"+
		"\u01ff\u0001\u0000\u0000\u0000\u0202\u0205\u0001\u0000\u0000\u0000\u0203"+
		"\u0201\u0001\u0000\u0000\u0000\u0203\u0204\u0001\u0000\u0000\u0000\u0204"+
		"1\u0001\u0000\u0000\u0000\u0205\u0203\u0001\u0000\u0000\u0000\u0206\u020a"+
		"\u00034\u001a\u0000\u0207\u0208\u0003\u00a0P\u0000\u0208\u0209\u00034"+
		"\u001a\u0000\u0209\u020b\u0001\u0000\u0000\u0000\u020a\u0207\u0001\u0000"+
		"\u0000\u0000\u020a\u020b\u0001\u0000\u0000\u0000\u020b3\u0001\u0000\u0000"+
		"\u0000\u020c\u0212\u00036\u001b\u0000\u020d\u020e\u0003\u00a2Q\u0000\u020e"+
		"\u020f\u00036\u001b\u0000\u020f\u0211\u0001\u0000\u0000\u0000\u0210\u020d"+
		"\u0001\u0000\u0000\u0000\u0211\u0214\u0001\u0000\u0000\u0000\u0212\u0210"+
		"\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000\u0000\u0000\u02135\u0001"+
		"\u0000\u0000\u0000\u0214\u0212\u0001\u0000\u0000\u0000\u0215\u021b\u0003"+
		"8\u001c\u0000\u0216\u0217\u0003\u00a4R\u0000\u0217\u0218\u00038\u001c"+
		"\u0000\u0218\u021a\u0001\u0000\u0000\u0000\u0219\u0216\u0001\u0000\u0000"+
		"\u0000\u021a\u021d\u0001\u0000\u0000\u0000\u021b\u0219\u0001\u0000\u0000"+
		"\u0000\u021b\u021c\u0001\u0000\u0000\u0000\u021c7\u0001\u0000\u0000\u0000"+
		"\u021d\u021b\u0001\u0000\u0000\u0000\u021e\u0224\u0003:\u001d\u0000\u021f"+
		"\u0220\u0003\u00a6S\u0000\u0220\u0221\u0003:\u001d\u0000\u0221\u0223\u0001"+
		"\u0000\u0000\u0000\u0222\u021f\u0001\u0000\u0000\u0000\u0223\u0226\u0001"+
		"\u0000\u0000\u0000\u0224\u0222\u0001\u0000\u0000\u0000\u0224\u0225\u0001"+
		"\u0000\u0000\u0000\u02259\u0001\u0000\u0000\u0000\u0226\u0224\u0001\u0000"+
		"\u0000\u0000\u0227\u022d\u0003<\u001e\u0000\u0228\u0229\u0003\u00a8T\u0000"+
		"\u0229\u022a\u0003<\u001e\u0000\u022a\u022c\u0001\u0000\u0000\u0000\u022b"+
		"\u0228\u0001\u0000\u0000\u0000\u022c\u022f\u0001\u0000\u0000\u0000\u022d"+
		"\u022b\u0001\u0000\u0000\u0000\u022d\u022e\u0001\u0000\u0000\u0000\u022e"+
		";\u0001\u0000\u0000\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u0230\u0232"+
		"\u0003\u00aaU\u0000\u0231\u0230\u0001\u0000\u0000\u0000\u0232\u0235\u0001"+
		"\u0000\u0000\u0000\u0233\u0231\u0001\u0000\u0000\u0000\u0233\u0234\u0001"+
		"\u0000\u0000\u0000\u0234\u0236\u0001\u0000\u0000\u0000\u0235\u0233\u0001"+
		"\u0000\u0000\u0000\u0236\u0237\u0003>\u001f\u0000\u0237=\u0001\u0000\u0000"+
		"\u0000\u0238\u0259\u0003h4\u0000\u0239\u0259\u0003@ \u0000\u023a\u023c"+
		"\u0005\b\u0000\u0000\u023b\u023d\u0003t:\u0000\u023c\u023b\u0001\u0000"+
		"\u0000\u0000\u023c\u023d\u0001\u0000\u0000\u0000\u023d\u023f\u0001\u0000"+
		"\u0000\u0000\u023e\u0240\u0003,\u0016\u0000\u023f\u023e\u0001\u0000\u0000"+
		"\u0000\u023f\u0240\u0001\u0000\u0000\u0000\u0240\u0259\u0001\u0000\u0000"+
		"\u0000\u0241\u0242\u0005\u000b\u0000\u0000\u0242\u0259\u0003,\u0016\u0000"+
		"\u0243\u0244\u0005\u001c\u0000\u0000\u0244\u0259\u0003,\u0016\u0000\u0245"+
		"\u0247\u0005\r\u0000\u0000\u0246\u0248\u0003t:\u0000\u0247\u0246\u0001"+
		"\u0000\u0000\u0000\u0247\u0248\u0001\u0000\u0000\u0000\u0248\u024a\u0001"+
		"\u0000\u0000\u0000\u0249\u024b\u0003,\u0016\u0000\u024a\u0249\u0001\u0000"+
		"\u0000\u0000\u024a\u024b\u0001\u0000\u0000\u0000\u024b\u0259\u0001\u0000"+
		"\u0000\u0000\u024c\u024d\u0005\"\u0000\u0000\u024d\u0259\u0003,\u0016"+
		"\u0000\u024e\u0250\u0005#\u0000\u0000\u024f\u0251\u0003,\u0016\u0000\u0250"+
		"\u024f\u0001\u0000\u0000\u0000\u0250\u0251\u0001\u0000\u0000\u0000\u0251"+
		"\u0259\u0001\u0000\u0000\u0000\u0252\u0254\u0003v;\u0000\u0253\u0252\u0001"+
		"\u0000\u0000\u0000\u0253\u0254\u0001\u0000\u0000\u0000\u0254\u0255\u0001"+
		"\u0000\u0000\u0000\u0255\u0259\u0003D\"\u0000\u0256\u0259\u0003B!\u0000"+
		"\u0257\u0259\u0003J%\u0000\u0258\u0238\u0001\u0000\u0000\u0000\u0258\u0239"+
		"\u0001\u0000\u0000\u0000\u0258\u023a\u0001\u0000\u0000\u0000\u0258\u0241"+
		"\u0001\u0000\u0000\u0000\u0258\u0243\u0001\u0000\u0000\u0000\u0258\u0245"+
		"\u0001\u0000\u0000\u0000\u0258\u024c\u0001\u0000\u0000\u0000\u0258\u024e"+
		"\u0001\u0000\u0000\u0000\u0258\u0253\u0001\u0000\u0000\u0000\u0258\u0256"+
		"\u0001\u0000\u0000\u0000\u0258\u0257\u0001\u0000\u0000\u0000\u0259?\u0001"+
		"\u0000\u0000\u0000\u025a\u025b\u0003\u0086C\u0000\u025b\u0261\u0003,\u0016"+
		"\u0000\u025c\u025e\u0005\u000f\u0000\u0000\u025d\u025f\u0003\u008cF\u0000"+
		"\u025e\u025d\u0001\u0000\u0000\u0000\u025e\u025f\u0001\u0000\u0000\u0000"+
		"\u025f\u0260\u0001\u0000\u0000\u0000\u0260\u0262\u0003,\u0016\u0000\u0261"+
		"\u025c\u0001\u0000\u0000\u0000\u0261\u0262\u0001\u0000\u0000\u0000\u0262"+
		"A\u0001\u0000\u0000\u0000\u0263\u0267\u0005M\u0000\u0000\u0264\u0266\u0003"+
		"\u0014\n\u0000\u0265\u0264\u0001\u0000\u0000\u0000\u0266\u0269\u0001\u0000"+
		"\u0000\u0000\u0267\u0265\u0001\u0000\u0000\u0000\u0267\u0268\u0001\u0000"+
		"\u0000\u0000\u0268\u026a\u0001\u0000\u0000\u0000\u0269\u0267\u0001\u0000"+
		"\u0000\u0000\u026a\u026b\u0005i\u0000\u0000\u026bC\u0001\u0000\u0000\u0000"+
		"\u026c\u026e\u0005\u0018\u0000\u0000\u026d\u026c\u0001\u0000\u0000\u0000"+
		"\u026d\u026e\u0001\u0000\u0000\u0000\u026e\u0271\u0001\u0000\u0000\u0000"+
		"\u026f\u0272\u0003F#\u0000\u0270\u0272\u0003H$\u0000\u0271\u026f\u0001"+
		"\u0000\u0000\u0000\u0271\u0270\u0001\u0000\u0000\u0000\u0272E\u0001\u0000"+
		"\u0000\u0000\u0273\u0274\u0003\u008aE\u0000\u0274\u0277\u0003,\u0016\u0000"+
		"\u0275\u0276\u0005\u000f\u0000\u0000\u0276\u0278\u0003,\u0016\u0000\u0277"+
		"\u0275\u0001\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278"+
		"G\u0001\u0000\u0000\u0000\u0279\u027a\u0003\u0088D\u0000\u027a\u0280\u0003"+
		",\u0016\u0000\u027b\u027d\u0005\u000f\u0000\u0000\u027c\u027e\u0003\u008c"+
		"F\u0000\u027d\u027c\u0001\u0000\u0000\u0000\u027d\u027e\u0001\u0000\u0000"+
		"\u0000\u027e\u027f\u0001\u0000\u0000\u0000\u027f\u0281\u0003,\u0016\u0000"+
		"\u0280\u027b\u0001\u0000\u0000\u0000\u0280\u0281\u0001\u0000\u0000\u0000"+
		"\u0281I\u0001\u0000\u0000\u0000\u0282\u0284\u0003N\'\u0000\u0283\u0285"+
		"\u0003L&\u0000\u0284\u0283\u0001\u0000\u0000\u0000\u0284\u0285\u0001\u0000"+
		"\u0000\u0000\u0285K\u0001\u0000\u0000\u0000\u0286\u0287\u0005M\u0000\u0000"+
		"\u0287\u028c\u0003x<\u0000\u0288\u0289\u0005<\u0000\u0000\u0289\u028b"+
		"\u0003x<\u0000\u028a\u0288\u0001\u0000\u0000\u0000\u028b\u028e\u0001\u0000"+
		"\u0000\u0000\u028c\u028a\u0001\u0000\u0000\u0000\u028c\u028d\u0001\u0000"+
		"\u0000\u0000\u028d\u0290\u0001\u0000\u0000\u0000\u028e\u028c\u0001\u0000"+
		"\u0000\u0000\u028f\u0291\u0005<\u0000\u0000\u0290\u028f\u0001\u0000\u0000"+
		"\u0000\u0290\u0291\u0001\u0000\u0000\u0000\u0291\u0292\u0001\u0000\u0000"+
		"\u0000\u0292\u0293\u0005i\u0000\u0000\u0293\u02a5\u0001\u0000\u0000\u0000"+
		"\u0294\u0295\u0005M\u0000\u0000\u0295\u029a\u0003,\u0016\u0000\u0296\u0297"+
		"\u0005<\u0000\u0000\u0297\u0299\u0003,\u0016\u0000\u0298\u0296\u0001\u0000"+
		"\u0000\u0000\u0299\u029c\u0001\u0000\u0000\u0000\u029a\u0298\u0001\u0000"+
		"\u0000\u0000\u029a\u029b\u0001\u0000\u0000\u0000\u029b\u029e\u0001\u0000"+
		"\u0000\u0000\u029c\u029a\u0001\u0000\u0000\u0000\u029d\u029f\u0005<\u0000"+
		"\u0000\u029e\u029d\u0001\u0000\u0000\u0000\u029e\u029f\u0001\u0000\u0000"+
		"\u0000\u029f\u02a0\u0001\u0000\u0000\u0000\u02a0\u02a1\u0005i\u0000\u0000"+
		"\u02a1\u02a5\u0001\u0000\u0000\u0000\u02a2\u02a3\u0005M\u0000\u0000\u02a3"+
		"\u02a5\u0005i\u0000\u0000\u02a4\u0286\u0001\u0000\u0000\u0000\u02a4\u0294"+
		"\u0001\u0000\u0000\u0000\u02a4\u02a2\u0001\u0000\u0000\u0000\u02a5M\u0001"+
		"\u0000\u0000\u0000\u02a6\u02a8\u0003\u00acV\u0000\u02a7\u02a6\u0001\u0000"+
		"\u0000\u0000\u02a8\u02ab\u0001\u0000\u0000\u0000\u02a9\u02a7\u0001\u0000"+
		"\u0000\u0000\u02a9\u02aa\u0001\u0000\u0000\u0000\u02aa\u02ac\u0001\u0000"+
		"\u0000\u0000\u02ab\u02a9\u0001\u0000\u0000\u0000\u02ac\u02ad\u0003P(\u0000"+
		"\u02adO\u0001\u0000\u0000\u0000\u02ae\u02b1\u0003R)\u0000\u02af\u02b0"+
		"\u0005E\u0000\u0000\u02b0\u02b2\u0003N\'\u0000\u02b1\u02af\u0001\u0000"+
		"\u0000\u0000\u02b1\u02b2\u0001\u0000\u0000\u0000\u02b2Q\u0001\u0000\u0000"+
		"\u0000\u02b3\u02b8\u0003T*\u0000\u02b4\u02b7\u0003\u00aeW\u0000\u02b5"+
		"\u02b7\u0003\u00b0X\u0000\u02b6\u02b4\u0001\u0000\u0000\u0000\u02b6\u02b5"+
		"\u0001\u0000\u0000\u0000\u02b7\u02ba\u0001\u0000\u0000\u0000\u02b8\u02b6"+
		"\u0001\u0000\u0000\u0000\u02b8\u02b9\u0001\u0000\u0000\u0000\u02b9S\u0001"+
		"\u0000\u0000\u0000\u02ba\u02b8\u0001\u0000\u0000\u0000\u02bb\u02bc\u0005"+
		"x\u0000\u0000\u02bc\u02d4\u0003\u00b0X\u0000\u02bd\u02d4\u0005u\u0000"+
		"\u0000\u02be\u02d4\u0003V+\u0000\u02bf\u02c0\u0005=\u0000\u0000\u02c0"+
		"\u02d4\u0005s\u0000\u0000\u02c1\u02c2\u0005=\u0000\u0000\u02c2\u02d4\u0003"+
		"L&\u0000\u02c3\u02d4\u0003X,\u0000\u02c4\u02d4\u0005v\u0000\u0000\u02c5"+
		"\u02d4\u0003\f\u0006\u0000\u02c6\u02d4\u0003Z-\u0000\u02c7\u02d4\u0003"+
		"^/\u0000\u02c8\u02d4\u0005s\u0000\u0000\u02c9\u02d4\u0003\\.\u0000\u02ca"+
		"\u02d4\u0005w\u0000\u0000\u02cb\u02cc\u0005\u000b\u0000\u0000\u02cc\u02d4"+
		"\u0003N\'\u0000\u02cd\u02ce\u0005\u0012\u0000\u0000\u02ce\u02cf\u0005"+
		"=\u0000\u0000\u02cf\u02d4\u0005s\u0000\u0000\u02d0\u02d4\u0005\u0005\u0000"+
		"\u0000\u02d1\u02d4\u0005+\u0000\u0000\u02d2\u02d4\u0005t\u0000\u0000\u02d3"+
		"\u02bb\u0001\u0000\u0000\u0000\u02d3\u02bd\u0001\u0000\u0000\u0000\u02d3"+
		"\u02be\u0001\u0000\u0000\u0000\u02d3\u02bf\u0001\u0000\u0000\u0000\u02d3"+
		"\u02c1\u0001\u0000\u0000\u0000\u02d3\u02c3\u0001\u0000\u0000\u0000\u02d3"+
		"\u02c4\u0001\u0000\u0000\u0000\u02d3\u02c5\u0001\u0000\u0000\u0000\u02d3"+
		"\u02c6\u0001\u0000\u0000\u0000\u02d3\u02c7\u0001\u0000\u0000\u0000\u02d3"+
		"\u02c8\u0001\u0000\u0000\u0000\u02d3\u02c9\u0001\u0000\u0000\u0000\u02d3"+
		"\u02ca\u0001\u0000\u0000\u0000\u02d3\u02cb\u0001\u0000\u0000\u0000\u02d3"+
		"\u02cd\u0001\u0000\u0000\u0000\u02d3\u02d0\u0001\u0000\u0000\u0000\u02d3"+
		"\u02d1\u0001\u0000\u0000\u0000\u02d3\u02d2\u0001\u0000\u0000\u0000\u02d4"+
		"U\u0001\u0000\u0000\u0000\u02d5\u02d7\u0007\u0002\u0000\u0000\u02d6\u02d5"+
		"\u0001\u0000\u0000\u0000\u02d6\u02d7\u0001\u0000\u0000\u0000\u02d7\u02d8"+
		"\u0001\u0000\u0000\u0000\u02d8\u02d9\u0003\u00b8\\\u0000\u02d9W\u0001"+
		"\u0000\u0000\u0000\u02da\u02db\u0005\u0012\u0000\u0000\u02db\u02dc\u0005"+
		"M\u0000\u0000\u02dc\u02dd\u0003\u00be_\u0000\u02dd\u02de\u0005i\u0000"+
		"\u0000\u02deY\u0001\u0000\u0000\u0000\u02df\u02e0\u0005O\u0000\u0000\u02e0"+
		"\u02e1\u0003,\u0016\u0000\u02e1\u02e2\u0005k\u0000\u0000\u02e2[\u0001"+
		"\u0000\u0000\u0000\u02e3\u02e4\u0003\u0086C\u0000\u02e4\u02ea\u0003N\'"+
		"\u0000\u02e5\u02e7\u0005\u000f\u0000\u0000\u02e6\u02e8\u0003\u008cF\u0000"+
		"\u02e7\u02e6\u0001\u0000\u0000\u0000\u02e7\u02e8\u0001\u0000\u0000\u0000"+
		"\u02e8\u02e9\u0001\u0000\u0000\u0000\u02e9\u02eb\u0003N\'\u0000\u02ea"+
		"\u02e5\u0001\u0000\u0000\u0000\u02ea\u02eb\u0001\u0000\u0000\u0000\u02eb"+
		"]\u0001\u0000\u0000\u0000\u02ec\u02ed\u0003v;\u0000\u02ed\u02ee\u0003"+
		"B!\u0000\u02ee\u02f8\u0001\u0000\u0000\u0000\u02ef\u02f1\u0003v;\u0000"+
		"\u02f0\u02ef\u0001\u0000\u0000\u0000\u02f0\u02f1\u0001\u0000\u0000\u0000"+
		"\u02f1\u02f2\u0001\u0000\u0000\u0000\u02f2\u02f8\u0003`0\u0000\u02f3\u02f5"+
		"\u0003v;\u0000\u02f4\u02f3\u0001\u0000\u0000\u0000\u02f4\u02f5\u0001\u0000"+
		"\u0000\u0000\u02f5\u02f6\u0001\u0000\u0000\u0000\u02f6\u02f8\u0003f3\u0000"+
		"\u02f7\u02ec\u0001\u0000\u0000\u0000\u02f7\u02f0\u0001\u0000\u0000\u0000"+
		"\u02f7\u02f4\u0001\u0000\u0000\u0000\u02f8_\u0001\u0000\u0000\u0000\u02f9"+
		"\u02fb\u0005\u0018\u0000\u0000\u02fa\u02f9\u0001\u0000\u0000\u0000\u02fa"+
		"\u02fb\u0001\u0000\u0000\u0000\u02fb\u02fe\u0001\u0000\u0000\u0000\u02fc"+
		"\u02ff\u0003b1\u0000\u02fd\u02ff\u0003d2\u0000\u02fe\u02fc\u0001\u0000"+
		"\u0000\u0000\u02fe\u02fd\u0001\u0000\u0000\u0000\u02ffa\u0001\u0000\u0000"+
		"\u0000\u0300\u0301\u0003\u008aE\u0000\u0301\u0304\u0003N\'\u0000\u0302"+
		"\u0303\u0005\u000f\u0000\u0000\u0303\u0305\u0003N\'\u0000\u0304\u0302"+
		"\u0001\u0000\u0000\u0000\u0304\u0305\u0001\u0000\u0000\u0000\u0305c\u0001"+
		"\u0000\u0000\u0000\u0306\u0307\u0003\u0088D\u0000\u0307\u030d\u0003N\'"+
		"\u0000\u0308\u030a\u0005\u000f\u0000\u0000\u0309\u030b\u0003\u008cF\u0000"+
		"\u030a\u0309\u0001\u0000\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000"+
		"\u030b\u030c\u0001\u0000\u0000\u0000\u030c\u030e\u0003N\'\u0000\u030d"+
		"\u0308\u0001\u0000\u0000\u0000\u030d\u030e\u0001\u0000\u0000\u0000\u030e"+
		"e\u0001\u0000\u0000\u0000\u030f\u0310\u0005&\u0000\u0000\u0310\u0311\u0005"+
		"O\u0000\u0000\u0311\u0312\u0003,\u0016\u0000\u0312\u0313\u0005k\u0000"+
		"\u0000\u0313\u0314\u0005M\u0000\u0000\u0314\u0315\u0003\u00c0`\u0000\u0315"+
		"\u0316\u0005i\u0000\u0000\u0316g\u0001\u0000\u0000\u0000\u0317\u0319\u0005"+
		"\u0007\u0000\u0000\u0318\u031a\u0005-\u0000\u0000\u0319\u0318\u0001\u0000"+
		"\u0000\u0000\u0319\u031a\u0001\u0000\u0000\u0000\u031a\u031b\u0001\u0000"+
		"\u0000\u0000\u031b\u031c\u0005O\u0000\u0000\u031c\u031e\u0003,\u0016\u0000"+
		"\u031d\u031f\u0003j5\u0000\u031e\u031d\u0001\u0000\u0000\u0000\u031e\u031f"+
		"\u0001\u0000\u0000\u0000\u031f\u0320\u0001\u0000\u0000\u0000\u0320\u0321"+
		"\u0005k\u0000\u0000\u0321i\u0001\u0000\u0000\u0000\u0322\u0323\u0005;"+
		"\u0000\u0000\u0323\u0325\u0003\u00c2a\u0000\u0324\u0326\u0003n7\u0000"+
		"\u0325\u0324\u0001\u0000\u0000\u0000\u0325\u0326\u0001\u0000\u0000\u0000"+
		"\u0326k\u0001\u0000\u0000\u0000\u0327\u0328\u0005N\u0000\u0000\u0328\u0329"+
		"\u0005s\u0000\u0000\u0329\u032a\u0005j\u0000\u0000\u032a\u032b\u0005t"+
		"\u0000\u0000\u032b\u032f\u0005O\u0000\u0000\u032c\u032d\u0005e\u0000\u0000"+
		"\u032d\u0330\u0003N\'\u0000\u032e\u0330\u0005s\u0000\u0000\u032f\u032c"+
		"\u0001\u0000\u0000\u0000\u032f\u032e\u0001\u0000\u0000\u0000\u0330\u0331"+
		"\u0001\u0000\u0000\u0000\u0331\u0332\u0005k\u0000\u0000\u0332m\u0001\u0000"+
		"\u0000\u0000\u0333\u0334\u0005;\u0000\u0000\u0334\u0336\u0003\u00c4b\u0000"+
		"\u0335\u0337\u0003r9\u0000\u0336\u0335\u0001\u0000\u0000\u0000\u0336\u0337"+
		"\u0001\u0000\u0000\u0000\u0337o\u0001\u0000\u0000\u0000\u0338\u0339\u0005"+
		"N\u0000\u0000\u0339\u033a\u0005s\u0000\u0000\u033a\u033b\u0005j\u0000"+
		"\u0000\u033b\u033c\u0005t\u0000\u0000\u033c\u033d\u0005O\u0000\u0000\u033d"+
		"\u033e\u0003,\u0016\u0000\u033e\u033f\u0005k\u0000\u0000\u033fq\u0001"+
		"\u0000\u0000\u0000\u0340\u0341\u0005;\u0000\u0000\u0341\u0342\u0003,\u0016"+
		"\u0000\u0342s\u0001\u0000\u0000\u0000\u0343\u0344\u0005;\u0000\u0000\u0344"+
		"\u0345\u0005s\u0000\u0000\u0345u\u0001\u0000\u0000\u0000\u0346\u0347\u0005"+
		"s\u0000\u0000\u0347\u0348\u0005;\u0000\u0000\u0348w\u0001\u0000\u0000"+
		"\u0000\u0349\u034a\u0005=\u0000\u0000\u034a\u034b\u0005s\u0000\u0000\u034b"+
		"\u034c\u0005B\u0000\u0000\u034c\u034d\u0003,\u0016\u0000\u034dy\u0001"+
		"\u0000\u0000\u0000\u034e\u034f\u0005;\u0000\u0000\u034f\u0350\u0005O\u0000"+
		"\u0000\u0350\u0351\u0003(\u0014\u0000\u0351\u0352\u0005k\u0000\u0000\u0352"+
		"{\u0001\u0000\u0000\u0000\u0353\u0354\u0005\u0019\u0000\u0000\u0354\u0355"+
		"\u0005O\u0000\u0000\u0355\u0356\u0003,\u0016\u0000\u0356\u0357\u0005k"+
		"\u0000\u0000\u0357}\u0001\u0000\u0000\u0000\u0358\u0359\u0005\u0001\u0000"+
		"\u0000\u0359\u035a\u0005O\u0000\u0000\u035a\u035b\u0003,\u0016\u0000\u035b"+
		"\u035c\u0005k\u0000\u0000\u035c\u007f\u0001\u0000\u0000\u0000\u035d\u035e"+
		"\u0005\t\u0000\u0000\u035e\u035f\u0005O\u0000\u0000\u035f\u0360\u0003"+
		",\u0016\u0000\u0360\u0361\u0005k\u0000\u0000\u0361\u0081\u0001\u0000\u0000"+
		"\u0000\u0362\u0364\u0005q\u0000\u0000\u0363\u0362\u0001\u0000\u0000\u0000"+
		"\u0363\u0364\u0001\u0000\u0000\u0000\u0364\u0366\u0001\u0000\u0000\u0000"+
		"\u0365\u0367\u0007\u0003\u0000\u0000\u0366\u0365\u0001\u0000\u0000\u0000"+
		"\u0366\u0367\u0001\u0000\u0000\u0000\u0367\u036a\u0001\u0000\u0000\u0000"+
		"\u0368\u0369\u0005s\u0000\u0000\u0369\u036b\u0005;\u0000\u0000\u036a\u0368"+
		"\u0001\u0000\u0000\u0000\u036a\u036b\u0001\u0000\u0000\u0000\u036b\u036c"+
		"\u0001\u0000\u0000\u0000\u036c\u036f\u0003\u0084B\u0000\u036d\u036f\u0005"+
		"?\u0000\u0000\u036e\u0363\u0001\u0000\u0000\u0000\u036e\u036d\u0001\u0000"+
		"\u0000\u0000\u036f\u0083\u0001\u0000\u0000\u0000\u0370\u0373\u0005\u0006"+
		"\u0000\u0000\u0371\u0373\u0003N\'\u0000\u0372\u0370\u0001\u0000\u0000"+
		"\u0000\u0372\u0371\u0001\u0000\u0000\u0000\u0373\u0085\u0001\u0000\u0000"+
		"\u0000\u0374\u0375\u0005\u0017\u0000\u0000\u0375\u0376\u0005O\u0000\u0000"+
		"\u0376\u0377\u0003,\u0016\u0000\u0377\u0379\u0005k\u0000\u0000\u0378\u037a"+
		"\u0003\u008eG\u0000\u0379\u0378\u0001\u0000\u0000\u0000\u0379\u037a\u0001"+
		"\u0000\u0000\u0000\u037a\u0087\u0001\u0000\u0000\u0000\u037b\u037c\u0005"+
		".\u0000\u0000\u037c\u037d\u0005O\u0000\u0000\u037d\u037e\u0003,\u0016"+
		"\u0000\u037e\u0380\u0005k\u0000\u0000\u037f\u0381\u0003\u008eG\u0000\u0380"+
		"\u037f\u0001\u0000\u0000\u0000\u0380\u0381\u0001\u0000\u0000\u0000\u0381"+
		"\u0383\u0001\u0000\u0000\u0000\u0382\u0384\u0003z=\u0000\u0383\u0382\u0001"+
		"\u0000\u0000\u0000\u0383\u0384\u0001\u0000\u0000\u0000\u0384\u0089\u0001"+
		"\u0000\u0000\u0000\u0385\u0386\u0005\u0016\u0000\u0000\u0386\u0387\u0005"+
		"O\u0000\u0000\u0387\u0388\u0003\u009aM\u0000\u0388\u0389\u0005k\u0000"+
		"\u0000\u0389\u038a\u0003\u0092I\u0000\u038a\u008b\u0001\u0000\u0000\u0000"+
		"\u038b\u038c\u0005Y\u0000\u0000\u038c\u038d\u0005s\u0000\u0000\u038d\u038e"+
		"\u0005Y\u0000\u0000\u038e\u008d\u0001\u0000\u0000\u0000\u038f\u0391\u0005"+
		"Y\u0000\u0000\u0390\u0392\u00052\u0000\u0000\u0391\u0390\u0001\u0000\u0000"+
		"\u0000\u0391\u0392\u0001\u0000\u0000\u0000\u0392\u0393\u0001\u0000\u0000"+
		"\u0000\u0393\u0394\u0005s\u0000\u0000\u0394\u0395\u0005Y\u0000\u0000\u0395"+
		"\u008f\u0001\u0000\u0000\u0000\u0396\u0398\u0005Y\u0000\u0000\u0397\u0399"+
		"\u00052\u0000\u0000\u0398\u0397\u0001\u0000\u0000\u0000\u0398\u0399\u0001"+
		"\u0000\u0000\u0000\u0399\u039a\u0001\u0000\u0000\u0000\u039a\u039d\u0005"+
		"s\u0000\u0000\u039b\u039c\u0005<\u0000\u0000\u039c\u039e\u0005s\u0000"+
		"\u0000\u039d\u039b\u0001\u0000\u0000\u0000\u039d\u039e\u0001\u0000\u0000"+
		"\u0000\u039e\u039f\u0001\u0000\u0000\u0000\u039f\u03a0\u0005Y\u0000\u0000"+
		"\u03a0\u0091\u0001\u0000\u0000\u0000\u03a1\u03a3\u0005Y\u0000\u0000\u03a2"+
		"\u03a4\u00052\u0000\u0000\u03a3\u03a2\u0001\u0000\u0000\u0000\u03a3\u03a4"+
		"\u0001\u0000\u0000\u0000\u03a4\u03a5\u0001\u0000\u0000\u0000\u03a5\u03ad"+
		"\u0005s\u0000\u0000\u03a6\u03a8\u0005<\u0000\u0000\u03a7\u03a9\u00052"+
		"\u0000\u0000\u03a8\u03a7\u0001\u0000\u0000\u0000\u03a8\u03a9\u0001\u0000"+
		"\u0000\u0000\u03a9\u03aa\u0001\u0000\u0000\u0000\u03aa\u03ac\u0005s\u0000"+
		"\u0000\u03ab\u03a6\u0001\u0000\u0000\u0000\u03ac\u03af\u0001\u0000\u0000"+
		"\u0000\u03ad\u03ab\u0001\u0000\u0000\u0000\u03ad\u03ae\u0001\u0000\u0000"+
		"\u0000\u03ae\u03b1\u0001\u0000\u0000\u0000\u03af\u03ad\u0001\u0000\u0000"+
		"\u0000\u03b0\u03b2\u0005<\u0000\u0000\u03b1\u03b0\u0001\u0000\u0000\u0000"+
		"\u03b1\u03b2\u0001\u0000\u0000\u0000\u03b2\u03b3\u0001\u0000\u0000\u0000"+
		"\u03b3\u03b4\u0005Y\u0000\u0000\u03b4\u0093\u0001\u0000\u0000\u0000\u03b5"+
		"\u03b7\u0005\u0018\u0000\u0000\u03b6\u03b5\u0001\u0000\u0000\u0000\u03b6"+
		"\u03b7\u0001\u0000\u0000\u0000\u03b7\u03b8\u0001\u0000\u0000\u0000\u03b8"+
		"\u03b9\u0003\u0096K\u0000\u03b9\u03bb\u0005D\u0000\u0000\u03ba\u03bc\u0003"+
		"\u0090H\u0000\u03bb\u03ba\u0001\u0000\u0000\u0000\u03bb\u03bc\u0001\u0000"+
		"\u0000\u0000\u03bc\u03bd\u0001\u0000\u0000\u0000\u03bd\u03be\u0003*\u0015"+
		"\u0000\u03be\u0095\u0001\u0000\u0000\u0000\u03bf\u03c4\u0003\u0098L\u0000"+
		"\u03c0\u03c1\u0005<\u0000\u0000\u03c1\u03c3\u0003\u0098L\u0000\u03c2\u03c0"+
		"\u0001\u0000\u0000\u0000\u03c3\u03c6\u0001\u0000\u0000\u0000\u03c4\u03c2"+
		"\u0001\u0000\u0000\u0000\u03c4\u03c5\u0001\u0000\u0000\u0000\u03c5\u03c8"+
		"\u0001\u0000\u0000\u0000\u03c6\u03c4\u0001\u0000\u0000\u0000\u03c7\u03c9"+
		"\u0005<\u0000\u0000\u03c8\u03c7\u0001\u0000\u0000\u0000\u03c8\u03c9\u0001"+
		"\u0000\u0000\u0000\u03c9\u03cc\u0001\u0000\u0000\u0000\u03ca\u03cc\u0005"+
		"\u000f\u0000\u0000\u03cb\u03bf\u0001\u0000\u0000\u0000\u03cb\u03ca\u0001"+
		"\u0000\u0000\u0000\u03cc\u0097\u0001\u0000\u0000\u0000\u03cd\u03d0\u0003"+
		",\u0016\u0000\u03ce\u03cf\u0005?\u0000\u0000\u03cf\u03d1\u0003,\u0016"+
		"\u0000\u03d0\u03ce\u0001\u0000\u0000\u0000\u03d0\u03d1\u0001\u0000\u0000"+
		"\u0000\u03d1\u0099\u0001\u0000\u0000\u0000\u03d2\u03d7\u0003\u009cN\u0000"+
		"\u03d3\u03d4\u0005<\u0000\u0000\u03d4\u03d6\u0003\u009cN\u0000\u03d5\u03d3"+
		"\u0001\u0000\u0000\u0000\u03d6\u03d9\u0001\u0000\u0000\u0000\u03d7\u03d5"+
		"\u0001\u0000\u0000\u0000\u03d7\u03d8\u0001\u0000\u0000\u0000\u03d8\u03db"+
		"\u0001\u0000\u0000\u0000\u03d9\u03d7\u0001\u0000\u0000\u0000\u03da\u03dc"+
		"\u0005<\u0000\u0000\u03db\u03da\u0001\u0000\u0000\u0000\u03db\u03dc\u0001"+
		"\u0000\u0000\u0000\u03dc\u009b\u0001\u0000\u0000\u0000\u03dd\u03e2\u0003"+
		",\u0016\u0000\u03de\u03e0\u0005>\u0000\u0000\u03df\u03e1\u0003,\u0016"+
		"\u0000\u03e0\u03df\u0001\u0000\u0000\u0000\u03e0\u03e1\u0001\u0000\u0000"+
		"\u0000\u03e1\u03e3\u0001\u0000\u0000\u0000\u03e2\u03de\u0001\u0000\u0000"+
		"\u0000\u03e2\u03e3\u0001\u0000\u0000\u0000\u03e3\u009d\u0001\u0000\u0000"+
		"\u0000\u03e4\u03e5\u0007\u0004\u0000\u0000\u03e5\u009f\u0001\u0000\u0000"+
		"\u0000\u03e6\u03e7\u0007\u0005\u0000\u0000\u03e7\u00a1\u0001\u0000\u0000"+
		"\u0000\u03e8\u03f1\u00050\u0000\u0000\u03e9\u03f1\u00059\u0000\u0000\u03ea"+
		"\u03f1\u0005Y\u0000\u0000\u03eb\u03f1\u0005\u001f\u0000\u0000\u03ec\u03ee"+
		"\u0005\n\u0000\u0000\u03ed\u03ef\u0003\u008cF\u0000\u03ee\u03ed\u0001"+
		"\u0000\u0000\u0000\u03ee\u03ef\u0001\u0000\u0000\u0000\u03ef\u03f1\u0001"+
		"\u0000\u0000\u0000\u03f0\u03e8\u0001\u0000\u0000\u0000\u03f0\u03e9\u0001"+
		"\u0000\u0000\u0000\u03f0\u03ea\u0001\u0000\u0000\u0000\u03f0\u03eb\u0001"+
		"\u0000\u0000\u0000\u03f0\u03ec\u0001\u0000\u0000\u0000\u03f1\u00a3\u0001"+
		"\u0000\u0000\u0000\u03f2\u03f3\u0007\u0006\u0000\u0000\u03f3\u00a5\u0001"+
		"\u0000\u0000\u0000\u03f4\u03f5\u0007\u0007\u0000\u0000\u03f5\u00a7\u0001"+
		"\u0000\u0000\u0000\u03f6\u03f7\u0007\b\u0000\u0000\u03f7\u00a9\u0001\u0000"+
		"\u0000\u0000\u03f8\u03f9\u0007\t\u0000\u0000\u03f9\u00ab\u0001\u0000\u0000"+
		"\u0000\u03fa\u0401\u0005d\u0000\u0000\u03fb\u03fc\u0005\u0005\u0000\u0000"+
		"\u03fc\u0401\u0005V\u0000\u0000\u03fd\u0401\u0003\u00b2Y\u0000\u03fe\u0401"+
		"\u0003\u00b4Z\u0000\u03ff\u0401\u0003\u00b6[\u0000\u0400\u03fa\u0001\u0000"+
		"\u0000\u0000\u0400\u03fb\u0001\u0000\u0000\u0000\u0400\u03fd\u0001\u0000"+
		"\u0000\u0000\u0400\u03fe\u0001\u0000\u0000\u0000\u0400\u03ff\u0001\u0000"+
		"\u0000\u0000\u0401\u00ad\u0001\u0000\u0000\u0000\u0402\u0403\u0005N\u0000"+
		"\u0000\u0403\u040e\u0003,\u0016\u0000\u0404\u040c\u0005>\u0000\u0000\u0405"+
		"\u0407\u0003,\u0016\u0000\u0406\u0405\u0001\u0000\u0000\u0000\u0406\u0407"+
		"\u0001\u0000\u0000\u0000\u0407\u040a\u0001\u0000\u0000\u0000\u0408\u0409"+
		"\u0005;\u0000\u0000\u0409\u040b\u0003,\u0016\u0000\u040a\u0408\u0001\u0000"+
		"\u0000\u0000\u040a\u040b\u0001\u0000\u0000\u0000\u040b\u040d\u0001\u0000"+
		"\u0000\u0000\u040c\u0406\u0001\u0000\u0000\u0000\u040c\u040d\u0001\u0000"+
		"\u0000\u0000\u040d\u040f\u0001\u0000\u0000\u0000\u040e\u0404\u0001\u0000"+
		"\u0000\u0000\u040e\u040f\u0001\u0000\u0000\u0000\u040f\u0410\u0001\u0000"+
		"\u0000\u0000\u0410\u0411\u0005j\u0000\u0000\u0411\u0417\u0001\u0000\u0000"+
		"\u0000\u0412\u0413\u0005=\u0000\u0000\u0413\u0417\u0005s\u0000\u0000\u0414"+
		"\u0417\u0005@\u0000\u0000\u0415\u0417\u0005A\u0000\u0000\u0416\u0402\u0001"+
		"\u0000\u0000\u0000\u0416\u0412\u0001\u0000\u0000\u0000\u0416\u0414\u0001"+
		"\u0000\u0000\u0000\u0416\u0415\u0001\u0000\u0000\u0000\u0417\u00af\u0001"+
		"\u0000\u0000\u0000\u0418\u0419\u0005O\u0000\u0000\u0419\u041a\u0003\u00c8"+
		"d\u0000\u041a\u041b\u0005k\u0000\u0000\u041b\u00b1\u0001\u0000\u0000\u0000"+
		"\u041c\u041f\u0005N\u0000\u0000\u041d\u041e\u0005;\u0000\u0000\u041e\u0420"+
		"\u0003,\u0016\u0000\u041f\u041d\u0001\u0000\u0000\u0000\u041f\u0420\u0001"+
		"\u0000\u0000\u0000\u0420\u0421\u0001\u0000\u0000\u0000\u0421\u0422\u0005"+
		"j\u0000\u0000\u0422\u00b3\u0001\u0000\u0000\u0000\u0423\u042e\u00052\u0000"+
		"\u0000\u0424\u042e\u00053\u0000\u0000\u0425\u0426\u0005N\u0000\u0000\u0426"+
		"\u042a\u00052\u0000\u0000\u0427\u042b\u0005c\u0000\u0000\u0428\u0429\u0005"+
		";\u0000\u0000\u0429\u042b\u0003,\u0016\u0000\u042a\u0427\u0001\u0000\u0000"+
		"\u0000\u042a\u0428\u0001\u0000\u0000\u0000\u042a\u042b\u0001\u0000\u0000"+
		"\u0000\u042b\u042c\u0001\u0000\u0000\u0000\u042c\u042e\u0005j\u0000\u0000"+
		"\u042d\u0423\u0001\u0000\u0000\u0000\u042d\u0424\u0001\u0000\u0000\u0000"+
		"\u042d\u0425\u0001\u0000\u0000\u0000\u042e\u00b5\u0001\u0000\u0000\u0000"+
		"\u042f\u0430\u0005N\u0000\u0000\u0430\u0433\u0003,\u0016\u0000\u0431\u0432"+
		"\u0005;\u0000\u0000\u0432\u0434\u0003,\u0016\u0000\u0433\u0431\u0001\u0000"+
		"\u0000\u0000\u0433\u0434\u0001\u0000\u0000\u0000\u0434\u0435\u0001\u0000"+
		"\u0000\u0000\u0435\u0436\u0005j\u0000\u0000\u0436\u00b7\u0001\u0000\u0000"+
		"\u0000\u0437\u0438\u0003\u00ba]\u0000\u0438\u0439\u0005M\u0000\u0000\u0439"+
		"\u043a\u0003\u0002\u0001\u0000\u043a\u043b\u0005i\u0000\u0000\u043b\u00b9"+
		"\u0001\u0000\u0000\u0000\u043c\u0441\u0005$\u0000\u0000\u043d\u043e\u0005"+
		"O\u0000\u0000\u043e\u043f\u0003,\u0016\u0000\u043f\u0440\u0005k\u0000"+
		"\u0000\u0440\u0442\u0001\u0000\u0000\u0000\u0441\u043d\u0001\u0000\u0000"+
		"\u0000\u0441\u0442\u0001\u0000\u0000\u0000\u0442\u045b\u0001\u0000\u0000"+
		"\u0000\u0443\u045b\u0005\u001d\u0000\u0000\u0444\u0449\u0005\u0010\u0000"+
		"\u0000\u0445\u0446\u0005O\u0000\u0000\u0446\u0447\u0003,\u0016\u0000\u0447"+
		"\u0448\u0005k\u0000\u0000\u0448\u044a\u0001\u0000\u0000\u0000\u0449\u0445"+
		"\u0001\u0000\u0000\u0000\u0449\u044a\u0001\u0000\u0000\u0000\u044a\u045b"+
		"\u0001\u0000\u0000\u0000\u044b\u0458\u0005*\u0000\u0000\u044c\u0455\u0005"+
		"O\u0000\u0000\u044d\u0452\u0005\u0010\u0000\u0000\u044e\u044f\u0005O\u0000"+
		"\u0000\u044f\u0450\u0003,\u0016\u0000\u0450\u0451\u0005k\u0000\u0000\u0451"+
		"\u0453\u0001\u0000\u0000\u0000\u0452\u044e\u0001\u0000\u0000\u0000\u0452"+
		"\u0453\u0001\u0000\u0000\u0000\u0453\u0456\u0001\u0000\u0000\u0000\u0454"+
		"\u0456\u0003,\u0016\u0000\u0455\u044d\u0001\u0000\u0000\u0000\u0455\u0454"+
		"\u0001\u0000\u0000\u0000\u0456\u0457\u0001\u0000\u0000\u0000\u0457\u0459"+
		"\u0005k\u0000\u0000\u0458\u044c\u0001\u0000\u0000\u0000\u0458\u0459\u0001"+
		"\u0000\u0000\u0000\u0459\u045b\u0001\u0000\u0000\u0000\u045a\u043c\u0001"+
		"\u0000\u0000\u0000\u045a\u0443\u0001\u0000\u0000\u0000\u045a\u0444\u0001"+
		"\u0000\u0000\u0000\u045a\u044b\u0001\u0000\u0000\u0000\u045b\u00bb\u0001"+
		"\u0000\u0000\u0000\u045c\u045d\u0005\u0002\u0000\u0000\u045d\u045e\u0005"+
		"O\u0000\u0000\u045e\u045f\u0003,\u0016\u0000\u045f\u0460\u0005k\u0000"+
		"\u0000\u0460\u00bd\u0001\u0000\u0000\u0000\u0461\u0463\u0005q\u0000\u0000"+
		"\u0462\u0461\u0001\u0000\u0000\u0000\u0462\u0463\u0001\u0000\u0000\u0000"+
		"\u0463\u0464\u0001\u0000\u0000\u0000\u0464\u0465\u0005s\u0000\u0000\u0465"+
		"\u0467\u0005<\u0000\u0000\u0466\u0462\u0001\u0000\u0000\u0000\u0467\u046a"+
		"\u0001\u0000\u0000\u0000\u0468\u0466\u0001\u0000\u0000\u0000\u0468\u0469"+
		"\u0001\u0000\u0000\u0000\u0469\u046f\u0001\u0000\u0000\u0000\u046a\u0468"+
		"\u0001\u0000\u0000\u0000\u046b\u046d\u0005q\u0000\u0000\u046c\u046b\u0001"+
		"\u0000\u0000\u0000\u046c\u046d\u0001\u0000\u0000\u0000\u046d\u046e\u0001"+
		"\u0000\u0000\u0000\u046e\u0470\u0005s\u0000\u0000\u046f\u046c\u0001\u0000"+
		"\u0000\u0000\u046f\u0470\u0001\u0000\u0000\u0000\u0470\u00bf\u0001\u0000"+
		"\u0000\u0000\u0471\u0472\u0003\u0094J\u0000\u0472\u0473\u0005<\u0000\u0000"+
		"\u0473\u0475\u0001\u0000\u0000\u0000\u0474\u0471\u0001\u0000\u0000\u0000"+
		"\u0475\u0478\u0001\u0000\u0000\u0000\u0476\u0474\u0001\u0000\u0000\u0000"+
		"\u0476\u0477\u0001\u0000\u0000\u0000\u0477\u047a\u0001\u0000\u0000\u0000"+
		"\u0478\u0476\u0001\u0000\u0000\u0000\u0479\u047b\u0003\u0094J\u0000\u047a"+
		"\u0479\u0001\u0000\u0000\u0000\u047a\u047b\u0001\u0000\u0000\u0000\u047b"+
		"\u00c1\u0001\u0000\u0000\u0000\u047c\u047d\u0003l6\u0000\u047d\u047e\u0005"+
		"<\u0000\u0000\u047e\u0480\u0001\u0000\u0000\u0000\u047f\u047c\u0001\u0000"+
		"\u0000\u0000\u0480\u0483\u0001\u0000\u0000\u0000\u0481\u047f\u0001\u0000"+
		"\u0000\u0000\u0481\u0482\u0001\u0000\u0000\u0000\u0482\u0485\u0001\u0000"+
		"\u0000\u0000\u0483\u0481\u0001\u0000\u0000\u0000\u0484\u0486\u0003l6\u0000"+
		"\u0485\u0484\u0001\u0000\u0000\u0000\u0485\u0486\u0001\u0000\u0000\u0000"+
		"\u0486\u00c3\u0001\u0000\u0000\u0000\u0487\u0488\u0003p8\u0000\u0488\u0489"+
		"\u0005<\u0000\u0000\u0489\u048b\u0001\u0000\u0000\u0000\u048a\u0487\u0001"+
		"\u0000\u0000\u0000\u048b\u048e\u0001\u0000\u0000\u0000\u048c\u048a\u0001"+
		"\u0000\u0000\u0000\u048c\u048d\u0001\u0000\u0000\u0000\u048d\u0490\u0001"+
		"\u0000\u0000\u0000\u048e\u048c\u0001\u0000\u0000\u0000\u048f\u0491\u0003"+
		"p8\u0000\u0490\u048f\u0001\u0000\u0000\u0000\u0490\u0491\u0001\u0000\u0000"+
		"\u0000\u0491\u00c5\u0001\u0000\u0000\u0000\u0492\u0493\u0003\u0082A\u0000"+
		"\u0493\u0494\u0005<\u0000\u0000\u0494\u0496\u0001\u0000\u0000\u0000\u0495"+
		"\u0492\u0001\u0000\u0000\u0000\u0496\u0499\u0001\u0000\u0000\u0000\u0497"+
		"\u0495\u0001\u0000\u0000\u0000\u0497\u0498\u0001\u0000\u0000\u0000\u0498"+
		"\u049b\u0001\u0000\u0000\u0000\u0499\u0497\u0001\u0000\u0000\u0000\u049a"+
		"\u049c\u0003\u0082A\u0000\u049b\u049a\u0001\u0000\u0000\u0000\u049b\u049c"+
		"\u0001\u0000\u0000\u0000\u049c\u00c7\u0001\u0000\u0000\u0000\u049d\u049e"+
		"\u0003,\u0016\u0000\u049e\u049f\u0005<\u0000\u0000\u049f\u04a1\u0001\u0000"+
		"\u0000\u0000\u04a0\u049d\u0001\u0000\u0000\u0000\u04a1\u04a4\u0001\u0000"+
		"\u0000\u0000\u04a2\u04a0\u0001\u0000\u0000\u0000\u04a2\u04a3\u0001\u0000"+
		"\u0000\u0000\u04a3\u04a6\u0001\u0000\u0000\u0000\u04a4\u04a2\u0001\u0000"+
		"\u0000\u0000\u04a5\u04a7\u0003,\u0016\u0000\u04a6\u04a5\u0001\u0000\u0000"+
		"\u0000\u04a6\u04a7\u0001\u0000\u0000\u0000\u04a7\u00c9\u0001\u0000\u0000"+
		"\u0000\u00a7\u00ce\u00d3\u00db\u00e2\u00e5\u00ea\u00ed\u00f0\u00fc\u0100"+
		"\u0105\u010a\u010d\u0110\u0114\u011a\u011d\u0120\u0123\u0126\u012e\u0131"+
		"\u0134\u0137\u013c\u0141\u0144\u0148\u014c\u0150\u015c\u0162\u0166\u016c"+
		"\u016f\u0176\u0179\u017b\u017e\u0183\u0186\u018a\u0190\u0198\u019e\u01a1"+
		"\u01a8\u01ab\u01ad\u01b3\u01b6\u01be\u01c2\u01d0\u01d4\u01d9\u01dd\u01e7"+
		"\u01ec\u01f2\u01fb\u0203\u020a\u0212\u021b\u0224\u022d\u0233\u023c\u023f"+
		"\u0247\u024a\u0250\u0253\u0258\u025e\u0261\u0267\u026d\u0271\u0277\u027d"+
		"\u0280\u0284\u028c\u0290\u029a\u029e\u02a4\u02a9\u02b1\u02b6\u02b8\u02d3"+
		"\u02d6\u02e7\u02ea\u02f0\u02f4\u02f7\u02fa\u02fe\u0304\u030a\u030d\u0319"+
		"\u031e\u0325\u032f\u0336\u0363\u0366\u036a\u036e\u0372\u0379\u0380\u0383"+
		"\u0391\u0398\u039d\u03a3\u03a8\u03ad\u03b1\u03b6\u03bb\u03c4\u03c8\u03cb"+
		"\u03d0\u03d7\u03db\u03e0\u03e2\u03ee\u03f0\u0400\u0406\u040a\u040c\u040e"+
		"\u0416\u041f\u042a\u042d\u0433\u0441\u0449\u0452\u0455\u0458\u045a\u0462"+
		"\u0468\u046c\u046f\u0476\u047a\u0481\u0485\u048c\u0490\u0497\u049b\u04a2"+
		"\u04a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}