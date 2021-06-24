package com.chatapplication.service.chat;

import com.chatapplication.data.models.Chat;
import com.chatapplication.data.models.User;
import com.chatapplication.web.exceptions.ChatNotFoundException;
import com.chatapplication.web.exceptions.UserNotFoundException;

public interface ChatService {

    Chat createChat(User firstUser, User secondUser);

    Chat getChatById(Long chatId) throws ChatNotFoundException;

    Chat getChatForUsers(Long userId1, Long userId2) throws UserNotFoundException;

//    List<Message> getAllMessages(Long chatId);

//    Chat getChatById(Long chatId);


//    void deleteChat(Long chatId);

//    String viewUserImage(Long userId);

//    void addMessageToChat(Long chatId, MessageDto messageDto);
}