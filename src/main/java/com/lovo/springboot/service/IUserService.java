package com.lovo.springboot.service;

import com.lovo.springboot.bean.UserEntity;

import java.util.List;

public interface IUserService {

    public String saveUserEntity(UserEntity userEntity);

    public List<UserEntity> findAllUser();

    /**
     * 根据角色ID查询出该角色拥有的用户
     * @param rid
     * @return
     */
    public List<UserEntity> getUserListByRoleId(String rid);

    /**
     * 通过已有的用户查到没有的用户
     * @param userListOfRole
     * @return
     */
    public List<UserEntity> getNOUserListByRoleId(List<UserEntity> userListOfRole);
}
