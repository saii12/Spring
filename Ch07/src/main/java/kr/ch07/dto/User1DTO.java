package kr.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data  5개 annotation 통합
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO {

	private String uid;
	private String name;
	private String hp;
	private int age;
	
	/*public User1DTO() { // 이게 @NoArgsConstructor
		
	}
	*/
	
}
