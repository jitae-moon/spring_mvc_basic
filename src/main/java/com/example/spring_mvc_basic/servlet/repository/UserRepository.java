package com.example.spring_mvc_basic.servlet.repository;

import com.example.spring_mvc_basic.servlet.domain.UserAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private static Map<Long, UserAccount> map = new HashMap<>();
    private static long sequence = 0L;

    private static final UserRepository instance = new UserRepository();

    public static UserRepository getInstance() {
        return instance;
    }

    private UserRepository() {}

    public UserAccount save(UserAccount userAccount) {
        userAccount.setId(++sequence);
        map.put(userAccount.getId(), userAccount);
        return userAccount;
    }

    public UserAccount findById(Long id) {
        return map.get(id);
    }

    public List<UserAccount> findAll() {
        return map.values().stream().toList();
    }

    public void clearMap() {
        map.clear();
    }

}
