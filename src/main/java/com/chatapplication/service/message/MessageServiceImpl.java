// The methods we are calling on the message, userService, and chatService have already been
// defined in them. Check message model to see content, receiver, sender. Check the userService
// to see the getUserById which was implemented by the @Data annotation that generates getters and setters.

// We injected the dependency userService for example because we called a method that exists in userService,
// So to use userService in this class, we need to do autowire or inject it into this class.

// We created a new message object by doing Message message = new Message because we are trying to implement
// a method called createMessage and we need a new message object to be able to create the message. We
// can't call these methods that were needed on the messageDto because the method doesn't occur in the messageDto
// before, if not, we would have used messageDto instead.
// Also, we can't do @Autowired for message because it was not marked as a component initially.
package com.chatapplication.service.message;

import com.chatapplication.data.models.Chat;
import com.chatapplication.data.models.Message;
import com.chatapplication.data.models.User;
import com.chatapplication.data.repository.MessageRepository;
import com.chatapplication.service.chat.ChatService;
import com.chatapplication.service.user.UserService;
import com.chatapplication.web.dto.ChatDto;
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
    public Message createMessage(MessageDto messageDto) throws Exception {

//            If an object is pointing to null, it means it has not been created/constructed;
//            it doesn't exist
        if (messageDto == null) {
            throw new Exception("Message body cannot be null");
        }

        Message message = new Message();

//        This(a)
//        String content = messageDto.getContent();  // content returns a String. Content is one of the properties in messageDto...check.
//        message.setContent(content);

//        Or this (a)
        message.setContent(messageDto.getContent());

//        This (b)
//        Long userIdOrReceiverIdToBeSpecific = messageDto.getReceiverId();
//        User weNeedTheUserFirst = userService.getUserById(userIdOrReceiverIdToBeSpecific);
//        message.setReceiver(weNeedTheUserFirst);      // You can't get the receiverId directly until you get to user(the receiver is a user)

//        Or this (b)
        User receiver = userService.getUserById(messageDto.getReceiverId());
        message.setReceiver(receiver);


        User sender = userService.getUserById(messageDto.getSenderId());
        message.setSender(sender);


        Chat chat;

        ChatDto chatDto = new ChatDto(messageDto.getSenderId(), messageDto.getReceiverId());

        if (messageDto.getChatId() <= 0) {
            chat = chatService.createChat(new ChatDto(messageDto.getSenderId(), messageDto.getReceiverId()));
            receiver.getChats().add(chat);
            sender.getChats().add(chat);
            userService.updateUser(receiver);
            userService.updateUser(sender);
        } else {
            chat = chatService.getChatById(messageDto.getChatId());
        }
        message.setChat(chat);
        chat.getMessages().add(message);    // chat.getMessages() gives you the list of messages.

        // message.setCreatedAt(LocalDateTime.now());
        return messageRepository.save(message);
    }

//    @Override
//    public Message createMessage(MessageDto messageDto) throws Exception {
//
//        if (messageDto == null) {
//            throw new Exception("Message body cannot be null");
//        }
//            Message message = new Message();
//
//            message.setContent(messageDto.getContent());
//
//            message.setReceiver(userService.getUserById(messageDto.getReceiverId()));
//
//            message.setSender(userService.getUserById(messageDto.getSenderId()));
//
//            Chat chat;
//
//            ChatDto chatDto = new chatDto(messageDto.getReceiverId(), messageDto.getSenderId());
//            chat = chatService.createChat(chatDto);
//            message.setChat(chat);
//    }
}
