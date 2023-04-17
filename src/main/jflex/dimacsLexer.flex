package org.example;

import java_cup.runtime.*;

%%
%public
%class IdLexer
%cup

header = "p cnf"
formulaEOL = "0"
minus = "-"
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

{comment} {}

{digit}+ { return symbol(ParserSym.NUMBER, Integer.valueOf(yytext())); }

{formulaEOL} { return symbol(ParserSym.FORMULANEWLINE, yytext()); }

{minus} {return symbol(ParserSym.MINUS, yytext());}


{whitespace}+ { }
[^] {throw new Error("Cadena incorrecta (" + yytext() + ")");}
