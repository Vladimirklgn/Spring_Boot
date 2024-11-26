package org.example.service;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findUserById(id).orElse(null);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.saveUser(user);
    }
}
