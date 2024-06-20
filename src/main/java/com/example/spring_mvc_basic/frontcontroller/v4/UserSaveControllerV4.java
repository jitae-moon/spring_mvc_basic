package com.example.spring_mvc_basic.frontcontroller.v4;

import com.example.spring_mvc_basic.servlet.domain.UserAccount;
import com.example.spring_mvc_basic.servlet.repository.UserRepository;

import java.util.Map;

public class UserSaveControllerV4 implements ControllerV4 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        UserAccount user = new UserAccount(username, age);
        userRepository.save(user);

        model.put("user", user); // 넘겨준 model에 그대로 저장

        return "save-result";
    }

}
