package friendsbets.ws.security;

import static friendsbets.core.security.SecurityConstants.SIGN_UP_URL;

import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception { // TODO: REMOVE CSRF DISABLE ?
		http.csrf().disable()
			.authorizeRequests()
            .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
            .and()
			.formLogin()
			.loginPage("http://localhost:4200/login")
			.permitAll()
			.and()
            .logout().permitAll();
	}


	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		Logger.getLogger(this.getClass()).info("		!! ENABLING CORS FROM FRONTEND !!");
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

}