package userinfo;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberVO;

/**
 * Servlet implementation class UserInfoAddServlet
 */
@WebServlet("/UserInfoAddServlet")
public class UserInfoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MySqlUserInfoDao dao = new MySqlUserInfoDao();
		RequestDispatcher rd = request.getRequestDispatcher("jsp/MemberForm.jsp");
		rd.include(request, response);
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>회원 등록</title></head>");
//		out.println("<body><h1>회원 등록</h1>");
//		out.println("<form action = 'UserInfoAddServlet' method = 'post'>");
//		out.println("ID: <input type = 'text' name = 'id'><br>");
//		out.println("PW: <input type = 'password' name = 'pw'><br>");
//		out.println("NAME: <input type = 'text' name = 'name'><br>");
//		out.println("<input type = 'submit' value='등록'><input type='reset' value='지우기'");
//		out.println("</form>");
//		out.println("</body></html>");
//		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		try {
		MySqlUserInfoDao dao = new MySqlUserInfoDao();
		MemberVO userinfo = new MemberVO().setId(id).setPwd(pwd).setName(name);
		if(dao.insert(userinfo)) {
			response.sendRedirect("jsp/practice2.jsp");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
