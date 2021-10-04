package productcontrolleraction;

import java.util.ArrayList;
import java.util.Map;

import dao.ProductDAO;
import dto.ProductVO;

public class SneakersAction implements Controller{
	private ProductDAO productDao;
	
	public SneakersAction setDao(ProductDAO productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		ArrayList<ProductVO> list = productDao.getListSneakers();
		model.put("sneakerslist", list);
		
		return "/shopping/service/Sneakers.jsp";
	}
}
