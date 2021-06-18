package com.chatapplication.web.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MessageDto {

    @NotNull
    private Long senderId;

    @NotNull
    private Long receiverId;

    @NotEmpty
    private String content;

    @NotNull
    private Long chatId;
}
