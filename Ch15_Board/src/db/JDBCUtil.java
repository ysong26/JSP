package db;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection con=null;
		try{
			Context init=new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/aaa");
			con=ds.getConnection();
			con.setAutoCommit(false);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("目乖 己傍");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void roolback(Connection con) {
		try {
			con.rollback();
			System.out.println("费归 己傍");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}