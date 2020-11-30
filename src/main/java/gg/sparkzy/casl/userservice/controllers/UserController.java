package gg.sparkzy.casl.userservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import gg.sparkzy.casl.userservice.entities.User;
import gg.sparkzy.casl.userservice.services.UserService;

@RestController
@RequestMapping("/users")
@RefreshScope // actuator/refresh
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/************************************************************************************
	 * Create
	 ************************************************************************************/
	
	/************************************************************************************
	 * Read
	 ************************************************************************************/
	@GetMapping
	@HystrixCommand(
			fallbackMethod = "fallbackFindAll",
			threadPoolKey = "userPool",
			threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "20"),
					@HystrixProperty(name = "maxQueueSize", value = "10")
			})
	public List<User> findAll() {
		return userService.findAll();
	}
	
	public List<User> fallbackFindAll() {
		List<User> users = new ArrayList<User>();
		users.add(new User(0, "No users", "n/a"));
		return users;
	}

	@GetMapping("/{id}")
	@HystrixCommand(
			fallbackMethod = "fallbackFindById",
			threadPoolKey = "userPool",
			threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "20"),
					@HystrixProperty(name = "maxQueueSize", value = "10")
			})
	public User findUserById(@PathVariable("id") int id) {
		return userService.findById(id);
	}
	
	public User fallbackFindById(int id) {
		return new User(id, "No user with id: " + id, "n/a");
	}
	
	/************************************************************************************
	 * Update
	 ************************************************************************************/
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	
}