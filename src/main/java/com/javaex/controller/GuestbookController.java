package com.javaex.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestService guestService;

	@RequestMapping("/addList")
	public String addList(Model model) {
		System.out.println("GuestbookController:addList");
		
		List<GuestVo> gList = guestService.getList();
		
		model.addAttribute("gList", gList);
		
		return "guestbook/addList";
	}
	
	@RequestMapping("/addGuest")
	public String addGuest(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestbookController:addGuest");
		System.out.println(guestVo.toString());
		
		guestService.addGuest(guestVo);
		
		return "redirect:/guestbook/addList";
	}
	
	
	@RequestMapping("/deleteForm")
	public String deleteForm(@RequestParam("no") int no, Model model) {
		System.out.println("GuestbookController:deleteForm");
		
		model.addAttribute("no", no);
		
		return "guestbook/deleteForm";
	}
	
	
	@RequestMapping("/delGuest")
	public String delGuest(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestController:delGuest");
			
		guestService.delGuest(guestVo);
				
		return "redirect:/guestbook/addList";	
	}
	
}
