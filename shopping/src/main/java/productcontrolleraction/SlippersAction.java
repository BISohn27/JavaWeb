package productcontrolleraction;

import java.util.ArrayList;
import java.util.Map;

import dao.ProductDAO;
import dto.ProductVO;

public class SlippersAction implements Controller{
private ProductDAO productDao;
	
	public SlippersAction setDao(ProductDAO productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		ArrayList<ProductVO> list = productDao.getListSlippers();
		model.put("slipperslist", list);
		
		return "Slippers.jsp";
	}
}
