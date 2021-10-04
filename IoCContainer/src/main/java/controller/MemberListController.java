package controller;

import java.util.Map;

import dao.MemberDAO;
import dao.MemberDAOImpl;

@Component("/member/list.do")
public class MemberListController implements Controller{
	MemberDAO memberDao;
	public MemberListController setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	@Override
	public String execute(Map<String,Object> model) throws Exception{
		model.put("memberlist", memberDao.selectList());
		return "/member/MemberList.jsp";
	}
}
