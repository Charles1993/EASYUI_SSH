package com.managementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.managementsystem.entity.ProcedureConfigs;
import com.managementsystem.service.ProcedureConfigsService;

@Controller
@RequestMapping("/config")
public class ProcedureConfigController {
	@Autowired
	private ProcedureConfigsService procedureConfigsService;
	
    @RequestMapping(value = "/getProcedureConfigs", method = RequestMethod.GET)
	public @ResponseBody List<ProcedureConfigs> getProcedureConfigs() {
		List<ProcedureConfigs> resources=procedureConfigsService.getAll();
		return resources;		
	}
    //增加
    @RequestMapping(value = "/addProcedureConfig", method = RequestMethod.GET)
	public @ResponseBody String addProcedureConfig() {
    	ProcedureConfigs procedure=new ProcedureConfigs();
    	procedure.setName("TOMCAT");
    	procedure.setPort("8080");
    	procedure.setUrl("/root/cong");
    	procedure.setDescript("安装tomcat,占用的端口是8080");
		int checked=procedureConfigsService.save(procedure);
		if(1==checked) {
			return "保存失败!";
		}else {
			return "保存成功!";
		}
	}
}
