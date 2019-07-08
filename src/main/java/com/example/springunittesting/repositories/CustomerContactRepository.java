package com.example.springunittesting.repositories;

import com.example.springunittesting.models.CustomerContact;
import org.springframework.data.repository.CrudRepository;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

    CustomerContact findByEmail(String email);

    CustomerContact findFirstByEmail(String email);
}

