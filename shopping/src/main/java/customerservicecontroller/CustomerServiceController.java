package customerservicecontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import dao.BoardDAO;
import dao.MemberDAO;

public class CustomerServiceController {
	MemberDAO memberDao;
	BoardDAO boardDao;
	
	public ModelAndView viewMemberInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mav= new ModelAndView();
		String viewName = getViewName(request);
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
