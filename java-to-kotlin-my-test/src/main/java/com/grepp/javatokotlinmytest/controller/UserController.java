package com.grepp.javatokotlinmytest.controller;

import com.grepp.javatokotlinmytest.entity.User;
import com.grepp.javatokotlinmytest.service.UserService;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // C
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request){
        User user = userService.createUser(request.getName(), request.getEmail());

        return ResponseEntity.ok(user);
    }

    // R
    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id){
        Optional<User> user = userService.findUser(id);

        return user.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // U
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
        @PathVariable Long id,
        @RequestParam String name
    ) {
        User user = userService.updateUser(id, name);

        return ResponseEntity.ok(user);
    }

}
