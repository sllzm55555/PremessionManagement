package com.lovo.springboot.outcontroller;

import java.util.List;

import com.lovo.springboot.bean.UserEntity;
import com.lovo.springboot.dto.PowerDto;
import com.lovo.springboot.dto.PowerDtoReslut;
import com.lovo.springboot.service.IPowerService;
import com.lovo.springboot.service.IUserRoleService;
import com.lovo.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OutPowerController {

	@Autowired
	private IPowerService powerService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRoleService userRoleService;
	
	@RequestMapping("{userName}/{password}/getListPowerDto")
	public List<PowerDto> getListPowerDto(@PathVariable("userName") String userName, @PathVariable("password")String password){
		
		return powerService.findPowerDtoListByUserNameAndPassword(userName, password);
	}
	
	@RequestMapping("{userName}/{password}/PowerDtoReslut")
	public PowerDtoReslut getPowerDtoReslut(@PathVariable("userName") String userName, @PathVariable("password")String password){
		
		List<PowerDto> list=  powerService.findPowerDtoListByUserNameAndPassword(userName, password);
		PowerDtoReslut powerDtoReslut = new PowerDtoReslut();
		powerDtoReslut.setDto(list);
		return powerDtoReslut;

	}

	/**
	 * 用户注册方法
	 * @param userName 从客户端传过来的用户名
	 * @param password 从客户端传过来的密码
	 *                 同时需要把事件管理员这个角色（事件操作的权限）给新创建的用户
	 * @return 如果添加成功返回1，失败返回0
	 */

	@RequestMapping("{userName}/{password}/userRegister")
	public String userRegister(@PathVariable("userName") String userName, @PathVariable("password")String password){
		UserEntity userEntity = new UserEntity();
		userEntity.setUname(userName);
		userEntity.setUpasss(password);
		String n = userService.saveUserEntity(userEntity);

		return n;

	}

}
