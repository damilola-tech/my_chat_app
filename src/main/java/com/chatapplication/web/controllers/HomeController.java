package com.chatapplication.web.controllers;

import com.chatapplication.data.models.Chat;
import com.chatapplication.data.models.Message;
import com.chatapplication.data.models.User;
import com.chatapplication.service.chat.ChatService;
import com.chatapplication.service.message.MessageService;
import com.chatapplication.service.user.UserService;
import com.chatapplication.web.dto.MessageDto;
import com.chatapplication.web.exceptions.ChatNotFoundException;
import com.chatapplication.web.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private MessageService messageService;

    @GetMapping
    public String index() {
        return "chat";
    }

    @GetMapping("/{userId}")
    public String index(Model model, @PathVariable Long userId, @ModelAttribute("chat") Chat chatToOpen) {

        try {
            User user = userService.getUserById(userId);

            for(Chat chat : user.getChats()) {
                setChatTitle(userId, chat);
            }

            model.addAttribute("userId", user.getId());
            model.addAttribute("chats", user.getChats());
            model.addAttribute("users", userService.getAllUsers());

            if(chatToOpen == null || chatToOpen.getUsers().isEmpty()) {
                model.addAttribute("chat", null);
            } else {
                model.addAttribute("chat", chatToOpen);
                log.info("Chat --> {}", chatToOpen);
                chatToOpen.getMessages().forEach(System.out::println);
            }

        } catch (UserNotFoundException e) {
            e.printStackTrace();
            //return no chats page, if exception
        }

        return "chat";
    }

    private void setChatTitle(Long userId, Chat chat) {
        if (userId.equals(chat.getUsers().get(0).getId())) {
            chat.setTitle(chat.getUsers().get(1).getName());
        } else {
            chat.setTitle(chat.getUsers().get(0).getName());
        }
    }

    @ModelAttribute
    public void createMessageDTO(Model model){
        model.addAttribute("messageDto", new MessageDto());
    }

    @GetMapping("/c/{userId1}/{userId2}")
    public RedirectView openChat(RedirectAttributes attributes,
                                 @PathVariable Long userId1, @PathVariable Long userId2) {

        try {
            Chat chat = chatService.getChatForUsers(userId1, userId2);
            attributes.addFlashAttribute("chat", chat);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        return new RedirectView("/" + userId1);
    }

    @PostMapping
    public String sendMessage(@ModelAttribute MessageDto messageDto, Model model) {

        try {
            messageService.createMessage(messageDto);
        } catch (UserNotFoundException | ChatNotFoundException e) {
            e.printStackTrace();
        }

        return String.format("redirect:/c/%d/%d", messageDto.getSenderId(), messageDto.getReceiverId());
    }
}
