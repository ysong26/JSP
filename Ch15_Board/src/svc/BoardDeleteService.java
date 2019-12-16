package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JDBCUtil;

public class BoardDeleteService {
	public boolean delectArticle(int board_num) {
		BoardDAO boarddao = BoardDAO.getInstance(); //boarddao ��ü ����(�̱���)
		Connection con=JDBCUtil.getConnection(); //db����
		boarddao.setConnection(con);
		int count=boarddao.deleteArticle(board_num);
			boolean isWriteSuccess=false;
		if(count>0) {
			JDBCUtil.commit(con);
			isWriteSuccess=true;
		}else {
			JDBCUtil.roolback(con);
		}
		JDBCUtil.close(con); //Ŭ����
			return isWriteSuccess;
	}
}
