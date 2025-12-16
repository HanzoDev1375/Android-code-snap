lexer grammar DiffLexer;
/* ---------- Headers ---------- */


DIFF
   : 'diff' ' ' '--git'
   ;

INDEX
   : 'index' ' ' HEX '..' HEX
   ;

OLD_FILE
   : '---' ' ' FILE_PATH
   ;

NEW_FILE
   : '+++' ' ' FILE_PATH
   ;

HUNK_HEADER
   : '@@' ' ' '-' INT (',' INT)? ' ' '+' INT (',' INT)? ' ' '@@'
   ;
/* ---------- Line types ---------- */
   
   
ADDED_LINE
   : '+' ~ [\r\n]*
   ;

REMOVED_LINE
   : '-' ~ [\r\n]*
   ;

CONTEXT_LINE
   : ' ' ~ [\r\n]*
   ;

NO_NEWLINE
   : '\\' ' No newline at end of file'
   ;
/* ---------- Fragments ---------- */
   
   
fragment HEX
   : [0-9a-fA-F]+
   ;

fragment INT
   : [0-9]+
   ;

fragment FILE_PATH
   : ~ [\r\n]+
   ;
/* ---------- Misc ---------- */
   
   
NEWLINE
   : '\r'? '\n'
   ;

WS
   : [ \t]+ -> skip
   ;

