package com.twu.biblioteca.io;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console {

    private InputStream inputStream;
    private PrintStream outputPrintStream;

    public Console(PrintStream outputPrintStream, InputStream inputStream) {
        //To change body of created methods use File | Settings | File Templates.
        this.outputPrintStream = outputPrintStream;
        this.inputStream = inputStream;
    }

    public void println(String str){
        outputPrintStream.println(str);
    }

    public String in() {
        Scanner in = new Scanner(inputStream);
        return in.nextLine();
    }
}
