package com.example.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.sba.domain.Member;
import com.example.sba.mapper.MemberMapper;

/*@Controller*/
//viewresolver를 통해 사용할 뷰를 지정하는 것이 아니라 기본 json 방식의 데이터를 뿌리는 방식
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String Hello() {
		return "main.html";
	}
	
	@RequestMapping("/helloJson")
	public String helloJson() {
		String message = "String Boot";
		return message;
	}
	
	@RequestMapping("/pramValueText/{id}")
	public ResponseEntity<Member> paramValueTest(@PathVariable String id){
		System.out.println(id);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST.OK);
	}
	
	@Autowired
	private MemberMapper mapper;
	@GetMapping("requestlist")
	public ModelAndView list() {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("list");
			mav.addObject("members",mapper.getMemberList());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
