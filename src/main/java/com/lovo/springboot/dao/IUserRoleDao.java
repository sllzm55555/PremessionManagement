package com.lovo.springboot.dao;

import com.lovo.springboot.bean.UserRoleEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserRoleDao extends CrudRepository<UserRoleEntity,String> {
    //作删除操作必须要写@Modifying ，如果写的是sql语句还应当再整个sql语句前添加value="",以及在语句后面添加nativeQuery = true。表示原生SQL语句
    @Modifying
//    //@Query(value = "delete from p_user_role where uid=?1 and rid=?2",nativeQuery = true )
    @Query("delete from UserRoleEntity where user.uid=?1 and role.rid=?2")
    public void deleteUserRoleById(String uid,String rid);

}
