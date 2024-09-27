package me.dio.web.service.impl;

import org.springframework.stereotype.Service;

import me.dio.web.model.User;
import me.dio.web.repository.UserRepository;
import me.dio.web.service.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User newUser) {
        if (repository.existsByAccountNumber(newUser.getAccount().getNumber())) {
            throw new IllegalArgumentException(
                    "Account number " + newUser.getAccount().getNumber() + " already exists.");
        }
        return repository.save(newUser);
    }
}
