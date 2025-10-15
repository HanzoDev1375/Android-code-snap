/**
 * Kotlin Grammar for ANTLR v4
 *
 * Based on:
 * http://jetbrains.github.io/kotlin-spec/#_grammars_and_parsing
 * and
 * http://kotlinlang.org/docs/reference/grammar.html
 *
 * Tested on
 * https://github.com/JetBrains/kotlin/tree/master/compiler/testData/psi
 */

// $antlr-format alignTrailingComments true, columnLimit 150, maxEmptyLinesToKeep 1, reflowComments false, useTab false


// $antlr-format allowShortRulesOnASingleLine true, allowShortBlocksOnASingleLine true, minEmptyLines 0, alignSemicolons ownLine


// $antlr-format alignColons trailing, singleLineOverrulesHangingColon true, alignLexerCommands true, alignLabels true, alignTrailers true

lexer grammar KotlinLexer;

import UnicodeClasses;
ShebangLine
   : '#!' ~ [\u000A\u000D]* -> channel (HIDDEN)
   ;

DelimitedComment
   : '/*' (DelimitedComment | .)*? '*/' -> channel (HIDDEN)
   ;

LineComment
   : '//' ~ [\u000A\u000D]* -> channel (HIDDEN)
   ;

WS
   : [ \t\r\n\u000C]+ -> channel (HIDDEN)
   ;

   
RESERVED
   : '...'
   ;

STRING
   : '"' .*? '"'
   | '"""' .*? '"""'
   | '\'\'\'' .*? '\'\'\''
   | '\'' .*? '\''
   ;

DOT
   : '.'
   ;

COMMA
   : ','
   ;

LPAREN
   : '(' 
   ;

RPAREN
   : ')'
   ;

LSQUARE
   : '['
   ;

RSQUARE
   : ']'
   ;

LCURL
   : '{'
   ;

RCURL
   : '}'
   ;

MULT
   : '*'
   ;

MOD
   : '%'
   ;

DIV
   : '/'
   ;

ADD
   : '+'
   ;

SUB
   : '-'
   ;

INCR
   : '++'
   ;

DECR
   : '--'
   ;

CONJ
   : '&&'
   ;

DISJ
   : '||'
   ;

EXCL
   : '!'
   ;

COLON
   : ':'
   ;

SEMICOLON
   : ';'
   ;

ASSIGNMENT
   : '='
   ;

ADD_ASSIGNMENT
   : '+='
   ;

SUB_ASSIGNMENT
   : '-='
   ;

MULT_ASSIGNMENT
   : '*='
   ;

DIV_ASSIGNMENT
   : '/='
   ;

MOD_ASSIGNMENT
   : '%='
   ;

ARROW
   : '->'
   ;

DOUBLE_ARROW
   : '=>'
   ;

RANGE
   : '..'
   ;

COLONCOLON
   : '::'
   ;

Q_COLONCOLON
   : '?::'
   ;

DOUBLE_SEMICOLON
   : ';;'
   ;

HASH
   : '#'
   ;

AT
   : '@'
   ;

QUEST
   : '?'
   ;

ELVIS
   : '?:'
   ;

LANGLE
   : '<'
   ;

RANGLE
   : '>'
   ;

LE
   : '<='
   ;

GE
   : '>='
   ;

EXCL_EQ
   : '!='
   ;

EXCL_EQEQ
   : '!=='
   ;

AS_SAFE
   : 'as?'
   ;

EQEQ
   : '=='
   ;

EQEQEQ
   : '==='
   ;

PACKAGE
   : 'package'
   ;

IMPORT
   : 'import'
   ;

CLASS
   : 'class'
   ;

INTERFACE
   : 'interface'
   ;

FUN
   : 'fun'
   ;

OBJECT
   : 'object'
   ;

VAL
   : 'val'
   ;

VAR
   : 'var'
   ;

TYPE_ALIAS
   : 'typealias'
   ;

CONSTRUCTOR
   : 'constructor'
   ;

BY
   : 'by'
   ;

COMPANION
   : 'companion'
   ;

INIT
   : 'init'
   ;

THIS
   : 'this'
   ;

SUPER
   : 'super'
   ;

TYPEOF
   : 'typeof'
   ;

WHERE
   : 'where'
   ;

IF
   : 'if'
   ;

ELSE
   : 'else'
   ;

WHEN
   : 'when'
   ;

TRY
   : 'try'
   ;

CATCH
   : 'catch'
   ;

FINALLY
   : 'finally'
   ;

FOR
   : 'for'
   ;

DO
   : 'do'
   ;

WHILE
   : 'while'
   ;

THROW
   : 'throw'
   ;

RETURN
   : 'return'
   ;

CONTINUE
   : 'continue'
   ;

BREAK
   : 'break'
   ;

AS
   : 'as'
   ;

IS
   : 'is'
   ;

IN
   : 'in'
   ;


OUT
   : 'out'
   ;


DYNAMIC
   : 'dynamic'
   ;
   //MODIFIERS
   
PUBLIC
   : 'public'
   ;

PRIVATE
   : 'private'
   ;

PROTECTED
   : 'protected'
   ;

INTERNAL
   : 'internal'
   ;

ENUM
   : 'enum'
   ;

SEALED
   : 'sealed'
   ;

ANNOTATION
   : 'annotation'
   ;

DATA
   : 'data'
   ;

INNER
   : 'inner'
   ;

TAILREC
   : 'tailrec'
   ;

OPERATOR
   : 'operator'
   ;

INLINE
   : 'inline'
   ;

INFIX
   : 'infix'
   ;

EXTERNAL
   : 'external'
   ;

SUSPEND
   : 'suspend'
   ;

OVERRIDE
   : 'override'
   ;

ABSTRACT
   : 'abstract'
   ;

FINAL
   : 'final'
   ;

OPEN
   : 'open'
   ;

CONST
   : 'const'
   ;

LATEINIT
   : 'lateinit'
   ;

VARARG
   : 'vararg'
   ;

NOINLINE
   : 'noinline'
   ;

CROSSINLINE
   : 'crossinline'
   ;

REIFIED
   : 'reified'
   ;
   //
   

RealLiteral
   : FloatLiteral
   | DoubleLiteral
   ;

FloatLiteral
   : (DoubleLiteral | IntegerLiteral) [fF]
   ;

DoubleLiteral
   : ((DecDigitNoZero DecDigit* | '0')? '.' | (DecDigitNoZero (DecDigit | '_')* DecDigit)? '.') (DecDigit+ | DecDigit (DecDigit | '_')+ DecDigit | DecDigit+ [eE] ('+' | '-')? DecDigit+ | DecDigit+ [eE] ('+' | '-')? DecDigit (DecDigit | '_')+ DecDigit | DecDigit (DecDigit | '_')+ DecDigit [eE] ('+' | '-')? DecDigit+ | DecDigit (DecDigit | '_')+ DecDigit [eE] ('+' | '-')? DecDigit (DecDigit | '_')+ DecDigit)
   ;

LongLiteral
   : (IntegerLiteral | HexLiteral | BinLiteral) 'L'
   ;

IntegerLiteral
   : ('0' | DecDigitNoZero DecDigit* | DecDigitNoZero (DecDigit | '_')+ DecDigit | DecDigitNoZero DecDigit* [eE] ('+' | '-')? DecDigit+ | DecDigitNoZero DecDigit* [eE] ('+' | '-')? DecDigit (DecDigit | '_')+ DecDigit | DecDigitNoZero (DecDigit | '_')+ DecDigit [eE] ('+' | '-')? DecDigit+ | DecDigitNoZero (DecDigit | '_')+ DecDigit [eE] ('+' | '-')? DecDigit (DecDigit | '_')+ DecDigit)
   ;

fragment DecDigit
   : UNICODE_CLASS_ND
   ;

fragment DecDigitNoZero
   : UNICODE_CLASS_ND_NoZeros
   ;

fragment UNICODE_CLASS_ND_NoZeros
   : '\u0031' .. '\u0039'
   | '\u0661' .. '\u0669'
   | '\u06f1' .. '\u06f9'
   | '\u07c1' .. '\u07c9'
   | '\u0967' .. '\u096f'
   | '\u09e7' .. '\u09ef'
   | '\u0a67' .. '\u0a6f'
   | '\u0ae7' .. '\u0aef'
   | '\u0b67' .. '\u0b6f'
   | '\u0be7' .. '\u0bef'
   | '\u0c67' .. '\u0c6f'
   | '\u0ce7' .. '\u0cef'
   | '\u0d67' .. '\u0d6f'
   | '\u0de7' .. '\u0def'
   | '\u0e51' .. '\u0e59'
   | '\u0ed1' .. '\u0ed9'
   | '\u0f21' .. '\u0f29'
   | '\u1041' .. '\u1049'
   | '\u1091' .. '\u1099'
   | '\u17e1' .. '\u17e9'
   | '\u1811' .. '\u1819'
   | '\u1947' .. '\u194f'
   | '\u19d1' .. '\u19d9'
   | '\u1a81' .. '\u1a89'
   | '\u1a91' .. '\u1a99'
   | '\u1b51' .. '\u1b59'
   | '\u1bb1' .. '\u1bb9'
   | '\u1c41' .. '\u1c49'
   | '\u1c51' .. '\u1c59'
   | '\ua621' .. '\ua629'
   | '\ua8d1' .. '\ua8d9'
   | '\ua901' .. '\ua909'
   | '\ua9d1' .. '\ua9d9'
   | '\ua9f1' .. '\ua9f9'
   | '\uaa51' .. '\uaa59'
   | '\uabf1' .. '\uabf9'
   | '\uff11' .. '\uff19'
   ;

HexLiteral
   : '0' [xX] HexDigit (HexDigit | '_')*
   ;

fragment HexDigit
   : [0-9a-fA-F]
   ;

BinLiteral
   : '0' [bB] BinDigit (BinDigit | '_')*
   ;

fragment BinDigit
   : [01]
   ;

BooleanLiteral
   : 'true'
   | 'false'
   ;

NullLiteral
   : 'null'
   ;

Identifier
   : (Letter | '_') (Letter | '_' | DecDigit)*
   | '`' ~ ('`')+ '`'
   ;


fragment EscapeSeq
   : UniCharacterLiteral
   | EscapedIdentifier
   ;

fragment UniCharacterLiteral
   : '\\' 'u' HexDigit HexDigit HexDigit HexDigit
   ;

fragment EscapedIdentifier
   : '\\' ('t' | 'b' | 'r' | 'n' | '\'' | '"' | '\\' | '$')
   ;

fragment Letter
   : UNICODE_CLASS_LL
   | UNICODE_CLASS_LM
   | UNICODE_CLASS_LO
   | UNICODE_CLASS_LT
   | UNICODE_CLASS_LU
   | UNICODE_CLASS_NL
   ;