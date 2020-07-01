package site.meiye.SpringMvcDemo.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.meiye.SpringMvcDemo.ui.model.request.UserDetailsRequestModel;
import site.meiye.SpringMvcDemo.ui.model.response.UserRest;

import javax.validation.Valid;

@RestController
@RequestMapping("users")// http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return "get users method was called: page: " + page + ", limit: " + limit;
    }

    @GetMapping(path = "/{userId}",
                produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        UserRest user = new UserRest();
        user.setFistName("Mei");
        user.setLastName("Ye");
        user.setEmail("meiye@gmail.com");

        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){

        UserRest user = new UserRest();
        user.setFistName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());

        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
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
