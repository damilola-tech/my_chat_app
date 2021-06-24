package com.chatapplication.service.message;

import com.chatapplication.data.models.Message;
import com.chatapplication.web.exceptions.ChatNotFoundException;
import com.chatapplication.web.dto.MessageDto;
import com.chatapplication.web.exceptions.UserNotFoundException;


public interface MessageService {

    Message createMessage(MessageDto messageDto) throws ChatNotFoundException, UserNotFoundException;

//      Message addMessage(MessageDto messageDto);
//    Message sendMessage(MessageDto messageDto);

//    boolean deleteMessage(Long messageId);
}
