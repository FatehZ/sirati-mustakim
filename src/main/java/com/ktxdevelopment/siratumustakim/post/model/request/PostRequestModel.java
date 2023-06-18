package com.ktxdevelopment.siratumustakim.post.model.request;

import com.ktxdevelopment.siratumustakim.auth.user.model.User;
import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;

import java.util.ArrayList;
import java.util.HashMap;

public class PostRequestModel {
    String title;
    String subtitle;
    ArrayList<String> tagIds;
    String categoryId;
    HashMap<String, String> content;
    ArrayList<User> authors; //todo
    ArrayList<String> references;
    ArrayList<String> additionalPostIds;
    Long viewed;
};
