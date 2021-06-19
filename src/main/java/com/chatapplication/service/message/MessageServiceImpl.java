package com.chatapplication.service.message;

import com.chatapplication.data.models.Chat;
import com.chatapplication.data.models.Message;
import com.chatapplication.data.models.User;
import com.chatapplication.data.repository.MessageRepository;
import com.chatapplication.service.chat.ChatService;
import com.chatapplication.service.user.UserService;
import com.chatapplication.web.exceptions.ChatException;
import com.chatapplication.web.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;

    private MessageRepository messageRepository;

    @Override
    public Message createMessage(MessageDto messageDto) throws Exception, ChatException {

        if (messageDto == null) {
            throw new Exception("Message body cannot be null");
        }

        Message message = new Message();

        message.setContent(messageDto.getContent());

        User receiver = userService.getUserById(messageDto.getReceiverId());
        message.setReceiver(receiver);

        User sender = userService.getUserById(messageDto.getSenderId());
        message.setSender(sender);

        Chat chat;
        if (messageDto.getChatId() <= 0) {
            chat = chatService.createChatForMessage(sender, receiver);
            receiver.getChats().add(chat);
            sender.getChats().add(chat);
        } else {
            chat = chatService.getChatById(messageDto.getChatId());
        }
        message.setChat(chat);
        chat.getMessages().add(message);

        return messageRepository.save(message);
    }
}
