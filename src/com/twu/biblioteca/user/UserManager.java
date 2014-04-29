package com.twu.biblioteca.user;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> users;

    public UserManager(){
        this.users = createUsers();
    }

    private List<User> createUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User("111-1234","Anand Beck","anand123","anand@tw.com","0098"));
        users.add(new User("111-7880","Sneha Wang","sneha123","sneha@tw.com","3265"));
        users.add(new User("111-4553","Frank Singh","frank123","frank@tw.com","5555"));
        return users;
    }

    public boolean isUserValid(UserCredentials userCredentials){
        for(User user:users){
            if(user.getCredentials().getLibraryNumber().equals(userCredentials.getLibraryNumber()) && user.getCredentials().getPassword().equals(userCredentials.getPassword()))
                return true;
        }
        return false;
    }

    public User getUserFromCredentials(UserCredentials userCredentials){
        for(User user:users){
            if(user.getCredentials().getLibraryNumber().equals(userCredentials.getLibraryNumber()))
                return user;
        }
        return null;
    }
}
