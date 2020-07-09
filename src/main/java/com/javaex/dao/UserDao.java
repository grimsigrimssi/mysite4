package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(UserVo userVo) {
		System.out.println("userDao:insert");
			
		return sqlSession.insert("user.insert", userVo);
		
	}
	
	public UserVo selectUser(UserVo userVo) {
		System.out.println("userService:login");
	
		
		return sqlSession.selectOne("user.selectUser", userVo);
		
	}
	
	public int updateUser(UserVo userVo) {
		System.out.println("userservice:modify");
		
		return sqlSession.selectOne("user.updateUser", userVo);
	}
	
	
}
