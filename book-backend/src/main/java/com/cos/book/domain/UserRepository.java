package com.cos.book.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value= "SELECT * FROM users WHERE userId=? AND userPassword=?", nativeQuery = true)
    User findByUserIdAndUserPassword(String userId, String userPassword);

}
