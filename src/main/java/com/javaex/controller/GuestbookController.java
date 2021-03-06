package com.javaex.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value="/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;

	//방명록 리스트 가져오기
	@RequestMapping(value="/list")
	public String list(Model model){
		System.out.println("guestbookController/list");
		
		//서비스를 통해 모든 방명록 글 가져오기
		List<GuestVo> guestList = guestbookService.list();
		
		//Dispacher Servlet에 방명록 글 리스트 전달
		model.addAttribute("guestList", guestList);
		
		return "guestbook/addList";
	}
	
	//방명록 글 저장
	@RequestMapping(value="/write")
	public String write(@ModelAttribute GuestVo guestbookVo){
		System.out.println("guestbookController/write");
		
		guestbookService.write(guestbookVo);
		return "redirect:/guestbook/list";
	}
	
	//방명록 삭제 폼
	@RequestMapping(value="/deleteForm")
	public String deleteform(){
		System.out.println("guestbookController/deleteform");
		
		return "guestbook/deleteForm";
	}
	
	//방명록 삭제
	@RequestMapping(value="/delete")
	public String delete(@ModelAttribute GuestVo guestbookVo){
		System.out.println("guestbookController/delete");
		
		guestbookService.remove(guestbookVo);
		return "redirect:/guestbook/list";
	}
	
	
	//ajax 방명록
	@RequestMapping(value="/ajaxList")
	public String ajaxList() {
		System.out.println("guestbookController/ajaxList");
		
		return "guestbook/ajaxList";
	}
	
}
