package com.twu.biblioteca.domain;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksList = new ArrayList<Book>();

    public Library(String[] booksList) {
        int i=1;
        for (String bookTitle : booksList) {
            this.booksList.add(new Book(i++,bookTitle));
        }
    }

    public List<String> getListOfAvailableBooks() {
        List<String> availableBooks = new ArrayList<String>();
        for(Book book : this.booksList){
            if(book.isAvailable()) availableBooks.add(book.getDisplayText());
        }
        return availableBooks;
    }

    public boolean checkoutBookByName(String bookToBeCheckedOut) {
        Book book = getBookByName(bookToBeCheckedOut);
        if(book.isAvailable()){
            book.markAsCheckedOut();
            return true;
        }
        else
            return false;
    }

    public boolean returnBookByName(String bookToBeReturned) {
        Book book = getBookByName(bookToBeReturned);
        if(!book.isAvailable()&&book.getId()>0){
            book.markAsAvailableForCheckOut();
            return true;
        }
        else
            return false;
    }

    private Book getBookByName(String titleOfBookToBeCheckedOut) {
        for (Book book : booksList) {
            if(titleOfBookToBeCheckedOut.equals(book.getName()))
                return book;
        }
        return Book.NULL_BOOK;
    }
}