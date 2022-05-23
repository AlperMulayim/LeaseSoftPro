package com.alper.leasesoftprobe.contacts.entity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Entity
@Table(name = "lesapro_contacts")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "user_uid", updatable = false)
    private UUID userUID = UUID.randomUUID();

    @Column(name = "username")
    private String username;

    @Column(name = "surname")
    private String surname;

    @Pattern(regexp="(^$|[0-9]{10})")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name= "adress")
    private String adress;

    @Column(name = "company")
    private String company;

    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Column(name = "email")
    private  String email;

}