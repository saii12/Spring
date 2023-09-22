package ch06.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch06.dto.User2DTO;

@Repository
public class User2DAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser2(User2DTO dto) {
		mybatis.insert("user2.insertUser2", dto);
	}
	
	public User2DTO selectUser2(String uid) {
		return null;
	}
	
	public List<User2DTO> selectUser2s() {
		return mybatis.selectList("user2.selectUser2s");
	}
	
	public void updateUser2(User2DTO dto) {
		
	}
	
	public void deleteUser2(String uid) {
		
	}
	
}
