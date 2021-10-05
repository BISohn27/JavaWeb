package productcontrolleraction;

import java.util.Map;

import dao.ProductDAO;
import dto.ProductVO;

public class ProductAction implements Controller{
private ProductDAO productDao;
	
	public ProductAction setDao(ProductDAO productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("product", productDao.getProduct(((ProductVO)model.get("product"))));
		
		return "Product.jsp";
	}
}
