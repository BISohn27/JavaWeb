package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBAction;
import dto.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		if(instance != null)
			instance = new MemberDAO();
		return instance;
	}
	
	public void insertMember(MemberVO member) {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO MEMBER (ID,PWD,NAME,EMAIL,ZIP_NUM,ADDRESS,PHONE) VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getZipcode());
			pstmt.setString(6, member.getAddress());
			pstmt.setString(7, member.getPhone());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}
	
	public MemberVO existMember(String id, String pwd) {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member=null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE ID=? AND PWD=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO().setId(rs.getString("id"))
										.setPwd(rs.getString("pwd"))
										.setName(rs.getString("name"))
										.setEmail(rs.getString("email"))
										.setZipcode(rs.getString("zip_num"))
										.setAddress(rs.getString("address"))
										.setPhone(rs.getString("phone"))
										.setUseyn(rs.getString("useyn"))
										.setIndate(rs.getString("indate"));
						
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
		return member;
	}
	
	public boolean checkId(String id) {
		boolean idCheck=false;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE ID=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				idCheck = true;
			}else {
				idCheck = false;
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
		return idCheck;
	}
	
	public int updateMemberInfo(String id,String email, String zipcode, String address, String phone) {
		int result=-1;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBER SET EMAIL=?, ZIPCODE=?, ADDRESS=?, PHONE=? WHERE ID=?");
			pstmt.setString(1, email);
			pstmt.setString(2, zipcode);
			pstmt.setString(3, address);
			pstmt.setString(4, phone);
			pstmt.setString(5, id);
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
	
	public int updatePassword(String id, String pwd) {
		int result=-1;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBER SET PWD=? WHERE ID=?");
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
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
	
	public int deleteMember(String id) {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		int result =-1;
		try {
			pstmt = conn.prepareStatement("update member set useyn='n' WHERE ID=?");
			pstmt.setString(1, "one");
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
