package com.example.spring_mvc_basic.frontcontroller.v3;

import com.example.spring_mvc_basic.frontcontroller.ModelView;
import com.example.spring_mvc_basic.servlet.domain.UserAccount;
import com.example.spring_mvc_basic.servlet.repository.UserRepository;

import java.util.List;
import java.util.Map;

public class UserListControllerV3 implements ControllerV3 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<UserAccount> users = userRepository.findAll();

        ModelView mv = new ModelView("users");
        mv.getModel().put("users", users);

        return mv;
    }

}
