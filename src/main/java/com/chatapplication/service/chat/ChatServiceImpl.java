package com.chatapplication.service.chat;

import com.chatapplication.data.models.Chat;
import com.chatapplication.data.models.User;
import com.chatapplication.data.repository.ChatRepository;
import com.chatapplication.web.exceptions.ChatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatRepository chatRepository;

    @Override
    public Chat createChatForMessage(User firstUser, User secondUser) {

        Chat chat = new Chat();

        chat.getUsers().add(firstUser);
        chat.getUsers().add(secondUser);
        return chat;
    }

    @Override
    public Chat getChatById(Long chatId) throws ChatException {

        if (chatId == null) {
            throw new ChatException("Chat id cannot be null");
        }

        Chat chat;
        chat = chatRepository.findById(chatId).orElse(null);
        return chat;
    }
//    public Chat saveChat()
}
