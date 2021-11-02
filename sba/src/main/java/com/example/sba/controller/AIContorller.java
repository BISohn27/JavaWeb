package com.example.sba.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.sba.ai.AIDataServiceImpl;
import com.example.sba.domain.Member;
import com.example.sba.mapper.MemberMapper;

@RestController
public class AIContorller {
	@Autowired
	private AIDataServiceImpl aiService;
	@Autowired
	private MemberMapper mapper;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/login")
	public ModelAndView goSignIn() {
		return new ModelAndView("login");
	}
	
	@PostMapping("/signin")
	public ModelAndView login(@Validated @RequestParam("email") String email, @Validated @RequestParam("pwd") String pwd, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		Member member = mapper.getLogin(email, pwd);
		
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			mav.addObject("session", session);
			mav.setViewName("aiface");
		}else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@PostMapping("/aiface")
	public ResponseEntity<?> aiface(
			@Validated @RequestParam("mname") String mname,
			@Validated @RequestParam("content") String content,
			@Validated @RequestParam("files") MultipartFile file) throws Exception{
		try {
			logger.info(mname);
			logger.info(content);
			logger.info(file.getOriginalFilename());
			String fileName = "\\"+file.getOriginalFilename();
			file.transferTo(new File(new File("").getAbsolutePath() + fileName));
			return new ResponseEntity<>(aiService.faceData(fileName), HttpStatus.BAD_REQUEST.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
