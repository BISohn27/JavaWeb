package controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDAO;
import dto.AddressVO;

public class ZipcodeAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		ArrayList<AddressVO> list = null;
		try {
			String dong = request.getParameter("dong").trim();
			AddressDAO addressDAO = AddressDAO.getInstance(); 
			list = addressDAO.getZipcode(dong);
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("member/Zipcode.jsp");
		rd.include(request, response);
	}
}
