package com.employee.service;
import com.employee.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
        // Adding a sample user for testing
        users.put("john", new User("hari", "password"));
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}
