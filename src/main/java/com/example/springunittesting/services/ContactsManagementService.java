package com.example.springunittesting.services;

import com.example.springunittesting.models.CustomerContact;
import com.example.springunittesting.repositories.CustomerContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactsManagementService {

    private CustomerContactRepository customerContactRepository;

    public ContactsManagementService(CustomerContactRepository customerContactRepository) {
        this.customerContactRepository = customerContactRepository;
    }

    public CustomerContact add(CustomerContact aContact) {

        if (aContact == null || aContact.getFirstName() == null || aContact.getFirstName().isEmpty()) {
            return null;
        }

        return customerContactRepository.save(aContact);
    }

}
