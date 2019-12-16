import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Member {
	public int memberCheck(HttpServletRequest request) {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		int check=0; //0:성공 -1:실패
		//db접근후확인
		//db test code id길이가 4일경우 로그인 성공으로 확인
		if(id.length()==4) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}else{
			check=-1;
		}
		return check;
	}
}
