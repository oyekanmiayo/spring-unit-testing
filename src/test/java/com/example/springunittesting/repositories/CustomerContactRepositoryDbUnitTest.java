package com.example.springunittesting.repositories;

import com.example.springunittesting.models.CustomerContact;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup("classpath:testDataset.xml")
public class CustomerContactRepositoryDbUnitTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Test
    public void testFindByEmail() {
        CustomerContact foundContact = customerContactRepository.findFirstByEmail("john@springtest.com");

        assertThat(foundContact.getEmail(), is(equalTo("john@springtest.com")));
    }

    @Test
    public void testFindSpecificContactByIdBypassReposClass(){

        /*
          JPA Repositories use entityManager internally.
         */
        CustomerContact foundContact = testEntityManager.find(CustomerContact.class, new Long("3"));

        assertThat(foundContact.getFirstName(), is(equalTo("Sanmi")));

    }

}
