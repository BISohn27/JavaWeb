package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		Connection conn = null;
		List<BoardVO> list = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
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
				if(conn != null) conn.close();
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
	
	public Object[] getBoardListAndTotal(int currentPage,int countArticles) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rsTotal = null;
		ResultSet rsList = null;
		Object[] objList = new Object[2];
		List<BoardVO> list = new ArrayList<>();
		int offset = (currentPage-1)*countArticles;
		
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rsTotal = stmt.executeQuery("SELECT COUNT(QSEQ) FROM QNA");
			if(rsTotal.next()) {
				objList[0] = rsTotal.getInt(1);
			}
			
			pstmt = conn.prepareStatement("SELECT * FROM QNA ORDER BY QSEQ DESC LIMIT ?, ?");
			pstmt.setInt(1, offset);
			pstmt.setInt(2, countArticles);
			rsList = pstmt.executeQuery();
			while(rsList.next()) {
				list.add(new BoardVO().setQseq(rsList.getInt(1))
													.setSubject(rsList.getString(2))
													.setContent(rsList.getString(3))
													.setReply(rsList.getString(4))
													.setId(rsList.getString(5))
													.setReq(rsList.getString(6))
													.setIndate(rsList.getDate(7)));
			}
			objList[1] = list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rsList != null) rsList.close();
				if(rsTotal != null) rsTotal.close();
				if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return objList;
	}
	
	public Object[] getSubjectBoardList(int currentPage,int countArticles, String subject) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rsTotal = null;
		ResultSet rsList = null;
		Object[] objList = new Object[2];
		List<BoardVO> list = new ArrayList<>();
		int offset = (currentPage-1)*countArticles;
		
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rsTotal = stmt.executeQuery("SELECT COUNT(QSEQ) FROM QNA");
			if(rsTotal.next()) {
				objList[0] = rsTotal.getInt(1);
			}
			
			pstmt = conn.prepareStatement("SELECT * FROM QNA WHERE SUBJECT=? ORDER BY QSEQ DESC LIMIT ?, ?");
			pstmt.setString(1, subject);
			pstmt.setInt(2, offset);
			pstmt.setInt(3, countArticles);
			rsList = pstmt.executeQuery();
			while(rsList.next()) {
				list.add(new BoardVO().setQseq(rsList.getInt(1))
													.setSubject(rsList.getString(2))
													.setContent(rsList.getString(3))
													.setReply(rsList.getString(4))
													.setId(rsList.getString(5))
													.setReq(rsList.getString(6))
													.setIndate(rsList.getDate(7)));
			}
			objList[1] = list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rsList != null) rsList.close();
				if(rsTotal != null) rsTotal.close();
				if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return objList;
	}
	
	public Object[] getContentSubjectBoardList(int currentPage,int countArticles, String str) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rsTotal = null;
		ResultSet rsList = null;
		Object[] objList = new Object[2];
		List<BoardVO> list = new ArrayList<>();
		int offset = (currentPage-1)*countArticles;
		
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rsTotal = stmt.executeQuery("SELECT COUNT(QSEQ) FROM QNA");
			if(rsTotal.next()) {
				objList[0] = rsTotal.getInt(1);
			}
			
			pstmt = conn.prepareStatement("SELECT * FROM QNA WHERE SUBJECT=? OR CONTENT=? ORDER BY QSEQ DESC LIMIT ?, ?");
			pstmt.setString(1, str);
			pstmt.setString(2, str);
			pstmt.setInt(3, offset);
			pstmt.setInt(4, countArticles);
			rsList = pstmt.executeQuery();
			while(rsList.next()) {
				list.add(new BoardVO().setQseq(rsList.getInt(1))
													.setSubject(rsList.getString(2))
													.setContent(rsList.getString(3))
													.setReply(rsList.getString(4))
													.setId(rsList.getString(5))
													.setReq(rsList.getString(6))
													.setIndate(rsList.getDate(7)));
			}
			objList[1] = list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rsList != null) rsList.close();
				if(rsTotal != null) rsTotal.close();
				if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return objList;
	}
	
	public Object[] getIdBoardList(int currentPage,int countArticles, String id) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rsTotal = null;
		ResultSet rsList = null;
		Object[] objList = new Object[2];
		List<BoardVO> list = new ArrayList<>();
		int offset = (currentPage-1)*countArticles;
		
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rsTotal = stmt.executeQuery("SELECT COUNT(QSEQ) FROM QNA");
			if(rsTotal.next()) {
				objList[0] = rsTotal.getInt(1);
			}
			
			pstmt = conn.prepareStatement("SELECT * FROM QNA WHERE ID=? ORDER BY QSEQ DESC LIMIT ?, ?");
			pstmt.setString(1, id);
			pstmt.setInt(2, offset);
			pstmt.setInt(3, countArticles);
			rsList = pstmt.executeQuery();
			while(rsList.next()) {
				list.add(new BoardVO().setQseq(rsList.getInt(1))
													.setSubject(rsList.getString(2))
													.setContent(rsList.getString(3))
													.setReply(rsList.getString(4))
													.setId(rsList.getString(5))
													.setReq(rsList.getString(6))
													.setIndate(rsList.getDate(7)));
			}
			objList[1] = list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rsList != null) rsList.close();
				if(rsTotal != null) rsTotal.close();
				if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return objList;
	}
	
	public void insertQna(String subject, String content, String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO QNA(subject,CONTENT,ID) VALUES(?,?,?)");
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}
		
	public BoardVO modifyQna(String subject, String content, int qseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO board = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("UPDATE QNA SET SUBJECT = ?, CONTENT =? WHERE QSEQ=?");
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, qseq);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = conn.prepareStatement("SELECT * FROM QNA WHERE QSEQ =?");
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
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
				if(rs!= null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return board;
	}
}

	
	/*public int getTotalArticles() {
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
	}*/

