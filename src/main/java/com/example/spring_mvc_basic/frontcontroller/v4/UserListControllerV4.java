package com.example.spring_mvc_basic.frontcontroller.v4;

import com.example.spring_mvc_basic.servlet.domain.UserAccount;
import com.example.spring_mvc_basic.servlet.repository.UserRepository;

import java.util.List;
import java.util.Map;

public class UserListControllerV4 implements ControllerV4 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<UserAccount> users = userRepository.findAll();
        model.put("users", users);

        return "users";
    }

}
