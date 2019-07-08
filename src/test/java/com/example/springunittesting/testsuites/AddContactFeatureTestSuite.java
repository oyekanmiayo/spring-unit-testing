package com.example.springunittesting.testsuites;

import com.example.springunittesting.controllers.ContactsManagementControllerIntegrationTest;
import com.example.springunittesting.repositories.CustomerContactRepositoryIntegrationTest;
import com.example.springunittesting.services.ContactManagementServiceIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContactManagementServiceIntegrationTest.class,
        ContactsManagementControllerIntegrationTest.class,
        CustomerContactRepositoryIntegrationTest.class
})
public class AddContactFeatureTestSuite {
}
