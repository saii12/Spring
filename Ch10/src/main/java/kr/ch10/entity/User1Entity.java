package kr.ch10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="USER1")
public class User1Entity {

	// 기존 테이블 속성과 다르면 테이블 새로 만들어짐
	@Id
	private String id;
	private String name;
	private String hp;
	private int age;
}
