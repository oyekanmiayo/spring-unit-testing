package com.example.springunittesting.testsuites;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DatastoreSystemsHealthTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void dbConnectionAndSchemaAreOK(){
        try {

            DatabaseMetaData metadata = dataSource.getConnection().getMetaData();
            String catalogName = dataSource.getConnection().getCatalog();

            assertThat(metadata, is(notNullValue()));
            assertThat(catalogName, is(equalTo("spring_tdd")));

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
