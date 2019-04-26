package com.lovo.springboot.service;

import com.lovo.springboot.bean.RoleEntity;

import java.util.List;

public interface IRoleService {
    public void saveRoleEntity(RoleEntity roleEntity);

    /**
     * 查询所有的角色
     * @return
     */
    public List<RoleEntity> findAllRole();
}
