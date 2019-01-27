package com.example.logintodatabase.models;

import java.util.ArrayList;
import java.util.List;

public class ContactCollection {
    List<Contact> contactList;

    public ContactCollection() {
        contactList = new ArrayList<>();
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
