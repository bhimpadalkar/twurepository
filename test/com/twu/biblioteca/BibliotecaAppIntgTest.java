package com.twu.biblioteca;

import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.io.Console;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * Created with IntelliJ IDEA.
 * user: bhimsenp
 * Date: 18/04/14
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */

public class BibliotecaAppIntgTest {

    private Console console;

    private BibliotecaApp sut;
    private PrintStream outputPrintStream;
    private ByteArrayOutputStream outputStream;
    private Library library;
    private BufferedReader inputReader;

    @Before
    public void setup(){
        library = initLibrary();
        outputStream = new ByteArrayOutputStream();
        outputPrintStream = new PrintStream(outputStream);
        inputReader = new BufferedReader(new StringReader("1\n7\n"));  //List Books action followed by Exit
        console = new Console(outputPrintStream, inputReader);
        sut = new BibliotecaApp(console,library);
    }
    private static Library initLibrary() {
        String [] booksList = new String[]{"Angels & Demons", "Digital Fortress", "Da Vinchi Code"};
        List<String[]> moviesList = new ArrayList<String[]>();
        moviesList.add(new String[]{"Frozen","2013","Chris Buck","8"});
        moviesList.add(new String[]{"The Dark Knight","2008","Christopher Nolan","9"});
        return new Library(booksList,moviesList);
    }

    @Test
    public void shouldPerformRequestedActionsForBooksFlow(){
        sut.start();
        String output = new String(outputStream.toByteArray());
        assertTrue(output.contains("Welcome to Biblioteca !\n"));
        assertTrue(output.contains("1. List Books"));
        assertTrue(output.contains("Available books are : \n1.\tAngels & Demons\n"));
        assertTrue(output.contains("Thank you for using Biblioteca!!\n"));
    }


}
