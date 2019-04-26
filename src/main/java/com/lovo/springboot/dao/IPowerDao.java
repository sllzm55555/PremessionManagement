package com.lovo.springboot.dao;

import com.lovo.springboot.bean.PowerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPowerDao extends CrudRepository<PowerEntity, String> {
    /**
     * 根据角色ID查询出该角色拥有的权限
     * @param rid
     * @return
     */
    @Query("select pr.power from RolePowerEntity  pr where pr.role.rid=?1")
    public List<PowerEntity> getPowerListByRoleId(String rid);

    /**
     * 用户名密码查询用户的权限资源
     * @param userName
     * @param password
     * @return 使用一个Object[]接收所有的权限DTO
     */
    @Query(value="SELECT" +
            " u.uname," +
            " p.puri " +
            " FROM " +
            " p_user u" +
            " LEFT JOIN p_user_role ur ON u.uid = ur.uid " +
            " LEFT JOIN p_role r ON r.rid = ur.rid " +
            " LEFT JOIN p_role_power rp ON rp.rid = r.rid " +
            " LEFT JOIN p_power p ON p.pid = rp.pid " +
            " WHERE " +
            " u.uname =?1" +
            " AND u.upasss =?2",nativeQuery=true)
    public List<Object[]>  findPowerDtoListByUserNameAndPassword(String userName,String password);

}
