package com.example.SocialMedia.controller;

import com.example.SocialMedia.models.Post;
import com.example.SocialMedia.models.User;
import com.example.SocialMedia.response.ApiResponse;
import com.example.SocialMedia.service.PostService;
import com.example.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;
    @PostMapping("/api/posts")
    public ResponseEntity<Post>createPost(@RequestHeader ("Authorization")String jwt,@RequestBody Post post
                                          ) throws Exception {

        User regUser=userService.findUserByJwt(jwt);

        Post createdPost=postService.createNewPost(post,regUser.getId());

        return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED) ;
    }

    @DeleteMapping("/api/posts/{postId}")
    public ResponseEntity<ApiResponse>deletePost(@PathVariable Integer postId,
                                                 @RequestHeader ("Authorization")String jwt) throws Exception {

        User regUser=userService.findUserByJwt(jwt);

        String message=postService.deletePost(postId,regUser.getId());
      ApiResponse res=new ApiResponse(message,true);
        return new  ResponseEntity<ApiResponse>(res,HttpStatus.OK);
    }

    @GetMapping("/api/posts/{postId}")
    public ResponseEntity<Post>findPostByIdHandler(@PathVariable Integer postId) throws Exception {

        Post post=postService.findPostById(postId);

        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }

    @GetMapping("/api/posts/user/{userId}")
    public ResponseEntity<List<Post>>findUsersPost(@PathVariable Integer userId){

        List<Post>posts=postService.findPostByUserId(userId);

        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }

    @GetMapping("/api/posts")
    public ResponseEntity<List<Post>>findAllPost(){

        List<Post>posts=postService.findAllPost();

        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }

    @PutMapping("/api/posts/save/{postId}")
    public ResponseEntity<Post>savePostHandler(@PathVariable Integer postId, @RequestHeader ("Authorization")String jwt) throws Exception {

        User regUser=userService.findUserByJwt(jwt);

        Post post=postService.savedPost(postId,regUser.getId());

        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/posts/like/{postId}")
    public ResponseEntity<Post>likePostHandler(@PathVariable Integer postId, @RequestHeader ("Authorization")String jwt) throws Exception {

        User regUser=userService.findUserByJwt(jwt);

        Post post=postService.likePost(postId, regUser.getId());

        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }

}
