package svc;

import java.sql.Connection;

import dao.BoardDAO;
import static db.JDBCUtil.*;
import vo.BoardBean;

public class BoardDetailService {
	public BoardBean getArticle(int board_num) {
		//1. ��ȸ�� 1������Ʈ
		Connection con=getConnection(); //DB����
		BoardDAO boardDAO = BoardDAO.getInstance(); //BoardDAO ��ü(boarddao)����
		boardDAO.setConnection(con); //DB�������� �Ѱ��ֱ�
		int updateCount=boardDAO.updateReadCount(board_num); //��ȸ�� ������Ʈ
		if(updateCount>0) {
			commit(con);     //�̻������ db
		}else {
			roolback(con);  //���� ������ ����
		}
		//2. ��ȣ�� �󼼳��� ��������
		BoardBean article=boardDAO.selectArticle(board_num);
		close(con);
		return article;
	}
}
