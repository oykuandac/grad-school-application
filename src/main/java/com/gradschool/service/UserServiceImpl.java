package com.gradschool.service;


import com.gradschool.model.User;
import com.gradschool.repository.RoleRepository;
import com.gradschool.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
    	System.out.println(userRepository.findByEmail(user.getEmail()));
    	if(userRepository.findByEmail(user.getEmail())==null) {
    		System.out.println("12312312");
    		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRoles(roleRepository.findByName("User"));
            userRepository.save(user);
    	}
  
        
    }
    
    @Override
    public void updatePassword(User user) {
    	System.out.println(userRepository.findByEmail(user.getEmail()));
    	if(userRepository.findByEmail(user.getEmail())!=null) {
    		System.out.println("12312312");
    		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
    	}
        
    }
    

    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }
    
    public List<User> getAll() {    	
    	return userRepository.findAll();
    }
}
