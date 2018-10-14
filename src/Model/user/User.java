package Model.user;

import java.util.ArrayList;
public class User {
	private String u_id;
	private String u_name;
	private String u_pwd;

	public User(String u_id, String u_name, String u_pwd) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pwd = u_pwd;
	}

    public User(String u_name, String u_pwd) {
        this.u_name = u_name;
        this.u_pwd = u_pwd;
    }

	public String getU_id() {
		return u_id;
	}

	public boolean userDuplicated(User newUser) {
	    return u_name.equals(newUser.u_name)?true:false;
    }

    public boolean compare(String u_name, String u_pwd) {
	    if (this.u_name.equals(u_name) && this.u_pwd.equals(u_pwd))
	        return true;
	    return false;
    }

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
}
