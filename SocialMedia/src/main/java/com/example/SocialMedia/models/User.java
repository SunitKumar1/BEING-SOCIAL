package com.example.SocialMedia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private List<Integer>followers=new ArrayList<>();
    private List<Integer>followings=new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    private List<Post>savedPost=new ArrayList<>();

    public User(){

    }

}
