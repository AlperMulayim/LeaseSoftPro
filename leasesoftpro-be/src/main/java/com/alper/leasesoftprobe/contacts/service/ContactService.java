package com.alper.leasesoftprobe.contacts.service;

import com.alper.leasesoftprobe.contacts.entity.Contact;
import com.alper.leasesoftprobe.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;

    public List<Contact> getContacts(){
        return  repository.findAll();
    }

    public Page<Contact> getContacts(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return  repository.findAll(pageable);
    }
    public Contact saveContact(Contact contact){
        return  repository.save(contact);
    }
    public Contact getContact(UUID uuid){
        return  repository.findByContactUuid(uuid);
    }
}
