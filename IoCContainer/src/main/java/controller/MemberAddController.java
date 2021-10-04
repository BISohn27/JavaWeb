package controller;

import java.util.Map;

import dao.MemberDAO;
import dto.Member;

@Component("/auth/add.do")
public class MemberAddController implements Controller, DataBinding{
	MemberDAO memberDao;
	
	public MemberAddController setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		Member member = (Member)model.get("member");
		if(member != null) {
//			if(member != null && member.getEmail() != null) {
			memberDao.insert(member);
			return "redirect:list.do";
		}else {
			return "/member/MemberForm.jsp";
		}
		
		
		
			/*
			if(memberDao.insert(member) == -1) {
				return "redirect:member/AddFail.jsp";
			}else {
				return "auth/Login.jsp";
			}
		}*/
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"member", dto.Member.class
		};
	}
}
