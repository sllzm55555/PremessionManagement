package com.lovo.springboot.service;

import com.lovo.springboot.bean.PowerEntity;
import com.lovo.springboot.dto.PowerDto;

import java.util.List;

public interface IPowerService {
    public void savePowerEntity(PowerEntity powerEntity);

    /**
     * 得到所有的权限
     * @return
     */
    public List<PowerEntity> getAllPower();

    /**
     * 得到该角色所拥有的所有权限
     * @param rid
     * @return
     */
    public List<PowerEntity> getPowerListByRoleId(String rid);

    /**
     * 根据该角色拥有的权限
     * 得到所有不属于该角色的权限
     * @param powerList 该角色拥有的权限
     * @return
     */
    public List<PowerEntity> getPowerListNoByRoleId(List<PowerEntity> powerList);

    /**
     * 根据用户名和密码查询出权限资源集合
     * @param userName 用户名
     * @param password 密码
     * @return 权限集合DTO
     */
    public List<PowerDto>  findPowerDtoListByUserNameAndPassword(String userName, String password);
}
