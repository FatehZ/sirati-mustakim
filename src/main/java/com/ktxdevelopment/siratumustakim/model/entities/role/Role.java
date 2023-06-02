package com.ktxdevelopment.siratumustakim.model.entities.role;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

//@Entity(name = "role")
@Table(name = "roles")
@Entity
@Data
@Builder
public class Role {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID) //todo
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "name")
    private String name;
}
