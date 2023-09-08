package com.alper.leasesoftprov2.leasesoft.employees;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "ldb_employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="start_date", columnDefinition = "DATE")
    private Date startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private Date endDate;

    @Column(name = "job_title")
    private String jobTitle;
}
