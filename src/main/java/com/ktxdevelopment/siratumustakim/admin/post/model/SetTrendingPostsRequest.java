package com.ktxdevelopment.siratumustakim.admin.post.model;

import lombok.Data;

import java.util.List;

public record SetTrendingPostsRequest(List<String> trends) {

}