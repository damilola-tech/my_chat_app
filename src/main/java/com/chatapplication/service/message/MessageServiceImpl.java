package com.chatapplication.service.message;

import com.chatapplication.data.models.Chat;
import com.chatapplication.data.models.Message;
import com.chatapplication.data.models.User;
import com.chatapplication.data.repository.MessageRepository;
import com.chatapplication.service.chat.ChatService;
import com.chatapplication.service.user.UserService;
import com.chatapplication.web.exceptions.ChatNotFoundException;
import com.chatapplication.web.dto.MessageDto;
import com.chatapplication.web.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message createMessage(MessageDto messageDto) throws ChatNotFoundException, UserNotFoundException {

        if (messageDto == null) {
            throw new NullPointerException("Message body cannot be null");
        }

        Message message = new Message();

        message.setContent(messageDto.getContent());

        User receiver = userService.getUserById(messageDto.getReceiverId());
        message.setReceiver(receiver);

        User sender = userService.getUserById(messageDto.getSenderId());
        message.setSender(sender);

        Chat chat;
        if (messageDto.getChatId() == null) {
            chat = chatService.createChat(sender, receiver);
            receiver.getChats().add(chat);
            sender.getChats().add(chat);
        } else {
            chat = chatService.getChatById(messageDto.getChatId());
        }

        log.info("Sender --> {}", sender);
        log.info("Receiver --> {}", receiver);
        log.info("Chat --> {}", chat);
        log.info("Message --> {}", message);

        message.setChat(chat);
        chat.getMessages().add(message);

        return messageRepository.save(message);
    }
}
