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
	 * �н�����
	 * 	������ �̵�, ������ ����, ���� ����
	 * 		-forward : ������ �̵�
	 * 		-include : ���� �������� �ϳ��� ������ �� ���
	 * 		-scope(page, request, session, application)  
	 * 			1. �� ������ �������� ������ ����(page)
	 * 			2. request ��ü �ȿ� ������ ����(parameter�� ������ �������� ���� ������ ����, �� ������ ����)
	 * 			3. �����ϴ� session ��ü�� �Ҹ�Ǵ� �������� ������ ����, �ð� �������� ����(default 30��), ��Ű�ʹ� �ٸ���. 
	 * 			   session�� ���� �� �޸𸮿� �����ϰ� ��Ű�� Ŭ���̾�Ʈ ��ǻ�Ϳ� �������� �ӽ� ���Ϸ� ������ ��. 
	 * 			   �Ѵ� �ð����� �Ҹ� �ð��� �����Ǵ� ���� �����ϳ� ��Ű�� ������ �ð����� �Ҹ��� �����ǰ�, ������ ����� �ð�(������� �ʴ� �ð��� ���� �Ҹ� �ð��� ���ư�)���� ����
	 * 			4. application�� ����ִ� ����(container ��Ĺ) ����� ������ ����ִ� ��. ��Ĺ �������� ������Ʈ�� ����ǰ� �ִ� ���� ����.
	 * 
	 * 	ex)
	 * 	RequestDipatcher rd = request.getRequestDspatcher("������ ���")  -> ������ �̵� �� ����
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
//		RequestDispatcher rd = request.getRequestDispatcher("login.html");       //Ư�� page�� ���(Ÿ���� �Ǵ� ������)
//		rd.forward(request, response);    //�̵��ϴ� �������� ���ҽ��� ������ ��.
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
////					out.println("<body>�α��� ����<br>");
////					out.println(userinfo.getName() + "�� �α��� ���Դϴ�.");
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
//					rd2.forward(request,response);    //fail page�� ������ ������ ���� ������ � ������ ���ؼ� �����ߴ��� �˷� �� �� �ִ�.
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