package com.example.spring_mvc_basic.frontcontroller.v2.controller;

import com.example.spring_mvc_basic.frontcontroller.ViewRenderer;
import com.example.spring_mvc_basic.frontcontroller.v2.ControllerV2;
import com.example.spring_mvc_basic.servlet.domain.UserAccount;
import com.example.spring_mvc_basic.servlet.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserSaveControllerV2 implements ControllerV2 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public ViewRenderer process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        UserAccount user = new UserAccount(username, age);
        userRepository.save(user);

        request.setAttribute("user", user);

        return new ViewRenderer("/WEB-INF/views/save-result.jsp");
    }

}
