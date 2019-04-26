package com.lovo.springboot.dto;

public class PowerDto {
	//用户名
     private String userName;
     //权限资源
     private String powerUri;

     public PowerDto(){}

	 public PowerDto(String userName, String powerUri) {
		this.userName = userName;
		this.powerUri = powerUri;
	 }

	 public String getUserName() {
		return userName;
	 }
	 public void setUserName(String userName) {
		this.userName = userName;
	 }
	 public String getPowerUri() {
		return powerUri;
	 }
	 public void setPowerUri(String powerUri) {
		this.powerUri = powerUri;
	 }
     
     
}
