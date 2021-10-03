package userinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
//		session.setMaxInactiveInterval(1);
		UserInfo userinfo = (UserInfo)session.getAttribute("userinfo");
		if(userinfo != null) {
			out.println(userinfo.getName() + "님 로그인 중입니다.");
			out.println("<input type='button' value='로그아웃'" + 
						" onclick='location.href=\"/webapps/UserInfoLogOutServlet\"'>");
		}else {
			out.println("session 정보 없음");
			out.println("<input type='button' value='로그인'"+
						" onclick='location.href=\"/webapps/login.html\"'>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
