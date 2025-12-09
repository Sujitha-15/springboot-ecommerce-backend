package com.ecommerce.service;

import com.ecommerce.model.User;
import java.util.List;

public interface UserService {

    User registerUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
}
