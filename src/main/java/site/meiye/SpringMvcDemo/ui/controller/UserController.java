package site.meiye.SpringMvcDemo.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.meiye.SpringMvcDemo.ui.model.request.UserDetailsRequestModel;
import site.meiye.SpringMvcDemo.ui.model.response.UserRest;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")// http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return "get users method was called: page: " + page + ", limit: " + limit;
    }

    @GetMapping(path = "/{userId}",
                produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){

        UserRest user = new UserRest();
        user.setFistName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());

        if (users == null) users = new HashMap<>();
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        users.put(userId, user);

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
