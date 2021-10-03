package userinfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MySqlUserInfoDao;

/**
 * Servlet implementation class UserInfoDeleteServlet
 */
@WebServlet("/UserInfoDeleteServlet")
public class UserInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			MySqlUserInfoDao dao = new MySqlUserInfoDao();
			dao.delete(request.getParameter("id"));
			response.sendRedirect("/jsp/Practice2.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/error/error.jsp");
			rd.forward(request, response);
		}
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		request.setCharacterEncoding("utf-8");
//		
//		Connection conn = DBAction.getInstance().getConnection();
//		PreparedStatement pstmt = null;
//		PrintWriter out = response.getWriter();
//		
//		String id = request.getParameter("id");
//		
//		out.println("<html><head></head><body>");
//		try {
//			pstmt = conn.prepareStatement("DELETE FROM USERINFO WHERE ID=?");
//			pstmt.setString(1, id);
//			int result = pstmt.executeUpdate();
//	
//			out.println(result >-1 ? "<a href='/webapps/UserInfoListServlet'>" + "È¸¿øÅ»Åð¿Ï·á</a>" : "<a href='/webapps/UserInfoListServlet'>È¸¿øÅ»Åð½ÇÆÐ</a>");
//			out.println("</body></html>");
//			out.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt != null) pstmt.close();
//			}catch(SQLException e) {}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
