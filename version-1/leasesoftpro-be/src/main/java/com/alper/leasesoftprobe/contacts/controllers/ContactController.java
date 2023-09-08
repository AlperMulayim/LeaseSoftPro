package com.alper.leasesoftprobe.contacts.controllers;

import com.alper.leasesoftprobe.contacts.entity.Contact;
import com.alper.leasesoftprobe.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("")
    public ResponseEntity<Page<Contact>> getContacts(
            @RequestParam(name = "page", required = false) Optional<Integer> page,
            @RequestParam(name = "size", required = false) Optional<Integer> size){

        if(page.isPresent() && size.isPresent()){
           return ResponseEntity.ok(this.contactService.getContacts(page.get(),size.get()));
        }
        return ResponseEntity.ok(this.contactService.getContacts(0,Integer.MAX_VALUE));
    }

    @PostMapping("")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
         Contact saved = contactService.saveContact(contact);
         return  ResponseEntity.ok(saved);
    }

}
