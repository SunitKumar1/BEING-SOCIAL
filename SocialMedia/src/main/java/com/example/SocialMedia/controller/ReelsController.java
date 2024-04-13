package com.example.SocialMedia.controller;

import com.example.SocialMedia.models.Reels;
import com.example.SocialMedia.models.User;
import com.example.SocialMedia.service.ReelsService;
import com.example.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReelsController {

    @Autowired
    private ReelsService reelsService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/reels")
     public Reels createReels(@RequestBody Reels reel, @RequestHeader("Authorization")String jwt){

         User regUser=userService.findUserByJwt(jwt);

         Reels createdReels=reelsService.createReel( reel,regUser);

         return createdReels;
     }

    @GetMapping("/api/reels")
    public List<Reels> findAllReels(){


        List<Reels>reels=reelsService.findAllReels();

        return reels;
    }

    @GetMapping("/api/reels/user/{userId}")
    public List<Reels> findUserReels(@PathVariable Integer userId) throws Exception {


        List<Reels>reels=reelsService.findUsersReel(userId);

        return reels;
    }


}
