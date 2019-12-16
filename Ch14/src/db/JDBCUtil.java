package db;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection con=null;
		Context init;
		try {
			init = new InitialContext();
			DataSource ds =(DataSource) init.lookup("java:comp/env/jdbc/testdb");
			con=ds.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs)  {
		try {
			rs.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("目乖己傍");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("费归己傍");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
