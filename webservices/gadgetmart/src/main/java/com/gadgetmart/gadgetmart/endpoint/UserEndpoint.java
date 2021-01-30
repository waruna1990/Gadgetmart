package com.gadgetmart.gadgetmart.endpoint;

import com.gadgetmart.gadgetmart.entity.User;
import com.gadgetmart.gadgetmart.service.UserService;
import com.waruna.gadgetmart_web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    UserService userService;

    @Autowired
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = "http://waruna.com/gadgetmart-web",
            localPart = "saveUserRequest")
    @ResponsePayload
    public SaveUserResponse saveUser(@RequestPayload SaveUserRequest request){
        User savedUser = userService.saveUser(request);
        SaveUserResponse response = new SaveUserResponse();
        response.setUserId(savedUser.getUserId());
        response.setName(savedUser.getName());
        response.setAddress(savedUser.getAddress());
        response.setPhone(savedUser.getPhone());

        return response;
    }

    @PayloadRoot(namespace = "http://waruna.com/gadgetmart-web",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse saveUser(@RequestPayload GetUserRequest request){

        User user = userService.getUserById(request);
        GetUserResponse response = new GetUserResponse();
        response.setUserId(user.getUserId());
        response.setName(user.getName());
        response.setPhone(user.getPhone());
        response.setAddress(user.getAddress());
        return response;
    }

    @PayloadRoot(namespace = "http://waruna.com/gadgetmart-web",
            localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse saveUser(@RequestPayload UpdateUserRequest request){
        User savedUser = userService.updateUser(request);
        UpdateUserResponse response = new UpdateUserResponse();
        response.setUserId(savedUser.getUserId());
        response.setName(savedUser.getName());
        response.setAddress(savedUser.getAddress());
        response.setPhone(savedUser.getPhone());
        return response;
    }
}
