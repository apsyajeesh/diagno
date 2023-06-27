package com.perscholas.persistence.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private long id;

    @Column(name = "FirstName")
    private String ufname;

    @Column(name = "LastName")
    private String ulname;

    @Column(name = "email")
    private String uemail;

    @Column(name = "PhoneNumber")
    private int uphone;

    @Column(name = "Age")
    private int uage;

    @Column(name = "Gender")
    private int ugender;




}