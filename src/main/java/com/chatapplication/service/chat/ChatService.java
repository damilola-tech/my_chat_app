package com.chatapplication.service.chat;

import com.chatapplication.data.models.Chat;
import com.chatapplication.data.models.User;
import com.chatapplication.web.exceptions.ChatException;

public interface ChatService {

    Chat createChatForMessage(User firstUser, User secondUser);

    Chat getChatById(Long chatId) throws ChatException;

//    List<Message> getAllMessages(Long chatId);

//    Chat getChatById(Long chatId);


//    void deleteChat(Long chatId);

//    String viewUserImage(Long userId);

//    void addMessageToChat(Long chatId, MessageDto messageDto);
}