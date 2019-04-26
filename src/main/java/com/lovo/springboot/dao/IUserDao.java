package com.lovo.springboot.dao;

import com.lovo.springboot.bean.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserDao extends CrudRepository<UserEntity, String> {
    @Query("select u from UserEntity u")
    public List<UserEntity> findAllUser();
    /**
     * 根据角色ID查询出该角色拥有的用户
     * @param rid
     * @return
     */
    @Query("select ur.user from UserRoleEntity ur where ur.role.rid=?1")
    public List<UserEntity> getUserListByRoleId(String rid);

}
