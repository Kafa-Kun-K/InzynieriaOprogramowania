package lab.foo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooConfig {
    @Bean
    String bar() { return "bar"; }
}
