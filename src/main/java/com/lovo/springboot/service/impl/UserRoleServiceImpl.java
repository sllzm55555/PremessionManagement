package com.lovo.springboot.service.impl;

import com.lovo.springboot.bean.RoleEntity;
import com.lovo.springboot.bean.UserEntity;
import com.lovo.springboot.bean.UserRoleEntity;
import com.lovo.springboot.dao.IUserRoleDao;
import com.lovo.springboot.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private IUserRoleDao userRoleDao;

    @Transactional
    public void addUserList(String addName, String rid) {
        //用户id的字符串部位为空
        if(null!=addName&&!"".equals(addName)){
            //去掉最后一个逗号
            addName = addName.substring(0,addName.length()-1);
            //把逗号分割为数组

            String[] userArray = addName.split(",");
            //创建角色用户集合,用于批量添加
            List<UserRoleEntity> userRoleEntityList = new ArrayList<>();

            for (String uid : userArray) {
                UserRoleEntity userRoleEntity = new UserRoleEntity();
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setRid(rid);

                UserEntity userEntity = new UserEntity();
                userEntity.setUid(uid);

                userRoleEntity.setRole(roleEntity);
                userRoleEntity.setUser(userEntity);
                userRoleEntityList.add(userRoleEntity);
            }

            userRoleDao.save(userRoleEntityList);

        }

    }

    @Transactional //做删除操作时必须要加事务
    public void delUserList(String delName, String rid) {
        if(null != delName && !"".equals(delName)){
            delName = delName.substring(0, delName.length()-1);
            //页面端拼接的是用户id，即delName就是Uid的字符串
            String[] delNameArray = delName.split(",");
            //为了系统健壮性，必须再次进行判断是否为空
            if(null!=delNameArray && delNameArray.length>0){
                for (String uid : delNameArray) {
                    userRoleDao.deleteUserRoleById(uid, rid);
                }
                /*for(int i = 0;i<delNameArray.length;i++){
                    userRoleDao.deleteUserRoleById(delNameArray[i],rid );
                }*/
            }


        }
    }


}
