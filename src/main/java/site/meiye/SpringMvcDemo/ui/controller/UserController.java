package site.meiye.SpringMvcDemo.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")// http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page") int page,
                           @RequestParam(value = "limit") int limit) {
        return "get users method was called: page: " + page + ", limit: " + limit;
    }

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId){


        return "getUser method was called with = "+ userId;
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
