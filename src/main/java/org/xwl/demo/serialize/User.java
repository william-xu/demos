package org.xwl.demo.serialize;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String userId;
	private String userName;
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
}
