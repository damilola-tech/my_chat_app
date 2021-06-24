//package com.chatapplication.data.repository;
//
//import com.chatapplication.data.models.Message;
//import org.junit.jupiter.api.BeforeEach;
//
//class MessageRepositoryTest {
//
//
//    @BeforeEach
//    void setUp() {
//    }
//// Save
//// read: findAll, findById(returns an optional), getById(returns the actual object)
//// delete
//
//    Optional<Message> foundMessage = messageRepository.findById(5L);
//
//    Message message;
//    if(foundMessage.isPresent()) {
//        message = foundMessage.get();
//    }
//
//    message = messageRepository.findById(4L).orElse(null);
//
//    message = messageRepository.getById(4L);
//
//    Message message = new Message();
//
//}