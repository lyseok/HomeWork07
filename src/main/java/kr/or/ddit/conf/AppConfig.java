package kr.or.ddit.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@ComponentScan(
	basePackages = "kr.or.ddit"
	, excludeFilters = {
		@Filter(Controller.class)
		, @Filter(ControllerAdvice.class)
	}
)
public class AppConfig {

}
