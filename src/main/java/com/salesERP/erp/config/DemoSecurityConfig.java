package com.salesERP.erp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	
	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication 		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.headers().frameOptions().disable();
		http.authorizeRequests()
		
		//authorizing the main menu and dashboard
		.antMatchers("/ERPmenu/menu").hasRole("EMPLOYEE")
		.antMatchers("/ERPmenu/empty").hasRole("EMPLOYEE")
		.antMatchers("/ERPmenu/empty2").hasRole("EMPLOYEE")
		.antMatchers("/dashboard/contents").hasRole("EMPLOYEE")
		
			.antMatchers("/customers/showForm*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/customers/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/customers/delete").hasRole("ADMIN")
			.antMatchers("/customers/**").hasRole("EMPLOYEE")
		
			.antMatchers("/employees/showForm*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/employees/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/employees/delete").hasRole("ADMIN")
			.antMatchers("/employees/**").hasRole("EMPLOYEE")
			
			.antMatchers("/sales/showForm*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/sales/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/sales/delete").hasRole("ADMIN")
			.antMatchers("/sales/**").hasRole("EMPLOYEE")
			
			.antMatchers("/products/showForm*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/products/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/products/delete").hasRole("ADMIN")
			.antMatchers("/products/**").hasRole("EMPLOYEE")
			
			.antMatchers("/suppliers/showForm*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/suppliers/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/suppliers/delete").hasRole("ADMIN")
			.antMatchers("/suppliers/**").hasRole("EMPLOYEE")
			
			.antMatchers("/units/showForm*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/units/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/units/delete").hasRole("ADMIN")
			.antMatchers("/units/**").hasRole("EMPLOYEE")
			
			.antMatchers("/resources/**").permitAll()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
		
}






