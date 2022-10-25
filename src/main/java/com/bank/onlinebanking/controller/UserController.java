package com.bank.onlinebanking.controller;

import com.bank.onlinebanking.model.dto.UserDto;
import com.bank.onlinebanking.model.response.UpdatedUserResponse;
import com.bank.onlinebanking.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PutMapping("/updatePassword{phoneNumber}")
    public UpdatedUserResponse updatePassword(@PathVariable("phoneNumber") String phoneNumber, @RequestParam String password){
        return userService.updatePassword(phoneNumber,password);
    }
}
