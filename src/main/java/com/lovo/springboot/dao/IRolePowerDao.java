package com.lovo.springboot.dao;

import com.lovo.springboot.bean.RolePowerEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IRolePowerDao extends CrudRepository<RolePowerEntity,String> {

    @Modifying
    @Query("delete from RolePowerEntity pr where pr.role.rid=?1 and pr.power.pid=?2")
    public void delRolePower(String rid,String pid);
}
