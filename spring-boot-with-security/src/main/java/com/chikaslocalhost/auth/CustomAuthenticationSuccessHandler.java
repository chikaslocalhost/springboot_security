package com.chikaslocalhost.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * App Name spring-boot-with-spring-security
 * <p>
 * Created Date : 6/16/17 Time : 10:34 AM
 * Created By : chikaslocalhost
 * <p>
 * Package Name : com.chikaslocalhost.auth
 * Class Name : CustomAuthenticationSuccessHandler
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        handle(httpServletRequest, httpServletResponse, authentication);
    }

    /**
     * Handle request to forward with user redirection
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     */
    private void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {

        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, determinRedirectURL());

    }

    /**
     * determine redirection URL
     * @return
     */
    private String determinRedirectURL() {

        return "/main-dashboard";
    }
}
