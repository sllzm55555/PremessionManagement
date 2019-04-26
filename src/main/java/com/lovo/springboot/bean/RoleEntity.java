package com.lovo.springboot.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * RoleEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_role")
public class RoleEntity {

	// Fields

	private String rid;

	private String rname;

	private String roleDescribe;

	public String getRoleDescribe() {
		return roleDescribe;
	}

	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}

	private Set<UserRoleEntity> setUserRole;
	

    private Set<RolePowerEntity> setRolePower;

	/** default constructor */
	public RoleEntity() {
	}

	/** full constructor */
	public RoleEntity(String rname) {
		this.rname = rname;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rid", unique = true, nullable = false, length = 32)
	public String getRid() {
		return this.rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	@Column(name = "rname", length = 48)
	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	@OneToMany(mappedBy="role")
	public Set<UserRoleEntity> getSetUserRole() {
		return setUserRole;
	}

	public void setSetUserRole(Set<UserRoleEntity> setUserRole) {
		this.setUserRole = setUserRole;
	}

	@OneToMany(mappedBy="role")
	public Set<RolePowerEntity> getSetRolePower() {
		return setRolePower;
	}

	public void setSetRolePower(Set<RolePowerEntity> setRolePower) {
		this.setRolePower = setRolePower;
	}

}