package com.lovo.springboot.service;

public interface IUserRoleService {
    /**
     * 添加用户角色
     * @param addName 用户id字符串,多个
     */
    public void addUserList(String addName,String roleId);

    /**
     * 删除用户角色
     * @param delName 用户id字符串
     */
    public void delUserList(String delName,String roleId);
}
