package controller;

import java.util.Map;

import dao.MemberDAO;

@Component("/member/delete.do")
public class MemberDeleteController implements Controller,DataBinding{
	private MemberDAO memberDao;
	public MemberDeleteController setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	public String execute(Map<String, Object> model) throws Exception{
		int no = Integer.parseInt(model.get("no").toString());
		memberDao.delete(no);
		return "redirect:auth/Login.html";
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"no", Integer.class
		};
	}
}
