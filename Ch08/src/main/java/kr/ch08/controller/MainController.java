package kr.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ch08.entity.User1Entity;
import kr.ch08.repository.User1Repository;

@Controller
public class MainController {
	
	@Autowired
	private User1Repository repo;
	
	
	@GetMapping(value = {"/", "/index"})
	public String idex() {
		return "/index";
	}
	
	@GetMapping("/query1")
	public String query1() {
		User1Entity entity = repo.findUser1EntityByUid("a101");
		System.out.println(entity);
		
		return "redirect:/";
	}
	@GetMapping("/query2")
	public String query2() {
		List<User1Entity> list = repo.findUser1EntityByName("홍길동");
		System.out.println(list);
		
		return "redirect:/";
	}
	@GetMapping("/query3")
	public String query3() {
		List<User1Entity> list = repo.findUser1EntityByNameNot("홍길동");
		System.out.println(list);
		
		return "redirect:/";
	}
	@GetMapping("/query4")
	public String query4() {
		User1Entity entity = repo.findUser1EntityByUidAndName("a101", "김유신");
		System.out.println(entity);
		return "redirect:/";
	}
	@GetMapping("/query5")
	public String query5() {
		List<User1Entity> list = repo.findUser1EntityByUidOrName("a101", "홍길동");
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query6")
	public String query6() {
		List<User1Entity> list = repo.findUser1EntityByAgeGreaterThan(23);
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query7")
	public String query7() {
		List<User1Entity> list = repo.findUser1EntityByAgeGreaterThanEqual(23);
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query8")
	public String query8() {
		List<User1Entity> list = repo.findUser1EntityByAgeLessThan(23);
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query9")
	public String query9() {
		List<User1Entity> list = repo.findUser1EntityByAgeLessThanEqual(23);
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query10")
	public String query10() {
		List<User1Entity> list = repo.findUser1EntityByAgeBetween(23, 30); // between이면 이상 이하로 나오네
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query11")
	public String query11() {
		List<User1Entity> list = repo.findUser1EntityByNameLike("김유신"); // 이건 어떻게 작성해야하지? 그냥 이름 같은 애들 다 나오게 하는 거네
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query12")
	public String query12() {
		List<User1Entity> list = repo.findUser1EntityByNameContains("김"); 
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query13")
	public String query13() {
		List<User1Entity> list = repo.findUser1EntityByNameStartsWith("홍"); 
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query14")
	public String query14() {
		List<User1Entity> list = repo.findUser1EntityByNameEndsWith("신"); 
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query15")
	public String query15() {
		List<User1Entity> list = repo.findUser1EntityByOrderByName(); // 기본은 오름차순
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query16")
	public String query16() {
		List<User1Entity> list = repo.findUser1EntityByOrderByAgeAsc(); 
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query17")
	public String query17() {
		List<User1Entity> list = repo.findUser1EntityByOrderByAgeDesc(); 
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query18")
	public String query18() {
		return "redirect:/";
	}
	@GetMapping("/query19")
	public String query19() {
		int result = repo.countUser1EntityByUid("a101"); // 대소문자 구분 안함
		System.out.println(result);
		return "redirect:/";
	}
	@GetMapping("/query20")
	public String query20() {
		int result = repo.countUser1EntityByName("김유신");
		System.out.println(result);
		return "redirect:/";
	}
	@GetMapping("/query21")
	public String query21() {
		List<User1Entity> list = repo.selectUser1UnderAge30();
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query22")
	public String query22() {
		List<User1Entity> list = repo.selectUser1ByName("김수로");
		System.out.println(list);
		return "redirect:/";
	}
	@GetMapping("/query23")
	public String query23() {
		return "redirect:/";
	}
}
