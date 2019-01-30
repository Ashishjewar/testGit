package com.ashish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.ashish.web.*"})
@Import({SecurityConfig.class})
public class AppConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
		
		return internalResourceViewResolver;
	}

}

/*eqivalent to:
	
	<context:component-scan base-package="com.mkyong.web.*" />

<bean
	class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix">
		<value>/WEB-INF/pages/</value>
	</property>
	<property name="suffix">
		<value>.jsp</value>
	</property>
</bean>*/
