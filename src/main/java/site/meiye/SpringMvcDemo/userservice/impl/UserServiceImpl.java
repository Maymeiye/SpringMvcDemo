package site.meiye.SpringMvcDemo.userservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import site.meiye.SpringMvcDemo.shared.Utils;
import site.meiye.SpringMvcDemo.ui.model.request.UserDetailsRequestModel;
import site.meiye.SpringMvcDemo.ui.model.response.UserRest;
import site.meiye.SpringMvcDemo.userservice.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {

        UserRest user = new UserRest();
        user.setFistName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());

        String userId = utils.generateUserId();
        user.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, user);

        return user;
    }
}
