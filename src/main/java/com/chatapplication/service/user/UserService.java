package com.chatapplication.service.user;

import com.chatapplication.data.models.User;

public interface UserService {
    User getUserById(Long id);

    User updateUser(User user);

//    User saveUser(UserDto userDto);
//
//    void deleteUser(Long userId);
//
//    User viewUser(Long userId);
}
