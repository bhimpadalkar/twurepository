package com.twu.biblioteca.domain;

import com.twu.biblioteca.menu.Displayable;

public class Book extends LibraryItem implements Displayable{

    public static final Book NULL_BOOK = new Book(-1, "") {
        @Override
        boolean isAvailableForCheckout(){
            return false;
        }

        @Override
        boolean isCheckedOut(){
            return false;
        }
    };

    public Book(int id, String name){
        super(id,name);
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

}
