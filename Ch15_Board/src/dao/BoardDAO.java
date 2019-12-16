package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.JDBCUtil;
import vo.BoardBean;

public class BoardDAO {
	Connection con=null;//db����
	
	/********�̱��� ����********/
	private static BoardDAO boarddao=null;
	
	//������ ���ٱ���
	private BoardDAO(){
		
	}
	//��ü ������ ���� �޼���
	public static BoardDAO getInstance() {
		if(boarddao==null) {
			boarddao=new BoardDAO();
		}
		return boarddao;
	}
	/***********************/
	
	//0.DB����
	public void setConnection(Connection con) {
		this.con=con;//db����

	}
	
	//1.�۳��� �󼼺���
	public BoardBean selectArticle(int board_num) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardBean boardBean=null;
	
		try {
		pstmt=con.prepareStatement("select board_subject, board_file, board_content from board where board_num=?;");
		pstmt.setInt(1, board_num); //�����ϼ�
		rs=pstmt.executeQuery(); //db��ȸ�� ����ޱ�
		if(rs.next()) {
			boardBean=new BoardBean();
			boardBean.setBoard_subject(rs.getString("board_subject"));
			boardBean.setBoard_file(rs.getString("board_file"));
			boardBean.setBoard_content(rs.getNString("board_content"));
			}
		}catch(Exception ex) {
			System.out.println("�� �󼼺��� ����:"+ex);
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return boardBean;
 	}
	//2.�ۼ��� ������ �� ��ȣ Ȯ��
	public int boardNumMax() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int numMax=0;
		
		try {
		pstmt=con.prepareStatement("SELECT max(board_num) FROM board;");
		rs=pstmt.executeQuery(); //db��ȸ�� ����ޱ�
		if(rs.next()) {
			numMax=rs.getInt(1);

			}
		}catch(Exception ex) {
			System.out.println("�ۼ��� ������ �� ��ȣ Ȯ�� ����:"+ex);
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return numMax;
	}

	//3.��ȸ�� ������Ʈ
	public int updateReadCount(int board_num) {
		PreparedStatement pstmt=null;
		int updateCount=0;

		try {
		pstmt=con.prepareStatement("UPDATE board SET board_readcount=board_readcount+1 WHERE board_num=?;");
		pstmt.setInt(1, board_num); //�����ϼ�
		updateCount=pstmt.executeUpdate(); //db������Ʈ
		}catch(Exception ex) {
			System.out.println("��ȸ�� ������Ʈ ����:"+ex);
		}finally {

			JDBCUtil.close(pstmt);
		}
		return updateCount;
		
	}
	//4.��ü �Խñ� ����
	public int selectListCount() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;

		try {
		pstmt=con.prepareStatement("SELECT COUNT(*) FROM board;");
		rs=pstmt.executeQuery(); //db��ȸ�� ����ޱ�
		if(rs.next()) {
			count=rs.getInt(1);
			}
		}catch(Exception ex) {
			System.out.println("��ü �Խñ� ���� Ȯ�� ����:"+ex);
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return count;
	}
	//5.�� �ۼ�
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
		updateCount=pstmt.executeUpdate(); //db������Ʈ
		System.out.println(updateCount);
		}catch(Exception ex) {
			System.out.println("�� �ۼ� ����:"+ex);
		}finally {
			JDBCUtil.close(pstmt);
		}
		return updateCount;
	}
	
	//6.�� ����
			public int deleteArticle(int board_num) {
				PreparedStatement pstmt=null;
				int Count=0;
				
				try {
				pstmt=con.prepareStatement("DELETE FROM board WHERE board_num=?;");
				pstmt.setInt(1, board_num);
				Count=pstmt.executeUpdate(); //���� ����
				}catch(Exception ex) {
					System.out.println("�� ���� ����:"+ex);
				}finally {
					JDBCUtil.close(pstmt);
				}
				return Count;
			}
			
	//7.�� ����
		public int modifyArticle(BoardBean article) {
			PreparedStatement pstmt=null;
			int updateCount=0;
			try {
				pstmt=con.prepareStatement("UPDATE board SET board_subject=?, board_content=? WHERE board_num=?;");
				pstmt.setString(1,article.getBoard_subject());
				pstmt.setString(2,article.getBoard_content());
				pstmt.setInt(3,article.getBoard_num());
				
			updateCount=pstmt.executeUpdate(); //db������Ʈ
			}catch(Exception ex) {
				System.out.println("�� ���� ����:"+ex);
			}finally {
				JDBCUtil.close(pstmt);
			}
			return updateCount;
		}
		
	//8. �� ��Ϻ���
		public ArrayList<BoardBean> selectArticleList(int page, int limit) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			BoardBean boardBean=null;
			ArrayList<BoardBean> articleList=new ArrayList<BoardBean>();
			try {
			pstmt=con.prepareStatement("SELECT * FROM board ORDER BY re_ref DESC, re_step LIMIT ?,?;");
			pstmt.setInt(1, (page-1)*limit); //�б� ������ �� ��ȣ
			pstmt.setInt(2, limit); //�ϳ��� �������� ������ ����
			rs=pstmt.executeQuery(); //db��ȸ�� ����ޱ�
			while(rs.next()) {
				boardBean=new BoardBean();
				boardBean.setBoard_num(rs.getInt("board_num")); //�۹�ȣ
				boardBean.setBoard_subject(rs.getString("board_subject")); //����
				boardBean.setBoard_name(rs.getString("board_name")); //�ۼ���
				boardBean.setBoard_date(rs.getDate("board_date"));//��¥
				boardBean.setBoard_readcount(rs.getInt("board_readcount"));//��ȸ��
				boardBean.setRe_lev(rs.getInt("re_lev")); //��� ����
				articleList.add(boardBean);
				}
			}catch(Exception ex) {
				System.out.println("�� ��Ϻ��� ����:"+ex);
			}finally {
				JDBCUtil.close(rs);
				JDBCUtil.close(pstmt);
			}
			return articleList;
		}
}