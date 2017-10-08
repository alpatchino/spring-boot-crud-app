package com.patrick.demo.services;

import com.patrick.demo.entity.User;

/**
 * Created by patri on 08/10/2017.
 */
public interface AuthenticatorService {

    User getAuthenticatedUser(String username, String accessKey);
}
