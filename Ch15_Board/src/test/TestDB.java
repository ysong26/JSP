package test;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import db.JDBCUtil;
import svc.BoardDeleteService;
import vo.BoardBean;

/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		BoardDAO boarddao =BoardDAO.getInstance();
//		boarddao.setConnection(JDBCUtil.getConnection());
//		System.out.println(boarddao.selectListCount());
		
		//���� �׽�Ʈ
//		BoardDetailService bdstest = new BoardDetailService();
//		BoardBean article=bdstest.getArticle(1);
//		System.out.println(article.getBoard_content());
		
		/* �����׽�Ʈ DAO
		BoardDAO boarddao = BoardDAO.getInstance(); //boarddao ��ü ����(�̱���)
		Connection con=JDBCUtil.getConnection(); //db����
		boarddao.setConnection(con);
		boarddao.deleteArticle(10);
		JDBCUtil.commit(con); //Ŀ�Դ���
		JDBCUtil.close(con); //Ŭ����
		*/
		
		//�����׽�Ʈ service
		BoardDeleteService bds = new BoardDeleteService();
		bds.delectArticle(8);
		
		/*//�����׽�Ʈ DAO
		BoardDAO boarddao = BoardDAO.getInstance(); //boarddao ��ü ����(�̱���)
		Connection con=JDBCUtil.getConnection(); //db����
		boarddao.setConnection(con);
		BoardBean article = new BoardBean();
		article.setBoard_subject("����������");
		article.setBoard_content("�����ѳ���");
		article.setBoard_num(2);
		boarddao.modifyArticle(article);
		JDBCUtil.commit(con); //Ŀ�Դ���
		JDBCUtil.close(con); //Ŭ����*/
		
	}

}
