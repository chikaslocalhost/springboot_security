package com.chikaslocalhost.controller;

import com.chikaslocalhost.model.User;
import com.chikaslocalhost.model.UserRegistrationForm;
import com.chikaslocalhost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * App Name spring-boot-with-spring-security
 * <p>
 * Created Date : 6/16/17 Time : 10:24 AM
 * Created By : chikaslocalhost
 * <p>
 * Package Name : com.chikaslocalhost.controller
 * Class Name : UserRegistrationController
 */
@Controller
@RequestMapping("/user/registration")
public class UserRegistrationController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String formBacking(ModelMap mainLogin){

        mainLogin.addAttribute("user-form", new UserRegistrationForm());
        return "user-registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(ModelMap modelMap,
                              @ModelAttribute("user-form") UserRegistrationForm userRegistrationForm){

        /*Register user*/
        User user = new User(userRegistrationForm.getUsername(),userRegistrationForm.getPassword());
        userRepository.save(user);

        return "redirect:/user-registration";
    }

}
