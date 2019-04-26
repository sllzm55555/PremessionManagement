package com.lovo.springboot.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * UserRoleEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_user_role")
public class UserRoleEntity {

	// Fields

	private String urId;

    private UserEntity user;

    private RoleEntity role;

	// Constructors

	/** default constructor */
	public UserRoleEntity() {
	}

	
	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "urId", unique = true, nullable = false, length = 32)
	public String getUrId() {
		return this.urId;
	}

	public void setUrId(String urId) {
		this.urId = urId;
	}

	@ManyToOne
	@JoinColumn(name="uid")
	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name="rid")
	public RoleEntity getRole() {
		return role;
	}


	public void setRole(RoleEntity role) {
		this.role = role;
	}

	
}