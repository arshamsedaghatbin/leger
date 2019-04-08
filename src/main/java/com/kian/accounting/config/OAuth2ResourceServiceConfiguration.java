package com.kian.accounting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServiceConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http
		.csrf().disable().authorizeRequests()
//		.antMatchers(HttpMethod.GET, "/api/v1/party-by-mobile/{mobile}").permitAll()
//		.antMatchers(HttpMethod.GET, "/api/v1/full-party-by-mobile/{mobile}").permitAll()
//        .antMatchers(HttpMethod.GET, "/api/v1/party-by-uuid/{uuid}").permitAll()
//        .antMatchers(HttpMethod.GET, "/api/v1/party-by-uuids").permitAll()
//        .antMatchers(HttpMethod.GET, "/api/v1/person-by-levantIds").permitAll()
//		.antMatchers(HttpMethod.GET, "/api/v1/bo/persons-by-status").permitAll()
//		.antMatchers(HttpMethod.GET, "/api/v1/bo/businesses-by-status").permitAll()
//		.antMatchers(HttpMethod.GET, "/api/v1/bo/parties").permitAll()
//        .antMatchers(HttpMethod.POST, "/api/v1/party").permitAll()
//        .antMatchers(HttpMethod.GET, "/api/v1/parties/reset-password").permitAll()
//        .antMatchers(HttpMethod.POST, "/api/v1/party-documents/levant/{levantId}").permitAll()
//        .antMatchers(HttpMethod.GET, "/api/v1/party-documents/levant/{levantId}").permitAll()
//        .antMatchers(HttpMethod.POST, "/api/v1/party-relations").permitAll()
//        .antMatchers(HttpMethod.PUT, "/api/v1/parties/{levantId}/clear").permitAll()
//		.antMatchers("/v2/api-docs/**").permitAll()
//		.antMatchers("/webjars/**").permitAll()
//		.antMatchers("/swagger-resources/**").permitAll()
//		.antMatchers("/swagger-ui.html").permitAll()
//		.antMatchers("/hystrix.stream").permitAll()
		.anyRequest().authenticated();
	}

}
