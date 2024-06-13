package com.example.spring_mvc_basic.servlet.response;

import com.example.spring_mvc_basic.servlet.domain.UserAccount;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("moon");
        userAccount.setAge(29);

        String result = objectMapper.writeValueAsString(userAccount);

        response.getWriter().write(result);
    }

}
