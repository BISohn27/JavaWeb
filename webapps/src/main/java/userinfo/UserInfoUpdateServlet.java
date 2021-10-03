package userinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MySqlUserInfoDao;
import dto.UserInfo;
import webapps.DBAction;

/**
 * Servlet implementation class UserInfoUpdateServlet
 */
@WebServlet("/UserInfoUpdateServlet")
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			MySqlUserInfoDao dao = new MySqlUserInfoDao();
			UserInfo userinfo = dao.selectone(request.getParameter("id"));
			request.setAttribute("userinfo", userinfo);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/userinfo/UserInfoUpdateForm.jsp");
			rd.include(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//update foam
//		Connection conn = DBAction.getInstance().getConnection();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		response.setContentType("text/html;charset=UTF-8");
//		request.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		
//		out.println("<html><head><title>회원정보수정</title></head>");
//		out.println("<body><h1>회원정보</h1>");
//		try {
//			pstmt = conn.prepareStatement("SELECT ID, PW, NAME FROM USERINFO WHERE ID=?");
//			pstmt.setString(1, request.getParameter("id"));
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				out.println("<body><form action = 'UserInfoUpdateServlet' method='post'>");
//				out.println("아이디 : <input type='text' name='id' value='" + rs.getString("ID") + "' readonly><br>");
//				out.println("암호 : <input type='text' name='pw' value='" + rs.getString("PW") +"'><br>");
//				out.println("이름 : <input type='text' name='name' value='" + rs.getString("NAME") + "'><br>");
//				out.println("<input type='submit' value='저장'>");
//				out.println("<input type='button' value='뒤로가기' onclick='location.href=\"/webapps/UserInfoListServlet\"'>");
//				out.println("<input type='button' value='삭제' onclick='location.href=\"/webapps/UserInfoDeleteServlet?id="+rs.getString("ID")+"\"'>");
//				out.println("</form>");
//				out.println("</body></html>");
//				out.close();
//			}else {
//				out.println("<b>회원정보 없음</b>");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs != null) rs.close();
//				if(pstmt != null) pstmt.close();
//			}catch(SQLException e) {}
//		}
		
//		out.println("<html><head><title>회원정보수정</title></head>");
//		out.println("<body><form>");
//		out.println("PW: <input type='password' name='pw'><br>");
//		out.println("NAME: <input type='text' name='name'><br>");
//		out.println("<input type='submit' value='수정'><input type='reset' value='지우기'>");
//		out.println("</form></body></html>");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MySqlUserInfoDao dao = new MySqlUserInfoDao();
			dao.update(request.getParameter("id"), request.getParameter("pw"), request.getParameter("name"));
			response.sendRedirect("/webapps/jsp/practice2.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
//		response.setContentType("text/html;charset=UTF-8");
//		request.setCharacterEncoding("utf-8");
//		Connection conn = DBAction.getInstance().getConnection();
//		PreparedStatement pstmt = null;
//		PrintWriter out = response.getWriter();
//		
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		String id = request.getParameter("id");
//		
//		try {
//			pstmt = conn.prepareStatement("UPDATE USERINFO SET PW=?,NAME=? WHERE ID=?");
//			pstmt.setString(1, pw);
//			pstmt.setString(2, name);
//			pstmt.setString(3, id);
//			int result = pstmt.executeUpdate();
//			out.println("<html><head></head><body>");
//			out.println(result >-1 ? "<a href='/webapps/UserInfoListServlet'>회원정보 변경 성공</a>": "회원정보 변경 실패");
//			out.println("</body></html>");
//			out.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt != null) pstmt.close();
//			}catch(SQLException e) {}
//		}
//		
//		out.close();
	}
}

