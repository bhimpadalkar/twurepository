package com.twu.biblioteca.io;

import java.io.PrintStream;

public class Console {

    private PrintStream outputPrintStream;

    public Console(PrintStream outputPrintStream) {
        //To change body of created methods use File | Settings | File Templates.
        this.outputPrintStream = outputPrintStream;
    }

    public void println(String str){
        outputPrintStream.println(str);
    }

}
