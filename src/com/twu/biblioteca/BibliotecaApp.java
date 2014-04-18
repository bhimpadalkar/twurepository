package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        welcome();
        LibMenu mainMenu = new LibMenu("Main");
        String [] mainMenuOptionsList =  {"List Books", "Quit"};
        mainMenu.createOptions(mainMenuOptionsList);
        mainMenu.showOptions();
        LibMenuOption currentOption = mainMenu.getOption();
        mainMenu.executeOption(currentOption);
    }

    private static void welcome() {
        System.out.println("Welcome to Biblioteca !");
    }
}
