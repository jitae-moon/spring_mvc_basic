package com.example.spring_mvc_basic.frontcontroller.v2.controller;

import com.example.spring_mvc_basic.frontcontroller.ViewRenderer;
import com.example.spring_mvc_basic.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserFormControllerV2 implements ControllerV2 {

    @Override
    public ViewRenderer process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new ViewRenderer("/WEB-INF/views/new-form.jsp");
    }

}
