package customerservicecontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.CustomerServiceDAO;
import dao.MemberDAO;
import dto.BoardVO;

public class CustomerServiceController extends MultiActionController{
	MemberDAO memberDao;
	CustomerServiceDAO customerServiceDao;
	
	public void setCustomerServiceDao(CustomerServiceDAO customerServiceDao) {
		this.customerServiceDao = customerServiceDao;
	}
	
	public ModelAndView viewMemberInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mav= new ModelAndView();
		String viewName = getViewName(request);
		mav.setViewName(viewName);
		return mav;
	}
	
	public ModelAndView qna(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		String temp= null;
		int countPages= 10;
		int countArticles = 10;
		int totalPages = 0;
		int totalArticles=0;
		
		if((temp = request.getParameter("totalpages")).isEmpty()) {
			totalArticles = customerServiceDao.getTotalArticles();
			totalPages = totalArticles/countArticles;
			if((totalArticles % countArticles) != 0) {
				totalPages++;
			}
		} else {
			totalPages = Integer.parseInt(temp);
			temp = null;
		}
		
		int page = 1;
		if(!((temp = request.getParameter("page")).isEmpty())) {
			page = Integer.parseInt(temp);
		}
		
		List<BoardVO> list = customerServiceDao.getBoardList(page,countArticles);
		
		int startPage = ((page-1)/countPages) * countPages + 1;
		int endPage = startPage -1 + countPages;
		
		if(totalPages < endPage) {
			endPage = totalPages;
		}
		
		if(list != null) {
			mav.addObject("qnalist", list);
			mav.addObject("startpage",startPage);
			mav.addObject("endpage",endPage);
			mav.addObject("page", page);
			mav.addObject("totalpages",totalPages);
			String viewName = getViewName(request);
			mav.setViewName(viewName);
		}else {
			mav.setViewName("redirect:shopping/service/index.product");
		}
		return mav;
	}
	
	public ModelAndView board(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		BoardVO board = customerServiceDao.getBoard(qseq);
		
		if(board != null) {
			mav.addObject("board",board);
			String viewName = getViewName(request);
			mav.setViewName(viewName);
		} else {
			mav.setViewName("redirect:/shopping/customerservice/qna.customerservice");
		}
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
