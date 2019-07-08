package com.example.springunittesting.services;

import com.example.springunittesting.models.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ContactManagementServiceIntegrationTest {

    @Autowired
    private ContactsManagementService contactsManagementService;

    @Test
    public void testAddContactHappyPath() {

        // Create a contact
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Ayomide");
        aContact.setLastName("Oyekanmi");
        aContact.setEmail("ayomideoyekanmi@gmail.com");

        // Test adding the contact
        CustomerContact newContact = contactsManagementService.add(aContact);

        // Verify the addition
        assertNotNull(newContact);
        assertEquals("Ayomide", newContact.getFirstName());

    }
}
