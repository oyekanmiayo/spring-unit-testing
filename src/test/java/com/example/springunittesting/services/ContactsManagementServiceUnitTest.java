package com.example.springunittesting.services;

import com.example.springunittesting.models.CustomerContact;
import com.example.springunittesting.repositories.CustomerContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ContactsManagementServiceUnitTest {

    @Mock
    private CustomerContactRepository customerContactRepository;

    @InjectMocks
    private ContactsManagementService contactsManagementService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContact() {

        CustomerContact aMockContact = new CustomerContact();
        aMockContact.setFirstName("Ayomide");
        aMockContact.setLastName("Oyekanmi");

        when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);

        //Save the contact
        CustomerContact newContact = contactsManagementService.add(null);

        assertEquals("Ayomide", newContact.getFirstName());

    }
}