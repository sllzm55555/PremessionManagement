package com.lovo.springboot.service.impl;

import com.lovo.springboot.bean.RoleEntity;
import com.lovo.springboot.dao.IRoleDao;
import com.lovo.springboot.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;
    @Override
    public void saveRoleEntity(RoleEntity roleEntity) {
        roleDao.save(roleEntity);
    }

    @Override
    public List<RoleEntity> findAllRole() {
        return roleDao.findAllRole();
    }
}
