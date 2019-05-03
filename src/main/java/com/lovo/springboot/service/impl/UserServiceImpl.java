package com.lovo.springboot.service.impl;

import com.lovo.springboot.bean.UserEntity;
import com.lovo.springboot.dao.IUserDao;
import com.lovo.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public String saveUserEntity(UserEntity userEntity) {
        String num = "";
        UserEntity entity = userDao.save(userEntity);
        if(null!=entity){
            num = "1";
        }else{
            num = "0";
        }
        return num;
    }

    @Override
    public List<UserEntity> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public List<UserEntity> getUserListByRoleId(String rid) {
        return userDao.getUserListByRoleId(rid);
    }

    @Override
    public List<UserEntity> getNOUserListByRoleId( List<UserEntity> userListOfRole) {
        //查询出所有用户
        List<UserEntity> listUserAll=	(List<UserEntity>) userDao.findAllUser();
        //所有-拥有=不拥有

        //拥有的为null,直接返回所有
        if(null==userListOfRole||userListOfRole.isEmpty()){
            return listUserAll;
        }else{
            for(int i=0;i<userListOfRole.size();i++){
                String uid=userListOfRole.get(i).getUid();
                for(int j=0;j<listUserAll.size();j++){
                    String allUid=listUserAll.get(j).getUid();
                    if(uid.equals(allUid)){
                        //删除用户
                        listUserAll.remove(j);
                        break;//跳出当前循环
                    }
                }
            }
        }
        return listUserAll;
    }
}
