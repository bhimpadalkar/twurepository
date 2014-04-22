package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.io.Console;
import com.twu.biblioteca.menu.Menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BibliotecaApp {

    private Console console;
    private Library library;

    public BibliotecaApp(Console console) {
        this.console = console;
        this.library = new Library(new String[]{"Angels & Demons", "Digital Fortress", "Da Vinchi Code"});

    }

    public static void main(String[] args) {
        Console console = new Console(System.out, new BufferedReader(new InputStreamReader(System.in)));
        BibliotecaApp app = new BibliotecaApp(console);
        app.start();
    }

    public void start() {
        displayWelcomeMsg();
        while(true){
            console.println("\nWhat you want to do? : ");
            displayMenus();
            Menu userSelectedMenu = getUserInput();
            userSelectedMenu.performAction(this);
        }
    }

    private Menu getUserInput() {
        Integer userInput = console.readInt();
        return Menu.getItemFor(userInput);

    }

    private void displayMenus() {
        for (Menu menu : Menu.values()) {
            console.println(menu);
        }
    }

    private void displayWelcomeMsg() {
        console.println("Welcome to Biblioteca !");
    }

    public void displayListOfAvailableBooks() {
        console.println("Available books are : ");
        for(Book book : library.getListOfAvailableBooks()){
            console.println(book);
        }
    }

    public void checkoutBook() {
        boolean isCheckedOut;
        do{
            console.println("Which book you want to checkout? : ");
            String bookToBeCheckedOut = console.readLine();
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
            String bookToBeReturned = console.readLine();
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