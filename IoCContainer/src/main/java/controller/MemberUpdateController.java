package controller;

import java.util.Map;

import dao.MemberDAO;
import dto.Member;

@Component("/member/update.do")
public class MemberUpdateController implements Controller ,DataBinding{
	private MemberDAO memberDao;
	public MemberUpdateController setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	public String execute(Map<String, Object> model) throws Exception{
		Member member = (Member)model.get("member");
		if(member != null && member.getEmail() != null) {
			memberDao.update(member);
			return "redirect:list.do";
		}else {
			model.put("model", memberDao.selectOne(Integer.parseInt(model.get("no").toString())));
			return "/member/MemberUpdate.jsp";
		}
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"member", dto.Member.class,
				"no",Integer.class
		};
	}
}
