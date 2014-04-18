package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class AppMenu {
    private final String name;
    private ArrayList<AppMenuOption> options = new ArrayList<AppMenuOption>();

    public AppMenu(String menuName, String[] menuOptionsList) {
        this.name = menuName;
        int i=1;
        for(String option: menuOptionsList){
            AppMenuOption currentOption = new AppMenuOption(option,i++);
            this.options.add(currentOption);
        }
    }

    public void showOptionsAndChoose() {
        System.out.println("\n" + this.name);
        printOptions();
        System.out.println("What you want to do ? : ");
    }

    private void printOptions() {
        for(AppMenuOption option : options){
            System.out.println(option.getId() + ". " + option.getName());
        }
    }

    public AppMenuOption getOption() {
        Scanner in = new Scanner(System.in);
        int userInput = Integer.parseInt(in.next());
        for(AppMenuOption option : options){
            if(userInput == option.getId()){
                return option;
            }
        }
        throw new IllegalArgumentException("Enter Valid Option");
    }

    public void executeOption(AppMenuOption currentOption, Library library) {
        System.out.println(currentOption.getName());
        OptionProcessor optionProcessor = getOptionProcessor(currentOption.getName());
        optionProcessor.doAction(library);
    }

    private OptionProcessor getOptionProcessor(String currentOption) {
        if(currentOption.equals("List Books")) return new ListBookOptionProcessor();
        else if (currentOption.equals("Check-out Book")) return new CheckoutBookProcessor();
        else if (currentOption.equals("Return Book")) return new ReturnBookProcessor();
        else if (currentOption.equals("Quit")) return new QuitOptionProcessor();
        else throw  new IllegalArgumentException("Enter Valid Option");
    }
}
