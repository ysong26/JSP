package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
public  class BoardListAction implements Action{
@Override
public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	BoardListService boardListService = new BoardListService();
	ArrayList<BoardBean> articleList
	= boardListService.getArticleList(1, 20); //test code;
	ActionForward forward = new ActionForward();
	
	request.setAttribute("articleList",articleList);
	forward.setPath("boardList.jsp");
	forward.setRedirect(false);
	return forward;

	}
}