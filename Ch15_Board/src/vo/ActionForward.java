package vo;

public class ActionForward {
	private String path; //URL�ּ�
	private boolean redirect; //������ ���(true==redirect, false=dispatcher)
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	
}
