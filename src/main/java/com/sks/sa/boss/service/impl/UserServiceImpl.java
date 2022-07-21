package com.sks.sa.boss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sks.sa.boss.dm.bean.User;
import com.sks.sa.boss.dm.mapper.UserVO;
import com.sks.sa.boss.repo.UserRepository;
import com.sks.sa.boss.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserVO addUser(UserVO userVO) {
		User user = new User();
		user.setUserNum(userVO.getUserNum());
		user.setFirstName(userVO.getFirstName());
		user.setLastName(userVO.getLastName());
		user.setEmail(userVO.getEmail());
		user.setPassword(userVO.getPassword());
		user = userRepository.saveAndFlush(user);
		userVO.setUserNum(user.getUserNum());
		return userVO;
	}

	public Boolean findUser(Long userId,String password) {
		Boolean trueUser = false;
		User user = userRepository.findById(userId).get();
		if(user!=null) {
			if (password.equals(user.getPassword())){
				trueUser = true;
			}
		}
		return trueUser;
	}

	@Override
	public User getUser(Long userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public User updateUser(User user) {
		return userRepository.saveAndFlush(user);
	}

}
