package com.twu.biblioteca.io;

import com.twu.biblioteca.menu.Displayable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Console {

    private BufferedReader inputStream;
    private PrintStream outputPrintStream;

    public Console(PrintStream outputPrintStream, BufferedReader inputStream) {
        //To change body of created methods use File | Settings | File Templates.
        this.outputPrintStream = outputPrintStream;
        this.inputStream = inputStream;
    }

    public void println(String str){
        outputPrintStream.println(str);
    }

    public void println(Displayable item){
        outputPrintStream.println(item.getDisplayText());
    }

    public Integer readInt(){
        try {
            return Integer.valueOf(inputStream.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readLine() {
        try {
            return inputStream.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
