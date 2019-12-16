package boarddao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import boardbean.boardbean;
import db.JDBCUtil;

public class BoardDAO {
	
	Connection con = null;
	
	private BoardDAO() {}
	private static BoardDAO boardDao=null;
	
	public static BoardDAO getInstance() {
		if(boardDao==null) {
			boardDao = new BoardDAO();
		}
		return boardDao;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	//db등록
	public boardbean resultDB(String id) {
		
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		boardbean bd = new boardbean();
		
		try {
			pstmt=con.prepareStatement("select * from login where id=?");
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bd.setId(rs.getString("id"));
				bd.setPw(rs.getString("password"));
			}
			
			System.out.println("db확인 성공");
		}catch(Exception e){
			System.out.println("db확인 실패" + e);
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return bd;
	}
}
			