package user;

import java.util.ArrayList;
public class User {
	private static ArrayList<User> user_list = new ArrayList();
	private String u_id;
	private String u_name;
	private String u_pwd;
	public User(String u_id, String u_name, String u_pwd) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pwd = u_pwd;
	}
	public static User getUserByID(String uid) {
		User result = null;
		for(User u: getUser_list()){
			if(u.getU_id().equals(uid)) {
				result = u;
			}
		}
		return result;
	}
	public static ArrayList<User> getUser_list() {
		return user_list;
	}
	public static void setUser_list(ArrayList<User> user_list) {
		User.user_list = user_list;
	}
	public String getU_id() {
		return u_id;
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
