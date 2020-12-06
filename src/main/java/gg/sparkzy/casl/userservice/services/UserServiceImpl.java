package gg.sparkzy.casl.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gg.sparkzy.casl.userservice.entities.User;
import gg.sparkzy.casl.userservice.repos.UserRepo;

/**
 * User service implementation for CASL
 * 
 * @author Bobby McGetrick
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	/************************************************************************************
	 * Create
	 ************************************************************************************/
	@Override
	public User save(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	/************************************************************************************
	 * Read
	 ************************************************************************************/
	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		return userRepo.getOne(id);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	/************************************************************************************
	 * Update
	 ************************************************************************************/
	@Override
	public void update(User updatedUser) {
		userRepo.save(updatedUser);
	}

	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	@Override
	public void delete(int id) {
		userRepo.deleteById(id);		
	}

}
