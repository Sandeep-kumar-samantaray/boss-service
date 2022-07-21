package com.sks.sa.boss.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sks.sa.boss.dm.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
//	List<User> findByLastname(String lastname);
//	
//	@Query(value = "select user from user where user.userNum = :userNum")
//	public User findByUserId(@Param("userNum") Long userNum);
//	
}
