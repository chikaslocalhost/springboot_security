package com.chikaslocalhost.auth;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Repository;

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
 * Class Name : CustomAuthenticationFailureHandler
 */
@Repository
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        System.out.println("--------------------Authentication Failed-----------------"+e);
        httpServletResponse.sendRedirect("login?error=true");

    }
}
