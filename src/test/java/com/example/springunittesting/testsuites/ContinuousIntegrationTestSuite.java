package com.example.springunittesting.testsuites;

import com.example.springunittesting.controllers.ContactsManagementControllerIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DatastoreSystemsHealthTest.class,
        ContactsManagementControllerIntegrationTest.class
})
public class ContinuousIntegrationTestSuite {
}

