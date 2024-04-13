package com.example.SocialMedia.request;

import com.example.SocialMedia.models.Chat;
import com.example.SocialMedia.models.User;
import com.example.SocialMedia.repository.ChatRepository;
import com.example.SocialMedia.service.ChatService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateChatRequest {

    private Integer userId;



}
