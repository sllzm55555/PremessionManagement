package com.lovo.springboot.bean;

public class UserRoleDTO {

    private UserEntity userEntity;
    private RoleEntity roleEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public UserRoleDTO() {
    }

    public UserRoleDTO(UserEntity userEntity, RoleEntity roleEntity) {
        this.userEntity = userEntity;
        this.roleEntity = roleEntity;
    }
}
