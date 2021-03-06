package common.web.spring.handler;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.common.base.Strings;
import common.api.json.CodeMessage;
import common.api.json.Json;
import common.web.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

import static common.api.json.CodeMessage.ERROR;
import static common.api.json.CodeMessage.OK;

final class JsonSerializer {

	private static final Logger logger = LoggerFactory.getLogger(JsonSerializer.class);
	private static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
	}

	public static void setMapper(ObjectMapper objectMapper) {
		mapper = objectMapper;
	}

	static void write(Object value, JsonBody meta, HttpServletRequest request, HttpServletResponse response) {

		logger.debug("value={}, meta={}", value, meta);

		String callback = Strings.emptyToNull(request.getParameter(meta.callback()));

		try {
			Object data = dataOf(value);

			if (callback != null) {
				response.setContentType("application/javascript; charset=UTF-8");
				// call setContentType before getWriter(), or else UTF-8 doesn't work
				Writer writer = response.getWriter();
				writer.write(callback);
				writer.write('(');
				mapper.writeValue(writer, data);
				writer.write(')');
			} else {
				response.setContentType("application/json; charset=UTF-8");
				mapper.writeValue(response.getWriter(), data);
			}
		} catch (IOException e) {
			logger.warn("response write error", e);
		}
	}

	private static Object dataOf(Object value) {

		if (value instanceof Json) {
			return value;
		}

		if (value instanceof CodeMessage) {
			final CodeMessage cm = (CodeMessage) value;
			return new Json<>(cm.getCode(), cm.getMessage(), cm.getData());
		}

		if (value instanceof Throwable) {
			final Throwable e = (Throwable) value;
			return new Json<>(ERROR, e.getMessage(), null);
		}

		return new Json<>(OK, null, value);
	}
}
