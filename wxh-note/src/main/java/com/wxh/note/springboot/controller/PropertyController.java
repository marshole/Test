package com.wxh.note.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wxh.note.springboot.property.dynamic.DynamicProperty;

@RestController
@RequestMapping("/property")
public class PropertyController {
	
	@Autowired
	private DynamicProperty dynamicProperty;
	
	@RequestMapping(value = "config", method = RequestMethod.POST)
    public String config(String key,String property) {
		dynamicProperty.addProperty(key,property);
        return "SUCCESS";
    } 
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String getByKey(String key) {
		return dynamicProperty.getProValueFromEnviroment(key);
	} 
}
