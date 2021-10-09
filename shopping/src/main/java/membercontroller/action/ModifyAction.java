package membercontroller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class ModifyAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		String email = request.getParameter("email");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		String url ="";
		try {
			if(memberDAO.updateMemberInfo(id,email,zipcode,address,phone)!=-1)
				url="/shopping/member/modifyform.jsp";
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);
	}
}
