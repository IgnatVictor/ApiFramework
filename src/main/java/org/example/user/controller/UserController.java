package org.example.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonObject;
import org.example.user.api.UserApi;
import org.example.user.repository.UserRepository;
import org.example.user.service.UserService;

import java.util.List;


//@Component
//@RestController
//@RequestMapping("https://reqres.in/api/")

public class UserController {


    private UserService userService;





    private UserApi userApi = new UserApi();

    public UserController(String selectService) throws JsonProcessingException {
        if (selectService == "apiUserService") {
            userService = new UserService(2);
        }

        if (selectService == "userServiceRepository") {
            userService = new UserService();
        }

    }

    public JsonObject getUserDetails() {

        return userApi.getUserDetails(userService.getName(0), userService.getId(0));
    }

//    public List<JsonObject> getUsers() {
//        return
//    }


}



