package productcontrolleraction;

import java.util.ArrayList;
import java.util.Map;

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
		model.put("Heelslist", list);
		
		return "/shopping/service/Heels.jsp";
	}
}
