package modelclasses;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	private static final long serialVersionUID = -7222146066645666942L;
	public String userid;
	public String username;
	public String lastlogin;
	
	public String getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
