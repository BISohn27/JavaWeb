package userinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MySqlUserInfoDao;
import dto.UserInfo;
import webapps.DBAction;

/**
 * Servlet implementation class UserInfoLoginServlet
 */
@WebServlet("/UserInfoLoginServlet")
public class UserInfoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * 학습주제
	 * 	페이지 이동, 페이지 병합, 정보 저장
	 * 		-forward : 페이지 이동
	 * 		-include : 여러 페이지를 하나로 병합할 때 사용
	 * 		-scope(page, request, session, application)  
	 * 			1. 한 페이지 내에서만 정보를 유지(page)
	 * 			2. request 객체 안에 정보를 저장(parameter로 던지는 곳까지만 저장 정보가 유지, 한 페이지 다음)
	 * 			3. 존재하는 session 객체가 소멸되는 시점까지 정보가 유지, 시간 개념으로 존재(default 30분), 쿠키와는 다르다. 
	 * 			   session은 서버 측 메모리에 저장하고 쿠키는 클라이언트 컴퓨터에 물리적인 임시 파일로 저장이 됨. 
	 * 			   둘다 시간으로 소멸 시간이 결정되는 것은 동일하나 쿠키는 절대적 시간으로 소멸이 결정되고, 세션은 상대적 시간(사용하지 않는 시간에 세션 소멸 시간이 돌아감)으로 결정
	 * 			4. application이 살아있는 동안(container 톰캣) 저장된 정보가 살아있는 것. 톰캣 엔진에서 프로젝트가 실행되고 있는 동안 유지.
	 * 
	 * 	ex)
	 * 	RequestDipatcher rd = request.getRequestDspatcher("페이지 경로")  -> 페이지 이동 및 병합
	 * 	HttpSession session = request.getSession();
	 */
       
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
		response.sendRedirect("/webapps/service/login.html");
//		response.setContentType("text/html;charset=UTF-8");
//		request.setCharacterEncoding("utf-8");
//		RequestDispatcher rd = request.getRequestDispatcher("login.html");       //특정 page를 명시(타겟이 되는 페이지)
//		rd.forward(request, response);    //이동하는 페이지에 리소스를 가지고 감.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=UTF-8");
//		
//		Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		RequestDispatcher rd1 = request.getRequestDispatcher("HeaderServlet");
//		RequestDispatcher rd2= request.getRequestDispatcher("/error/LoginFail.html");
//		RequestDispatcher rd3 = request.getRequestDispatcher("UserInfoListServlet");
//		try {
//			conn = DBAction.getInstance().getConnection();
//			stmt = conn.createStatement();
////			pstmt = conn.prepareStatement("SELECT * FROM USERINFO WHERE ID=?");
////			pstmt.setString(1, request.getParameter("id"));
////			rs = pstmt.executeQuery();
//			rs = stmt.executeQuery("SELECT * FROM USERINFO WHERE ID='" + request.getParameter("id") + "'");
//			if(rs.next()) {
//				if(request.getParameter("pw").equals(rs.getString("PW"))) {
//					PrintWriter out = response.getWriter();
//					UserInfo userinfo = new UserInfo().setId(rs.getString("id"))
//							.setPw(rs.getString("pw"))
//							.setName(rs.getString("name"));
//
//					out.println("<html><head><title>LoginSuccessFully</title></head>");
////					out.println("<body>로그인 성공<br>");
////					out.println(userinfo.getName() + "님 로그인 중입니다.");
////					out.println("</body></html>");
//					
//											
//					HttpSession session = request.getSession();
//					session.setAttribute("userinfo", userinfo);
////					response.sendRedirect("UserInfoListServlet");
//					rd1.include(request, response);
//					out.println("<b><br>Service Page</b><br></html>");
//					out.println("</body></html>");
//					out.close();
//				}else {
//					rd2.forward(request,response);    //fail page에 정보를 가지고 가기 때문에 어떤 이유에 의해서 실패했는지 알려 줄 수 있다.
//				}
//			}else {
//				rd2.forward(request, response);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs != null) rs.close();
//				if(pstmt != null) pstmt.close();
//				if(stmt != null) stmt.close();
//				if(conn != null) conn.close();
//			}catch(SQLException e) {}
//		}
		
		try {
			MySqlUserInfoDao dao = new MySqlUserInfoDao();
			UserInfo userinfo = dao.exist(request.getParameter("id"), request.getParameter("pw"));
			if(userinfo != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", userinfo);
				response.sendRedirect("jsp/practice2.jsp");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/error/LoginFail.html");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}