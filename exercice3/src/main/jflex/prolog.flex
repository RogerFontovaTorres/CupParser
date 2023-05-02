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
Var=[a-zA-Z]
Negation="!"
Conjunction="&&"
Disjunction="||"
Implication="->"
DoubleImplication=\<-\>
LeftParenthesis="("
RightParenthesis=")"
Space=" "+

Comment=#.*{SaltoDeLinea}

SaltoDeLinea= \n|\r|\r\n

NoMatch=.

%state PANIC
/* Finaliza expresiones regulares */
%%
/* Finaliza la sección de declaraciones de JFlex */

/* Inicia sección de reglas */

// Cada regla está formada por una {expresión} espacio {código}

<YYINITIAL> {


    {Var} {
        return new Symbol(ParserSym.VAR, yytext());
    }

    {Negation} {
        return new Symbol(ParserSym.NOT, yytext());
    }

    {Conjunction} {
        return new Symbol(ParserSym.AND, yytext());
    }

    {Disjunction} {
        return new Symbol(ParserSym.OR, yytext());
    }

    {DoubleImplication} {
        return new Symbol(ParserSym.DIMPL, yytext());
    }

    {Implication} {
        return new Symbol(ParserSym.IMPL, yytext());
    }

    {LeftParenthesis} {
        return new Symbol(ParserSym.LPAREN, yytext());
    }

    {RightParenthesis} {
        return new Symbol(ParserSym.RPAREN, yytext());
    }

    {Space} {}

    {Comment} {
        yyline += 1;
    }

    {SaltoDeLinea} {
        yyline += 1;
        return new Symbol((ParserSym.NEWLINE));
    }
    {NoMatch} {
        System.out.println("Error found in line " + (yyline + 1) + ": \"" + yytext() + '"');
        yybegin(PANIC);
        yyline += 1;
    }
}
<PANIC> {
    .   {;}
    \n|\r|\r\n   { yybegin(YYINITIAL);}
}
