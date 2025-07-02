grammar Javython;

// ------------------- Options -------------------
options { caseInsensitive=true; }

// ------------------- Regras do Parser -------------------


program
    : PROGRAM COLON ID SEMICOLON
      decIds            // Declarações globais obrigatórias
      metodo*
      blocoMain
      END
    ;

// Bloco de declarações (obrigatório em escopo global, opcional em métodos)
decIds
    : DECIDS COLON (declaracao SEMICOLON)+
    ;


declaracao
    : ID ASSIGN valor
    | listaIds COLON tipo
    ;


listaIds
    : ID (COMMA ID)*
    ;


tipo
    : INT_TYPE
    | REAL_TYPE
    | STR_TYPE
    | BOOL_TYPE
    ;


valor
    : INT
    | REAL
    | STRING
    | TRUE
    | FALSE
    ;


metodo
    : (tipo | VOID) ID LPAREN parametros? RPAREN blocoMetodo
    ;


parametros
    : parametro (COMMA parametro)*
    ;


parametro
    : tipo ID
    ;


blocoMetodo
    : LBRACE
        decIds?
        comando*
      RBRACE
    ;

blocoMain
    : MAIN COLON
        decIds?
        comando*
    ;


comando
    : atribuicao SEMICOLON
    | chamadaMetodo SEMICOLON
    | expressao SEMICOLON
    | io SEMICOLON
    | ifElse
    | whileLoop
    | forLoop
    | RETURN expressao? SEMICOLON
    | BREAK SEMICOLON
    ;

atribuicao
    : ID ASSIGN expressao
    ;


expressao
    : op=(NOT | SUB) expressao                                               # unariaExpr
    | <assoc=left> left=expressao op=(MUL | DIV) right=expressao             # multdivExpr
    | <assoc=left> left=expressao op=(ADD | SUB) right=expressao             # addsubExpr
    | <assoc=left> left=expressao op=(EQ | NEQ | GT | LT) right=expressao    # relacionalExpr
    | expressao op=(INC | DEC)                                               # postfixExpr
    | chamadaMetodo                                                          # chamadaExpr
    | ID                                                                     # idExpr
    | valor                                                                  # valorExpr
    | LPAREN expressao RPAREN                                                # parenExpr
    ;


chamadaMetodo
    : ID LPAREN argumentos? RPAREN
    ;


argumentos
    : expressao (COMMA expressao)*
    ;


ifElse
    : IF LPAREN expressao RPAREN LBRACE comando* RBRACE (ELSE LBRACE comando* RBRACE)?
    ;

whileLoop
    : WHILE LPAREN expressao RPAREN LBRACE comando* RBRACE
    ;

forLoop
    : FOR LPAREN atribuicao? SEMICOLON expressao? SEMICOLON expressao? RPAREN LBRACE comando* RBRACE
    ;


io
    : PRINT LPAREN argumentos? RPAREN
    | INPUT LPAREN listaIds RPAREN
    ;

// ------------------- Tokens (Lexer) -------------------
PROGRAM : 'program';
MAIN    : 'main';
END     : 'end';
RETURN  : 'return';
DECIDS  : 'decIds';
PRINT   : 'print';
INPUT   : 'input';
IF      : 'if';
ELSE    : 'else';
WHILE   : 'while';
FOR     : 'for';
BREAK   : 'break';
VOID    : 'void';

// Tipos
BOOL_TYPE : 'bool';
INT_TYPE  : 'int';
REAL_TYPE : 'real';
STR_TYPE  : 'str';
TRUE      : 'true';
FALSE     : 'false';

// Operadores Aritméticos e de Atribuição
ADD    : '+';
SUB    : '-';
MUL    : '*';
DIV    : '/';
INC    : '++';
DEC    : '--';
ASSIGN : '=';

// Operadores Relacionais e Lógicos Permitidos
EQ  : '==';
NEQ : '!=';
GT  : '>';
LT  : '<';
NOT : '!'; 

// Operadores não permitidos (causarão erro de sintaxe)
GE  : '>=';
LE  : '<=';
AND : 'and';
OR  : 'or';


// Símbolos
LPAREN    : '(';
RPAREN    : ')';
LBRACE    : '{';
RBRACE    : '}';
COLON     : ':';
SEMICOLON : ';';
COMMA     : ',';


STRING : '"' .*? '"';
REAL   : [0-9]+ '.' [0-9]+;
INT    : [0-9]+;
ID     : [_a-zA-Z] [_a-zA-Z0-9]*;

WS           : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;