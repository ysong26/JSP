

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boardbean.boardbean;
import boarddao.BoardDAO;
import db.JDBCUtil;


/**
 * Servlet implementation class test3Servlet
 */
@WebServlet("*.bo")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String command = requestURI.substring(contextPath.length());
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Connection con = JDBCUtil.getConnection();
		BoardDAO boarddao = BoardDAO.getInstance();
		boardbean bd1 = new boardbean();
		RequestDispatcher dispatcher = null;
		boarddao.setConnection(con);
		bd1=boarddao.resultDB(id);
		HttpSession session = request.getSession();
		
		if(requestURI.equals("/Ch14/test3/LoginServlet.bo")) {
			if(bd1.getId().equals(id)&& bd1.getPw().equals(pw)) {
				request.setAttribute("check", 0);
				session.setAttribute("id", id);
				dispatcher=request.getRequestDispatcher("test1.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("check", -1);
				dispatcher=request.getRequestDispatcher("test1.jsp");
				dispatcher.forward(request, response);
			}
			JDBCUtil.close(con);
			
		}else if(requestURI.equals("/Ch14/test3/logoutServlet.bo")) {
				System.out.println(requestURI);
				session.removeAttribute("check");
				session.removeAttribute("id");
				dispatcher=request.getRequestDispatcher("test1.jsp");
				dispatcher.forward(request, response);
				
		}
	}
}