package com.chatapplication.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class ChatDto {

    @NotEmpty
    private Long senderId;

    @NotEmpty
    private Long receiverId;

}
