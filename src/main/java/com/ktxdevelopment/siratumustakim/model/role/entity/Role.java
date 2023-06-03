package com.ktxdevelopment.siratumustakim.model.role.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

//@Entity(name = "role")
@Table(name = "roles")
@Data
@Builder
public class Role {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "name")
    private String name;
}