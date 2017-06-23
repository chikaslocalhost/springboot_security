package com.chikaslocalhost.model;

/**
 * App Name spring-boot-with-spring-security
 * <p>
 * Created Date : 6/16/17 Time : 11:35 AM
 * Created By : chikaslocalhost
 * <p>
 * Package Name : com.chikaslocalhost.model
 * Class Name : UserRegistrationForm
 */
public class UserRegistrationForm {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
