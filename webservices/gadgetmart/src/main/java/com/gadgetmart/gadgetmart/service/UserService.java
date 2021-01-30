package com.gadgetmart.gadgetmart.service;

import com.gadgetmart.gadgetmart.entity.User;
import com.gadgetmart.gadgetmart.repository.UserRepository;
import com.waruna.gadgetmart_web.GetUserRequest;
import com.waruna.gadgetmart_web.SaveUserRequest;
import com.waruna.gadgetmart_web.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(SaveUserRequest user) {
        User entityUser = new User();
        entityUser.setUserId(user.getUserId());
        entityUser.setName(user.getName());
        entityUser.setAddress(user.getAddress());
        entityUser.setPhone(user.getPhone());
        entityUser.setPassword(user.getPassword());

        return userRepository.save(entityUser);
    }

    public User updateUser(UpdateUserRequest user) {
        User entityUser = new User();
        entityUser.setUserId(user.getUserId());
        entityUser.setName(user.getName());
        entityUser.setAddress(user.getAddress());
        entityUser.setPhone(user.getPhone());
        entityUser.setPassword(user.getPassword());

        return userRepository.save(entityUser);
    }
    public User getUserById(GetUserRequest request){
        return userRepository.findUserByUserId(request.getUserId());
    }
}
