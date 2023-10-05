package kr.ch09.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {

	@Autowired
	private SecurityUserService service;
	
	@Bean // Bean은 왜??
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// 인가 설정 / 람다식
		http.authorizeHttpRequests(
				authorizeHttpRequests ->
				authorizeHttpRequests
					.requestMatchers("/").permitAll() // index는 모두한테 허가
					.requestMatchers("/admin/**").hasAuthority("ADMIN") // admin 쪽은 ADMIN한테만
					.requestMatchers("/manager/**").hasAnyAuthority("ADMIN", "MANAGER") // manager 쪽은 ADMIN이랑 MANAGER한테만
					.requestMatchers("/user/**").permitAll()
				);
		
		
		
		//http.authorizeRequests().requestMatchers("/").permitAll();
		//http.authorizeRequests().requestMatchers("/admin/**").hasRole("ADMIN");
		//http.authorizeRequests().requestMatchers("/user/**").hasAnyRole("USER", "MANAGER", "ADMIN");
		
		// 사이트 위변조 방지 설정
		http.csrf(CsrfConfigurer::disable);
		
		// 로그인 설정
		http.formLogin(
				login -> login
					.loginPage("/user/login")
					.defaultSuccessUrl("/user/success") // succss가 아니고!!!
					.failureUrl("/user/login?success=100")
					.usernameParameter("uid")
					.passwordParameter("pass")
		);
		
		
		// 로그아웃 설정
		http.logout(
				logout -> logout
					.invalidateHttpSession(true)
					.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
					.logoutSuccessUrl("/user/login?success=200")
		);
		
		
		// 사용자 인증처리 컴포넌트 등록
		http.userDetailsService(service);
		
		
		
		return http.build(); //build 왜??
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
