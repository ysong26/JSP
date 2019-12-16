package svc;

import static db.JDBCUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import db.JDBCUtil;
import vo.BoardBean;

public class BoardWriteProService {

	public boolean registArticle(BoardBean boardbean){
	//1.마지막 글 번호 알아오기
		Connection con=getConnection(); //DB연결
		BoardDAO boardDAO = BoardDAO.getInstance(); //BoardDAO 객체(boarddao)생성
		boardDAO.setConnection(con);
		int numMax=boardDAO.boardNumMax();
		boolean isWriteSuccess=false;
		
	//2.마지막 글 번호+1 글번호에 글쓰기
		boardbean.setBoard_num(numMax+1); //작성된 글 번호는 마지막 글번호 +1
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
