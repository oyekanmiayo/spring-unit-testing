package com.example.springunittesting.controllers;

import com.example.springunittesting.models.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest {

    @Autowired
    ContactsManagementController contactsManagementController;

    @Test
    public void testAddContactSuccessfully() {

        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("John");
        aContact.setLastName("Doe");

        String response = contactsManagementController.processAddContact(aContact);
        assertThat(response, is(equalTo("/addContactForm")));

    }

    @Test
    public void testAddContactWithFirstNameMissing() {

        CustomerContact customerContact = new CustomerContact();

        String response = contactsManagementController.processAddContact(customerContact);
        assertThat(response, is(equalTo("redirect:/showAddContact")));

    }
}
