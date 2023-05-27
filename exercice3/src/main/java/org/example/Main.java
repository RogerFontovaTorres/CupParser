package org.example;

import java_cup.runtime.Symbol;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String archivo = "test.txt";
        File f = new File(archivo);
        InputStream inputStream = new FileInputStream(f);
        IdLexer lexer = new org.example.IdLexer(new InputStreamReader(inputStream));

        Parser p = new Parser();
        p.idLexer = lexer;
        p.setScanner(p.idLexer);
        p.parse();
    }
}