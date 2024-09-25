package com.techwave.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.techwave.demo.pojo.User;
//import com.techwave.demo.repo.UserRepository;

@RestController
public class WelcomeController {

//	@Autowired
//	private UserRepository userRepository;

	@GetMapping("/")
	public String home() {
		return "<h1>HOME<h1>";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "<h1>Hello, Welcome to SprinBoot <h1>";
	}

//	@GetMapping("/all")
//	public List<User> getAllUser() {
//		return (List<User>) userRepository.findAll();
//	}
//
//	@PostMapping("/adduser")
//	public void createUser(@RequestBody User user) {
//		System.out.println("hello");
//		userRepository.save(user);
//
//	}

}
