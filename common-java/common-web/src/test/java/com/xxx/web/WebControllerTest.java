package com.xxx.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebControllerTest {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @LocalServerPort
    private int port;

    @Resource
    private TestRestTemplate testRestTemplate;

    private String api(String uri) {
        return "http://localhost:" + port + "/api" + uri;
    }

    @Test
    public void testRest() {
        String data = this.testRestTemplate.getForObject(api("/rest"), String.class);
        logger.info("test .....");
        assertEquals("{\"name\":\"alice\"}", data);
    }

    @Test
    public void testHello() {
        String data = this.testRestTemplate.getForObject(api("/hello?name=alice"), String.class);
        assertEquals("{\"code\":0,\"message\":null,\"data\":\"alice\"}", data);
    }

    @Test
    public void testException() {
        String data = this.testRestTemplate.getForObject(api("/exception"), String.class);
        assertEquals("{\"code\":-1,\"message\":\"Oops\",\"data\":null}", data);
    }

    @Test
    public void testMappedException() {
        String data = this.testRestTemplate.getForObject(api("/mapped"), String.class);
        assertEquals("{\"code\":-1,\"message\":\"SQL异常\",\"data\":null}", data);
    }
}
