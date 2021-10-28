package naverAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
	private static LoginService instance = new LoginService();
	
	static public LoginService getInstance() {
		if(instance == null) instance = new LoginService();
		
		return instance;
	}
	
	public int login(String id, String pwd) {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBERS WHERE EMAIL =? AND PWD =?");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("MNAME");
				String fileName = APIExamTTS.getInstance().getWelcomeVoice(name);
				PlayMP3.getInstance().playMP3(fileName);
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return -1;
	}
}
