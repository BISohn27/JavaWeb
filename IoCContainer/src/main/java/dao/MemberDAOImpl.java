package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import dto.Member;

public class MemberDAOImpl implements MemberDAO{
	private DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	@Override
	public List<Member> selectList() throws Exception{
		return null;
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
		return 0;
	}
	@Override
	public Member selectOne(int no) throws Exception{
		return null;
	}
	@Override
	public int update(Member member) throws Exception{
		return 0;
	}
	@Override
	public Member exist(String email, String password) throws Exception{
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			pstmt = conn.prepareStatement("SELECT MNAME,EMAIL FROM MEMBERS WHERE EMAIL=? AND PWD=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member = new Member().setName(rs.getString("MNAME"))
									.setEmail(rs.getString("EMAIL"));
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
