package com.example.BitCoin.SecurityConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .requestMatchers("/register").permitAll()
                .requestMatchers("/login", "/perform_login").permitAll()
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/error").permitAll()
                .requestMatchers("/WEB-INF/**").permitAll()  // WEB-INF 직접 접근 차단
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            )
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
            );

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(dataSource); // DataSource를 설정하여 MariaDB 연결
        return userDetailsService;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://15.164.245.97:3306/bitcoin");
        dataSource.setUsername("snail");
        dataSource.setPassword("bit");
        return dataSource;
    }
	/*
	 * @Bean public UserDetailsService userDetailsService() { var user =
	 * User.withUsername("user") .password(passwordEncoder().encode("password"))
	 * .roles("USER") .build(); return new InMemoryUserDetailsManager(user); }
	 */
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}


