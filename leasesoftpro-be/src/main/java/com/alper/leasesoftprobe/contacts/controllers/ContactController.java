package com.alper.leasesoftprobe.contacts.controllers;

import com.alper.leasesoftprobe.contacts.entity.Contact;
import com.alper.leasesoftprobe.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("")
    public ResponseEntity<List<Contact>> getContacts(){
        return  ResponseEntity.ok(this.contactService.getContacts());
    }

    @PostMapping("")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
         Contact saved = contactService.saveContact(contact);
         return  ResponseEntity.ok(saved);
    }

}
