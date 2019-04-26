package com.lovo.springboot.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * RolePowerEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_role_power")
public class RolePowerEntity {

	// Fields

	private String rpid;

   private RoleEntity role;

   private PowerEntity power;

	// Constructors

	/** default constructor */
	public RolePowerEntity() {
	}


	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rpid", unique = true, nullable = false, length = 32)
	public String getRpid() {
		return this.rpid;
	}

	public void setRpid(String rpid) {
		this.rpid = rpid;
	}

	@ManyToOne
	@JoinColumn(name="rid")
	public RoleEntity getRole() {
		return role;
	}


	public void setRole(RoleEntity role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name="pid")
	public PowerEntity getPower() {
		return power;
	}


	public void setPower(PowerEntity power) {
		this.power = power;
	}

	

}