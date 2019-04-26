package com.lovo.springboot.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * UserEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_user")
public class UserEntity{

	// Fields

	private String uid;
	private String uname;
	private String upasss;
	
    private Set<UserRoleEntity> setUserRole;
	// Constructors

	/** default constructor */
	public UserEntity() {
	}

	/** full constructor */
	public UserEntity(String uname, String upasss) {
		this.uname = uname;
		this.upasss = upasss;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "uid", unique = true, nullable = false, length = 32)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "uname", length = 48)
	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Column(name = "upasss", length = 48)
	public String getUpasss() {
		return this.upasss;
	}

	public void setUpasss(String upasss) {
		this.upasss = upasss;
	}
	@OneToMany(mappedBy="user")
	public Set<UserRoleEntity> getSetUserRole() {
		return setUserRole;
	}

	public void setSetUserRole(Set<UserRoleEntity> setUserRole) {
		this.setUserRole = setUserRole;
	}

}