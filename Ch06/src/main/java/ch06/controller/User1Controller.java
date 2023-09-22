package ch06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch06.dto.User1DTO;
import ch06.service.User1Service;

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
		model.addAttribute("users", users); // model의 속성으로 저장해서 list.jsp에서 표현언어로 나타낸다
		
		return "/user1/list";
	}
	
	
	
	@GetMapping("/user1/modify")
	public String modify(@RequestParam("uid") String uid, Model model) {
		User1DTO user = service.selectUser1(uid);
		model.addAttribute(user); // ("user", user) 이렇게 안 쓰네
		
		return "/user1/modify";
	}
	
	@PostMapping("/user1/modify")
	public String modify(@ModelAttribute User1DTO dto) { //@ModelAttribute 왜 쓰는 거지?? 아, 수정한 데이터를 value로 받아오니까!
		service.updateUser1(dto);
		
		return "redirect:/user1/list";
	}
	
	@GetMapping("/user1/delete")
	public String delete(String uid) { // 원래 modify처럼 @RequestParam 쓰는건데 깔끔하게 하기 위해 생략하는 거임
		service.deleteUser1(uid); //  list.jsp에서 uid 파라미터로 데이터 전송하는데 수신은 어떻게 하는거지??
		return "redirect:/user1/list"; // Mapping 주소 "/user1/delete" 자기 자신 그대로 나타내면 redirect 안 쓰고, 다른 주소로 연결시키면 redirect
	}
	
}
