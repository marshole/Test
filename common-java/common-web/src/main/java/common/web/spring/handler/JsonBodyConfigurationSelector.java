/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package common.web.spring.handler;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import common.api.json.CodeMessage;
import common.web.annotation.EnableJsonBody;
import common.web.configuration.JsonBodyConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author weixuhui Date: 19/9/30 Time: 下午4:37
 */
public class JsonBodyConfigurationSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata annotationMetadata) {

		AnnotationAttributes enableJsonBody = AnnotationAttributes.fromMap(
				annotationMetadata.getAnnotationAttributes(EnableJsonBody.class.getName(), false));
		if (enableJsonBody == null) {
			throw new IllegalArgumentException("@EnableJsonBody is not present on importing class " + annotationMetadata.getClassName());
		}

		String enableJsonBodyCode = enableJsonBody.getString("code");
		String enableJsonBodyData = enableJsonBody.getString("data");
		String enableJsonBodyMessage = enableJsonBody.getString("message");

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
		SimpleModule module = new SimpleModule();
		module.addSerializer(CodeMessage.class, new CodeMessageSerializer(enableJsonBodyCode, enableJsonBodyData, enableJsonBodyMessage));
		mapper.registerModule(module);

		JsonSerializer.setMapper(mapper);

		return new String[]{JsonBodyConfiguration.class.getName()};
	}
}
