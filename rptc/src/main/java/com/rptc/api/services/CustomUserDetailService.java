package com.rptc.api.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rptc.api.entity.User;
import com.rptc.api.filter.JwtFilter;
import com.rptc.api.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(CustomUserDetailService.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername *** " + username);
		User user = userRepository.findByUsername(username);
		System.out.println(user.getUsername() + " : " + user.getPassword());
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

}