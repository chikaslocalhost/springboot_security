package com.chikaslocalhost.repository;

import com.chikaslocalhost.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * App Name spring-boot-with-spring-security
 * <p>
 * Created Date : 6/16/17 Time : 10:31 AM
 * Created By : chikaslocalhost
 * <p>
 * Package Name : com.chikaslocalhost.repository
 * Class Name : UserRepository
 */
@Repository
public interface UserRepository extends MongoRepository<User , String>{

    User readUserByUsername(String username);

}
