package com.twu.biblioteca.domain;

import com.twu.biblioteca.menu.Displayable;

public class Book implements Displayable{
    public static final Book NULL_BOOK = new Book(-1, "") {
        @Override
        public boolean isAvailableForCheckout() {
            return false;
        }

        @Override
        public boolean isCheckedOut() {
            return false;
        }
    };
    private int id;
    private String name;
    private boolean isAvailable = true;

    void markAsAvailableForCheckOut(){
        this.isAvailable = true;
    }

    void markAsCheckedOut(){
        this.isAvailable = false;
    }

    public Book(int id, String name){
        if (name == null){
            throw new IllegalArgumentException("NULL titles not allowed");
        }
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getDisplayText() {
        return String.format("%s. %s",getId(),getName());
    }

    public boolean isAvailableForCheckout() {
        return this.isAvailable;
    }

    public boolean isCheckedOut() {
        return !this.isAvailable;
    }

    @Override
    public boolean equals(Object o) {

        if(!(o instanceof Book))
            return false;

        if(o == this)
            return true;

        Book bookToCompare = (Book) o;
        return (bookToCompare.id == id) &&
                (bookToCompare.name.equals(name)) &&
                (bookToCompare.isAvailable == isAvailable);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (isAvailable ? 1 : 0);
        return result;
    }
}
