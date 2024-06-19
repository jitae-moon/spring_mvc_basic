package com.example.spring_mvc_basic.frontcontroller.v2;

import com.example.spring_mvc_basic.frontcontroller.ViewRenderer;
import com.example.spring_mvc_basic.frontcontroller.v2.controller.UserFormControllerV2;
import com.example.spring_mvc_basic.frontcontroller.v2.controller.UserListControllerV2;
import com.example.spring_mvc_basic.frontcontroller.v2.controller.UserSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/users/new-form", new UserFormControllerV2());
        controllerMap.put("/front-controller/v2/users/save", new UserSaveControllerV2());
        controllerMap.put("/front-controller/v2/users", new UserListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV2 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            return;
        }

        ViewRenderer view = controller.process(request, response);
        view.render(request, response);
    }

}
