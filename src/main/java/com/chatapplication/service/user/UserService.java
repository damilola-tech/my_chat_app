package com.chatapplication.service.user;

import com.chatapplication.data.models.User;

public interface UserService {
    User getUserById(Long id) throws Exception;

}
