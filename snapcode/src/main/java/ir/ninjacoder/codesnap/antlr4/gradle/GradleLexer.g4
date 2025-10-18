lexer grammar GradleLexer;

PLUGINS
   : 'plugins'
   ;

APPLY
   : 'apply'
   ;

TASK
   : 'task'
   ;

DO_LAST
   : 'doLast'
   ;

DEPENDENCIES
   : 'dependencies'
   ;

IMPLEMENTATION
   : 'implementation'
   ;

COMPILE_ONLY
   : 'compileOnly'
   ;

RUNTIME_ONLY
   : 'runtimeOnly'
   ;

TEST_IMPLEMENTATION
   : 'testImplementation'
   ;

ANDROID_TEST_IMPLEMENTATION
   : 'androidTestImplementation'
   ;

API
   : 'api'
   ;

KAPT
   : 'kapt'
   ;

ANNOTATION_PROCESSOR
   : 'annotationProcessor'
   ;

COMPILE
   : 'compile'
   ;

RUNTIME
   : 'runtime'
   ;

TEST_COMPILE
   : 'testCompile'
   ;

TEST_RUNTIME
   : 'testRuntime'
   ;

VARIANT_CONFIGURATION
   : IDENTIFIER 'Implementation'
   | IDENTIFIER 'Compile'
   | IDENTIFIER 'Runtime'
   | IDENTIFIER 'Api'
   | IDENTIFIER 'Kapt'
   ;

ID
   : 'id'
   ;

VERSION
   : 'version'
   ;

GROUP
   : 'group'
   ;

NAME
   : 'name'
   ;

FROM
   : 'from'
   ;

INTO
   : 'into'
   ;

SETTINGS
   : 'settings'
   ;

BUILDSCRIPT
   : 'buildscript'
   ;

REPOSITORIES
   : 'repositories'
   ;

MAVEN
   : 'maven'
   ;

GOOGLE
   : 'google'
   ;

GRADLE
   : 'gradle'
   ;

PROJECT
   : 'project'
   ;

FILES
   : 'files'
   ;

FILE_TREE
   : 'fileTree'
   ;

DIR
   : 'dir'
   ;

INCLUDE
   : 'include'
   ;

EXCLUDE
   : 'exclude'
   ;

AS
   : 'as'
   ;

ASSERT
   : 'assert'
   ;

BREAK
   : 'break'
   ;

CASE
   : 'case'
   ;

CATCH
   : 'catch'
   ;

CLASS
   : 'class'
   ;

CONST
   : 'const'
   ;

CONTINUE
   : 'continue'
   ;

DEF
   : 'def'
   ;

DEFAULT
   : 'default'
   ;

DO
   : 'do'
   ;

ELSE
   : 'else'
   ;

ENUM
   : 'enum'
   ;

EXTENDS
   : 'extends'
   ;

FINALLY
   : 'finally'
   ;

FOR
   : 'for'
   ;

GOTO
   : 'goto'
   ;

IF
   : 'if'
   ;

IMPLEMENTS
   : 'implements'
   ;

IMPORT
   : 'import'
   ;

IN
   : 'in'
   ;

INSTANCEOF
   : 'instanceof'
   ;

INTERFACE
   : 'interface'
   ;

NEW
   : 'new'
   ;

PACKAGE
   : 'package'
   ;

RETURN
   : 'return'
   ;

SUPER
   : 'super'
   ;

SWITCH
   : 'switch'
   ;

THIS
   : 'this'
   ;

THROW
   : 'throw'
   ;

THROWS
   : 'throws'
   ;

TRAIT
   : 'trait'
   ;

TRY
   : 'try'
   ;

WHILE
   : 'while'
   ;

TRUE
   : 'true'
   ;

FALSE
   : 'false'
   ;

NULL
   : 'null'
   ;

DOT
   : '.'
   ;

COLON
   : ':'
   ;

COMMA
   : ','
   ;

SEMICOLON
   : ';'
   ;

LPAREN
   : '('
   ;

RPAREN
   : ')'
   ;

LBRACE
   : '{'
   ;

RBRACE
   : '}'
   ;

LBRACKET
   : '['
   ;

RBRACKET
   : ']'
   ;

ASSIGN
   : '='
   ;

ARROW
   : '->'
   ;

PLUS
   : '+'
   ;

MINUS
   : '-'
   ;

MULT
   : '*'
   ;

DIV
   : '/'
   ;

QUEST
   : '?'
   ;

ELVIS
   : '?:'
   ;

NOT_NULL
   : '!!'
   ;

SINGLE_QUOTE_STRING
   : '\'' .*? '\''
   ;

DOUBLE_QUOTE_STRING
   : '"' .*? '"'
   ;

TRIPLE_QUOTE_STRING
   : '"""' .*? '"""'
   ;

fragment ESC
   : '\\' (['"\\/bfnrt] | UNICODE)
   ;

fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;

fragment HEX
   : [0-9a-fA-F]
   ;
   // Numbers
   
INTEGER
   : [0-9]+
   ;

FLOAT
   : [0-9]+ '.' [0-9]* EXP?
   | '.' [0-9]+ EXP?
   | [0-9]+ EXP
   ;

fragment EXP
   : [Ee] [+\-]? [0-9]+
   ;
   // Identifiers and variables
   
IDENTIFIER
   : Letter LetterOrDigit*
   ;

LINE_COMMENT
   : '//' ~ [\r\n]* -> skip
   ;

BLOCK_COMMENT
   : '/*' .*? '*/' -> skip
   ;

DOC_COMMENT
   : '/**' .*? '*/' -> skip
   ;

WS
   : [ \t\r\n\u000C]+ -> channel (HIDDEN)
   ;

fragment LetterOrDigit
   : Letter
   | [0-9]
   ;

fragment Letter
   : [a-zA-Z$_\-] // these are the "java letters" below 0x7F
   | ~ [\u0000-\u007F\uD800-\uDBFF] // covers all characters above 0x7F which are not a surrogate
   | [\uD800-\uDBFF] [\uDC00-\uDFFF] // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
   
   ;

