package site.meiye.SpringMvcDemo.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.meiye.SpringMvcDemo.exceptions.UserServiceException;
import site.meiye.SpringMvcDemo.ui.model.request.UpdateUserDetailsRequestModel;
import site.meiye.SpringMvcDemo.ui.model.request.UserDetailsRequestModel;
import site.meiye.SpringMvcDemo.ui.model.response.UserRest;
import site.meiye.SpringMvcDemo.userservice.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")// http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return "get users method was called: page: " + page + ", limit: " + limit;
    }

    @GetMapping(path = "/{userId}",
                produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

//        String firstName = null;
//        int firstNameLength = firstName.length();
        if(true) throw new UserServiceException("A user service exception is thrown");

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

        UserRest user = userService.createUser(userDetails);

        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
                 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails){
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFistName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }

}
