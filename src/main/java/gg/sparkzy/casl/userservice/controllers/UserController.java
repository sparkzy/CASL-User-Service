package gg.sparkzy.casl.userservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import gg.sparkzy.casl.userservice.entities.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	/************************************************************************************
	 * Create
	 ************************************************************************************/
	
	/************************************************************************************
	 * Read
	 ************************************************************************************/
	@GetMapping("/{id}")
	public User findUserById(@PathVariable("id") int id) {
		return new User(id, "sparkzy", "ramjr13@gmail.com");
	}
	
	@GetMapping
	@HystrixCommand(
			fallbackMethod = "getFallbackFindUser",
			threadPoolKey = "userPool",
			threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "20"),
					@HystrixProperty(name = "maxQueueSize", value = "10")
			})
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "sparkzy", "ramjr13@gmail.com"));
		users.add(new User(2, "oretara", "chungus@gmail.com"));
		return users;
	}
	
	public List<User> getFallbackUser() {
		List<User> users = new ArrayList<User>();
		users.add(new User(0, "No users", "n/a"));
		return users;
	}
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	
}