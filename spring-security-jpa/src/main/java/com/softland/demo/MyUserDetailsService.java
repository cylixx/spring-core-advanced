package com.softland.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softland.demo.model.MyUserDetails;
import com.softland.demo.model.User;
import com.softland.demo.repository.UserRepository;

/*
 * 
 */
@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	// This method is use to retrieve user information (Dummy data, Data Base, LDAP, etc..) and return the UserDetails
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		//return new MyUserDetailsDummy(userName);
		
		Optional<User> user = userRepository.findByUserName(userName); // we need to conver User to UserDetails
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		
		return user.map(MyUserDetails::new).get();
	}

}
