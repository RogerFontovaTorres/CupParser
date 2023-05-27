package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
    String archivo = "test.txt";
    File f = new File(archivo);
    InputStream inputStream = new FileInputStream(f);
    IdLexer idLexer = new org.example.IdLexer(new InputStreamReader(inputStream));
    Parser p = new Parser(idLexer);
    p.parse();
//        Symbol sym = idLexer.next_token();
//        while(sym.sym != ParserSym.EOF){
//            System.out.println(sym.value);
//            sym = idLexer.next_token();
//        }
}
}