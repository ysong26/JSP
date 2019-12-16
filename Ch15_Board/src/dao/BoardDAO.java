package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.JDBCUtil;
import vo.BoardBean;

public class BoardDAO {
	Connection con=null;//db연결
	
	/********싱글톤 패턴********/
	private static BoardDAO boarddao=null;
	
	//생성자 접근금지
	private BoardDAO(){
		
	}
	//객체 생성을 위한 메서드
	public static BoardDAO getInstance() {
		if(boarddao==null) {
			boarddao=new BoardDAO();
		}
		return boarddao;
	}
	/***********************/
	
	//0.DB연결
	public void setConnection(Connection con) {
		this.con=con;//db연결

	}
	
	//1.글내용 상세보기
	public BoardBean selectArticle(int board_num) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardBean boardBean=null;
	
		try {
		pstmt=con.prepareStatement("select board_subject, board_file, board_content from board where board_num=?;");
		pstmt.setInt(1, board_num); //쿼리완성
		rs=pstmt.executeQuery(); //db조회후 결과받기
		if(rs.next()) {
			boardBean=new BoardBean();
			boardBean.setBoard_subject(rs.getString("board_subject"));
			boardBean.setBoard_file(rs.getString("board_file"));
			boardBean.setBoard_content(rs.getNString("board_content"));
			}
		}catch(Exception ex) {
			System.out.println("글 상세보기 에러:"+ex);
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return boardBean;
 	}
	//2.작성된 마지막 글 번호 확인
	public int boardNumMax() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int numMax=0;
		
		try {
		pstmt=con.prepareStatement("SELECT max(board_num) FROM board;");
		rs=pstmt.executeQuery(); //db조회후 결과받기
		if(rs.next()) {
			numMax=rs.getInt(1);

			}
		}catch(Exception ex) {
			System.out.println("작성된 마지막 글 번호 확인 에러:"+ex);
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return numMax;
	}

	//3.조회수 업데이트
	public int updateReadCount(int board_num) {
		PreparedStatement pstmt=null;
		int updateCount=0;

		try {
		pstmt=con.prepareStatement("UPDATE board SET board_readcount=board_readcount+1 WHERE board_num=?;");
		pstmt.setInt(1, board_num); //쿼리완성
		updateCount=pstmt.executeUpdate(); //db업데이트
		}catch(Exception ex) {
			System.out.println("조회수 업데이트 에러:"+ex);
		}finally {

			JDBCUtil.close(pstmt);
		}
		return updateCount;
		
	}
	//4.전체 게시글 개수
	public int selectListCount() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;

		try {
		pstmt=con.prepareStatement("SELECT COUNT(*) FROM board;");
		rs=pstmt.executeQuery(); //db조회후 결과받기
		if(rs.next()) {
			count=rs.getInt(1);
			}
		}catch(Exception ex) {
			System.out.println("전체 게시글 개수 확인 에러:"+ex);
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return count;
	}
	//5.글 작성
	public int insertArticle(BoardBean article) {
		PreparedStatement pstmt=null;
		int updateCount=0;
		
		try {
		pstmt=con.prepareStatement("INSERT INTO board VALUES(?, ?, ?, ?, ?, ?, 0, now(), ?, 0, 0);");
		pstmt.setInt(1,article.getBoard_num());
		pstmt.setString(2,article.getBoard_name());
		pstmt.setString(3,article.getBoard_pass());
		pstmt.setString(4,article.getBoard_content());
		pstmt.setString(5,article.getBoard_file());
		pstmt.setString(6,article.getBoard_subject());
		pstmt.setInt(7,article.getBoard_num());
		updateCount=pstmt.executeUpdate(); //db업데이트
		System.out.println(updateCount);
		}catch(Exception ex) {
			System.out.println("글 작성 에러:"+ex);
		}finally {
			JDBCUtil.close(pstmt);
		}
		return updateCount;
	}
	
	//6.글 삭제
			public int deleteArticle(int board_num) {
				PreparedStatement pstmt=null;
				int Count=0;
				
				try {
				pstmt=con.prepareStatement("DELETE FROM board WHERE board_num=?;");
				pstmt.setInt(1, board_num);
				Count=pstmt.executeUpdate(); //쿼리 실행
				}catch(Exception ex) {
					System.out.println("글 삭제 에러:"+ex);
				}finally {
					JDBCUtil.close(pstmt);
				}
				return Count;
			}
			
	//7.글 수정
		public int modifyArticle(BoardBean article) {
			PreparedStatement pstmt=null;
			int updateCount=0;
			try {
				pstmt=con.prepareStatement("UPDATE board SET board_subject=?, board_content=? WHERE board_num=?;");
				pstmt.setString(1,article.getBoard_subject());
				pstmt.setString(2,article.getBoard_content());
				pstmt.setInt(3,article.getBoard_num());
				
			updateCount=pstmt.executeUpdate(); //db업데이트
			}catch(Exception ex) {
				System.out.println("글 수정 에러:"+ex);
			}finally {
				JDBCUtil.close(pstmt);
			}
			return updateCount;
		}
		
	//8. 글 목록보기
		public ArrayList<BoardBean> selectArticleList(int page, int limit) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			BoardBean boardBean=null;
			ArrayList<BoardBean> articleList=new ArrayList<BoardBean>();
			try {
			pstmt=con.prepareStatement("SELECT * FROM board ORDER BY re_ref DESC, re_step LIMIT ?,?;");
			pstmt.setInt(1, (page-1)*limit); //읽기 시작할 행 번호
			pstmt.setInt(2, limit); //하나의 페이지에 보여줄 개수
			rs=pstmt.executeQuery(); //db조회후 결과받기
			while(rs.next()) {
				boardBean=new BoardBean();
				boardBean.setBoard_num(rs.getInt("board_num")); //글번호
				boardBean.setBoard_subject(rs.getString("board_subject")); //제목
				boardBean.setBoard_name(rs.getString("board_name")); //작성자
				boardBean.setBoard_date(rs.getDate("board_date"));//날짜
				boardBean.setBoard_readcount(rs.getInt("board_readcount"));//조회수
				boardBean.setRe_lev(rs.getInt("re_lev")); //답글 레벨
				articleList.add(boardBean);
				}
			}catch(Exception ex) {
				System.out.println("글 목록보기 에러:"+ex);
			}finally {
				JDBCUtil.close(rs);
				JDBCUtil.close(pstmt);
			}
			return articleList;
		}
}