package com.chikaslocalhost.config;

import com.chikaslocalhost.auth.CustomAuthenticationFailureHandler;
import com.chikaslocalhost.auth.CustomAuthenticationSuccessHandler;
import com.chikaslocalhost.auth.CustomLogoutSuccessHandler;
import com.chikaslocalhost.service.SecureUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * App Name spring-boot-with-spring-security
 * <p>
 * Created Date : 6/16/17 Time : 10:29 AM
 * Created By : chikaslocalhost
 * <p>
 * Package Name : com.chikaslocalhost.config
 * Class Name : WebSecurityConfigurations
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurations extends WebSecurityConfigurerAdapter{

    @Autowired
    private SecureUserDetailsService SecureUserDetailService;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(SecureUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .successHandler(customAuthenticationSuccessHandler)
                .usernameParameter("user")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);

        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");


    }


}
