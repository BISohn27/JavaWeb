package membercontroller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberVO;

public class JoinAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String url = "member/login.jsp";
		HttpSession session= request.getSession();
		MemberVO member = new MemberVO().setId(request.getParameter("id"))
											.setPwd(request.getParameter("pwd"))
											.setName(request.getParameter("name"))
											.setEmail(request.getParameter("emailid")+ "@" + request.getParameter("emailaddress"))
											.setZipcode(request.getParameter("zipcode"))
											.setAddress(request.getParameter("address"))
											.setPhone(request.getParameter("phone"));
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		try {
			memberDAO.insertMember(member);
			session.setAttribute("loginUser", member);
			url = "/shopping/member/Login.jsp";
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
