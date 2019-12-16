package svc;

import static db.JDBCUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import db.JDBCUtil;
import vo.BoardBean;

public class BoardWriteProService {

	public boolean registArticle(BoardBean boardbean){
	//1.������ �� ��ȣ �˾ƿ���
		Connection con=getConnection(); //DB����
		BoardDAO boardDAO = BoardDAO.getInstance(); //BoardDAO ��ü(boarddao)����
		boardDAO.setConnection(con);
		int numMax=boardDAO.boardNumMax();
		boolean isWriteSuccess=false;
		
	//2.������ �� ��ȣ+1 �۹�ȣ�� �۾���
		boardbean.setBoard_num(numMax+1); //�ۼ��� �� ��ȣ�� ������ �۹�ȣ +1
		int insertCount=boardDAO.insertArticle(boardbean);
		if(insertCount>0) {
			JDBCUtil.commit(con);
			isWriteSuccess=true;
		}else {
			JDBCUtil.roolback(con);
		}
		JDBCUtil.close(con);
		return isWriteSuccess;
	}
}
