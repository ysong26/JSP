package svc;

import static db.JDBCUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;

public class BoardListService {
	public ArrayList<BoardBean> getArticleList(int page, int limit){
		Connection con=getConnection(); //DB�������� ����
		BoardDAO boardDAO = BoardDAO.getInstance(); //BoardDAO ��ü(boarddao)����
		boardDAO.setConnection(con); //DB�������� �Ѱ��ֱ�
		ArrayList<BoardBean> articleList=null;
		articleList=boardDAO.selectArticleList(page,limit); //�Խñ� ���
		close(con);
		return articleList;
	}
}
