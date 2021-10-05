package productcontrolleraction;

import java.util.ArrayList;
import java.util.Map;

import dao.ProductDAO;
import dto.ProductVO;

public class SandalsAction implements Controller{
	private ProductDAO productDao;
	
	public SandalsAction setDao(ProductDAO productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		ArrayList<ProductVO> list = productDao.getListSandals();
		model.put("sandalslist", list);
		
		return "Sandals.jsp";
	}
}
