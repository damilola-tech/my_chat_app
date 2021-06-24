package com.chatapplication.service.chat;

import com.chatapplication.data.models.Chat;
import com.chatapplication.data.models.User;
import com.chatapplication.data.repository.ChatRepository;
import com.chatapplication.service.user.UserService;
import com.chatapplication.web.exceptions.ChatNotFoundException;
import com.chatapplication.web.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    UserService userService;

    @Override
    public Chat createChat(User firstUser, User secondUser) {

        Chat chat = new Chat();

        chat.getUsers().add(firstUser);
        chat.getUsers().add(secondUser);

        chat.setCreatedAt(LocalDateTime.now());
        return chat;
    }

    @Override
    public Chat getChatById(Long chatId) throws ChatNotFoundException {

        if (chatId == null) {
            throw new NullPointerException("Chat id cannot be null");
        }

        Chat chat;
        chat = chatRepository.findById(chatId).orElse(null);

        if(chat == null) {
            throw new ChatNotFoundException("Chat with id " + chatId + " not found");
        }

        return chat;
    }

    @Override
    public Chat getChatForUsers(Long userId1, Long userId2) throws UserNotFoundException {

        if(userId1 == null || userId2 == null) {
            throw new NullPointerException("User Id cannot be null");
        }

        User user1 = userService.getUserById(userId1);
        User user2 = userService.getUserById(userId2);

        for(Chat chat: user1.getChats()) {
            if(chat.getUsers().get(0).getId().equals(userId2) ||
                    chat.getUsers().get(1).getId().equals(userId2)) {
                return chat;
            }
        }

        return createChat(user1, user2);
    }
//    public Chat saveChat()
}
