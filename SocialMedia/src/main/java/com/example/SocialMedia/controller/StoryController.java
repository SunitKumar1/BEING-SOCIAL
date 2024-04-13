package com.example.SocialMedia.controller;

import com.example.SocialMedia.models.Story;
import com.example.SocialMedia.models.User;
import com.example.SocialMedia.service.StoryService;
import com.example.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/story")
    public Story createStory(@RequestBody Story story, @RequestHeader("Authorization")String jwt){

        User regUser=userService.findUserByJwt(jwt);
        Story createdStory=storyService.createStory(story,regUser);

        return createdStory;
    }

    @GetMapping("/api/story/user/{userId}")
    public List<Story> findUserStory(@PathVariable Integer userId, @RequestHeader("Authorization")String jwt) throws Exception {

        User regUser=userService.findUserByJwt(jwt);
        List<Story>stories =storyService.findStoryByUserId(userId);

        return stories;
    }
}
