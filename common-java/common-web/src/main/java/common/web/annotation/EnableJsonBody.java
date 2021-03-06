package common.web.annotation;

import common.web.configuration.JsonBodyConfiguration;
import common.web.spring.handler.JsonBodyConfigurationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({JsonBodyConfigurationSelector.class})
public @interface EnableJsonBody {

	String code() default "code";

	String data() default "data";

	String message() default "message";

	boolean logException() default true;
}
