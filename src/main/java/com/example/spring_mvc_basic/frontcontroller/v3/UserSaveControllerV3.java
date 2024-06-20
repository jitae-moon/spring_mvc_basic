package com.example.spring_mvc_basic.frontcontroller.v3;

import com.example.spring_mvc_basic.frontcontroller.ModelView;
import com.example.spring_mvc_basic.servlet.domain.UserAccount;
import com.example.spring_mvc_basic.servlet.repository.UserRepository;

import java.util.Map;

public class UserSaveControllerV3 implements ControllerV3 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username"); // HttpServletRequest를 사용 안 하도록 변경
        int age = Integer.parseInt(paramMap.get("age"));

        UserAccount user = new UserAccount(username, age);
        userRepository.save(user);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("user", user);

        return mv;
    }

}
