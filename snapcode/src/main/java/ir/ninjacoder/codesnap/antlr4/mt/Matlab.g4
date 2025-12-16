lexer grammar matlab;

// Operators
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
POW: '^';
ASSIGN: '=';
NOT: '~';
LT: '<';
GT: '>';
DOT: '.';
COLON: ':';
SEMI: ';';
COMMA: ',';
AT: '@';

// Array operators
ARRAYMUL: '.*';
ARRAYDIV: '.\\';
ARRAYRDIV: './';
ARRAYPOW: '.^';
NCTRANSPOSE: '.\'';

// Comparison operators
LE_OP: '<=';
GE_OP: '>=';
EQ_OP: '==';
NE_OP: '~=';

// Parentheses and brackets
LPAREN: '(';
RPAREN: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

// Keywords
BREAK: 'break';
CASE: 'case';
CATCH: 'catch';
CONTINUE: 'continue';
ELSE: 'else';
ELSEIF: 'elseif';
END: 'end';
FOR: 'for';
FUNCTION: 'function';
GLOBAL: 'global';
IF: 'if';
OTHERWISE: 'otherwise';
PERSISTENT: 'persistent';
RETURN: 'return';
SWITCH: 'switch';
TRY: 'try';
WHILE: 'while';
CLEAR: 'clear';
TRANSPOSE: 'transpose';

// Literals
STRING_LITERAL: '\'' (~'\'' | '\'\'')* '\'';
IDENTIFIER: [a-zA-Z] [a-zA-Z0-9_]*;
CONSTANT: NUMBER (E SIGN? NUMBER)?;

// Fragments
fragment NUMBER: [0-9]+ ('.' [0-9]+)?;
fragment E: [Ee];
fragment SIGN: [+-];

// Whitespace and newlines
CR: [\r\n]+ -> channel(HIDDEN);
WS: [ \t]+ -> skip;