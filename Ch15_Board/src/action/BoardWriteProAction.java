package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BoardDetailService;
import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 String uploadPath=("c:/upload"); //실제 서버의 폴더위치
		 int size= 1024*1024*10; //10메가(기본값 byte)
		 
		 MultipartRequest multi = new MultipartRequest(request,uploadPath,
		   size,"UTF-8",new DefaultFileRenamePolicy());
		 
		 String board_name=multi.getParameter("BOARD_NAME");
		 String board_pass=multi.getParameter("BOARD_PASS");
		 String board_subject=multi.getParameter("BOARD_SUBJECT");
		 String board_content=multi.getParameter("BOARD_CONTENT");
		 String board_file= multi.getFilesystemName("BOARD_FILE"); 
		 
		 BoardBean boardbean=new BoardBean();
		 boardbean.setBoard_name(board_name);
		 boardbean.setBoard_pass(board_pass);
		 boardbean.setBoard_subject(board_subject);
		 boardbean.setBoard_content(board_content);
		 boardbean.setBoard_file(board_file);
		 
		 
		 BoardWriteProService boardWriteProService= new BoardWriteProService();
		 boardWriteProService.registArticle(boardbean);
		 
		 ActionForward forward = new ActionForward();
		 forward.setPath("boardList.bo");
		 forward.setRedirect(true);
		 
		 
		return forward;
	}

}
