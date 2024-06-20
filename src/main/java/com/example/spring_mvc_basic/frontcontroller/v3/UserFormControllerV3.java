package com.example.spring_mvc_basic.frontcontroller.v3;

import com.example.spring_mvc_basic.frontcontroller.ModelView;

import java.util.Map;

public class UserFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }

}
