package com.chatapplication.service.user;

import com.chatapplication.data.models.User;
import com.chatapplication.web.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    User getUserById(Long id) throws UserNotFoundException;

    List<User> getAllUsers();
}
