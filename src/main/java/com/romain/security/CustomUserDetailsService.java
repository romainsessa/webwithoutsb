package com.romain.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.romain.models.User;
import com.romain.repositories.UserRepository;

@Service
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository repository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Retrieving the user according to its name.
		User user = repository.findByName(username);
		
		// If the password is plain text in database (not encoded), uncomment the following line. 
		//user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		// Building a Spring Security User with the local user information
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), getGrantedAuthorities());
	}
	
	/**
	 * In order to provide authorities to users.
	 * @return a list of granted authority.
	 */
	private List<GrantedAuthority> getGrantedAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		return authorities;
	}

}
