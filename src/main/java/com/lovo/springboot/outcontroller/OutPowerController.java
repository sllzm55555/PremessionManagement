package com.lovo.springboot.outcontroller;

import java.util.List;

import com.lovo.springboot.dto.PowerDto;
import com.lovo.springboot.dto.PowerDtoReslut;
import com.lovo.springboot.service.IPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OutPowerController {

	@Autowired
	private IPowerService powerService;
	
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
}
