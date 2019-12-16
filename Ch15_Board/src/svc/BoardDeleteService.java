package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JDBCUtil;

public class BoardDeleteService {
	public boolean delectArticle(int board_num) {
		BoardDAO boarddao = BoardDAO.getInstance(); //boarddao ∞¥√º ª˝º∫(ΩÃ±€≈Ê)
		Connection con=JDBCUtil.getConnection(); //dbø¨∞·
		boarddao.setConnection(con);
		int count=boarddao.deleteArticle(board_num);
			boolean isWriteSuccess=false;
		if(count>0) {
			JDBCUtil.commit(con);
			isWriteSuccess=true;
		}else {
			JDBCUtil.roolback(con);
		}
		JDBCUtil.close(con); //≈¨∑Œ¡Ó
			return isWriteSuccess;
	}
}
