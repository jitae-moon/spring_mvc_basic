package com.example.spring_mvc_basic.frontcontroller.v1.controller;

import com.example.spring_mvc_basic.frontcontroller.v1.ControllerV1;
import com.example.spring_mvc_basic.servlet.domain.UserAccount;
import com.example.spring_mvc_basic.servlet.repository.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserSaveControllerV1 implements ControllerV1 {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccount user = new UserAccount();

        String username = request.getParameter("username");
        user.setUsername(username);

        if (request.getParameter("age") != null) {
            int age = Integer.parseInt(request.getParameter("age"));
            user.setAge(age);
        }

        userRepository.save(user);

        request.setAttribute("user", user);

        String path = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

}
