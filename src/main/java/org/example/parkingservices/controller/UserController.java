package org.example.parkingservices.controller;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}
