package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestVo> selectList(){
		System.out.println("guestbookDao:selectList");
		List<GuestVo> gList =sqlSession.selectList("selectList");
		
		return gList;		
	}
	
	public int addGuest(GuestVo guestVo) {
		System.out.println("guestbookDao:addGuest");
		
		return sqlSession.insert("addGuest", guestVo);		
	}
	
	public int delGuest(GuestVo guestVo) {
		System.out.println("");
		
		return sqlSession.delete("delGuest", guestVo);				
	}
	
}
