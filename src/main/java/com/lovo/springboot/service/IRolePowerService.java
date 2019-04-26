package com.lovo.springboot.service;

public interface IRolePowerService {
    /**
     * 给某个角色添加权限
     * @param addPowerName
     * @param rid
     */
    public void addRolePower(String addPowerName,String rid);

    /**
     * 删除某个角色的权限
     * @param delPowerName
     * @param rid
     */
    public void delRolePower(String delPowerName,String rid);
}
