package kr.or.ddit.conf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(DataSourceContextConfig.class)
class DataSourceContextConfigTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	void test() {
		log.info("{}", jdbcTemplate);
		
	}

}
