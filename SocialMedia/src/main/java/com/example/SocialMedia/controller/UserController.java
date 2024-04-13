package com.example.SocialMedia.controller;

import com.example.SocialMedia.Exception.UserException;
import com.example.SocialMedia.models.User;
import com.example.SocialMedia.repository.UserRepository;
import com.example.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
     @Autowired
    UserService userService;

    @GetMapping("/api/users")
    public List<User> getUsers(){
        List<User>users=userRepository.findAll();

          return users;
    }
    @GetMapping("/api/users/{userId}")
    public User getUserById(@PathVariable("userId")Integer id) throws UserException {

        User user=userService.findUserById(id);
        return user;

    }

    @PutMapping("api/users")
    public User updateUser(@RequestHeader ("Authorization")String jwt, @RequestBody User user) throws UserException {
//        User user1=new User(1,"code","zosh","codewithsunit","1234");

//        if(user.getFirstName()!=null){
//            user1.setFirstName(user.getFirstName());
//        }
//        if(user.getLastName()!=null){
//            user1.setLastName(user.getLastName());
//        }
//        if (user.getEmail()!=null){
//            user1.setEmail(user.getEmail());
//        }

        User regUser=userService.findUserByJwt(jwt);

        User updatedUser=userService.updateUser(user,regUser.getId());

        return updatedUser;
    }

    @PutMapping("/users/follow/{userId2}")
     public User followUserhandler(@RequestHeader ("Authorization")String jwt,@PathVariable Integer userId2) throws UserException {
        User regUser=userService.findUserByJwt(jwt);
        User user=userService.followUser(regUser.getId(),userId2);
        return user;
     }

@GetMapping("/api/user/search")
     public List<User>searchUser(@RequestParam("query")String query){
        List<User>users=userService.searchUser(query);

        return users;
     }

     @GetMapping("/api/users/profile")
     public User getUserFromToken(@RequestHeader ("Authorization")String jwt){
//         System.out.println("jwt------"+jwt);

        User user=userService.findUserByJwt(jwt);

        user.setPassword(null);
         return user;
     }




    @DeleteMapping("users/{userId}")
    public String deleteUser(@PathVariable Integer userId) throws UserException {

        Optional<User> user=  userRepository.findById(userId);

        if(user.isEmpty()){
            throw new UserException("user not exist with id"+userId);
        }
        userRepository.delete(user.get());

        return "User Deleted SuccessFullly"+userId;
    }

}
