package com.patrick.demo.bootstrap;


import com.patrick.demo.domain.Model;
import com.patrick.demo.domain.User;
import com.patrick.demo.repositories.UserRepository;
import com.patrick.demo.utils.Constants;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent>  {

	//TODO: finish model repo
	
    private UserRepository userRepository;
    //private ModelRepository modelRepository;

    private Logger log = Logger.getLogger(UserLoader.class);

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	
    	User admin = new User();
    	admin.setAccountType(Constants.ACCOUNT_TYPE_ADMIN);
    	admin.setApiKey("0000-1111-abcd-edfg");
    	admin.setCreatedOn(new Date());
    	admin.setFailedLoginAttempts(0);
    	admin.setFirstName("Admin");
    	admin.setLastName("Admin");
    	admin.setEmail("admin@admin.com");
    	admin.setUsername("admin");
    	admin.setPassword("password");
    	userRepository.save(admin);
    	log.info("Saved user - " + admin.getId());
    	
    	User premiumUser = new User();
    	premiumUser.setAccountType(Constants.ACCOUNT_TYPE_PREMIUM);
    	premiumUser.setApiKey("1234-5678-abcd-edfg");
    	premiumUser.setCreatedOn(new Date());
    	premiumUser.setFailedLoginAttempts(0);
    	premiumUser.setFirstName("Premium");
    	premiumUser.setLastName("User");
    	premiumUser.setEmail("premium@user.com");
    	premiumUser.setUsername("premiumuser");
    	premiumUser.setPassword("password");
    	userRepository.save(premiumUser);
    	log.info("Saved user - " + premiumUser.getId());
    	
    	Model premiumUserModel = new Model();
    	premiumUserModel.setCreatedBy(premiumUser);
    	premiumUserModel.setDescription("A simple model that adds two inputs");
    	premiumUserModel.setEndpointUri("/addition");
    	premiumUserModel.setName("Simple Addition");
    	premiumUserModel.setStatus(Constants.MODEL_STATUS_OFFLINE);
    	//modelRepository.save(premiumUserModel);
    	
    	User freeUser = new User();
    	freeUser.setAccountType(Constants.ACCOUNT_TYPE_FREE);
    	freeUser.setApiKey("abcd-efgh-1234-5678");
    	freeUser.setCreatedOn(new Date());
    	freeUser.setFailedLoginAttempts(0);
    	freeUser.setFirstName("Free");
    	freeUser.setLastName("User");
    	freeUser.setEmail("free@user.com");
    	freeUser.setUsername("freeuser");
    	freeUser.setPassword("password");
    	userRepository.save(freeUser);
    	log.info("Saved user - " + freeUser.getId());
    	
    	Model freeUserModel = new Model();
    	freeUserModel.setCreatedBy(premiumUser);
    	freeUserModel.setDescription("A simple model that adds two inputs");
    	freeUserModel.setEndpointUri("/addition");
    	freeUserModel.setName("Simple Addition");
    	freeUserModel.setStatus(Constants.MODEL_STATUS_ONLINE);
    	
    }
}

