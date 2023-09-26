package kr.ch07.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import groovy.util.logging.Slf4j;
import kr.ch07.dto.User6DTO;

@Slf4j
@SpringBootTest
public class User6MapperTest {

	@Autowired
	private User6Mapper mapper;
	
	@Test
	public void insertUser6() {
		
		User6DTO user6 = User6DTO.builder()
				.uid("A103")
				.name("강감찬")
				.birth("2000-01-10")
				.gender("M")
				.age(35)
				.addr("부산")
				.hp("010-1234-1005")
				.build();
		
		mapper.insertUser6(user6);
	}

	public User6DTO selectUser6(String uid) {
		return null;
	}
	public List<User6DTO> selectUser6s() {
		return null;
	}
	public void updateUser6(User6DTO dto) {}
	public void deleteUser6(String uid) {}
}
