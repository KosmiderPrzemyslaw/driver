package pl.coderslab.service;

import pl.coderslab.model.User;

import java.util.List;

public interface UserService {
    User findByUserName(String name);
    List<User> findAll();
    void saveUser(User user);
}
