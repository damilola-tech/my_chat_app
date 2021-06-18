package com.chatapplication.service.chat;

import com.chatapplication.data.models.Chat;
import com.chatapplication.data.models.Message;
import com.chatapplication.service.message.MessageService;
import com.chatapplication.service.user.UserService;
import com.chatapplication.web.dto.ChatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatServiceImpl implements ChatService {

    @Override
    public Chat createChat(ChatDto chatDto) {

        Chat chat = new Chat();

        Long b = messageDto.getMessageId();
        List<Message> a = chatService.getMessageById(b);
        chat.setMessages(a);

        chat.setReceiver(userService.getUserById(messageDto.getReceiverId));
    }

    @Override
    public Chat getChatById(Long chatId) {
        return null;
    }


//    @Override
//    public List<Message> getAllMessages(Long chatId) {
//        return null;
//    }
//
//    @Override
//    public Chat getChatById(Long chatId) {
//        return null;
//    }
//
//    @Override
//    public void deleteChat(Long chatId) {
//
//    }
//
//    @Override
//    public String viewUserImage(Long userId) {
//        return null;
//    }
//
//    @Override
//    public void addMessageToChat(Long chatId, MessageDto messageDto) {
//
//    }
}
