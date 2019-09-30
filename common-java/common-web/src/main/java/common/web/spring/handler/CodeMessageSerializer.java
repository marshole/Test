package common.web.spring.handler;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import common.api.json.CodeMessage;

import java.io.IOException;

/**
 * 自定义输出字段名
 */
public class CodeMessageSerializer extends StdSerializer<CodeMessage> {

	private String code;
	private String data;
	private String message;

	public CodeMessageSerializer(String code, String data, String message) {
		super(CodeMessage.class);

		this.code = code;
		this.data = data;
		this.message = message;
	}

	@Override
	public void serialize(CodeMessage json, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {
		generator.writeStartObject();
		generator.writeNumberField(code, json.getCode());
		generator.writeObjectField(data, json.getData());
		generator.writeStringField(message, json.getMessage());
		generator.writeEndObject();
	}
}
