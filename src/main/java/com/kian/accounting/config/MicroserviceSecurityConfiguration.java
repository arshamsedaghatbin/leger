package com.kian.accounting.config;

import com.kian.accounting.security.AuthoritiesConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

@Configuration
@Import(SecurityProblemSupport.class)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MicroserviceSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final SecurityProblemSupport problemSupport;

    public MicroserviceSecurityConfiguration(SecurityProblemSupport problemSupport) {
        this.problemSupport = problemSupport;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .antMatchers("/app/**/*.{js,html}")
            .antMatchers("/bower_components/**")
            .antMatchers("/i18n/**")
            .antMatchers("/content/**")
            .antMatchers("/swagger-resources/**")
            .antMatchers("/swagger-ui/index.html")
            .antMatchers("/v2/api-docs/**")
    			.antMatchers("/webjars/**")
            .antMatchers("/test/**")
            .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

	    	http
	    		.formLogin()
	    		.loginPage("/login")
			.permitAll()
			.and()
				.httpBasic()
			.and()
				.requestMatchers()
			// specify urls handled
				.antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
				.antMatchers("/fonts/**", "/js/**", "/css/**").and().authorizeRequests()
				.antMatchers("/fonts/**", "/js/**", "/css/**").permitAll()
				.antMatchers("/management/health").permitAll()
				.antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN)
	            .antMatchers("/swagger-resources/configuration/ui").permitAll()
				.anyRequest().authenticated();

		http
			.csrf()
			.disable()
			.exceptionHandling()
			.authenticationEntryPoint(problemSupport)
			.accessDeniedHandler(problemSupport);

		http
			.headers()
			.frameOptions()
			.disable();

		http.cors();
    }

}
