package webapps;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBAction {
	static private DBAction instance = new DBAction();
	private Connection conn;
	private DataSource ds;

	public DBAction() {
//		String driver = "com.mysql.cj.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/exercise?characterEncoding=UTF-8&serverTimezone=UTC";
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url,"root","java");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		try {
			InitialContext initctx = new InitialContext();
			Context ctx = (Context)initctx.lookup("java:/comp/env");
			ds = (DataSource)ctx.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static public DBAction getInstance() {
		if(instance == null)
			instance = new DBAction();
		
		return instance;
	}
	
	public Connection getConnection() {
		try {
			conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void close() {
		try {
			if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
