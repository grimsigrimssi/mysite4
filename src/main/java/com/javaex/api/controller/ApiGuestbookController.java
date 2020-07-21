package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value="/api/guestbook")
public class ApiGuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	@ResponseBody
	@RequestMapping(value="/list")
	public List<GuestVo> list() {
		System.out.println("ApiGuestbookController/list");
		
		List<GuestVo> guestbookList = guestbookService.list();
		System.out.println(guestbookList.toString());
		return guestbookList;
	}
	
	@ResponseBody
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public GuestVo write(@RequestBody GuestVo guestbookVo) {
		System.out.println("ApiGuestbookController/write");
		System.out.println(guestbookVo.toString());
		GuestVo vo = guestbookService.addGuest(guestbookVo);
		System.out.println("보내줄 vo:" + vo.toString());
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public int delete(@ModelAttribute GuestVo guestbookVo) {
		System.out.println("ApiGuestbookController/delete");
		
		int count = guestbookService.remove(guestbookVo);
		return count;
	}
	
	
	
}
