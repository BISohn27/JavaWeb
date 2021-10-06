package ordercontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.OrderDAO;

public class OrderController extends MultiActionController{
	private OrderDAO orderDao;
	
	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}
	
	public ModelAndView cart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		ModelAndView mav = new ModelAndView();
		String viewName = getViewName(request);
		
		if(orderDao.getCartList(id).isEmpty()) {
			mav.addObject("cart",null);
		}else {
			mav.addObject("cart",orderDao.getCartList(id));
		}
		mav.setViewName(viewName);
		
		return mav;
	}
	
	public ModelAndView order(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		ModelAndView mav = new ModelAndView();
		String viewName = getViewName(request);
		
		if(orderDao.getOrderList(id).isEmpty()) {
			mav.addObject("order",null);
		}else {
			mav.addObject("order",orderDao.getOrderList(id));
		}
		mav.setViewName(viewName);
		
		return mav;
	}
	
	public String getViewName(HttpServletRequest request) throws Exception{
		String contextPath = request.getContextPath();
		String uri = (String)request.getAttribute("javax.servlet.include.reqeust_uri");
		if(uri==null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		int begin = 0;
		if(!((contextPath==null)||("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		}else if(uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		}else {
			end = uri.length();
		}
		
		String fileName = uri.substring(begin,end);
		if(fileName.indexOf(".")!= -1) {
			fileName=fileName.substring(0,fileName.lastIndexOf("."));
		}
		if(fileName.lastIndexOf("/") != -1) {
			fileName=fileName.substring(fileName.lastIndexOf("/")+1,fileName.length());
		}
		return fileName;
	}
}
