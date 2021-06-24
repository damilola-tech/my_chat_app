package com.chatapplication.service.user;

import com.chatapplication.data.models.User;
import com.chatapplication.data.repository.UserRepository;
import com.chatapplication.web.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        if (id == null) {
            throw new NullPointerException("User id cannot be null");
        }
            Optional<User> user = userRepository.findById(id);
            if (user.isEmpty()) {
                throw new UserNotFoundException("User with id" + id + "does not exist");
            }
            return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Order.desc("createdAt")));
    }
}





