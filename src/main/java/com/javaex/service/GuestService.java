package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {	
	
	@Autowired
	GuestbookDao guestbookDao;
	
	
	public List<GuestVo> getList() {
		System.out.println("GuestService:selectList");
			
		return guestbookDao.selectList();		
	}
	
	public int addGuest(GuestVo guestVo) {
		System.out.println("GuestService:addGuest");
		
		return guestbookDao.addGuest(guestVo);
	}
	
	
	
	public int delGuest(GuestVo guestVo) {
		System.out.println("GuestService:delGuest");
		
		return guestbookDao.delGuest(guestVo);			
	}
	
	
	
	
	
	

}
