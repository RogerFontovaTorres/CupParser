package org.example;

import java_cup.runtime.*;

%%
%public
%class IdLexer
%cup

header = "p cnf"
formulaEOL = "0"
negated = "-"
comment = "^c ".{newLine}
number = [1-9][0-9]*
whitespace = [ \t\n]
newLine = \n | \r | \r\n

%{
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

%eofval{
    return symbol(ParserSym.EOF);
%eofval}

%%

{digit}+ { return symbol(ParserSym.NUMBER, Integer.valueOf(yytext())); }
"(" { return symbol(ParserSym.FORMULANEWLINE, yytext()); }
")" { return symbol(ParserSym.RPAREN, yytext()); }
"+" { return symbol(ParserSym.ADD, yytext()); }
"*" { return symbol(ParserSym.MULT, yytext()); }

{whitespace}+ { }
[^] {throw new Error("Cadena incorrecta (" + yytext() + ")");}
