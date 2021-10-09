package membercontroller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class PasswordAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		String password=request.getParameter("pwd");
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		String url ="";
		try {
			if(memberDAO.updatePassword(id,password)!=-1)
				url="service/index.product";
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);
	}
}
