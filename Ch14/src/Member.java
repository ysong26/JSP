import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Member {
	public int memberCheck(HttpServletRequest request) {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		int check=0; //0:���� -1:����
		//db������Ȯ��
		//db test code id���̰� 4�ϰ�� �α��� �������� Ȯ��
		if(id.length()==4) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}else{
			check=-1;
		}
		return check;
	}
}
