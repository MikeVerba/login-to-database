package com.example.logintodatabase.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
@Data
public class ContactEntity {

    @Id
    @GeneratedValue()
    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private Integer userId;

}
