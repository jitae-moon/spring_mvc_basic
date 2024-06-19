package com.example.spring_mvc_basic.frontcontroller.v1.controller;

import com.example.spring_mvc_basic.frontcontroller.v1.ControllerV1;
import com.example.spring_mvc_basic.servlet.domain.UserAccount;
import com.example.spring_mvc_basic.servlet.repository.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UserListControllerV1 implements ControllerV1 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserAccount> users = userRepository.findAll();
        request.setAttribute("users", users);

        String path = "/WEB-INF/views/users.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

}
