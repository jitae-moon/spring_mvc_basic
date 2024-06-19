package com.example.spring_mvc_basic.frontcontroller.v2.controller;

import com.example.spring_mvc_basic.frontcontroller.ViewRenderer;
import com.example.spring_mvc_basic.frontcontroller.v2.ControllerV2;
import com.example.spring_mvc_basic.servlet.domain.UserAccount;
import com.example.spring_mvc_basic.servlet.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UserListControllerV2 implements ControllerV2 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public ViewRenderer process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserAccount> users = userRepository.findAll();

        request.setAttribute("users", users);

        return new ViewRenderer("/WEB-INF/views/users.jsp");
    }

}
