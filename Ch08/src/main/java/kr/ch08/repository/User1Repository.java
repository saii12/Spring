package kr.ch08.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ch08.entity.User1Entity;

@Repository // 첫번째 매개변수에 entity
public interface User1Repository extends JpaRepository<User1Entity, String> {

	// JPA 쿼리 메서드
	public User1Entity findUser1EntityByUid(String uid); // select * from User1 Where `uid`=?;
	public List<User1Entity> findUser1EntityByName(String name); // select * from User1 Where `name`=?; 이름은 여러개 나올 수 있으니까 List로
	public List<User1Entity> findUser1EntityByNameNot(String name);
	
	public User1Entity findUser1EntityByUidAndName(String uid, String name); // WHERE `uid`=? AND `name`=?;
	public List<User1Entity> findUser1EntityByUidOrName(String uid, String name);
	
	public List<User1Entity> findUser1EntityByAgeGreaterThan(int age);
	public List<User1Entity> findUser1EntityByAgeGreaterThanEqual(int age);
	public List<User1Entity> findUser1EntityByAgeLessThan(int age);
	public List<User1Entity> findUser1EntityByAgeLessThanEqual(int age);
	public List<User1Entity> findUser1EntityByAgeBetween(int low, int high);
	
	public List<User1Entity> findUser1EntityByNameLike(String name);
	public List<User1Entity> findUser1EntityByNameContains(String name);
	public List<User1Entity> findUser1EntityByNameStartsWith(String name);
	public List<User1Entity> findUser1EntityByNameEndsWith(String name);
	
	public List<User1Entity> findUser1EntityByOrderByName(); // 기본은 오름차순
	public List<User1Entity> findUser1EntityByOrderByAgeAsc();
	public List<User1Entity> findUser1EntityByOrderByAgeDesc();
	//public List<User1Entity> findUser1EntityByOrderByAgeGreaterThanOrderByAgeDesc(int age);
	
	public int countUser1EntityByUid(String uid);
	public int countUser1EntityByName(String name);
	
	// JPQL 
	@Query("select u1 from User1Entity as u1 where u1.age < 30") // JPQL 방언(형식)은 entity 별칭 지정하고, 별칭으로 조회
	public List<User1Entity> selectUser1UnderAge30();
	
	@Query("select u1 from User1Entity as u1 where u1.name = ?1") 
	public List<User1Entity> selectUser1ByName(String name);
	
	@Query("select u1 from User1Entity as u1 where u1.name = :name") 
	public List<User1Entity> selectUser1ByNameParam(@Param("name") String name);
	
	// MainController내용 Github에 업로드
	@Query("select u1.uid, u1.name, u1.age from User1Entity as u1 where u1.uid = :uid") 
	public List<Object[]> selectUser1ByUid(@Param("uid") String uid); 
}
