package vo;

public class ActionForward {
	private String path; //URL林家
	private boolean redirect; //器况爹 规过(true==redirect, false=dispatcher)
	
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
