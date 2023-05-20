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

/* Inicio de Expresiones regulares */
constructor=[A-Z]
terminal=[a-z]
separator="|"
finalmark=";"
doublepoints=":"
space=[ \t]*

SaltoDeLinea= \n|\r|\r\n

NoMatch=.

%state PANIC
/* Finaliza expresiones regulares */
%%
/* Finaliza la sección de declaraciones de JFlex */

/* Inicia sección de reglas */

// Cada regla está formada por una {expresión} espacio {código}

<YYINITIAL> {

    {constructor} {
        return new Symbol(ParserSym.CONST, yytext());
    }

    {terminal} {
        return new Symbol(ParserSym.TERMINAL, yytext());
    }

    {separator} {
        return new Symbol(ParserSym.SEPARATOR, yytext());
    }

    {finalmark} {
        return new Symbol(ParserSym.FINALMARK, yytext());
    }

    {doublepoints} {
        return new Symbol(ParserSym.DOUBLEPOINTS, yytext());
    }

    {SaltoDeLinea} {
    }

    {space} {

      }

    {NoMatch} {
        System.out.println("Error found in line " + (yyline + 1) + ": \"" + yytext() + '"');
        yybegin(PANIC);
    }
}
<PANIC> {
    .   {;}
    \n|\r|\r\n   { yybegin(YYINITIAL);}
}
