package my.examples.springjdbc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = { "my.examples.springjdbc.dao","my.examples.springjdbc.service" })
@Import({DataSourceConfig.class})
public class ApplicationConfig {
}
