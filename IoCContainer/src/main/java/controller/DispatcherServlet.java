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
    		//��û�� ������ �����ϱ� ���Ͽ� �ؽ����� �����, �� �ȿ� key ���� ���� pagecontroller���� ����� �� �ֵ��� �����Ѵ�.
    		HashMap<String,Object> model = new HashMap<String,Object>();
    		model.put("session", request.getSession());
    		model.put("request", request);
    		model.put("memberdao", sc.getAttribute("memberdao"));
//    		Controller pageController = (Controller)sc.getAttribute(servletPath);
    		
    		//applicationcontext ��ü�κ��� �ʿ��� ������ ��Ʈ�ѷ��� servletpath�� ���� ���´�.
    		//applicationcontext ��ü�� �ؽ� ���̺��� %.do key�� ����Ǿ� �ְ�, ���ε� key�� ���� controller�� ������ ��� �ִ�.
    		ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
    		Controller pageController = (Controller)ctx.getBean(servletPath);
    		if(pageController == null) {
    			throw new Exception("��û�� ���񽺸� ã�� �� �����ϴ�.");
    		}
    		
    		if("/member/add.do".equals(servletPath)) {
    			model.put("memberadd", new Member().setEmail(request.getParameter("email"))
    					.setName(request.getParameter("name")).setPassword(request.getParameter("pwd")));
    		}else {
    			
    		}
    		
    		//������ ��Ʈ�ѷ��� dao�� ������ ������ �� �� ������ ������ page �ּҸ� ��ȯ�ϱ� ������ �� �ּҸ� �����Ͽ�
    		String viewUrl = pageController.execute(model);
    		//���� ���������� ������ �����͸� ����ϱ� ���� �ؽøʿ� ����� ��ü���� Ű�� ���ν��� �����ϰ�
    		for(String key : model.keySet()) {
    			request.setAttribute(key, model.get(key));
    		}
    		//������ ��Ʈ�ѷ��κ��� ���޹��� url�� �м��Ͽ� �ٸ� �������� �̵��� �ʿ䰡 ������ redirect�Ǿ� �ٽ� dispatcherservlet ��ü�� ���ε� url�� ������ ���� �ǰ�
    		if(viewUrl.startsWith("redirect:")) {
    			response.sendRedirect(viewUrl.substring(9));
    		}else {
    			//���� �����͸� ���� �� ���������� ǥ���ؾ� �Ǹ� dispatcher include �޼ҵ带 ���� �ش� ������ �����ش�.
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
