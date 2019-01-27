package com.example.logintodatabase.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_table")
@Data
public class UserEntity {
    @Id
    @GeneratedValue()
    private Integer id;
    private String name;
    private String password;
    private @Column(name = "entry_date") LocalDateTime time;

}
