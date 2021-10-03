package userinfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBAction;
import dto.MemberVO;


/**
 * Servlet implementation class CheckId
 */
@WebServlet("/CheckIdServlet")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBAction.getInstance().getConnection();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id").trim();
		String sql = "SELECT ID FROM USERINFO WHERE ID=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				member = new MemberVO().setId(rs.getString("ID"));
				request.setAttribute("userinfo", member);
			}
			request.getRequestDispatcher("jsp/CheckId.jsp").include(request, response);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
