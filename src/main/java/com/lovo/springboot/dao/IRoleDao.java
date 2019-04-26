package com.lovo.springboot.dao;

import com.lovo.springboot.bean.RoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IRoleDao extends CrudRepository<RoleEntity, String> {

    @Query("select r from RoleEntity r ")
    public List<RoleEntity> findAllRole();
}
