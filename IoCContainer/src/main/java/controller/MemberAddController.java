package controller;

import java.util.Map;

import dao.MemberDAO;
import dto.Member;

public class MemberAddController implements Controller{
//	MemberDAO memberDAO;
//	
//	public MemberAddController setMemberDao(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//		return this;
//	}
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		
		Member member = (Member)model.get("memberadd");
		if(((MemberDAO)model.get("memberdao")).insert(member) == -1) {
			return "/member/AddFail.jsp";
		}else {
			return "auth/Login.jsp";
		}
	}
}
