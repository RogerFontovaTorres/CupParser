package org.example;

import java_cup.runtime.*;

%%
%public
%class IdLexer
%cup

parameter = "p"
cnf = "cnf"
formulaEOL = "0"
negation = "-"
comment = "c ".*{newLine}
number = [1-9][0-9]*
whitespace = [ \t]
newLine = \n | \r | \r\n

%{
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    public static int nlin = 1;
%}

%eofval{
    return symbol(ParserSym.EOF);
%eofval}

%%

{comment}           { nlin++; }

{newLine}           { nlin++; }

{parameter}         {return symbol(ParserSym.PARAMETER, yytext()); }

{cnf}               {return symbol(ParserSym.CNF, yytext()); }

{number}            { return symbol(ParserSym.NUMBER, Integer.valueOf(yytext())); }

{negation}          { return symbol(ParserSym.NEGATION, yytext()); }

{formulaEOL}        { return symbol(ParserSym.EOL, yytext()); nlin++;}

.                   {  }


[^] {throw new Error("Cadena incorrecta (" + yytext() + ")");}