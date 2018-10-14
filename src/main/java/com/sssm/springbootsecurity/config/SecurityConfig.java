package com.sssm.springbootsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String ADMIN = "ADMIN";
	private static final String USER = "USER";

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// read following to understand why password contains {noop} ->
		// https://github.com/spring-projects/spring-security/issues/5086
		auth.inMemoryAuthentication().withUser("MS").password("{noop}MS24").roles(USER).and().withUser("PS")
				.password("{noop}PS12").roles(USER, ADMIN);
	}

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests().antMatchers("/getcheckingaccountbalance/*").hasRole(USER)
				.antMatchers("/getuserdetails/admin/*").hasRole(ADMIN).and().formLogin();
	}

}
