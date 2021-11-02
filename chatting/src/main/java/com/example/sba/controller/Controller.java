package com.example.sba.controller;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.sba.chat.APIExamSTT;
import com.example.sba.chat.APIExamTTS;
import com.example.sba.chat.ChatService;
import com.example.sba.domain.Member;
import com.example.sba.mapper.Mapper;

@RestController
public class Controller {
	@Autowired
	Mapper mapper;
	
	@RequestMapping("/login")
	public ModelAndView sendLoginPage() {
		return new ModelAndView("login");
	}
	
	@PostMapping("/signin")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		Member member = mapper.getMember(email, pwd);
		
		String msg = null;
		if (member != null) {
			String fileName = APIExamTTS.getInstance().getWelcomeVoice(member.getMname());
			msg = APIExamSTT.getInstance().voice(fileName);
			
			mav.addObject("msg",msg);
			mav.addObject("filename",fileName);
			mav.setViewName("chat");
		} else {
			mav.addObject("status","false");
			mav.setViewName("login");
		}
		
		return mav;
	}
	
	@PostMapping("/chat")
	public Map<String,String> chat(HttpServletRequest request) {
		Map<String,String> map = new Hashtable<>();
		String sendMessage = request.getParameter("message");
		String returnMessage = ChatService.getMessage(sendMessage);

		map.put("sendmessage", sendMessage);
		map.put("returnmessage", returnMessage);
		
		return map;
	}
}
