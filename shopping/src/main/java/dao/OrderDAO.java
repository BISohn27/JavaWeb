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
			pstmt = conn.prepareStatement("select oseq, count(odseq) as cnt, indate, sum(price2) as sum from order_view where id=? and result=1 group by oseq");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new OrderVO().setOseq(rs.getInt(1))
										.setCnt(rs.getInt(2))
										.setIndate(rs.getString(3))
										.setSum(rs.getInt(4)));
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
	
	public ArrayList<OrderVO> getOrderDetailList(String id, int oseq) throws Exception{
		ArrayList<OrderVO> list = new ArrayList<>();
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM ORDER_VIEW WHERE ID=? AND OSEQ=?");
			pstmt.setString(1,id);
			pstmt.setInt(2, oseq);
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
	
	public int setCart(String id, int pseq, int quantity) throws Exception{
		int result =-1;
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {
			pstmt2 = conn.prepareStatement("SELECT QUANTITY FROM CART WHERE ID=? AND PSEQ=?");
			pstmt2.setString(1, id);
			pstmt2.setInt(2, pseq);
			rs = pstmt2.executeQuery();
			if(rs.next()) {
				pstmt1 = conn.prepareStatement("UPDATE CART SET QUANTITY=? WHERE ID=? AND PSEQ=?");
				pstmt1.setInt(1, quantity + rs.getInt("quantity"));
				pstmt1.setString(2, id);
				pstmt1.setInt(3, pseq);
				result = pstmt1.executeUpdate();
			}else {
				pstmt1 = conn.prepareStatement("INSERT CART(ID,PSEQ,QUANTITY) VALUES(?,?,?)");
				pstmt1.setString(1, id);
				pstmt1.setInt(2, pseq);
				pstmt1.setInt(3, quantity);
				result=pstmt1.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt2 != null) pstmt2.close();
				if(pstmt1 != null) pstmt1.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return result;
	}
	
	public int deleteCart(String id, int cseq) throws Exception{
		int result = -1;
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("DELETE FROM CART WHERE ID=? AND CSEQ=?");
			pstmt.setString(1, id);
			pstmt.setInt(2, cseq);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return result;
	}
}
