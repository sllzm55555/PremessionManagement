package com.lovo.springboot.service.impl;

import com.lovo.springboot.bean.PowerEntity;
import com.lovo.springboot.bean.RoleEntity;
import com.lovo.springboot.bean.RolePowerEntity;
import com.lovo.springboot.dao.IRolePowerDao;
import com.lovo.springboot.service.IRolePowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "RolePowerService")
public class RolePowerServiceImpl implements IRolePowerService{

    @Autowired
    private IRolePowerDao rolePowerDao;

    @Override
    public void addRolePower(String addPowerName, String rid) {
        //如果权限不为空
        if(null!=addPowerName&&!"".equals(addPowerName)){
            addPowerName = addPowerName.substring(0, addPowerName.length()-1);

            List<RolePowerEntity> rolePowerEntityList = new ArrayList<>();
            String[] powerName = addPowerName.split(",");
            if(null!=powerName && powerName.length>0){
                for (String pid : powerName) {
                    RolePowerEntity rolePowerEntity = new RolePowerEntity();
                    RoleEntity roleEntity = new RoleEntity();
                    roleEntity.setRid(rid);

                    PowerEntity powerEntity = new PowerEntity();
                    powerEntity.setPid(pid);

                    rolePowerEntity.setRole(roleEntity);
                    rolePowerEntity.setPower(powerEntity);
                    rolePowerEntityList.add(rolePowerEntity);

                }
                //批量添加
                rolePowerDao.save(rolePowerEntityList);
            }

        }
    }

    @Transactional
    public void delRolePower(String delPowerName, String rid) {
        if(null!=delPowerName && !"".equals(delPowerName)){
            delPowerName = delPowerName.substring(0, delPowerName.length()-1);
            String [] delPowerNameArray = delPowerName.split(",");

            if(null!=delPowerNameArray&&delPowerNameArray.length>0){
                for (String pid : delPowerNameArray) {
                    rolePowerDao.delRolePower(rid, pid);
                }
            }
        }
    }
}
