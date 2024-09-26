package me.dio.web.service;

import me.dio.web.model.User;

public interface UserService {
    User findById(Long id);

    User create(User user);
}
