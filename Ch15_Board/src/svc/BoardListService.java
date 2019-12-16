package svc;

import static db.JDBCUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;

public class BoardListService {
	public ArrayList<BoardBean> getArticleList(int page, int limit){
		Connection con=getConnection(); //DB연결정보 생성
		BoardDAO boardDAO = BoardDAO.getInstance(); //BoardDAO 객체(boarddao)생성
		boardDAO.setConnection(con); //DB연결정보 넘겨주기
		ArrayList<BoardBean> articleList=null;
		articleList=boardDAO.selectArticleList(page,limit); //게시글 목록
		close(con);
		return articleList;
	}
}
