package com.chatapplication.service.user;

import com.chatapplication.data.models.User;
import com.chatapplication.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(Long id) throws Exception {
        if (id == null) {
            throw new NullPointerException("User id cannot be null");
        }
            Optional<User> user = userRepository.findById(id);
            if (user.isEmpty()) {
                throw new Exception("User with id" + id + "does not exist");
            }
            return user.get();
    }
}





