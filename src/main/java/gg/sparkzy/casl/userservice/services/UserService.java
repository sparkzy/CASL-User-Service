package gg.sparkzy.casl.userservice.services;

import java.util.List;

import gg.sparkzy.casl.userservice.entities.User;

/**
 * User service implementation for CASL
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
	public User findById(int id);

	public List<User> findAll();

	/************************************************************************************
	 * Update
	 ************************************************************************************/
	public void update(User updatedUser);

	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	public void delete(int id);

}
