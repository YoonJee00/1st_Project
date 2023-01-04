package models;

import java.sql.Timestamp;

public class Member {
	private long id;
	private String username;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private Timestamp createDate;

	public Member() {

	}

	public Member(long id, String username, String pwd, String name, String phone, String email, Timestamp createDate) {
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.createDate = createDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
