package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import controller.Component;
import dto.Member;

@Component("MemberDAOImpl")
public class MemberDAOImpl implements MemberDAO{
	private DataSource ds;
	
	public void setDataSource(DataSource ds) { 
	this.ds = ds; 
	}
	 
	@Override
	public List<Member> selectList() throws Exception{
		List<Member> list = null;
		Connection conn = ds.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM MEMBERS");
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new Member().setNo(rs.getInt(1))
										.setEmail(rs.getString(2))
										.setPassword(rs.getString(3))
										.setName(rs.getString(4))
										.setCreateDate(rs.getDate(5))
										.setModifiedDate(rs.getDate(6)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs !=null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return list;
	}
	
	@Override
	public int insert(Member member) throws Exception{
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		int result=-1;
		try {
			pstmt = conn.prepareStatement("INSERT INTO MEMBERS(EMAIL,PWD,MNAME) VALUES(?,?,?)");
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3,member.getName());
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
	
	@Override
	public int delete(int no) throws Exception{
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			pstmt = conn.prepareStatement("DELETE FROM MEMBERS WHERE MNO=?");
			pstmt.setInt(1, no);
			if( (result = pstmt.executeUpdate()) != -1)
				return result;
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
	@Override
	public Member selectOne(int no) throws Exception{
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBERS WHERE MNO=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Member().setNo(rs.getInt(1))
									.setEmail(rs.getString(2))
									.setPassword(rs.getString(3))
									.setName(rs.getString(4))
									.setCreateDate(rs.getDate(5))
									.setModifiedDate(rs.getDate(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		
		return null;
	}
	@Override
	public int update(Member member) throws Exception{
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBERS SET EMAIL=?, MNAME=?, PWD=? MOD_DATE=NOW() WHERE MNO=?");
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getName());
			pstmt.setString(3,member.getPassword());
			pstmt.setInt(4, member.getNo());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return member.getNo();
	}
	
	@Override
	public Member exist(String email, String password) throws Exception{
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBERS WHERE EMAIL=? AND PWD=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member = new Member().setNo(rs.getInt(1))
										.setEmail(rs.getString(2))
										.setPassword(rs.getString(3))
										.setName(rs.getString(4))
										.setCreateDate(rs.getDate(5))
										.setModifiedDate(rs.getDate(6));
						
			}else {
				member= null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return member;
	}
}
