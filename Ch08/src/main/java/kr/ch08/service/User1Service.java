package kr.ch08.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch08.dto.User1DTO;
import kr.ch08.entity.User1Entity;
import kr.ch08.repository.User1Repository;

@Service
public class User1Service {

	@Autowired
	private User1Repository repo;
	
	// CRD 메서드 dto가 매개변수로!
	public void insertUser1(User1DTO dto) {
		// DTO를 Entity로 변환
		User1Entity entity = dto.toEntity();
		
		repo.save(entity);
	}
	 
	public User1DTO selectUser1(String uid) {
		
		Optional<User1Entity> result = repo.findById(uid);
		
		// Entity를 DTO로 변환
		 User1DTO dto = result.get().toDTO();
		
		return dto; // get 해줘야 user1dto타입됨 
	}
	
	public List<User1DTO> selectUser1s() {
		
		// List<Entity>를 List<DTO>로 변환 / JAVA 컬렉션 stream
		 List<User1DTO> list = repo.findAll()
				 					.stream()
				 					.map(entity -> User1DTO.builder()
				 							.uid(entity.getUid())
				 							.name(entity.getName())
				 							.hp(entity.getHp())
				 							.age(entity.getAge())
				 							.build())
				 					.collect(Collectors.toList());
		
		return list;
	}
	
	public void updateUser1(User1DTO dto) {
		// DTO를 Entity로 변환
		User1Entity entity = dto.toEntity();
		
		repo.save(entity);
	}
	
	public void deleteUser1(String uid) {
		repo.deleteById(uid);
	}
}
