package webapps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserInfo;

/**
 * Servlet implementation class Servlet7Ex
 */
@WebServlet("/Servlet7Ex")
public class Servlet7Ex extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet7Ex() {
        super();
    }
    
    @Override
    public void init() throws ServletException{
    	String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bank?characterEncoding=UTF-8&serverTimezone=UTC";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "java");
		}catch(Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		PrintWriter out = response.getWriter();
		Statement stmt = null;
		ResultSet rs = null;
		UserInfo ui = null;                                                       //DTO
		out.println("<html>");
		out.println("<body>");
		try{
			stmt = conn.createStatement();
			rs= stmt.executeQuery("SELECT * FROM CUSTOMERS WHERE ID= BINARY('" + id + "')");
			if(rs.next()) {
				if(pw.equals(rs.getString("PASSWORD"))) {
					ui = new UserInfo().setId(rs.getString("ID"))
							.setPw(rs.getString("PASSWORD"))
							.setName(rs.getString("Name"));
					out.println("ID: " + ui.getId() +"<br>NAME: " + ui.getName());
					out.println("<br><br><b>인증 되었습니다.</b>");
				}else
					out.println("패스워드가 맞지 않습니다.");
			}else
				out.println("아이디가 존재하지 않습니다.");
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
			}catch(SQLException e) {}
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void destory() {
		try {
			if(conn != null) conn.close();
			
		}catch(SQLException e) {}
	}

}
