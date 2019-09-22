package cn.xhf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "S_USER")
public class User {
	
	private Long uid;
	private String username;
	private String nickname;
	private String password;
	@Column(name = "PHONECHECKCODE")
    private String phoneCheckCode;
	@Column(name = "CHECKCODE")
    private String checkCode;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneCheckCode() {
		return phoneCheckCode;
	}
	public void setPhoneCheckCode(String phoneCheckCode) {
		this.phoneCheckCode = phoneCheckCode;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", nickname=" + nickname + ", password=" + password
				+ ", phoneCheckCode=" + phoneCheckCode + ", checkCode=" + checkCode + "]";
	}
    
    

}
