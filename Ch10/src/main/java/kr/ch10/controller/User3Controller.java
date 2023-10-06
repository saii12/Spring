package kr.ch10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ch10.dto.User3DTO;
import kr.ch10.entity.User3Entity;
import kr.ch10.service.User3Service;

@RestController
public class User3Controller {

	@Autowired
	private User3Service service;
	
	// DTO 생성하는 이유가 메서드 매개변수나 타입에 Entity 안 쓰려고 하는거네
	@GetMapping("/user3")
	public List<User3DTO> list() { 
		
		return service.selectUser3s();

	}
	
	@GetMapping("/user3/{id}")
	public User3DTO user3(@PathVariable("id") String id) { // ajax로 쏜 걸 id로 받는다
		return service.selectUser3(id);
	}
	
	@PostMapping("/user3")
	public void register(User3DTO dto) { // ajax로 쏜 걸 User3DTO로 받는다
		
		service.insertUser3(dto);
	}
	
	@PutMapping("/user3") // ajax로 PUT전송 하는 거 수신
	public void modify(User3DTO dto) {
		service.updateUser3(dto);
	}
	
	@DeleteMapping("/user3/{id}")
	public void delete(@PathVariable("id") String id) {
		service.deleteUser3(id);
	}
}
