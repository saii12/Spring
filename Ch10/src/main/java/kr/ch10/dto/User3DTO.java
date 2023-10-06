package kr.ch10.dto;

import kr.ch10.entity.User3Entity;
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
public class User3DTO {

	private String id;
	private String name;
	private String hp;
	private int age;
	
	// Entity 변환 메서드 / Entity로 변환할 때 그 때 Entity의 속성을 지정해주는 것
	public User3Entity toEntity() {
		
		return User3Entity.builder()
				.id(id)
				.name(name)
				.hp(hp)
				.age(age)
				.build();
	}
}
