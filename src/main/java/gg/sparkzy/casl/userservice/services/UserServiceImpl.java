package gg.sparkzy.casl.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gg.sparkzy.casl.userservice.entities.User;
import gg.sparkzy.casl.userservice.repos.UserRepo;

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
//		List<User> users = new ArrayList<>();
//		users.add(new User(1, "sparkzy", "ramjr13@gmail.com"));
//		users.add(new User(2, "oretara", "chungus@gmail.com"));
//		return users;
	}

	@Override
	public User findById(int id) {
		return userRepo.getOne(id);
//		return new User(id, "sparkzy", "ramjr13@gmail.com");
	}

	/************************************************************************************
	 * Update
	 ************************************************************************************/
	@Override
	public void update(User updatedUser) {
		// TODO Auto-generated method stub
		
	}

	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
