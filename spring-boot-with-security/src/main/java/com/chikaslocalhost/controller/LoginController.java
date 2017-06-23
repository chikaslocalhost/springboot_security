package com.chikaslocalhost.controller;

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
 * Class Name : LoginController
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String formBacking(ModelMap mainLogin){
        return "login";
    }

}
