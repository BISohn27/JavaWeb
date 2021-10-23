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
	
	public ModelAndView writer(HttpServletRequest request,HttpServletResponse response) throws Exception{
		return new ModelAndView("redirect:/view/writer.jsp");
	}
	
	public ModelAndView write(HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		if(subject != null && content !=null) {
			customerServiceDao.insertQna(subject, content,id);
		}
		
		return new ModelAndView("redirect:../customerservice/qna.customerservice");
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
		int page = 1;
		List<BoardVO> list = null;
		
		if(!((temp = request.getParameter("page"))==null)) {
			page = Integer.parseInt(temp);
			temp = null;
		}
		
		if((temp = request.getParameter("totalpages"))==null) {
			Object[] objList = customerServiceDao.getBoardListAndTotal(page, countArticles);
			totalArticles = (int)objList[0];
			totalPages = totalArticles/countArticles;
			if((totalArticles % countArticles) != 0) {
				totalPages++;
			}
			if(objList[1] instanceof List) {
				list = (List<BoardVO>)objList[1];
			}
		} else {
			totalPages = Integer.parseInt(temp);
			list = customerServiceDao.getBoardList(page,countArticles);
		}
		
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
			mav.addObject("page", request.getParameter("page"));
			mav.addObject("totalpages",request.getParameter("totalpages"));
		} else {
			mav.setViewName("redirect:/shopping/customerservice/qna.customerservice");
		}
		return mav;
	}
	
	public ModelAndView modify(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		BoardVO board = customerServiceDao.modifyQna(subject, content, qseq);
		
		mav.addObject("board", board);
		mav.addObject("page", request.getParameter("page"));
		mav.addObject("totalpages", request.getParameter("totalpages"));
		mav.setViewName("board");
		return mav;
	}
	
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String searchOption = request.getParameter("searchoption");
		String search = request.getParameter("searching");
		String temp= null;
		int countPages= 10;
		int countArticles = 10;
		int totalPages = 0;
		int totalArticles=0;
		int page = 1;
		List<BoardVO> list = null;
		
		if(!((temp = request.getParameter("page"))==null)) {
			page = Integer.parseInt(temp);
			temp = null;
		}
		
		Object[] objList = null;
		
		if(searchOption.equals("1")) {
			objList = customerServiceDao.getSubjectBoardList(page, countArticles, search);
		}else if(searchOption.equals("2")) {
			objList = customerServiceDao.getContentSubjectBoardList(page, countArticles, search);
		}else if(searchOption.equals("3")){
			objList = customerServiceDao.getIdBoardList(page, countArticles, search);
		}else {
			mav.setViewName("redirect:../customerservice/qna.customerservice");
			return mav;
		}
		
		if(objList[1] instanceof List) {
			list = (List<BoardVO>)objList[1];
			if(list.isEmpty()) {
				list = null;
			}
		}
		
		if((temp = request.getParameter("totalpages"))==null) {
			totalArticles = (int)objList[0];
			totalPages = totalArticles/countArticles;
			if((totalArticles % countArticles) != 0) {
				totalPages++;
			}
		} else {
			totalPages = Integer.parseInt(temp);
		}
		
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
			mav.addObject("searching", search);
			mav.addObject("searchoption",searchOption);
			String viewName = getViewName(request);
			mav.setViewName(viewName);
		}else {
			mav.addObject("qnalist", list);
			String viewName = getViewName(request);
			mav.setViewName(viewName);
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
