package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto.CartVO;
import dto.OrderVO;

public class OrderDAO {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public ArrayList<CartVO> getCartList(String id) throws Exception {
		ArrayList<CartVO> list = new ArrayList<>();
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM CART_VIEW WHERE ID=? AND RESULT=1");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new CartVO().setCseq(rs.getInt(1))
										.setId(rs.getString(2))
										.setPseq(rs.getInt(3))
										.setMname(rs.getString(4))
										.setPname(rs.getString(5))
										.setQuantity(rs.getInt(6))
										.setIndate(rs.getString(7))
										.setPrice2(rs.getInt(8)));
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
		return list;
	}
	
	public ArrayList<OrderVO> getOrderList(String id) throws Exception{
		ArrayList<OrderVO> list = new ArrayList<>();
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM ORDER_VIEW WHERE ID=? AND RESULT=1");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new OrderVO().setOdseq(rs.getInt(1))
										.setOseq(rs.getInt(2))
										.setId(rs.getString(3))
										.setIndate(rs.getString(4))
										.setPseq(rs.getInt(5))
										.setQuantity(rs.getInt(6))
										.setName(rs.getString(7))
										.setZipcode(rs.getString(8))
										.setAddress(rs.getString(9))
										.setPhone(rs.getString(10))
										.setPname(rs.getString(11))
										.setPrice2(rs.getInt(12)));
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
		
		return list;
	}
}
