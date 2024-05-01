package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final String[] openEndpoints = {"/sign-in", "/sign-up", "/", "/img/**","/css/user", "/css/**","/user/admin","/user","/userType",
    "/create-buss","/buss-all","/search","/bascet","/ticket"};
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers(openEndpoints).permitAll()
                                .anyRequest().authenticated()
                ).formLogin(
                        loginConfig -> {
                            loginConfig
                                    .loginPage("/sign-in")
                                    .defaultSuccessUrl("/userType")
                                    .loginProcessingUrl("/sign-in")
                                    .usernameParameter("email")
                                    .passwordParameter("password");
                        }
                ).logout(
                        logoutConfig -> logoutConfig
                                .logoutRequestMatcher(new AntPathRequestMatcher("/sign-out"))
                                .logoutSuccessUrl("/sign-in")
                )
                .rememberMe(
                        rememberMeConfig -> {
                            rememberMeConfig
                                    .rememberMeCookieName("rememberMe")
                                    .tokenValiditySeconds(3 * 60 * 60 * 24)
                                    .rememberMeParameter("rememberMe");
                        }

                ).build();


    }
//    @Bean
//    public UserDetailsService admin(){
//        User admin = new User("admin", "123", Collections.emptyList());
//        return new InMemoryUserDetailsManager(admin);
//    }
}
