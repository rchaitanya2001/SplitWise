package org.example.splitwise.Controllers;

import org.example.splitwise.Dtos.Transaction;

import org.example.splitwise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    public UserService userService;


    public List<Transaction> settleUpGroup(Long groupId){
        return userService.settleUpGroup(groupId);
    }
}