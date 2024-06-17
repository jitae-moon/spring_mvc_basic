package com.example.spring_mvc_basic.servlet.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAccount {

    private Long id;
    private String username;
    private int age;

    public UserAccount(String username, int age) {
        this.username = username;
        this.age = age;
    }

}
