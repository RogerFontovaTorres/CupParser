package org.example;

import java_cup.runtime.Symbol;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String archivo = "src/main/java/org/example/prueba.txt";
        File f = new File(archivo);
        InputStream inputStream = new FileInputStream(f);
        IdLexer idLexer = new IdLexer(new InputStreamReader(inputStream));
        Parser p = new Parser(idLexer);
        p.parse();
//        Symbol sym = idLexer.next_token();
//        while(sym.sym != ParserSym.EOF){
//            System.out.println(sym.value);
//            sym = idLexer.next_token();
//        }
    }
}