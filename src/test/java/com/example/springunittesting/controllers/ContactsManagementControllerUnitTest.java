package com.example.springunittesting.controllers;

import com.example.springunittesting.models.CustomerContact;
import com.example.springunittesting.services.ContactsManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
public class ContactsManagementControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactsManagementService contactsManagementService;

    @InjectMocks
    private ContactsManagementController contactsManagementController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testAddContact() throws Exception {

        //Mock contact to be returned by the mock service component
        CustomerContact mockContact = new CustomerContact();
        mockContact.setFirstName("Fred");

        when(contactsManagementService.add(any(CustomerContact.class)))
                .thenReturn(mockContact);

        //Simulate the form bean that would POST from the webpage
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Fred");
        aContact.setEmail("freddy@spring.com");

        mockMvc.perform(post("/addContact", aContact))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void testAddNullContact() throws Exception {

        when(contactsManagementService.add(any(CustomerContact.class)))
                .thenReturn(null);

        CustomerContact aContact = new CustomerContact();

        mockMvc.perform(post("/addContact", aContact))
                .andExpect(status().is(302))
                .andReturn();

    }

}