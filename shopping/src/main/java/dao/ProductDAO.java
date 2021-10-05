package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import db.DBAction;
import dto.ProductVO;

public class ProductDAO {
	static private ProductDAO instance = new ProductDAO();
	private DataSource ds;
	
	public static ProductDAO getInstance() {
		if(instance == null)
			instance = new ProductDAO();
		
		return instance;
	}
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public ArrayList<ProductVO> getListNewProduct() throws Exception {
		ArrayList<ProductVO> productlist = new ArrayList<>();
		Connection conn = ds.getConnection();
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
		Connection conn = ds.getConnection();
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
	
	public ArrayList<ProductVO> getListHeels() throws Exception{
		ArrayList<ProductVO> list = new ArrayList<>();
		Connection conn = ds.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM PRODUCT WHERE USEYN='Y' AND Kind='1'");
			while(rs.next()) {
				list.add(new ProductVO().setPseq(rs.getInt(1))
										.setName(rs.getString(2))
										.setKind(rs.getString(3))
										.setPrice1(rs.getInt(4))
										.setPrice2(rs.getInt(5))
										.setPrice3(rs.getInt(6))
										.setContent(rs.getString(7))
										.setImage(rs.getString(8))
										.setBestyn(rs.getString(10).charAt(0))
										.setDate(rs.getString(11)));	
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
		return list;
	}
	
	public ArrayList<ProductVO> getListBoots() throws Exception{
		ArrayList<ProductVO> list = new ArrayList<>();
		Connection conn = ds.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM PRODUCT WHERE USEYN='Y' AND Kind='2'");
			while(rs.next()) {
				list.add(new ProductVO().setPseq(rs.getInt(1))
										.setName(rs.getString(2))
										.setKind(rs.getString(3))
										.setPrice1(rs.getInt(4))
										.setPrice2(rs.getInt(5))
										.setPrice3(rs.getInt(6))
										.setContent(rs.getString(7))
										.setImage(rs.getString(8))
										.setBestyn(rs.getString(10).charAt(0))
										.setDate(rs.getString(11)));	
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
		return list;
	}
	
	public ArrayList<ProductVO> getListSandals() throws Exception{
		ArrayList<ProductVO> list = new ArrayList<>();
		Connection conn = ds.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM PRODUCT WHERE USEYN='Y' AND Kind='3'");
			while(rs.next()) {
				list.add(new ProductVO().setPseq(rs.getInt(1))
										.setName(rs.getString(2))
										.setKind(rs.getString(3))
										.setPrice1(rs.getInt(4))
										.setPrice2(rs.getInt(5))
										.setPrice3(rs.getInt(6))
										.setContent(rs.getString(7))
										.setImage(rs.getString(8))
										.setBestyn(rs.getString(10).charAt(0))
										.setDate(rs.getString(11)));	
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
		return list;
	}
	
	public ArrayList<ProductVO> getListSlippers() throws Exception{
		ArrayList<ProductVO> list = new ArrayList<>();
		Connection conn = ds.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM PRODUCT WHERE USEYN='Y' AND Kind='4'");
			while(rs.next()) {
				list.add(new ProductVO().setPseq(rs.getInt(1))
										.setName(rs.getString(2))
										.setKind(rs.getString(3))
										.setPrice1(rs.getInt(4))
										.setPrice2(rs.getInt(5))
										.setPrice3(rs.getInt(6))
										.setContent(rs.getString(7))
										.setImage(rs.getString(8))
										.setBestyn(rs.getString(10).charAt(0))
										.setDate(rs.getString(11)));
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
		return list;
	}
	
	public ArrayList<ProductVO> getListSneakers() throws Exception{
		ArrayList<ProductVO> list = new ArrayList<>();
		Connection conn = ds.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM PRODUCT WHERE USEYN='Y' AND Kind='5'");
			while(rs.next()) {
				list.add(new ProductVO().setPseq(rs.getInt(1))
										.setName(rs.getString(2))
										.setKind(rs.getString(3))
										.setPrice1(rs.getInt(4))
										.setPrice2(rs.getInt(5))
										.setPrice3(rs.getInt(6))
										.setContent(rs.getString(7))
										.setImage(rs.getString(8))
										.setBestyn(rs.getString(10).charAt(0))
										.setDate(rs.getString(11)));	
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
		return list;
	}
	
	public ProductVO getProduct(ProductVO product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE PSEQ=?");
			pstmt.setInt(1, product.getPseq());
			rs=pstmt.executeQuery();
			if(rs.next()) {
						product.setName(rs.getString(2))
								.setKind(rs.getString(3))
								.setPrice1(rs.getInt(4))
								.setPrice2(rs.getInt(5))
								.setPrice3(rs.getInt(6))
								.setContent(rs.getString(7))
								.setImage(rs.getString(8))
								.setBestyn(rs.getString(10).charAt(0))
								.setDate(rs.getString(11));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return product;
	}
}
