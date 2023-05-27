
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package org.example;

import java_cup.runtime.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.HashMap;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return ParserSym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\015\000\002\002\004\000\002\002\002\000\002\002" +
    "\004\000\002\003\003\000\002\003\004\000\002\005\006" +
    "\000\002\004\004\000\002\004\004\000\002\006\003\000" +
    "\002\006\004\000\002\007\003\000\002\007\004\000\002" +
    "\010\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\025\000\006\002\000\004\005\001\002\000\004\002" +
    "\027\001\002\000\004\005\024\001\002\000\010\003\007" +
    "\007\016\010\011\001\002\000\004\006\023\001\002\000" +
    "\010\006\ufff7\007\ufff7\010\ufff7\001\002\000\010\006\ufff5" +
    "\007\ufff5\010\ufff5\001\002\000\010\006\ufff9\007\ufff9\010" +
    "\ufff9\001\002\000\012\002\ufffe\003\ufffe\007\ufffe\010\ufffe" +
    "\001\002\000\010\006\021\007\016\010\011\001\002\000" +
    "\012\002\uffff\003\007\007\016\010\011\001\002\000\004" +
    "\010\011\001\002\000\010\006\ufff6\007\ufff6\010\ufff6\001" +
    "\002\000\012\002\ufffd\003\ufffd\007\ufffd\010\ufffd\001\002" +
    "\000\012\002\ufffb\003\ufffb\007\ufffb\010\ufffb\001\002\000" +
    "\010\006\ufff8\007\ufff8\010\ufff8\001\002\000\012\002\ufffa" +
    "\003\ufffa\007\ufffa\010\ufffa\001\002\000\004\010\025\001" +
    "\002\000\004\010\026\001\002\000\010\003\ufffc\007\ufffc" +
    "\010\ufffc\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\025\000\006\002\003\005\005\001\001\000\002\001" +
    "\001\000\002\001\001\000\014\003\014\004\012\006\013" +
    "\007\011\010\007\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\007\021\010\007\001\001\000\012\004\017\006" +
    "\013\007\011\010\007\001\001\000\004\010\016\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    IdLexer idLexer;
    public static void main(String[] arg) throws Exception{
        String archivo = "est.txt";
        File f = new File(archivo);
        InputStream inputStream = new FileInputStream(f);
        IdLexer lexer = new org.example.IdLexer(new InputStreamReader(inputStream));

        Parser p = new Parser();
        p.idLexer = lexer;
        p.setScanner(p.idLexer);
        p.parse();
    }

    private Integer maxLiterals;
    private Integer maxClauses;
    private Integer totalClauses = 0;

    private boolean ok = true;

    public void syntax_error(Symbol cur_token){
//        report_error("Error de sintaxis: linea "+idLexer.linea()+
//        ", columna "+idLexer.columna() + "\n", null);
        report_error("Error de sintaxis: linea "+ (((IdLexer) this.getScanner()).linea() + 1) +
        ", columna "+ (((IdLexer) this.getScanner()).columna() + 1) + "\n", null);
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // program ::= 
            {
              Object RESULT =null;
		 ; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // program ::= header clauses 
            {
              Object RESULT =null;
		 ; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // clauses ::= clause 
            {
              Object RESULT =null;
		 ; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("clauses",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // clauses ::= clauses clause 
            {
              Object RESULT =null;
		 ; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("clauses",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // header ::= PARAMETER CNF NUMBER NUMBER 
            {
              Object RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 maxLiterals=e1;
                                                maxClauses=e2;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("header",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // clause ::= literals EOL 
            {
              Object RESULT =null;
		int lsleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int lsright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object ls = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		   totalClauses++;
                                if(totalClauses > maxClauses){
                                    System.out.println("Error: maximum number of clauses exceeded!");
                                }else{
                                    System.out.println(ls);
                                }
                                 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("clause",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // clause ::= error EOL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("clause",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // literals ::= literal 
            {
              Object RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object l = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT=l; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("literals",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // literals ::= literals literal 
            {
              Object RESULT =null;
		int lsleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int lsright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object ls = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object l = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT=ls + " v " + l; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("literals",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // literal ::= variable 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT="p"+e ; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("literal",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // literal ::= NEGATION variable 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT="¬p"+e; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("literal",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // variable ::= NUMBER 
            {
              Object RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 if (e1 > maxLiterals){
                            System.out.println("Error: " + '"' + e1 + '"' + " variable no definida");
                          }else{
                            RESULT=e1;
                          }
                          ; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("variable",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
