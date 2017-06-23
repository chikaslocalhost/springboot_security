package com.chikaslocalhost.controller;

import com.chikaslocalhost.model.SecuredUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * App Name spring-boot-with-spring-security
 * <p>
 * Created Date : 6/16/17 Time : 10:21 AM
 * Created By : chikaslocalhost
 * <p>
 * Package Name : com.chikaslocalhost.controller
 * Class Name : DashboardController
 */
@Controller
@RequestMapping("/main-dashboard")
public class DashboardController {

    @RequestMapping(method = RequestMethod.GET)
    public String formBacking(ModelMap home){

        SecuredUserDetails user = (SecuredUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        home.addAttribute("auth_user", user.getUsername());
        return "dashboard";

    }

}
