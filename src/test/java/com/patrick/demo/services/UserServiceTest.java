package com.patrick.demo.services;

import com.patrick.demo.entity.User;
import com.patrick.demo.bootstrap.utils.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by patri on 18/09/2017.
 */

public class UserServiceTest {

    @Autowired
    private UserService userService;

    User testUser;

    String apiKey;

    @Before
    public void setUp() throws Exception {
        apiKey = "0000-1111-abcd-edfg";
        testUser = new User();
        testUser.setAccountType(Constants.ACCOUNT_TYPE_ADMIN);
        testUser.setApiKey(apiKey);
        testUser.setCreatedOn(new Date());
        testUser.setLastLogin(new Date());
        testUser.setFailedLoginAttempts(0);
        testUser.setFirstName("Admin");
        testUser.setLastName("Admin");
        testUser.setEmail("admin@admin.com");
        testUser.setUsername("admin");
        testUser.setPassword("password");
        userService.saveUser(testUser);
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testGetUserByApiKey() throws Exception {
        User user = userService.getUserByApiKey(apiKey);
        assertEquals(user.getUsername(), "admin");
    }

    @Test(expected = Exception.class)
    public void testGetAuthenticatedUserGivenEmptyStringShouldFail() throws Exception{
        User user = userService.getAuthenticatedUser("", "");
    }

    @Test(expected = Exception.class)
    public void testGetAuthenticatedUserGivenWrongUserNameAndApiKeyShouldFail() throws Exception{
        User user = userService.getAuthenticatedUser(testUser.getUsername(), "WRONG-API-KEY");
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = userService.saveUser(new User());
        assertNotNull(user);
    }

}