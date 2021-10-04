package productcontrolleraction;

import java.util.ArrayList;
import java.util.Map;

import dao.ProductDAO;
import dto.ProductVO;

public class BootsAction implements Controller{
	ProductDAO productDao;
	
	public BootsAction setDao(ProductDAO productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		ArrayList<ProductVO> list = productDao.getListBoots();
		model.put("bootslist", list);
		
		return "/shopping/service/Boots.jsp";
	}
}
