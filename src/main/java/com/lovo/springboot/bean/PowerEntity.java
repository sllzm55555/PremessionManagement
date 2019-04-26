package com.lovo.springboot.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * PowerEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "p_power")
public class PowerEntity{

	//权限id
	private String pid;
	//权限名
	private String pname;
	//权限资源
	private String puri;
	
    private Set<RolePowerEntity> setRolePower;
	// Constructors

	/** default constructor */
	public PowerEntity() {
	}


	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "pid", unique = true, nullable = false, length = 32)
	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Column(name = "pname", length = 48)
	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Column(name = "puri", length = 48)
	public String getPuri() {
		return this.puri;
	}

	public void setPuri(String puri) {
		this.puri = puri;
	}

	@OneToMany(mappedBy="power")
	public Set<RolePowerEntity> getSetRolePower() {
		return setRolePower;
	}


	public void setSetRolePower(Set<RolePowerEntity> setRolePower) {
		this.setRolePower = setRolePower;
	}

}