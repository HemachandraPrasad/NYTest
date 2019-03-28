package com.sample.demo;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Users {	
	public Users() {		
	}	
    private Long user_Id;
    private String ﬁrst_name;
    private String last_name;
    private String username ;
    private String status;
    
	public Users(Long user_Id, String ﬁrst_name, String last_name, String username, String status) {
		super();
		this.user_Id = user_Id;
		this.ﬁrst_name = ﬁrst_name;
		this.last_name = last_name;
		this.username = username;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Users [user_Id=" + user_Id + ", ﬁrst_name=" + ﬁrst_name + ", last_name=" + last_name + ", username="
				+ username + ", status=" + status + "]";
	}

	public Long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}

	public String getﬁrst_name() {
		return ﬁrst_name;
	}

	public void setﬁrst_name(String ﬁrst_name) {
		this.ﬁrst_name = ﬁrst_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}   

}
