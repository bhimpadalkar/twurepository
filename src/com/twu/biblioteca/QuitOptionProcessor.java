package com.twu.biblioteca;

public class QuitOptionProcessor implements OptionProcessor {
    public void doAction(Library library){
        System.exit(0);
    }
}
