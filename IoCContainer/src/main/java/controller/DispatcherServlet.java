package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import listener.ApplicationContext;
import listener.ContextLoaderListener;

/**
 * Servlet implementation class DispatcherServletTest
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	String servletPath = request.getServletPath();
    	System.out.println(servletPath);
    	try {
    		ServletContext sc = this.getServletContext();
    		//요청과 세션을 전달하기 위하여 해쉬맵을 만들고, 그 안에 key 값을 통해 pagecontroller에서 사용할 수 있도록 저장한다.
    		HashMap<String,Object> model = new HashMap<String,Object>();
    		model.put("session", request.getSession());
    		model.put("request", request);
    		model.put("memberdao", sc.getAttribute("memberdao"));
//    		Controller pageController = (Controller)sc.getAttribute(servletPath);
    		
    		//applicationcontext 객체로부터 필요한 페이지 컨트롤러를 servletpath를 통해 얻어온다.
    		//applicationcontext 객체의 해시 테이블에는 %.do key가 저장되어 있고, 매핑된 key의 실제 controller가 값으로 들어 있다.
    		ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
    		Controller pageController = (Controller)ctx.getBean(servletPath);
    		if(pageController == null) {
    			throw new Exception("요청한 서비스를 찾을 수 없습니다.");
    		}
    		
    		if("/member/add.do".equals(servletPath)) {
    			model.put("memberadd", new Member().setEmail(request.getParameter("email"))
    					.setName(request.getParameter("name")).setPassword(request.getParameter("pwd")));
    		}else {
    			
    		}
    		
    		//페이지 컨트롤러는 dao와 데이터 가공을 한 후 다음에 가야할 page 주소를 반환하기 때문에 이 주소를 저장하여
    		String viewUrl = pageController.execute(model);
    		//다음 페이지에서 가공된 데이터를 사용하기 위해 해시맵에 사용할 객체들을 키로 매핑시켜 저장하고
    		for(String key : model.keySet()) {
    			request.setAttribute(key, model.get(key));
    		}
    		//페이지 컨트롤러로부터 전달받은 url을 분석하여 다른 페이지로 이동할 필요가 있으면 redirect되어 다시 dispatcherservlet 객체로 매핑된 url을 가지고 오게 되고
    		if(viewUrl.startsWith("redirect:")) {
    			response.sendRedirect(viewUrl.substring(9));
    		}else {
    			//받은 데이터를 기존 웹 페이지에서 표시해야 되면 dispatcher include 메소드를 통해 해당 정보를 보여준다.
    			RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
    			rd.include(request, response);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
