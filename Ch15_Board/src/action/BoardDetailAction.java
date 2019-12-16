package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num"));
		BoardDetailService bds=new BoardDetailService();
		BoardBean boardbean=bds.getArticle(num);
		ActionForward forward=new ActionForward();
		
		request.setAttribute("boardbean", boardbean);
		forward.setPath("qna_board_view.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
