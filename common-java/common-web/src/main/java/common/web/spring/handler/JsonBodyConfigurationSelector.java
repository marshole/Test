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
import org.apache.commons.lang3.StringUtils;
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

		configJsonSerializerMapper(enableJsonBody);

		return new String[]{JsonBodyConfiguration.class.getName()};
	}

	/**
	 * 配置JsonSerializer的mapper
	 *
	 * @param enableJsonBody
	 */
	private void configJsonSerializerMapper(AnnotationAttributes enableJsonBody) {

		String code = enableJsonBody.getString("code");
		String data = enableJsonBody.getString("data");
		String message = enableJsonBody.getString("message");

		CodeMessageSerializer codeMessageSerializer = new CodeMessageSerializer(code, data, message);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
		SimpleModule module = new SimpleModule();
		module.addSerializer(CodeMessage.class, codeMessageSerializer);
		mapper.registerModule(module);

		JsonSerializer.setMapper(mapper);
	}
}
