package com.chikaslocalhost.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * App Name spring-boot-with-spring-security
 * <p>
 * Created Date : 6/16/17 Time : 10:57 AM
 * Created By : chikaslocalhost
 * <p>
 * Package Name : com.chikaslocalhost.auth
 * Class Name : CustomLogoutSuccessHandler
 */
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler{
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        System.out.println("------------Logged out Successfully-----------");
        httpServletResponse.sendRedirect("login");

    }
}
