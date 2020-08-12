package com.softland.springsecurityjwt.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	/*
	 * Sobreescribimos este metodo para obtener informacion de nuestro usuario a autenticar
	 * este se puede optener de una base de datos, LDP, etc. En este ejemplo lo ponemos estatico.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new User("foo", "foo", new ArrayList<>()); // seteamos user, password y una lista de Authorities 
	}

}
