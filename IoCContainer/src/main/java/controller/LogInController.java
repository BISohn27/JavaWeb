package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.Member;

@Component("/auth/login.do")
public class LogInController implements Controller, DataBinding{
	MemberDAO memberDao;
	public LogInController setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		/*Member loginInfo = (Member)model.get("loginInfo");
		if(loginInfo == null) {
			return "/auth/LoginForm.html";
		}else {*/
			Member member = (memberDao.exist(((HttpServletRequest)model.get("request")).getParameter("email"), ((HttpServletRequest)model.get("request")).getParameter("pwd")));
			if(member != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("member", member);
				return "redirect:../member/list.do";
			}else {
				return "/auth/LogInFail.jsp";
			}
		}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				//dto.Member.class : relections ��ü���� ��ü�� �����ϱ� ���� �����ϰ��� �ϴ� class ����
				"loginInfo", dto.Member.class
		};
	}
}

