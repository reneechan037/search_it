package Model.user;

public class Officer extends User{
	private Role r;
	public Officer(String u_id, String u_name, String u_pwd,Role r) {
		super(u_id, u_name, u_pwd);
		this.r = r;
	}

}
