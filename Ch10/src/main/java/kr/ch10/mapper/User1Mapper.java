package kr.ch10.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ch10.dto.User1DTO;

@Mapper
public interface User1Mapper {

	// user1.xml에서 mapper 메서드 이름과 같은 id의 쿼리를 실행시킴
	public int insertUser1(User1DTO dto); // 왜 int지??
	public User1DTO selectUser1(String id);
	public List<User1DTO> selectUser1s();
	public int updateUser1(User1DTO dto);
	public int deleteUser1(String id);
}
