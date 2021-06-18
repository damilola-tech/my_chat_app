package com.chatapplication.web.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {

    @NotEmpty(message = "Name cannot be null")
    private String firstName;

    private String lastName;

    private MultipartFile imageFile;

}
