package com.rubypaper.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
   
	SecurityConfig(){
		System.out.println("==>SecurityConfig");
	}
	/*
	@Autowired
	private DataSource datasource;
	*/
	@Autowired
	private BoardUserDetailsService boardUserDetails;
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		
		System.out.println("==> void configure");
		security.authorizeRequests().antMatchers("/","/system/**").permitAll();  // 모든사용자 오픈
		security.authorizeRequests().antMatchers("/board/**").authenticated();  // 인증만 받으면됨
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");  // admin 권한까지 있어야함

	    security.csrf().disable();
	    security.formLogin().loginPage("/system/login.do").defaultSuccessUrl("/board/getBoardList.do",true); // 1
	    security.exceptionHandling().accessDeniedPage("/system/accessDenied.do");
		security.logout().logoutUrl("/system/logout.do").invalidateHttpSession(true).logoutSuccessUrl("/");
	
	    security.userDetailsService(boardUserDetails); // 2
	
	    // 1번 - username과 password를 받아온다
	    // 2번 - 테이블의 값을 받아온다
	    // 1번과 2번이 매핑되어 인증을 체크한다 
	}	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
	}
	/*
	@Autowired
	public  void  authenticate(AuthenticationManagerBuilder  auth) throws Exception {
		System.out.println("===> authenticate");
		
		String query1 = "select id username, concat('{noop}',password) password, enabled from member1025 where id=?";
		String query2 = "select id, role from member1025 where id=?";
		
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery(query1)
		.authoritiesByUsernameQuery(query2);
	}
	
	/*
	@Autowired
	public  void  authenticate(AuthenticationManagerBuilder  auth) throws Exception {
		System.out.println("===> authenticate");
		
		auth.inMemoryAuthentication().
		withUser("manager").
		password("{noop}manager123").
		roles("MANAGER");
		
		auth.inMemoryAuthentication().
		withUser("admin").
		password("{noop}admin123").
		roles("ADMIN");
	}
	*/
	
}
