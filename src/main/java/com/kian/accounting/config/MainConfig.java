package com.kian.accounting.config;


import com.kian.common.config.*;
import com.kian.common.feign.FeignErrorDecoder;
import com.kian.common.filter.CustomCorsFilter;
import com.kian.common.util.security.SpringSecurityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AsyncConfiguration.class,
        CloudDatabaseConfiguration.class,
        DateTimeFormatConfiguration.class,
        JacksonConfiguration.class,
        LocaleConfiguration.class,
        LoggingConfiguration.class,
        MetricsConfiguration.class,
        ThymeleafConfiguration.class,
        ExceptionHandlingConfig.class,
        ResourceConfiguration.class,
        WebConfigurer.class})
public class MainConfig {

    @Bean
    public SpringSecurityAuditorAware springSecurityAuditorAware(){
        return new SpringSecurityAuditorAware();
    }

    @Bean
    public CustomCorsFilter corsFilter(){
        return new CustomCorsFilter();
    }
}
