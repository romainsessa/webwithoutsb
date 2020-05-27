package com.romain.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.romain.models.User;

@Repository
@Qualifier("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {
	
	/**
	 * Needed for the custom UserDetailService
	 * @param name of the user to retrieve
	 * @return the user mapping this name
	 */
	public User findByName(String name);

}
