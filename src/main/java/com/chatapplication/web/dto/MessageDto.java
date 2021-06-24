package com.chatapplication.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
