package com.example.spring_mvc_basic.frontcontroller.v3;

import com.example.spring_mvc_basic.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap); // HttpServletRequest, HttpServletResponse를 사용하지 않으려고

}
