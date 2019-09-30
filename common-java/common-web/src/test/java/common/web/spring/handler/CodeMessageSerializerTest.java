package common.web.spring.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import common.api.json.CodeMessage;
import common.api.json.Json;
import junit.framework.TestCase;
import org.junit.Test;

public class CodeMessageSerializerTest extends TestCase {

    @Test
    public void testDefault() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        assertEquals("{\"code\":1,\"message\":\"hello\",\"data\":\"world\"}", mapper.writeValueAsString(new Json<Object>(1, "hello", "world")));
    }

    @Test
    public void testCustomize() throws Exception{
        SimpleModule module = new SimpleModule();
        module.addSerializer(CodeMessage.class, new CodeMessageSerializer("status", "data", "msg"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        assertEquals("{\"status\":1,\"data\":\"world\",\"msg\":\"hello\"}", mapper.writeValueAsString(new Json<Object>(1, "hello", "world")));
    }
}
