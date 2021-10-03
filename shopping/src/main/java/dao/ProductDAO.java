package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DBAction;
import dto.ProductVO;

public class ProductDAO {
	static private ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		if(instance == null)
			instance = new ProductDAO();
		
		return instance;
	}
	
	public ArrayList<ProductVO> getListNewProduct() throws Exception {
		ArrayList<ProductVO> productlist = new ArrayList<>();
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM NEW_PRO_VIEW");
			conn = DBAction.getInstance().getConnection();
			rs=pstmt.executeQuery();
			while(rs.next()) {
				productlist.add(new ProductVO().setPseq(rs.getInt("pseq"))
												.setName(rs.getString("name"))
												.setPrice2(rs.getInt("price2"))
												.setImage(rs.getString("image")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return productlist;
	}
	
	public ArrayList<ProductVO> getListBestProduct() throws Exception {
		ArrayList<ProductVO> productlist = new ArrayList<>();
		Connection conn = DBAction.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM BEST_PRO_VIEW");
			while(rs.next()) {
				productlist.add(new ProductVO().setPseq(rs.getInt("pseq"))
						.setName(rs.getString("name"))
						.setPrice2(rs.getInt("price2"))
						.setImage(rs.getString("image")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return productlist;
	}
}
