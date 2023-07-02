package com.ktxdevelopment.siratumustakim.post.model.request;

import com.ktxdevelopment.siratumustakim.auth.user.model.entity.User;

import java.util.HashMap;
import java.util.List;

public class PostRequestModel {
    String postId;
    String title;
    String subtitle;
    List<String> tagIds;
    String categoryId;
    HashMap<String, String> content;
    List<User> authors;
    List<String> references;
    List<String> additionalPostIds;
    Long viewed;
};