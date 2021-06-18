package com.chatapplication.service.chat;

import com.chatapplication.data.models.Chat;
import com.chatapplication.web.dto.ChatDto;

public interface ChatService {

    Chat createChat(ChatDto chatDto);

    Chat getChatById(Long chatId);

//    List<Message> getAllMessages(Long chatId);

//    Chat getChatById(Long chatId);


//    void deleteChat(Long chatId);

//    String viewUserImage(Long userId);

//    void addMessageToChat(Long chatId, MessageDto messageDto);
}