package kr.or.ddit.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:kr/or/ddit/db/DBInfo.properties")
public class DataSourceContextConfig {
	@Bean
	public DataSource dataSource(
		@Value("${db.driverClassName}") String driverClassName	
		, @Value("${db.url}") String url
		, @Value("${db.username}") String username
		, @Value("${db.password}") String password
		, @Value("${db.autoCommit}") boolean autoCommit
		, @Value("${db.minimumIdle}") int minimumIdle
		, @Value("${db.maximumPoolSize}") int maximumPoolSize
		, @Value("${db.connectionTimeout}") long connectionTimeout	
	) {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setJdbcUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setAutoCommit(autoCommit);
		ds.setMinimumIdle(minimumIdle);
		ds.setMaximumPoolSize(maximumPoolSize);
		ds.setConnectionTimeout(connectionTimeout);
		return ds;
	}
}
