package com.ktxdevelopment.siratumustakim.post.model.request;

import com.ktxdevelopment.siratumustakim.auth.user.model.entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class PostRequestModel {
    String postId;
    String title;
    String subtitle;
    ArrayList<String> tagIds;
    String categoryId;
    HashMap<String, String> content;
    ArrayList<User> authors;
    ArrayList<String> references;
    ArrayList<String> additionalPostIds;
    Long viewed;
};