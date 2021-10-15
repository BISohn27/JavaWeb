package ordercontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.OrderDAO;
import dto.CartVO;
import dto.OrderVO;

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
		ArrayList<CartVO> list = orderDao.getCartList(id);
		
		if(list.isEmpty()) {
			mav.addObject("cart",null);
		}else {
			mav.addObject("cart",list);
		}
		mav.setViewName(viewName);
		
		return mav;
	}
	
	public ModelAndView order(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		ModelAndView mav = new ModelAndView();
		String viewName = getViewName(request);
		ArrayList<OrderVO> list = orderDao.getOrderList(id);
		
		if(list.isEmpty()) {
			mav.addObject("order",null);
		}else {
			mav.addObject("order",list);
		}
		mav.setViewName(viewName);
		
		return mav;
	}
	
	public ModelAndView addcart(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		ModelAndView mav = new ModelAndView();
		
		if(orderDao.setCart(id,pseq,quantity)!=-1) {
			mav.addObject("id",id);
			mav.setViewName("redirect:/shopping/order/cart.order");
		}
		
		return mav;
	}
	
	public ModelAndView deletecart(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		int cseq = Integer.parseInt(request.getParameter("cseq"))	;
		ModelAndView mav = new ModelAndView();
		
		if(orderDao.deleteCart(id,cseq) != -1) {
			mav.addObject("id",id);
			mav.setViewName("redirect:/order/cart.order");
		}
		return mav;
	}
	
	public ModelAndView orderdetail(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		int oseq = Integer.parseInt(request.getParameter("oseq"));
		ModelAndView mav = new ModelAndView();
		String viewName = getViewName(request);
		ArrayList<OrderVO> list = orderDao.getOrderDetailList(id, oseq);
		
		if(list.isEmpty()) {
			mav.addObject("orderdetail",null);
		}else {
			mav.addObject("orderdetail",list);
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
