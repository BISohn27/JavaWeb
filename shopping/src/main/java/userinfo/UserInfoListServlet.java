package userinfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberVO;

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
		List<MemberVO> list = null;
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
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
