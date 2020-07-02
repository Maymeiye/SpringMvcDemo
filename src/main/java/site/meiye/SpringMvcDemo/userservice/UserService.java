package site.meiye.SpringMvcDemo.userservice;

import site.meiye.SpringMvcDemo.ui.model.request.UserDetailsRequestModel;
import site.meiye.SpringMvcDemo.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
