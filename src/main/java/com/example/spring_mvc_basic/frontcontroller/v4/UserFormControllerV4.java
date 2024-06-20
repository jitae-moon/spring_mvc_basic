package com.example.spring_mvc_basic.frontcontroller.v4;

import java.util.Map;

public class UserFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }

}
