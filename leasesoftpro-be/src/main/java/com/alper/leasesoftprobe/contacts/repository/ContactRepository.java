package com.alper.leasesoftprobe.contacts.repository;

import com.alper.leasesoftprobe.contacts.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findByContactUuid(UUID uuid);

}
