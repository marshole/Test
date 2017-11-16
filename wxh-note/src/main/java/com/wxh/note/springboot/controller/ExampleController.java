package com.wxh.note.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wxh.note.springboot.property.dynamic.DynamicProperty;

@RestController
@RequestMapping("/springboot")
public class ExampleController {
	
	@Autowired
	private DynamicProperty dynamicProperty;
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String sayWorld(@PathVariable("name") String name) {
		
		
		dynamicProperty.addProperty("dynamic-info1",name + "1");
		dynamicProperty.addProperty("dynamic-info2",name + "2");
		dynamicProperty.addProperty("dynamic-info3",name + "3");
		
		String property1 = dynamicProperty.getProValueFromEnviroment("dynamic-info1");
		String property2 = dynamicProperty.getProValueFromEnviroment("dynamic-info2");
		String property3 = dynamicProperty.getProValueFromEnviroment("dynamic-info3");
		
        return "Hello " + property1 + " " + property2 + " " + property3;
    } 

}
