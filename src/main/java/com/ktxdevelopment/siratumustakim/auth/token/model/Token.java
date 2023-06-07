package com.ktxdevelopment.siratumustakim.auth.token.model;


import com.ktxdevelopment.siratumustakim.auth.user.model.User;
import jakarta.persistence.*;

@Table(name = "tokens")
@Entity(name = "token")
public class Token {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;
}
