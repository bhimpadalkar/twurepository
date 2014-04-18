package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class LibMenu {
    private final String name;
    private ArrayList<LibMenuOption> options = new ArrayList<LibMenuOption>();

    public LibMenu(String menuName) {
        this.name = menuName;
    }

    public void showOptions() {
        printOptions();
        System.out.println("What you want to do ? : ");
    }

    private void printOptions() {
        for(LibMenuOption option : options){
            System.out.println(option.getId() + ". " + option.getName());
        }
    }

    public void createOptions(String[] menuOptionsList) {
        int i=1;
        for(String option: menuOptionsList){
            LibMenuOption currentOption = new LibMenuOption(option,i++);
            this.options.add(currentOption);
        }
    }

    public LibMenuOption getOption() {
        Scanner in = new Scanner(System.in);
        int userInput = Integer.parseInt(in.next());
        for(LibMenuOption option : options){
            if(userInput == option.getId()){
                return option;
            }
        }
        throw new IllegalArgumentException("Enter Valid Option");
    }

    public void executeOption(LibMenuOption currentOption) {
        currentOption.doAction();
    }
}
