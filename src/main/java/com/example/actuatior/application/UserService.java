package com.example.actuatior.application;

import com.example.actuatior.controller.UserNotFoundException;
import com.example.actuatior.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }


    @Transactional
    public User update(int id, User user) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found"));
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        foundUser.setArticles(user.getArticles());
        return userRepository.save(foundUser);
    }


    public User get(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found"));
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }


}
