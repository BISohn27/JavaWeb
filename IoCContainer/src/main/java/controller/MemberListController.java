package controller;

import java.util.Map;

import dao.MemberDAO;
import dao.MemberDAOImpl;

public class MemberListController implements Controller{
//	MemberDAO memberDao;
//	public MemberListController setMemberDao(MemberDAO memeberDao) {
//		this.memberDao = memberDao;
//		return this;
//	}
	@Override
	public String execute(Map<String,Object> model) throws Exception{
		model.put("member", new MemberDAOImpl().selectList());
		return "/member/MemberList.jsp";
	}
}
