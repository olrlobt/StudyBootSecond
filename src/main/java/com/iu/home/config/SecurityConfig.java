package com.iu.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	//public 을 선언하면 default로 바꾸라는 메세지 출력
	WebSecurityCustomizer wegSecurityConfig() {
		//Security에서 무시해야하는 URL 패턴 등록
		return web -> web
			   .ignoring()
			   .antMatchers("/images/**")
			   .antMatchers("/css/**")
			   .antMatchers("/js/**")
			   .antMatchers("/favicon/**")
			   .antMatchers("/resources/**");
	}
	@Bean
	SecurityFilterChain fiterChain(HttpSecurity httpSecurity)throws Exception{
		httpSecurity
					.cors()
					.and()
					.csrf()
					.disable()
				.authorizeRequests()
					.antMatchers("/").permitAll()
					.antMatchers("/admin").hasRole("ADMIN")
					.antMatchers("/manager").hasRole("MANAGER")
					.anyRequest().authenticated()
					.and()
				.formLogin()
					.permitAll()
					.and()
				.logout()
					.permitAll();
		
		return httpSecurity.build();
					
	}

}