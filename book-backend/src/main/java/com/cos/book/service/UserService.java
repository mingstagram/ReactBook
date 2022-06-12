package com.cos.book.service;

import com.cos.book.domain.User;
import com.cos.book.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional //
    public User 로그인(User user) {
        User loginUser = userRepository.findByUserIdAndUserPassword(user.getUserId(), user.getUserPassword());
        return loginUser;
    }

    @Transactional //
    public User 회원가입(User user) {
        return userRepository.save(user);
    }

}
