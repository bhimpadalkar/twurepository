package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.io.Console;
import com.twu.biblioteca.menu.Menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private Console console;
    private Library library;

    public BibliotecaApp(Console console, Library library) {
        this.console = console;
        this.library = library;
    }

    public static void main(String[] args) {
        Console console = new Console(System.out, new BufferedReader(new InputStreamReader(System.in)));
        Library library = initLibrary();
        BibliotecaApp app = new BibliotecaApp(console,library);
        app.start();
    }

    private static Library initLibrary() {
        String [] booksList = new String[]{"Angels & Demons", "Digital Fortress", "Da Vinchi Code"};
        List<String[]> moviesList = new ArrayList<String[]>();
        moviesList.add(new String[]{"Frozen","2013","Chris Buck","8"});
        moviesList.add(new String[]{"The Dark Knight","2008","Christopher Nolan","9"});
        return new Library(booksList,moviesList);
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

    public void displayListOfAvailableMovies() {
        console.println("Available movies are : ");
        for(Movie movie : library.getListOfAvailableMovies()){
            console.println(movie);
        }
    }

    public void checkoutBook() {
        console.println("Which book you want to checkout?");
        String bookToBeCheckedOut = console.readLine();
        if(bookToBeCheckedOut.equals(""))
            return;
        boolean isCheckedOut = library.checkoutBookByName(bookToBeCheckedOut);
        if(isCheckedOut) console.println("Thank you!! Enjoy the book.");
        else console.println("That book is not available.");
    }

    public void checkoutMovie() {
        boolean isCheckedOut;
        do{
            console.println("Which movie you want to checkout? : ");
            String movieToBeCheckedOut = console.readLine();
            if(!movieToBeCheckedOut.equals("-1")){
                isCheckedOut = library.checkoutMovieByName(movieToBeCheckedOut);
                if(isCheckedOut) console.println("Thank you!! Enjoy the movie");
                else console.println("That movie is not available");
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
            if(!bookToBeReturned.equals("-1")){
                isReturned = library.returnBookByName(bookToBeReturned);
                if(isReturned) console.println("Thank you for returning the book");
                else console.println("That is not a valid book to return");
            }
            else
                break;
        }while(!isReturned);
    }

    public void returnMovie() {
        boolean isReturned;
        do{
            console.println("Which movie you want to return? : ");
            String movieToBeReturned = console.readLine();
            if(!movieToBeReturned.equals("-1")){
                isReturned = library.returnMovieByName(movieToBeReturned);
                if(isReturned) console.println("Thank you for returning the movie");
                else console.println("That is not a valid movie to return");
            }
            else
                break;
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