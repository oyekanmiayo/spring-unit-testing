package com.example.springunittesting.repositories;

import com.example.springunittesting.models.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CustomerContactRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Test
    public void testFindByEmail() {

        CustomerContact customerContact = new CustomerContact();
        customerContact.setEmail("ayo@springtest.com");
        testEntityManager.persist(customerContact);

        CustomerContact foundContact = customerContactRepository.findByEmail(customerContact.getEmail());

        assertThat(foundContact.getEmail(), is(equalTo(customerContact.getEmail())));

    }

}