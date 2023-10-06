package kr.ch10.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch10.Repository.User3Repository;
import kr.ch10.dto.User3DTO;
import kr.ch10.entity.User3Entity;

@Service
public class User3Service {

	@Autowired
	private User3Repository repo;
	
	
	// DTO 생성하는 이유가 메서드 매개변수나 타입에 Entity 안 쓰려고 하는거네
	public void insertUser3(User3DTO dto) {
		// DTO를 Entity로 변환
		User3Entity entity = dto.toEntity();
		
		repo.save(entity);
	}
	
	public User3DTO selectUser3(String id) {
		
		Optional<User3Entity> result = repo.findById(id);	
		// Entity를 DTO로 변환
		User3DTO dto = result.get().toDTO();
			
		return dto;
	}
	
	public List<User3DTO> selectUser3s() {
	
		// List<Entity>를 List<DTO>로 변환 / JAVA 컬렉션 stream
		List<User3DTO> list = repo.findAll()
									.stream()
									.map(entity -> User3DTO.builder()
											.id(entity.getId()) // uid가 아니라 id 미친놈아
											.name(entity.getName())
											.hp(entity.getHp())
											.age(entity.getAge())
											.build())
									.collect(Collectors.toList());
		return list;
	}											
	
	public void updateUser3(User3DTO dto) {
		
		User3Entity entity = dto.toEntity();
		
		repo.save(entity);
	}
	
	public void deleteUser3(String id) {
		repo.deleteById(id);
	}
}
