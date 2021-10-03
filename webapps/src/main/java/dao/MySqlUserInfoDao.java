package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.UserInfo;
import webapps.DBAction;

public class MySqlUserInfoDao {
	public List<UserInfo> selectList() throws Exception{
		ArrayList<UserInfo> userinfo = null;
		Connection conn = DBAction.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM USERINFO ORDER BY NAME ASC");
			userinfo= new ArrayList<>();
			
			while(rs.next()) {
				UserInfo user = new UserInfo().setId(rs.getString(1)).
											setPw(rs.getString(2)).
											setName(rs.getString(3));
				userinfo.add(user);
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
		return userinfo;
	}
	
	public UserInfo exist(String id, String password) {
		UserInfo userinfo = new UserInfo();
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM USERINFO WHERE ID=? AND PW=?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				userinfo.setId(rs.getString("id")).setPw(rs.getString("pw")).setName(rs.getString("name"));
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
		return userinfo;
	}
	
	public boolean insert(UserInfo userinfo) {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		if(userinfo != null) {
			try {
				pstmt = conn.prepareStatement("INSERT INTO USERINFO VALUES(?,?,?)");
				pstmt.setString(1, userinfo.getId());
				pstmt.setString(2, userinfo.getPw());
				pstmt.setString(3, userinfo.getName());
				pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {}
			}
			return true;
		}else {
			return false;
		}
	}
	
	public UserInfo selectone(String id) throws Exception{
		UserInfo userinfo = null;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM USERINFO WHERE ID=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userinfo= new UserInfo().setId(id).setPw(rs.getString("pw")).setName(rs.getString("name"));
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
		return userinfo;
	}
	
	public void update(String id, String pw, String name) throws Exception{
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("UPDATE USERINFO SET PW=?, NAME=? WHERE ID=?");
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}
	
	public void delete(String id) throws Exception {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("DELETE FROM USERINFO WHERE ID=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}
	
	public boolean overlappedID(String id) {
		boolean result = false;
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			pstmt = conn.prepareStatement("SELECT IF(ID=?,'TRUE','FALSE') as result FROM USERINFO");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return result;
	}
}
