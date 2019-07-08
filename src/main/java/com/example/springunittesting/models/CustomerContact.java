package com.example.springunittesting.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer_contact")
@Getter (value = AccessLevel.PUBLIC)
@Setter
@NoArgsConstructor
public class CustomerContact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String deliveryAddress;

}