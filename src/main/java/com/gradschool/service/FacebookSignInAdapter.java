package com.gradschool.service;

import java.util.Arrays;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;
import org.thymeleaf.extras.springsecurity5.dialect.processor.AuthenticationAttrProcessor;

import com.gradschool.model.miniUser;

@Service
public class FacebookSignInAdapter implements SignInAdapter {
    @Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {

        System.out.println(" ====== Sign In adapter");
        Facebook facebook = (Facebook) connection.getApi();
		String[] fields = { "id", "email","first_name","last_name"};
        miniUser miniuser = facebook.fetchObject("me", miniUser.class, fields);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(miniuser.getEmail(), null, Arrays.asList(new SimpleGrantedAuthority("User"))));
        return null;
    }
}
