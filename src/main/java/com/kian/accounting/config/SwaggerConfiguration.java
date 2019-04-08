package com.kian.accounting.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.kian.accounting"))
            .paths(paths())
            .build().securitySchemes(Arrays.asList(apiKey()))
            .apiInfo(getApiInfo());

    }

    private ApiKey apiKey() {
        return new ApiKey("apikey", "Authorization", "header");
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
            "Kian accounting",
            "This project is responsible for handling all transaction ",
            "Latest",
            "kiandigital.com/tos",
            new Contact("KIAN", "kiandigital.com", "info@kiandigital.com"),
            "KianDigital proprietary license.",
            "kiandigital.com/licenses",
            Collections.emptyList()
        );
    }
    private Predicate<String> paths() {
        return or(
            regex("/*.*"));
    }

}
