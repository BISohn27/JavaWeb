package userinfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberVO;

/**
 * Servlet implementation class UserInfoLoginServlet
 */
@WebServlet("/UserInfoLoginServlet")
public class UserInfoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MySqlUserInfoDao dao = new MySqlUserInfoDao();
			MemberVO member = dao.exist(request.getParameter("id"), request.getParameter("pw"));
			if(member != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", member);
				response.sendRedirect("jsp/practice2.jsp");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error/LoginFail.html");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}