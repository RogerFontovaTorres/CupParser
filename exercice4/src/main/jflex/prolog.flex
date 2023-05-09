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
Var=[x-z1-9]
Const=[a-c1-9]
Predicates=[P-T1-9]
Functions=[f-g1-9]
Negation="!"
Conjunction="&&"
Disjunction="||"
Implication="->"
DoubleImplication="<->"
Space=" "+
ForAll="forall"
Exists="exists"
Separator=","
LeftParenthesis="("
RightParenthesis=")"

SaltoDeLinea= \n|\r|\r\n

NoMatch=.

%state PANIC
/* Finaliza expresiones regulares */
%%
/* Finaliza la sección de declaraciones de JFlex */

/* Inicia sección de reglas */

// Cada regla está formada por una {expresión} espacio {código}

<YYINITIAL> {
    {ForAll} {
        return new Symbol(ParserSym.FORALL, yytext());
    }

    {Exists} {
        return new Symbol(ParserSym.EXISTS, yytext());
    }

    {Var} {
        return new Symbol(ParserSym.VAR, yytext());
    }

    {Const} {
        return new Symbol(ParserSym.CONST, yytext());
    }

    {Predicates} {
        return new Symbol(ParserSym.PREDICATE, yytext());
    }

    {Functions} {
        return new Symbol(ParserSym.FUNCTION, yytext());
    }

    {Separator} {
        return new Symbol(ParserSym.SEPARATOR, yytext());
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

    {Implication} {
        return new Symbol(ParserSym.IMPL, yytext());
    }

    {DoubleImplication} {
        return new Symbol(ParserSym.DIMPL, yytext());
    }

    {LeftParenthesis} {
        return new Symbol(ParserSym.LPAREN, yytext());
    }

    {RightParenthesis} {
        return new Symbol(ParserSym.RPAREN, yytext());
    }

    {Space} {
    }

    {SaltoDeLinea} {
        return new Symbol(ParserSym.NEWLINE, yytext());
    }
    {NoMatch} {
        System.out.println("Error found in line " + (linea()) + ": \"" + yytext() + '"');
        yybegin(PANIC);
    }
}
<PANIC> {
    .   {;}
    \n|\r|\r\n   { yybegin(YYINITIAL);}
}