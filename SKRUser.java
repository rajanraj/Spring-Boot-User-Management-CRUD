package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Model.UserModel;
import com.Repository.UserRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
public class SKRUser {
	@JsonIgnore
	@Autowired(required=true)
	UserRepo userRepo;
	@PostMapping("/newuser/{firsname}/{lastname}/{username}/{email}/{password}")
	public UserModel newUser(@PathVariable("firsname") String firstname,@PathVariable("lastname") String lastname,@PathVariable("username") String username,@PathVariable("email") String email,@PathVariable("password") long password) {
		UserModel usermodel = new UserModel();
		usermodel.setFirstName(firstname);
		usermodel.setLastName(lastname);
		usermodel.setUserName(username);
		usermodel.setEmail(email);
		usermodel.setPassword(password);
		userRepo.save(usermodel);
		return usermodel;
	}
	@GetMapping("/all")
	public List<UserModel> getAllUser() {
		return userRepo.findAll();
	}
	@GetMapping("/user/{id}")
	public UserModel getUser(@PathVariable("id") long id) {
		 
		return userRepo.getById(id);
	}
	@PutMapping("/edit/{id}/{firstName}/{lastName}/{email}/{password}")
	public UserModel getUpdate(@PathVariable("id") long id, @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, @PathVariable("email") String email, @PathVariable("password") long password) {
		UserModel update = userRepo.getById(id);
		update.setFirstName(firstName);
		update.setLastName(lastName);
		update.setEmail(email);
		update.setPassword(password);
		return userRepo.save(update);
	}
	@DeleteMapping("/removeuser/{id}")
	public void deleteUser(@PathVariable("id")long id) {
		
		 userRepo.deleteById(id);
	}
}
