package com.lc.springbootlession15safe.security;


import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.frameoptions.AllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		//CSRF 拦截哪些路径或者访问方式 
		http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository()).requireCsrfProtectionMatcher(

		/*		new RequestMatcher() {
					
					@Override
					public boolean matches(HttpServletRequest httpServletRequest) {
						return httpServletRequest.getRequestURI().startsWith("/login");
					}
				}
				*/
				httpServletRequest ->httpServletRequest.getMethod().equals("POST")
					
				);
		
		//CSP header  设置白名单
		http.headers().contentSecurityPolicy("script-src https://code.jquery.com/");
		
		// X-Frame-Options header , 相同域名时允许的
		//http.headers().frameOptions().sameOrigin();
		
		//实现绝对允许,iFrame可以访问此域名  白名单方式
		http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(new AllowFromStrategy() {
			
			@Override
			public String getAllowFromValue(HttpServletRequest request) {
				return "mylc.com";
			}
		}));
		
		// XSS header
		http.headers().xssProtection().block(false);
		
		// 授权  任意的请求要全面的去认证
		http.authorizeRequests().anyRequest().fullyAuthenticated()
		        .and().formLogin().loginPage("/login").failureForwardUrl("/error").permitAll()
		        .and().logout().permitAll();
		
		//设置前台的name名称formLogin().usernameParameter("name").passwordParameter("pwd")
/*		http.authorizeRequests().anyRequest().fullyAuthenticated()
		        .and().formLogin().usernameParameter("name").passwordParameter("pwd").loginPage("/login").failureForwardUrl("/error").permitAll()
		        .and().logout().permitAll();*/
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("lc").password("111").roles("admin")
		        .and().withUser("刘德华").password("111").roles("user");
	}
}
    

 
 