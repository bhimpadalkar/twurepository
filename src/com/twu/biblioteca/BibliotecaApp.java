package com.twu.biblioteca;

import com.twu.biblioteca.io.Console;

public class BibliotecaApp {

    private Console console;

    public BibliotecaApp() {
//        LibMenu mainMenu = new LibMenu("Main");
//        String [] mainMenuOptionsList =  {"List Books", "Quit"};
//        mainMenu.createOptions(mainMenuOptionsList);
//        mainMenu.showOptions();
//        LibMenuOption currentOption = mainMenu.getOption();
//        mainMenu.executeOption(currentOption);
    }

    public BibliotecaApp(Console console) {

        this.console = console;
    }

    public static void main(String[] args) {
        Console console = new Console(System.out);
        BibliotecaApp app = new BibliotecaApp(console);
        app.start();

    }

    public void start() {
        displayWelcomeMsg();
    }

    private void displayWelcomeMsg() {
        console.println("Welcome to Biblioteca !");
    }
}
