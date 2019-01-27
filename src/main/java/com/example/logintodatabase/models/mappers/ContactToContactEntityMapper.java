package com.example.logintodatabase.models.mappers;

import com.example.logintodatabase.models.Contact;
import com.example.logintodatabase.models.entities.ContactEntity;
import org.springframework.stereotype.Service;

@Service
public class ContactToContactEntityMapper extends Mapper<Contact, ContactEntity> {
    @Override
    public ContactEntity map(Contact key) {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setName(key.getName());
        contactEntity.setSurname(key.getSurname());
        contactEntity.setPhoneNumber(key.getPhoneNumber());
        contactEntity.setEmail(key.getEmail());
        contactEntity.setUserId(key.getUserId());


        return contactEntity;
    }
}
