package com.lovo.springboot.service.impl;

import com.lovo.springboot.bean.PowerEntity;
import com.lovo.springboot.dao.IPowerDao;
import com.lovo.springboot.dto.PowerDto;
import com.lovo.springboot.service.IPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "powerService")
public class PowerServiceImpl implements IPowerService {
    @Autowired
    private IPowerDao powerDao;

    @Override
    public void savePowerEntity(PowerEntity powerEntity) {
        powerDao.save(powerEntity);
    }

    @Override
    public List<PowerEntity> getAllPower() {
        return ( List<PowerEntity> )powerDao.findAll();
    }

    @Override
    public List<PowerEntity> getPowerListByRoleId(String rid) {
        return powerDao.getPowerListByRoleId(rid);
    }

    @Override
    public List<PowerEntity> getPowerListNoByRoleId(List<PowerEntity> powerList) {
        List<PowerEntity> allPowerList = (List<PowerEntity>)powerDao.findAll();
        //如果powerList不为空，则从所有权限中去掉拥有的权限
        if(null!= powerList && !powerList.isEmpty()){
            for(int i=0;i<powerList.size();i++){
                String pid = powerList.get(i).getPid();
                for(int j=0;j<allPowerList.size();j++){
                    String allPid = allPowerList.get(j).getPid();
                    if(pid.equals(allPid)){
                        allPowerList.remove(j);
                        break;
                    }
                }
            }
        }else{ //否则角色没有的权限就是所有权限
            return allPowerList;
        }
        return allPowerList;
    }

    @Override
    public List<PowerDto> findPowerDtoListByUserNameAndPassword(String userName, String password) {

        List<Object[]> list = powerDao.findPowerDtoListByUserNameAndPassword(userName, password);

        List<PowerDto>  listdto=null;
        if(null != list && !list.isEmpty()){
            listdto=new ArrayList<>();
            for (Object[] objs : list) {
                PowerDto dto=new PowerDto();
                dto.setUserName(objs[0].toString());
                dto.setPowerUri(objs[1].toString());
                //把List<Object[]> 数据放入到List<PowerDto>
                listdto.add(dto);
            }

        }
        return listdto;
    }


}
