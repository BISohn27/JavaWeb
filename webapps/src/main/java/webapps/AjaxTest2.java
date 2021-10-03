package webapps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTest2
 */
@WebServlet("/AjaxTest2")
public class AjaxTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String result="";
		PrintWriter out = response.getWriter();
		result = "<main><book>" +
		"<title><![CDATA[초보를 위한 자바 프로그래밍]]></title>"+
		"<writer><![CDATA[인포북스 저 | 이병승]]></writer>"+
		"</book>"+
		"<book>" +
		"<title><![CDATA[모두의 파이선]]></title>"+
		"<writer><![CDATA[길벗 저 | 이승찬]]></writer>"+
		"</book></main>";
		out.print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
