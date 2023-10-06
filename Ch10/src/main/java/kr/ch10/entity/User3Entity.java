package kr.ch10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.ch10.dto.User3DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "USER3")
public class User3Entity {

	@Id
	private String id;
	private String name;
	private String hp;
	private int age;
	
	// DTO 변환 메서드 / DTO로 변환할 때 그 때 DTO의 속성을 지정해주는 것
	public User3DTO toDTO () {
		
		return User3DTO.builder()
				.id(id)
				.name(name)
				.hp(hp)
				.age(age)
				.build();
	}
		
				
}
