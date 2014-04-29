package com.twu.biblioteca.user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserManagerTest {
    private UserManager sut;

    @Before
    public void setup(){
        sut = new UserManager();
    }

    @Test
    public void shouldReturnTrueIfUserIsValid(){
        UserCredentials userCredentials = new UserCredentials("111-1234","anand123");
        assertTrue(sut.isUserValid(userCredentials));
    }

    @Test
    public void shouldReturnFalseIfUserIsNotValid(){
        UserCredentials userCredentials = new UserCredentials("111-1234","anand123");
        assertFalse(sut.isUserValid(userCredentials));
    }
}
