package com.shzx.role.entity;

import java.io.Serializable;

public class RoleInfo implements Serializable{

	private String id;
	private String roleName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}
