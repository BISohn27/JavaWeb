package productcontrolleraction;

import java.util.ArrayList;
import java.util.Map;

import dao.ProductDAO;
import dto.ProductVO;

public class IndexAction implements Controller{
	private ProductDAO productDao;
	
	public IndexAction setDao(ProductDAO productDao) {
		this.productDao = productDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		ArrayList<ProductVO> bestlist = null;
		ArrayList<ProductVO> newlist = null;
		try {
			bestlist = productDao.getListBestProduct();
			newlist = productDao.getListNewProduct();
		}catch(Exception e) {
			e.printStackTrace();
		}
		model.put("newProductList", newlist);
		model.put("bestProductList", bestlist);
		return "/service/Index.jsp";
	}
	
	
	
	
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException{
//		String url = "service/Index.jsp";
//		ProductDAO productDAO = ProductDAO.getInstance();
//		ArrayList<ProductVO> newProductList = null, bestProductList = null;
//		try {
//			newProductList = productDAO.getListNewProduct();
//			bestProductList = productDAO.getListBestProduct();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		request.setAttribute("newProductList", newProductList);
//		request.setAttribute("bestProductList", bestProductList);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
//	}
}
