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

	public void insertUser1(User1DTO dto) {}
	
	public User1DTO selectUser1(String uid) {
		return null;
	}
	
	public List<User1DTO> selectUser1s() {
		return null;
	}
	
	public void updateUser1(User1DTO dto) {}
	
	public void deleteUser1(String uid) {}
}
