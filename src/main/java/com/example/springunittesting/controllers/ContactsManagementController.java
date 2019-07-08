package com.example.springunittesting.controllers;

import com.example.springunittesting.models.CustomerContact;
import com.example.springunittesting.services.ContactsManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactsManagementController {

    private ContactsManagementService contactsManagementService;

    public ContactsManagementController(ContactsManagementService contactsManagementService) {
        this.contactsManagementService = contactsManagementService;
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String processAddContact(@ModelAttribute CustomerContact aContact) {

        CustomerContact newContact = contactsManagementService.add(aContact);

        if (newContact != null) {
            return "/addContactForm";
        }

        return "redirect:/showAddContact";
    }
}
