package com.kairos.starConnect.controller;

import com.kairos.starConnect.entities.User;
import com.kairos.starConnect.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class ApiController {
    private final UserService userService;

    @GetMapping("/online-user")
    public List<User> getOnLineUsers(){
        return userService.getOnlineUsers();
    }


}
