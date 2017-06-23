package com.chikaslocalhost.service;

import com.chikaslocalhost.model.SecuredUserDetails;
import com.chikaslocalhost.model.User;
import com.chikaslocalhost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * App Name spring-boot-with-spring-security
 * <p>
 * Created Date : 6/16/17 Time : 10:30 AM
 * Created By : chikaslocalhost
 * <p>
 * Package Name : com.chikaslocalhost.service
 * Class Name : SecureUserDetailsService
 */
@Component
public class SecureUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    /**
     * load user by username
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.readUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }else{
            UserDetails details = new SecuredUserDetails(user);
            return details;
        }
    }
}
