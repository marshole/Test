/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package common.web.spring.handler;

import org.springframework.context.annotation.Configuration;

/**
 * @author weixuhui Date: 19/9/30 Time: 下午5:29
 */
@Configuration
public class JsonSerializerMapperHandler {

	private String enableJsonBodyCode;
	private String enableJsonBodyDate;
	private String enableJsonBodyMessage;

	public void setEnableJsonBodyCode(String enableJsonBodyCode) {
		this.enableJsonBodyCode = enableJsonBodyCode;
	}

	public void setEnableJsonBodyDate(String enableJsonBodyDate) {
		this.enableJsonBodyDate = enableJsonBodyDate;
	}

	public void setEnableJsonBodyMessage(String enableJsonBodyMessage) {
		this.enableJsonBodyMessage = enableJsonBodyMessage;
	}

}
