package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DBAction;
import dto.AddressVO;

public class AddressDAO {
	private static AddressDAO instance = new AddressDAO();
	
	public static AddressDAO getInstance() {
		if(instance == null)
			instance = new AddressDAO();
		return instance;
	}
	
	@SuppressWarnings("null")
	public ArrayList<AddressVO> getZipcode(String dong){
		ArrayList<AddressVO> list = null;
		Connection conn = DBAction.getInstance().getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM ZIPCODE WHERE DONG LIKE '%"+dong+"%'");
			list = new ArrayList<AddressVO>();
			while(rs.next()) {
				list.add(new AddressVO().setZipcode(rs.getString("zipcode"))
											.setSido(rs.getString("sido"))
											.setGugun(rs.getString("gugun"))
											.setDong(rs.getString("dong"))
											.setRi(rs.getString("ri"))
											.setBldg(rs.getString("bldg"))
											.setBunji(rs.getString("bunji")));
			}
		} catch(SQLException e) {
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
}
