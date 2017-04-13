package bean;

public class UserInfoBean {

	private String id = null;
	private String login_id = null;
	private String password = null;

	public UserInfoBean(String id, String login_id, String password) {
		super();
		this.id = id;
		this.login_id = login_id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void writeLog() {
		System.out.println("id:" + id);
		System.out.println("login_id:" + login_id);
		System.out.println("pass:" + password);
	}

}
