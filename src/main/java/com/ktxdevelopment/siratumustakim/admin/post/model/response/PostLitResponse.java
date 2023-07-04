package com.ktxdevelopment.siratumustakim.admin.post.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostLitResponse {
    String postId;
    String title;
    String subtitle;
};