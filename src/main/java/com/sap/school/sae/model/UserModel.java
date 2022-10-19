package com.sap.school.sae.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String mail;

    @Column
    private String phone;

    @Column
    private UUID uuid;
}
