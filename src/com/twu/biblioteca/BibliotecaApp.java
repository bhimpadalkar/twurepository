package com.twu.biblioteca;

import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.io.Console;
import com.twu.biblioteca.menu.Menu;

public class BibliotecaApp {

    private Console console;
    private Library library;

    public BibliotecaApp(Console console) {
        this.console = console;
        String [] booksList = {"Angels & Demons", "Digital Fortress", "Da Vinchi Code"};
        this.library = new Library(booksList);

    }

    public static void main(String[] args) {
        Console console = new Console(System.out, System.in);
        BibliotecaApp app = new BibliotecaApp(console);
        app.start();
    }

    public void start() {
        displayWelcomeMsg();
        while(true){
            console.println("\nWhat you want to do? : ");
            displayMenus();
            Menu userSelectedMenu = getUserInput();
            //console.println(userSelectedMenu.getDisplayText());
            userSelectedMenu.action.performAction(this);
        }
    }

    private Menu getUserInput() {
        int userInput = Integer.parseInt(console.in());
        return Menu.getItemFor(userInput);

    }

    private void displayMenus() {
        for (Menu menu : Menu.values()) {
            console.println(menu.getDisplayText());
        }
    }

    private void displayWelcomeMsg() {
        console.println("Welcome to Biblioteca !");
    }

    public void displayListOfAvailableBooks() {
        console.println("Available books are : ");
        for(String bookInfo : library.getListOfAvailableBooks()){
            console.println(bookInfo);
        }
    }

    public void checkoutBook() {
        boolean isCheckedOut;
        do{
            console.println("Which book you want to checkout? : ");
            String bookToBeCheckedOut = console.in();
            if(!bookToBeCheckedOut.equals("-1")){
                isCheckedOut = library.checkoutBookByName(bookToBeCheckedOut);
                if(isCheckedOut) console.println("Thank you!! Enjoy the book");
                else console.println("That book is not available");
            }
            else
                break;
        }while(!isCheckedOut);
    }

    public void returnBook() {
        boolean isReturned;
        do{
            console.println("Which book you want to return? : ");
            String bookToBeReturned = console.in();
            isReturned = library.returnBookByName(bookToBeReturned);
            if(isReturned) console.println("Thank you for returning the book");
            else console.println("That is not a valid book to return");
        }while(!isReturned);
    }

    public void invalidMenuAction() {
        console.println("Choose Valid Option");
    }

    public void quit() {
        console.println("Thank you for using Biblioteca!!");
        System.exit(0);
    }
}