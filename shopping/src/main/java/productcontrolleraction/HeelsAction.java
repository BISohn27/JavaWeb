package productcontrolleraction;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.ProductDAO;
import dto.ProductVO;

public class HeelsAction implements Controller{
	ProductDAO productDao;
	
	public HeelsAction setDao(ProductDAO productDao) {
		this.productDao = productDao;
		return this;
	}
	
	public String execute(Map<String, Object> model) throws Exception{
		ArrayList<ProductVO> list = productDao.getListHeels();
		((HttpServletRequest)model.get("request")).setAttribute("heelslist", list);
		
		return "Heels.jsp";
	}
}
