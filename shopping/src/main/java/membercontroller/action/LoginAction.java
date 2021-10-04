package membercontroller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberVO;

public class LoginAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		try {
			MemberDAO memberDAO = MemberDAO.getInstance();
			MemberVO member = memberDAO.existMember(request.getParameter("id"), request.getParameter("pwd"));
			if(member != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				response.sendRedirect("service/index.product");
			}else {
				response.sendRedirect("/shopping/member/Login.jsp?status=loginfail");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
