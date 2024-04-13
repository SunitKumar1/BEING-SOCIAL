package com.example.SocialMedia.controller;

import com.example.SocialMedia.models.Chat;
import com.example.SocialMedia.models.User;
import com.example.SocialMedia.repository.ChatRepository;
import com.example.SocialMedia.request.CreateChatRequest;
import com.example.SocialMedia.service.ChatService;
import com.example.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

        @PostMapping("/api/chats")
        public Chat createChat(@RequestHeader("Authorization")String jwt,@RequestBody CreateChatRequest req) throws Exception {

            User regUser=userService.findUserByJwt(jwt);
            User user2=userService.findUserById(req.getUserId());
            Chat chat=chatService.createChat(regUser,user2);

            return chat;
        }

    @GetMapping("/api/chats")
    public List<Chat> findUserschat( @RequestHeader("Authorization")String jwt){

        User user=userService.findUserByJwt(jwt);
         List<Chat> chats=chatService.findUsersChat(user.getId());

        return chats;
    }

}
