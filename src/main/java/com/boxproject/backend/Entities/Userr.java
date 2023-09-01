package com.boxproject.backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "userdetails")
public class Userr {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String username;
    private String password;
    private Integer usermobile;
	private String role = "USER";

    public Userr(Integer userid, String username, String password,Integer usermobile,String role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.usermobile = usermobile;
		this.role = role;
	}

	public Userr(){
		
	}

    public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

     public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

     public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public Integer getUsermobile() {
		return usermobile;
	}
	public void setUsermobile(Integer usermobile) {
		this.usermobile = usermobile;
	}

	public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", usermobile="
                + usermobile + ",role="+ role + "]";
    }
}
