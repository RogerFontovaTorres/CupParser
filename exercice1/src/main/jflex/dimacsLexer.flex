package org.example;

import java_cup.runtime.*;

%%
%public
%class IdLexer
%cupsym ParserSym
%cup
%column
%line
%unicode

%{
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    public int linea(){ return yyline+1; }
    public int columna(){ return yycolumn+1; }

%}

%eofval{
    return symbol(ParserSym.EOF);
%eofval}

parameter = "p"
cnf = "cnf"
formulaEOL = "0"
negation = "-"
number = [1-9][0-9]*

whitespace = [ \t]
newLine = (\n | \r | \r\n)

%state PANIC
/* Finaliza expresiones regulares */
%%
/* Finaliza la sección de declaraciones de JFlex */

/* Inicia sección de reglas */

// Cada regla está formada por una {expresión} espacio {código}

<YYINITIAL> {

    ^c.*{newLine}       { }

    {newLine}           { }

    {parameter}         {
                            return new Symbol(ParserSym.PARAMETER, yytext()); }

    {cnf}               {
                            return new Symbol(ParserSym.CNF, yytext()); }

    {number}            { return new Symbol(ParserSym.NUMBER, Integer.valueOf(yytext())); }

    {negation}          {
    return new Symbol(ParserSym.NEGATION, yytext()); }

    {formulaEOL}        { return new Symbol(ParserSym.EOL, yytext()); }

    .                   {  }

    {whitespace}        {  }

}

<PANIC> {
    .   {;}
    \n|\r|\r\n   { yybegin(YYINITIAL);}
}
