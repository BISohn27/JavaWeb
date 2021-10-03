package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.Member;

public class LogInController implements Controller{
//	MemberDAO memberDAO;
//	public LogInController setMemberDao(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//		return this;
//	}
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		/*Member loginInfo = (Member)model.get("loginInfo");
		if(loginInfo == null) {
			return "/auth/LoginForm.html";
		}else {*/
			Member member = ((MemberDAO)model.get("memberdao")).exist(((HttpServletRequest)model.get("request")).getParameter("email"), ((HttpServletRequest)model.get("request")).getParameter("pwd"));
			if(member != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("member", member);
				return "redirect:../member/list.do";
			}else {
				return "/auth/LogInFail.jsp";
			}
		}
	
}

