package com.cos.book.web;

import com.cos.book.domain.Book;
import com.cos.book.domain.User;
import com.cos.book.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> save(@RequestBody User user, HttpServletRequest req, RedirectAttributes rttr){
        HttpSession session = req.getSession();
        User loginUser = userService.로그인(user);

        if(loginUser == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            session.setAttribute("user", loginUser);
            return new ResponseEntity<>(loginUser, HttpStatus.OK);
        }

    }

    @CrossOrigin
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody User user){
        return new ResponseEntity<>(userService.회원가입(user), HttpStatus.CREATED);
    }

}
