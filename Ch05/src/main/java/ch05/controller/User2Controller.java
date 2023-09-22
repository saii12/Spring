package ch05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ch05.dto.User2DTO;
import ch05.service.User2Service;

public class User2Controller {

	@Autowired
	private User2Service service;
	
	@GetMapping("/user2/register")
	public String register() {
		return "/user2/register";
	}
	
	@PostMapping("/user2/register")
	public String register(User2DTO dto) {
		return "/user2/register";
	}
}
