package com.example.actuatior.controller;

import com.example.actuatior.application.UserService;
import com.example.actuatior.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseBody
    public User save(@RequestBody @Validated User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User get(@PathVariable int id) {
        return userService.get(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public User update(@PathVariable int id, @RequestBody @Validated User user) {
        return userService.update(id, user);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Void> delete(@RequestParam int id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
