package productcontroller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listener.ApplicationContext;
import listener.ContextLoaderListener;
import productcontrolleraction.Controller;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.product")
public class ProductDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=UTF-8");
    	String servletPath= request.getServletPath();
    	try {
    		ServletContext sc = getServletContext();
    		HashMap<String,Object> model = new HashMap<String,Object>();
    		model.put("request", request);
    		model.put("response", response);
    		ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
    		Controller pageController= (Controller)ctx.getBean(servletPath);
    		
    		if(pageController == null) {
    			throw new Exception("요청한 페이지를 찾을 수 없습니다.");
    		}
    		
    		if("/service/index.product".equals(servletPath)) {
    		}
    		
    		String viewUrl = pageController.execute(model);
    		for(String key: model.keySet()) {
    			request.setAttribute(key, model.get(key));
    		}
    		
    		if(viewUrl.startsWith("redirect:")) {
    			response.sendRedirect(viewUrl.substring(9));
    		}else {
    			RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
    			rd.include(request, response);
    		}
    	}catch(Exception e) {
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
