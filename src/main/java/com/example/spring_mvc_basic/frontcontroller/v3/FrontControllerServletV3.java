package com.example.spring_mvc_basic.frontcontroller.v3;

import com.example.spring_mvc_basic.frontcontroller.ModelView;
import com.example.spring_mvc_basic.frontcontroller.ViewRenderer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/users/new-form", new UserFormControllerV3());
        controllerMap.put("/front-controller/v3/users/save", new UserSaveControllerV3());
        controllerMap.put("/front-controller/v3/users", new UserListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();
        ViewRenderer view = viewResolver(viewName);
        view.render(mv.getModel(), request, response);
    }

    // HttpServletRequet에서 파라미터 정보 추출 후 맵으로 변환하는 메서드
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }

    private ViewRenderer viewResolver(String viewName) {
        return new ViewRenderer("/WEB-INF/views/" + viewName + ".jsp");
    }

}
