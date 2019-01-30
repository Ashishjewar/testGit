package com.ashish.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("USER").password("1234").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
		.and().formLogin();
		
	}

}


/*eqivalent to:
	
	 <http auto-config="true">
	<intercept-url pattern="/admin" access="ROLE_ADMIN"/>
	</http>
	
	<authentication-manager>
	<authentication-provider>
		<user-service>
		<user name="admin" password="1234" authorities="ROLE_ADMIN"/>
		</user-service>
	</authentication-provider>
	</authentication-manager>*/
