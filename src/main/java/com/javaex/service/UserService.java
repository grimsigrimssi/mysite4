package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//회원가입
	public int join(UserVo userVo) {
		System.out.println("UserService:join");
				
		return userDao.insert(userVo);
		
		
	}
	
	public UserVo login(UserVo userVo) {
		System.out.println("UserService:login");
		UserVo authUser = userDao.selectUser(userVo);
		
		return authUser;
	}
	
	public int updateUser(UserVo userVo) {
		System.out.println("UserService:update");
				
		return userDao.updateUser(userVo);
	}

}