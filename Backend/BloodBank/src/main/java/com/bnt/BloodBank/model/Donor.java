package com.bnt.BloodBank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donors")
public class Donor {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

     @Column(name = "father_name", nullable = false)
    private String fatherName;

    @Column(name = "mother_name", nullable = false)
    private String motherName;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

   

    @Column(name = "address", nullable = false)
    private String address;
}
