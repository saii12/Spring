package ch05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch05.dto.User1DTO;
import ch05.service.User1Service;

@Controller
public class User1Controller {

	@Autowired
	private User1Service service;
	
	@GetMapping("/user1/register")
	public String register() {
		return "/user1/register";
	}
	
	@PostMapping("/user1/register")
	public String register(User1DTO dto) {
		service.insertUser1(dto);
		return "redirect:/user1/list";
		
	}
	
	@GetMapping("/user1/list")
	public String list(Model model) {
		
		List<User1DTO> users = service.selectUser1s();
		model.addAttribute("users", users); // model 객체로 속성 지정해서 표현언어로 나타낸다
		
		return "/user1/list";
	}
	
	@GetMapping("/user1/modify")
	public String modify(@RequestParam("uid") String uid, Model model) { // list.jsp에서 delete도 a태그로 전송하는데 왜 modify만 @RequestParam 하지?
		
		User1DTO user = service.selectUser1(uid);
		model.addAttribute(user);
		
		return "/user1/modify";
	}
	
	@PostMapping("/user1/modify")
	public String modify(@ModelAttribute User1DTO dto) {
		service.updateUser1(dto);
		return "redirect:/user1/list"; //redirect는 다른 페이지로 다이렉트할 때 
	}
	
	@GetMapping("/user1/delete")
	public String delete(String uid) { // delete도 modify처럼 똑같이 list.jsp에서 uid로 파라미터 전송하는데 왜 얘는 requestParam 안 쓰지??
		service.deleteUser1(uid);
		return "redirect:/user1/list";
	}
}
