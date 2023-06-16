package com.ktxdevelopment.siratumustakim.category.model.response;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;

public class CategoryResponseModel {

    private String categoryId;
    private String title;
}
