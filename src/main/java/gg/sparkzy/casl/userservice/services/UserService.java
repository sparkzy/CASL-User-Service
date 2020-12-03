package gg.sparkzy.casl.userservice.services;

import java.util.List;

import gg.sparkzy.casl.userservice.entities.User;

/**
 * User service interface for CASL
 * 
 * @author Bobby McGetrick
 *
 */
public interface UserService {
	
	/************************************************************************************
	 * Create
	 ************************************************************************************/
	public User save(User newUser);

	/************************************************************************************
	 * Read
	 ************************************************************************************/
	public List<User> findAll();
	
	public User findById(int id);

	public User findByUsername(String username);

	/************************************************************************************
	 * Update
	 ************************************************************************************/
	public void update(User updatedUser);

	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	public void delete(int id);

}
