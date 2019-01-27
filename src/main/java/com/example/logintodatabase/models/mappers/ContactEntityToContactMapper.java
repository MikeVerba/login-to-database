package com.example.logintodatabase.models.mappers;

import com.example.logintodatabase.models.Contact;
import com.example.logintodatabase.models.entities.ContactEntity;
import org.springframework.stereotype.Service;

@Service
public class ContactEntityToContactMapper extends Mapper<ContactEntity, Contact> {
    @Override
    public Contact map(ContactEntity key) {
        Contact contact = new Contact();
        contact.setName(key.getName());
        contact.setSurname(key.getSurname());
        contact.setPhoneNumber(key.getPhoneNumber());

        return contact ;
    }
}
