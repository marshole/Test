package com.wxh.note.springboot.property.dynamic;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 动态配置信息
 *
 * @author weixuhui
 *
 */
@Component 
public class DynamicProperty {
	
	public static final String DYNAMIC_CONFIG_NAME = "dynamic_config";  
	
	private static Logger log = LoggerFactory.getLogger(DynamicProperty.class);
	  
    @Autowired  
    AbstractEnvironment environment;  
    
    private void addDynamicProperty(PropertySource<?> property) {
    		environment.getPropertySources().addFirst(property);  
    }
    
    public void addProperty(String key, String property) {
    	
    		MapPropertySource propertySource = (MapPropertySource) environment.getPropertySources().get(DYNAMIC_CONFIG_NAME);
    		
    		Map<String, Object> map = propertySource == null ? new ConcurrentHashMap<String, Object>(64) : propertySource.getSource();
    		
        log.info("add property, source {} key {} property {};currentTime:{}",DYNAMIC_CONFIG_NAME, key,property, new Date());  
        
        map.put(key, property);
        
        addDynamicProperty(new MapPropertySource(DYNAMIC_CONFIG_NAME, map));
        
    }
    
    public String getProValueFromEnviroment(String key) {  
        return environment.getProperty(key);  
    } 


}
