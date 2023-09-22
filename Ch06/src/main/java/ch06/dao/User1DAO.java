package ch06.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ch06.dto.User1DTO;

@Repository
public class User1DAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertUser1(User1DTO dto) {
		mybatis.insert("user1.insertUser1", dto); // ("namespace.id이름", 매개변수) 꼴
	}
	
	public User1DTO selectUser1(String uid) {
		return mybatis.selectOne("user1.selectUser1", uid); // selectOne 메서드 맞아?? 맞네
	}
	
	public List<User1DTO> selectUser1s() {
		return mybatis.selectList("user1.selectUser1s");
	}
	
	public void updateUser1(User1DTO dto) {
		mybatis.update("user1.updateUser1", dto);
	}
	
	public void deleteUser1(String uid) {
		mybatis.delete("user1.deleteUser1", uid);
	}
}
