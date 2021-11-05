package com.face.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.face.ai.AIDataServiceImpl;
import com.face.domain.Member;
import com.face.mapper.MemberMapper;

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
	@RequestMapping("/aiface")
	public ModelAndView goAiFace() {
		return new ModelAndView("aiface");
	}
	
	@PostMapping("/signin")
	public ModelAndView login(@Validated @RequestParam("email") String email, @Validated @RequestParam("pwd") String pwd, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		Member member = mapper.getLogin(email, pwd);
		
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			mav.addObject("session", session);
			mav.setViewName("index");
		}else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@PostMapping("/saveface")
	public ModelAndView saveFace(
			@Validated @RequestParam("files") MultipartFile file,
			HttpServletRequest request) {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMddHHmmss");
		Date date = new Date();
		
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		Member member = (Member)(session.getAttribute("member"));
		int mNo=member.getMno();
		
		try {
			String fileName = format.format(date)+file.getOriginalFilename();
			file.transferTo(new File(new File("").getAbsolutePath()+ "\\"+fileName));
			aiService.saveFaceData(fileName, mNo);
			mav.setViewName("index");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;	
	}
	
	@PostMapping("/facesignin")
	public ModelAndView facelogin(
			@Validated @RequestParam("files") MultipartFile file,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMddHHmmss");
		Date date = new Date();
		
		try {
			String fileName = format.format(date)+file.getOriginalFilename();
			file.transferTo(new File(new File("").getAbsolutePath()+ "\\"+fileName));
			Map<String,Object> map = aiService.returnFace(fileName);
			Member member = mapper.loginWithFace((String)map.get("value"), (float)map.get("confidence"));
			
			if(member != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				
				mav.addObject("session", session);
				mav.setViewName("index");
			}else {
				mav.setViewName("login");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;	
	}
}
