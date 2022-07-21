package com.sks.sa.boss.service;

import com.sks.sa.boss.dm.bean.User;
import com.sks.sa.boss.dm.mapper.UserVO;

public interface UserService {

	public UserVO addUser(UserVO userVo);
	
	public Boolean findUser(Long userId,String password);
	
	public User getUser(Long userId);
	
	public User updateUser(User user);

}
