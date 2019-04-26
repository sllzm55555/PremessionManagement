package com.lovo.springboot.dto;

import java.util.List;

/**
 * 用于接收所有的powerDto结果
 */

public class PowerDtoReslut {
   
	private List<PowerDto> dto;

	public List<PowerDto> getDto() {
		return dto;
	}

	public void setDto(List<PowerDto> dto) {
		this.dto = dto;
	}
	
}
