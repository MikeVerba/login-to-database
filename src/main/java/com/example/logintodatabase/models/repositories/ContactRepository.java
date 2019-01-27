package com.example.logintodatabase.models.repositories;

import com.example.logintodatabase.models.entities.ContactEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ContactRepository extends CrudRepository<ContactEntity,Integer> {
    @Query(value = "SELECT * FROM `contact` WHERE `user_id` = ?1", nativeQuery = true)
    List<ContactEntity> getContactEntitiesByUserId(Integer userId);

}
