package com.twu.biblioteca.domain;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksList = new ArrayList<Book>();
    private List<Movie> moviesList = new ArrayList<Movie>();

    public Library(String[] booksList, List<String []> moviesList) {
        int i=1;
        for (String bookTitle : booksList) {
            this.booksList.add(new Book(i++,bookTitle));
        }
        i=1;
        for (String [] movieInfo: moviesList){
            this.moviesList.add(new Movie(i++,movieInfo));
        }
    }

    public List<Book> getListOfAvailableBooks() {
        List<Book> availableBooks = new ArrayList<Book>();
        for (Book book : booksList) {
            if(book.isAvailableForCheckout()) availableBooks.add(book);
        }
        return availableBooks;
    }

    public List<Movie> getListOfAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<Movie>();
        for (Movie movie : moviesList) {
            if(movie.isAvailableForCheckout()) availableMovies.add(movie);
        }
        return availableMovies;
    }

    public boolean checkoutBookByName(String bookToBeCheckedOut) {
        Book book = getBookByName(bookToBeCheckedOut);
        if(book.isAvailableForCheckout()){
            book.markAsCheckedOut();
            return true;
        }
        else
            return false;
    }

    public boolean checkoutMovieByName(String movieToBeCheckedOut) {
        Movie movie = getMovieByName(movieToBeCheckedOut);
        if(movie.isAvailableForCheckout()){
            movie.markAsCheckedOut();
            return true;
        }
        else
            return false;
    }


    public boolean returnBookByName(String bookToBeReturned) {
        Book book = getBookByName(bookToBeReturned);
        if(book.isCheckedOut()){
            book.markAsAvailableForCheckOut();
            return true;
        }
        else
            return false;
    }

    public boolean returnMovieByName(String movieToBeReturned) {
        Movie movie = getMovieByName(movieToBeReturned);
        if(movie.isCheckedOut()){
            movie.markAsAvailableForCheckOut();
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

    private Movie getMovieByName(String titleOfMovieToBeCheckedOut) {
        for (Movie movie : moviesList) {
            if(titleOfMovieToBeCheckedOut.equals(movie.getName()))
                return movie;
        }
        return Movie.NULL_MOVIE;
    }

}
