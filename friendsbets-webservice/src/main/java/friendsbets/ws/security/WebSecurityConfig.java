package friendsbets.ws.security;

import static friendsbets.core.security.SecurityConstants.SIGN_UP_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//import friendsbets.ws.securingweb.JWTAuthenticationFilter;
//import friendsbets.ws.securingweb.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	/**
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 *           http.cors().and().csrf().disable()
	 *           .authorizeRequests()
	 *           .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
	 *           .anyRequest().authenticated() 
	 *           .and() .addFilter(new
	 *           JWTAuthenticationFilter(authenticationManager())) 
	 *           .addFilter(new JWTAuthorizationFilter(authenticationManager())) // this disables session creation on Spring Security
	 *           .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 *           }
	 * 	@Override protected void configure(HttpSecurity http) throws Exception {
			http
					// TODO: REMOVE CSRF DISABLE
					.csrf().disable().authorizeRequests().antMatchers("/", "/authentication/login/*", "/users").permitAll()
	//				.anyRequest().authenticated()
					.and()
	//			.formLogin()
	//				.loginPage("http://localhost:4200/login")
	//				.permitAll()
	//				.and()
					.cors().and().logout().permitAll();
	}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception { // TODO: REMOVE CSRF DISABLE
		http.csrf().disable()
			.authorizeRequests()
            .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
            .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
			.formLogin()
			.loginPage("http://localhost:4200/login")
			.permitAll()
			.and()
            .logout().permitAll();


	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("CONFIG");
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		System.out.println("CORSCONFIG");
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

//
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
//	
//
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","UPDATE","DELETE","OPTIONS"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
}