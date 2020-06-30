package site.meiye.SpringMvcDemo.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")// http://localhost:8080/users
public class UserController {
    @GetMapping
    public String getUser(){
        return "getUser method was called";
    }

    @PostMapping
    public String createUser(){
        return "CreateUser method was called";
    }

    @PutMapping
    public String updateUser(){
        return "updateUser method was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "DeleteUser method was called";
    }

}
