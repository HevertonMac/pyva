// Caminho do arquivo: Javython.g4
grammar Javython;

// ------------------------------------------------------------------
// 1. Regra Principal (Program)
// ------------------------------------------------------------------

program:
    PROGRAM COLON ID SEMICOLON
    decIds?
    metodo*
    blocoMain
    END;

// ------------------------------------------------------------------
// 2. Estruturas de Bloco e Escopo
// ------------------------------------------------------------------

bloco:
    LBRACE comando* RBRACE;

blocoMetodo:
    LBRACE decIds? comando* RBRACE;

blocoMain:
    MAIN COLON decIds? comando*;

metodo:
    (tipo | VOID) ID LPAREN parametros? RPAREN blocoMetodo;

parametros:
    parametro (COMMA parametro)*;

parametro:
    tipo ID;

// ------------------------------------------------------------------
// 3. Regras de Declaração
// ------------------------------------------------------------------

decIds:
    DECIDS COLON (declaracao SEMICOLON)+;

declaracao:
    listaIds COLON tipo (ASSIGN valor)?
    | ID ASSIGN valor;

listaIds:
    ID (COMMA ID)*;

tipo:
    INT_TYPE | REAL_TYPE | STR_TYPE | BOOL_TYPE;

valor:
    INT | REAL | STRING | TRUE | FALSE;

// ------------------------------------------------------------------
// 4. Regras de Comando e Estruturas de Controle
// ------------------------------------------------------------------

comando:
    atribuicao SEMICOLON
    | chamadaMetodo SEMICOLON
    | io SEMICOLON
    | ifElse
    | whileLoop
    | forLoop
    | RETURN expressao? SEMICOLON
    | BREAK SEMICOLON
    | expressao SEMICOLON; // Permitir expressões como um comando

ifElse:
    IF LPAREN expressao RPAREN bloco (ELSE bloco)?;

whileLoop:
    WHILE LPAREN expressao RPAREN bloco;

forLoop:
    FOR LPAREN atribuicao? SEMICOLON expressao? SEMICOLON (expressao | atribuicao)? RPAREN bloco;

io:
    PRINT LPAREN argumentos? RPAREN
    | INPUT LPAREN listaIds RPAREN;

// ------------------------------------------------------------------
// 5. Regras de Expressão e Atribuição (Ordem de Precedência)
// ------------------------------------------------------------------

atribuicao:
    ID ASSIGN expressao;

chamadaMetodo:
    ID LPAREN argumentos? RPAREN;

argumentos:
    expressao (COMMA expressao)*;

expressao:
      LPAREN expressao RPAREN                                         # parenExpr
    | chamadaMetodo                                                   # chamadaExpr
    | ID                                                              # idExpr
    | valor                                                           # valorExpr
    | <assoc=right> expressao (INC | DEC)                             # postfixExpr
    | (SUB | NOT) expressao                                           # unariaExpr
    | <assoc=left> expressao (MUL | DIV) expressao                    # multdivExpr
    | <assoc=left> expressao (ADD | SUB) expressao                    # addsubExpr
    | <assoc=left> expressao (EQ | NEQ | GT | LT | GE | LE) expressao # relacionalExpr
    | <assoc=left> expressao (AND | OR) expressao                     # logicaExpr
    ;

// ------------------------------------------------------------------
// 6. Regras do Lexer (Tokens)
// ------------------------------------------------------------------

PROGRAM: 'program';
MAIN: 'main';
END: 'end';
RETURN: 'return';

// Regra 'decIds' case-insensitive
DECIDS: D E C I D S;
fragment D: ('d'|'D');
fragment E: ('e'|'E');
fragment C: ('c'|'C');
fragment I: ('i'|'I');
fragment S: ('s'|'S');

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
GE: '>=';
LE: '<=';
AND: 'and';
OR: 'or';

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

ID: [a-zA-Z_] [a-zA-Z_0-9]*;
WS: [ \t\r\n]+ -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;