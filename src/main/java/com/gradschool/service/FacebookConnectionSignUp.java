package com.gradschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

import com.gradschool.model.User;
import com.gradschool.model.miniUser;
import com.gradschool.repository.UserRepository;

@Service
public class FacebookConnectionSignUp implements ConnectionSignUp{
	@Autowired
    private UserServiceImpl userServiceImpl;
 
    @Override
    public String execute(Connection<?> connection) {
        User user = new User();
        
		Facebook facebook = (Facebook) connection.getApi();
		String[] fields = { "id", "email","first_name","last_name"};
        miniUser miniuser = facebook.fetchObject("me", miniUser.class, fields);
        
        user.setId(miniuser.getId());
        user.setEmail(miniuser.getEmail());
        user.setName(miniuser.getFirst_name());
        user.setSurname(miniuser.getLast_name());
        
        user.setPassword("12346578");
        userServiceImpl.save(user);
        return user.getName();
    }

}
