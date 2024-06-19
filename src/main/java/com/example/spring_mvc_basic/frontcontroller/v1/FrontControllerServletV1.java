package com.example.spring_mvc_basic.frontcontroller.v1;

import com.example.spring_mvc_basic.frontcontroller.v1.controller.UserFormControllerV1;
import com.example.spring_mvc_basic.frontcontroller.v1.controller.UserListControllerV1;
import com.example.spring_mvc_basic.frontcontroller.v1.controller.UserSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/users/new-form", new UserFormControllerV1());
        controllerMap.put("/front-controller/v1/users/save", new UserSaveControllerV1());
        controllerMap.put("/front-controller/v1/users", new UserListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV1 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(request, response);
    }
}
