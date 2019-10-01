package io.codefountain.spring.boot.all.adminserver.security;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AdminServerProperties adminServerProperties;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter("redirectTo");
		successHandler.setDefaultTargetUrl(this.adminServerProperties.getContextPath()+"/");
		
		
		http
			.authorizeRequests()
				.antMatchers(this.adminServerProperties.getContextPath()+"/assets/**").permitAll()
				.antMatchers(this.adminServerProperties.getContextPath()+"/login").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage(this.adminServerProperties.getContextPath()+"/login")
				.successHandler(successHandler)
				.and()
			.logout()
				.logoutUrl(this.adminServerProperties.getContextPath()+"/logout")
				.and()
			.httpBasic()
				.and()
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.ignoringRequestMatchers(
							new AntPathRequestMatcher(this.adminServerProperties.getContextPath()+"/instances", HttpMethod.POST.toString()),
							new AntPathRequestMatcher(this.adminServerProperties.getContextPath()+"/instances", HttpMethod.DELETE.toString()),
							new AntPathRequestMatcher(this.adminServerProperties.getContextPath()+"/actuator/**"))
				.and()
			.rememberMe()
				.key(UUID.randomUUID().toString())
				.tokenValiditySeconds(1209600);
				

	}
}
