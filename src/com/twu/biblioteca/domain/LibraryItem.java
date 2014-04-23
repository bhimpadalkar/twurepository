package com.twu.biblioteca.domain;

import com.twu.biblioteca.menu.Displayable;

public abstract class LibraryItem implements Displayable{

    protected int id;
    protected String name;
    protected boolean isAvailable = true;

    protected LibraryItem(int id, String name) {
        if (name == null){
            throw new IllegalArgumentException("NULL titles/names not allowed");
        }
        this.id = id;
        this.name = name;
        this.isAvailable = true;
    }

    void markAsAvailableForCheckOut(){
        this.isAvailable = true;
    }

    void markAsCheckedOut(){
        this.isAvailable = false;
    }

    boolean isAvailableForCheckout() {
        return this.isAvailable;
    }

    boolean isCheckedOut() {
        return !this.isAvailable;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getDisplayText() {
        return String.format("%s.\t%s",id,name);
    }

}
