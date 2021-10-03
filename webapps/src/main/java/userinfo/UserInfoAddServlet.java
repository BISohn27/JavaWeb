package userinfo;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MySqlUserInfoDao;
import dto.UserInfo;

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
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		try {
		MySqlUserInfoDao dao = new MySqlUserInfoDao();
		UserInfo userinfo = new UserInfo().setId(id).setPw(pw).setName(name);
		if(dao.insert(userinfo)) {
			response.sendRedirect("jsp/practice2.jsp");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		
//		UserInfo user = new UserInfo().setId(id).setPw(pw).setName(name);
//		
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		String sql = "";
//		
//		out.println("<html>");
//		out.println("<body>");
//		try {
//			stmt = conn.createStatement();
//			pstmt = conn.prepareStatement("INSERT INTO USERINFO VALUES(?,?,?)");
//			pstmt.setString(1, user.getId());
//			pstmt.setString(2, user.getPw());
//			pstmt.setString(3, user.getName());
//			int result = pstmt.executeUpdate();
//			
////			int result = stmt.executeUpdate("INSERT INTO USERINFO VALUES('"+user.getId()+"','"+user.getPw()+"','"+user.getName()+"')");
////			
//			out.println(result > -1 ? "<a href='UserInfoListServlet'>회원가입 성공</a>" : "회원가입 실패");
//			out.println("</body></html>");
//			out.close();
////			out.println(user.getName() + "님 회원 가입이 완료되었습니다.");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(stmt != null) stmt.close();
//			}catch(SQLException e) {}
//		}
////		out.println("</body>");
////		out.println("</html>");
	}

}
