package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dto.BoardVO;

public class CustomerServiceDAO {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource= dataSource; 
	}
	
	public List<BoardVO> getBoardList(int currentPage,int countArticles) {
		int offset = (currentPage-1)*countArticles;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM QNA ORDER BY QSEQ DESC LIMIT ?, ?");
			pstmt.setInt(1, offset);
			pstmt.setInt(2, countArticles);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO().setQseq(rs.getInt(1))
										.setSubject(rs.getString(2))
										.setContent(rs.getString(3))
										.setReply(rs.getString(4))
										.setId(rs.getString(5))
										.setReq(rs.getString(6))
										.setIndate(rs.getDate(7)));			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}catch(SQLException e) {}
		}
		return list;
	}
	
	public BoardVO getBoard(int Qseq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		BoardVO board = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM QNA WHERE QSEQ=?");
			pstmt.setInt(1, Qseq);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO().setQseq(rs.getInt(1))
										.setSubject(rs.getString(2))
										.setContent(rs.getString(3))
										.setReply(rs.getString(4))
										.setId(rs.getString(5))
										.setReq(rs.getString(6))
										.setIndate(rs.getDate(7));			
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
		return board;
	}
	
	public int getTotalArticles() {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int total = 0;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(QSEQ) FROM QNA");
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return total;
	}
}
