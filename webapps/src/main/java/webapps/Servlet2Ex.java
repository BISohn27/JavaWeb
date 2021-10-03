package webapps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2Ex
 */
@WebServlet("/Servlet2Ex")
public class Servlet2Ex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2Ex() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bank?characterEncoding=UTF-8&serverTimezone=UTC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		out.println("<html>");
		out.println("<body>");
		out.println("<table border ='1'>");
		out.println("<tr>" + "<td>ID</td>" + "<td>Password</td>" + "<td>Name</td>" + "<td>Cre_Date</td>"
				+ "<td>rate</td></tr>");

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "java");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM CUSTOMERS");
			ResultSetMetaData rsmd = rs.getMetaData();
			int cnt = rsmd.getColumnCount();

			while (rs.next()) {
				out.println("<tr>");
				for (int i = 1; i <= cnt; i++)
					out.print("<td>" + rs.getString(i) + "</td>");
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

//			out.println("<tr><td colspan='9'>´Ü: " + dan + "</td></tr>");
//			for(int i = 2; i< 10; i++) {
//				out.println("<tr>");
//				for(int j = 1; j<9; j++)
//					out.println("<td>" + j + " * " + i + " = " + (j*i) + "</td>");
//				out.println("</tr>");
//			} 

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
