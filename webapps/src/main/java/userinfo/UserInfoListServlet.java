package userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MySqlUserInfoDao;
import dto.UserInfo;

/**
 * Servlet implementation class UserInfoList
 */
@WebServlet("/UserInfoListServlet")
public class UserInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MySqlUserInfoDao userinfoDao=new MySqlUserInfoDao();
		List<UserInfo> list = null;
		try {
			list = userinfoDao.selectList();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/userinfo/UserInfoList.jsp");
			rd.include(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/error/Error.jsp");
			rd.include(request, response);
		}
		
		
//		
//		out.println("<html><body>");
//		out.println("<table border='1'");
//		Iterator<UserInfo> data = list.iterator();
//		while(data.hasNext()) {
//			UserInfo user = data.next();
//			out.println("<tr>");
//			out.println("<td><b><a href='/webapps/UserInfoUpdateServlet?id=" + user.getId() + "'>"
//																			+ user.getId() + "</a></b></td>");
//			out.println("<td><b>" + user.getPw() + "</b></td>");
//			out.println("<td><b>" + user.getName() + "</b></td>");
//			out.println("</tr>");
//		}
//		out.println("</table>");
//		out.println("<a href = '/webapps/UserInfoAddServlet'>회원가입</a>");
//		out.println("</body></html>");
//		out.close();
//		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/ViewList.jsp");
//		request.setAttribute("userinfo", list);
//		dispatcher.forward(request, response);
	}
//		Connection conn = DBAction.getInstance().getConnection();
//		Statement stmt = null;
//		ResultSet rs = null;
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		List<UserInfo> users = new ArrayList<>();
//		
//		out.println("<html><head><title>회원목록</title></head>");
//		out.println("<body><table border = '1'>");
//		out.println("<tr><th> 아이디 </th><th> 패스워드 </th><th> 이 름 </th></tr>");
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery("SELECT * FROM USERINFO");
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int cnt = rsmd.getColumnCount();
//			while(rs.next()) {
//				out.println("<tr>");
//				/*
//				for(int i = 1; i<= cnt; i++) {
//					if(i<2) {
//						String id = rs.getString(i);
//						out.println("<td><a href='/webapps/UserInfoUpdateServlet?id="+ id +"'>" + id + "</a></td>");
//					}else {
//						out.println("<td>"+rs.getString(i) + "</td>");
//					}
//				 
//				}
//				*/
//				UserInfo user = new UserInfo().setId(rs.getString(1)).setPw(rs.getString(2)).setName(rs.getString(3));
//				users.add(user);
//				out.println("<td><a href='UserInfoUpdateServlet?id="+ user.getId() +"'>" + user.getId() + "</a></td>");
//				out.println("<td>" + user.getPw() + "</td>");
//				out.println("<td>" + user.getName() + "</td>");
//				out.println("</tr>");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(stmt !=null) stmt.close();
//			}catch(SQLException e) {}
//		}
//		out.println("</table>");
//		out.println("<a href = 'UserInfoAddServlet'>회원가입</a>");
//		out.println("</body></html>");
//
//		out.close();
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
