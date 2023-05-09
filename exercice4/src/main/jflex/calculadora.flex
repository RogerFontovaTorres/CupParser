package org.example;

import java_cup.runtime.*;

%%
%public
%class IdLexer
%cup
%cupsym ParserSym
%column
%line
%unicode
digit = [0-9]
letter = [a-zA-Z]
whitespace = [ \t]
newline = [\r\n]

%{
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type){
        return new Symbol(type);
    }
    private Symbol symbol(int type, Object value){
        return new Symbol(type, value);
    }

    public int linea(){ return yyline+1; }
    public int columna(){ return yycolumn+1; }
%}

%eofval{
    return symbol(ParserSym.EOF);
%eofval}

%%


[a-z] { return new Symbol(ParserSym.REG, (int) yytext().charAt(0) - (int) 'a'); }

"=" { return new Symbol(ParserSym.ASSIGN, yytext()); }
"(" { return new Symbol(ParserSym.LPAREN, yytext()); }
")" { return new Symbol(ParserSym.RPAREN, yytext()); }
"+" { return new Symbol(ParserSym.ADD, yytext()); }
"*" { return new Symbol(ParserSym.MULT, yytext()); }
"/" { return new Symbol(ParserSym.DIV, yytext()); }
">" { return new Symbol(ParserSym.BT, yytext()); }
"?" { return new Symbol(ParserSym.QUESTION, yytext()); }

{digit}+ { return new Symbol(ParserSym.NUMBER, Integer.valueOf(yytext())); }

{whitespace}+ { }
{newline}+ { return new Symbol((ParserSym.NEWLINE)); }
. {throw new Error("Cadena incorrecta (" + yytext() + ")");}
