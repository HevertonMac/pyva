// Caminho do arquivo: Javython.g4
grammar Javython;

options { caseInsensitive=true; }

program:
    PROGRAM COLON ID SEMICOLON
    decIds
    metodo*
    blocoMain
    END;

decIds:
    'decIds' COLON (declaracao SEMICOLON)+;

declaracao:
    listaIds COLON tipo (ASSIGN valor)? // Declaração com tipo explícito e atribuição opcional
    | ID ASSIGN valor;                  // Inferência de tipo para constantes/variáveis

listaIds:
    ID (COMMA ID)*;

tipo:
    INT_TYPE | REAL_TYPE | STR_TYPE | BOOL_TYPE;

valor:
    INT | REAL | STRING | TRUE | FALSE;

metodo:
    (tipo | VOID) ID LPAREN parametros? RPAREN blocoMetodo;

parametros:
    parametro (COMMA parametro)*;

parametro:
    tipo ID;

blocoMetodo:
    LBRACE decIds? comando* RBRACE;

blocoMain:
    MAIN COLON decIds? comando*;

comando:
    atribuicao SEMICOLON
    | chamadaMetodo SEMICOLON
    | io SEMICOLON
    | ifElse
    | whileLoop
    | forLoop
    | RETURN expressao? SEMICOLON
    | BREAK SEMICOLON;

atribuicao:
    ID ASSIGN expressao;

expressao:
    (SUB | NOT) expressao                                                       # unariaExpr
    | chamadaMetodo                                                             # chamadaExpr
    | ID                                                                        # idExpr
    | valor                                                                     # valorExpr
    | LPAREN expressao RPAREN                                                   # parenExpr
    | <assoc=left> expressao (MUL | DIV) expressao                              # multdivExpr
    | <assoc=left> expressao (ADD | SUB) expressao                              # addsubExpr
    | <assoc=left> expressao (EQ | NEQ | GT | LT) expressao                     # relacionalExpr
    | <assoc=right> expressao (INC | DEC)                                       # postfixExpr
    ;

chamadaMetodo:
    ID LPAREN argumentos? RPAREN;

argumentos:
    expressao (COMMA expressao)*;

ifElse:
    IF LPAREN expressao RPAREN LBRACE comando* RBRACE (ELSE LBRACE comando* RBRACE)?;

whileLoop:
    WHILE LPAREN expressao RPAREN LBRACE comando* RBRACE;

forLoop:
    FOR LPAREN atribuicao? SEMICOLON expressao? SEMICOLON (expressao | atribuicao)? RPAREN LBRACE comando* RBRACE;

io:
    PRINT LPAREN argumentos? RPAREN
    | INPUT LPAREN listaIds RPAREN;

// --- Lexer Rules ---

PROGRAM: 'program';
MAIN: 'main';
END: 'end';
RETURN: 'return';

// // Regra 'decIds' case-insensitive
// DECIDS: D E C I D S;
// fragment D: ('d'|'D');
// fragment E: ('e'|'E');
// fragment C: ('c'|'C');
// fragment I: ('i'|'I');
// fragment S: ('s'|'S');

PRINT: 'print';
INPUT: 'input';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';
BREAK: 'break';
VOID: 'void';

BOOL_TYPE: 'bool';
INT_TYPE: 'int';
REAL_TYPE: 'real';
STR_TYPE: 'str';

TRUE: 'true';
FALSE: 'false';

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
INC: '++';
DEC: '--';
ASSIGN: '=';
EQ: '==';
NEQ: '!=';
GT: '>';
LT: '<';
NOT: '!';


LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
COLON: ':';
SEMICOLON: ';';
COMMA: ',';

STRING: '"' (~["])* '"';
REAL: [0-9]+ '.' [0-9]+;
INT: [0-9]+;

ID: [a-z_] [a-z_0-9]*;
WS: [ \t\r\n]+ -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;