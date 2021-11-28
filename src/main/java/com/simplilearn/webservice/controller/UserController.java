package com.simplilearn.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.simplilearn.webservice.entity.User;

import com.simplilearn.webservice.exception.UserNotFoundException;
import com.simplilearn.webservice.repository.UserRepository;

@RestController
public class UserController {

	//1. Inject Dependency 
	@Autowired
	private UserRepository userRepository;
	
	//2. Get All User
	@GetMapping("/users")
	public List<User>getAllUser(){
		
		return this.userRepository.findAll();
	}
	
	//3. Get One User By Id
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id")long userId) {
		return this.userRepository.findById(userId).orElseThrow(()->{
			throw new UserNotFoundException("User Not Found With Id" + userId);
		});	
	}
		
	//4. Add A User
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		
		return this.userRepository.save(user);
	}
	
	//5. Update A User 
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user) {
		//5.1 Find User
		User fetchedUser = this.userRepository.findById(user.getId()).orElseThrow(()->{
			throw new UserNotFoundException("User Not Found With Id " + user.getId());
		});
		
		
		//5.2 Set New User
		fetchedUser.setName(user.getName());
		fetchedUser.setEmail(user.getEmail());
		fetchedUser.setAge(user.getAge());
		fetchedUser.setGender(user.getGender());
		fetchedUser.setUsername(user.getUsername());
		
		//5.3 Save User
		return this.userRepository.save(fetchedUser);
	}
	
	//6. Delete A User
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable(value="id") long userId) {
		
		//6.1 find User
		
		User fetchedUser = this.userRepository.findById(userId).orElseThrow(()->{
			throw new UserNotFoundException("User Not Found With Id" + userId);
		});
		
		//6.2 delete User
		   this.userRepository.delete(fetchedUser);
	}
}
