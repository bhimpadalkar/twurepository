package com.twu.biblioteca;

import com.twu.biblioteca.io.Console;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private Console console;
    private Library library;

    public BibliotecaApp(Console console) {
        this.console = console;
        String [] booksList = {"Angels & Demons", "Digital Fortress", "Da Vinchi Code"};
        library = new Library(booksList);

    }

    public static void main(String[] args) {
        Console console = new Console(System.out);
        BibliotecaApp app = new BibliotecaApp(console);
        app.start();
    }

    public void start() {
        displayWelcomeMsg();
        String [] mainMenuOptionsList =  {"List Books", "Check-out Book", "Return Book", "Quit"};
        AppMenu mainMenu = new AppMenu("Main",mainMenuOptionsList);
        while(true)
        {
            mainMenu.showOptionsAndChoose();
            AppMenuOption currentOption = mainMenu.getOption();
            mainMenu.executeOption(currentOption,library);
        }
    }

    private void displayWelcomeMsg() {
        console.println("Welcome to Biblioteca !");
    }
}
