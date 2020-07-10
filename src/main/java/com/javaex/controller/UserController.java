package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		System.out.println("UserController:joinForm");
		
		return "user/joinForm";
		
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController:join");
		
		// UserService userService = new UserService(); 위에 @Autowired 로 대신함.
		userService.join(userVo);
		
		return "user/joinOk";
		
	}
	

	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("UserController:loginForm");
		
		return "user/loginForm";
		
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController:login");
		
		// UserService userService = new UserService(); 위에 @Autowired 로 대신함.
		
		
		UserVo authUser = userService.login(userVo);
		
		if(authUser !=null) {//로그인 성공일때
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		}else { //로그인 실패일때
			return "redirect:/user/loginForm?result=fail";
		}
		
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("userController:logout");
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/main";
	}
	
	@RequestMapping("/modifyForm")
	public String modifyForm(Model model, HttpSession session) {
		System.out.println("userController:modifyForm");
		
		return "user/modifyForm";
	}
	
	@RequestMapping("/modify")
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("userController:modify");
		
		userService.updateUser(userVo);
		
		UserVo authUser = userService.login(userVo);
		
		session.removeAttribute("authUser");
		session.setAttribute("authUser", authUser);
		
		return "redirect:/main";
	}
		

}
