package com.example.logintodatabase.models.services;

import com.example.logintodatabase.models.Contact;
import com.example.logintodatabase.models.UserForm;
import com.example.logintodatabase.models.entities.ContactEntity;
import com.example.logintodatabase.models.mappers.ContactEntityToContactMapper;
import com.example.logintodatabase.models.mappers.ContactToContactEntityMapper;
import com.example.logintodatabase.models.mappers.UserToUserEntityMapper;
import com.example.logintodatabase.models.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UserSession userSession;

    @Autowired
    ContactEntityToContactMapper contactEntityToContactMapper;

    @Autowired
    ContactToContactEntityMapper contactToContactEntityMapper;

    public List<ContactEntity> getContacts(){

        List<ContactEntity> contactEntities = contactRepository.getContactEntitiesByUserId(userSession.getUserEntity().getId());
        return contactEntities;

    }

    public boolean addContact(Contact contact, int userId) {

        contact.setUserId(userId);
        contactRepository.save(contactToContactEntityMapper.map(contact));

        return true;

    }


}
