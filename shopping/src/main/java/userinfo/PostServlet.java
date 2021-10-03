package userinfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AddressVO;


/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		Connection conn = DBActionZ.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String dong = request.getParameter("dong");
		
		if(dong != null) {
			List<AddressVO> list = new ArrayList<>();
			String sql = "SELECT * FROM ZIPCODE WHERE DONG LIKE '%" + dong.trim() + "%'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				AddressVO addressVo = new AddressVO();
				addressVo.setZipcode(rs.getString("zipcode"));
				addressVo.setSido(rs.getString("sido"));
				addressVo.setGugun(rs.getString("gugun"));
				addressVo.setDong(rs.getString("dong"));
				addressVo.setRi(rs.getString("ri"));
				addressVo.setBldg(rs.getString("bldg"));
				addressVo.setBunji(rs.getString("bunji"));
				list.add(addressVo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		request.setAttribute("zip", list);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Zipcode.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
