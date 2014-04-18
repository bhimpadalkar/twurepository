package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books = new ArrayList<Book>();

    public Library(String[] booksList){
        int i=1;
        for(String bookName : booksList){
            books.add(new Book(i, bookName));
        }
    }

    public void printAllBooks() {
        for(Book book : books){
            if(book.isAvailable) System.out.println(book.getName());
        }
    }

    public Book getBook(String userInput) {
        for(Book book : books){
            if(userInput.equals(book.getName())) return book;
        }
        return null;
    }

    public void checkoutBook(Book bookToBeCheckedOut) {
        for(Book book : books){
            if (book.equals(bookToBeCheckedOut)){
                book.isAvailable = false;
                break;
            }
        }
    }


    public void returnBook(Book bookToBeReturned) {
        for(Book book : books){
            if (book.equals(bookToBeReturned)){
                book.isAvailable = true;
                break;
            }
        }
    }
}
