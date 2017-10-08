package com.patrick.demo.services.impl;

import com.patrick.demo.bootstrap.exceptions.AccessKeyException;
import com.patrick.demo.entity.User;
import com.patrick.demo.services.AuthenticatorService;
import com.patrick.demo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by patri on 08/10/2017.
 */
@Service
public class AuthenticatorServiceImpl implements AuthenticatorService {

    @Autowired
    UserService userService;

    private static final int USERNAME_MINIMUM = 5;
    private static final int ACCESSKEY_MINIMUM = 12;

    private static final Logger logger = LoggerFactory.getLogger(AuthenticatorServiceImpl.class);

    @Override
    public User getAuthenticatedUser(String username, String accessKey){

        User user = null;

        if(isUsernameAndAccessKeyValid(username, accessKey)){

            try{

                user  = userService.getUserByUsername(username);

                if(user != null)
                    throw new UsernameNotFoundException("Username provided does not match our records");

                // TODO: a better authentication method
                if(user.getAccessKey().equalsIgnoreCase(accessKey)){
                    logger.info("User {} with key {} has been authenticated", username, accessKey);
                }else{
                    throw new AccessKeyException("API key provided does not match our records.");
                }

            }catch(AccessKeyException ex){
                // TODO: plaintext access-key in logs REEEEEEE
                logger.info("User {} with key {} has could not bee authenticated", username, accessKey);
            }
        }

        return user;

    }

    private boolean isUsernameAndAccessKeyValid(String username, String accessKey){
        checkNotNull(username, accessKey);
        checkArgument(username.length() > USERNAME_MINIMUM && accessKey.length() > ACCESSKEY_MINIMUM);
        return true;
    }
}
