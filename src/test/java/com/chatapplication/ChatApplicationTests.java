package com.chatapplication;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@SpringBootTest
class ChatApplicationTests {

//    Spring Boot provides datasource at runtime, once you have the database dependency.
    @Autowired
    DataSource dataSource;

    @Test
    void applicationCanConnectToLocalDatabaseTest() {
        assertThat(dataSource).isNotNull();
        log.info("Datasource object is created");

        try(Connection connection = dataSource.getConnection()) {
            assertThat(connection).isNotNull();
            assertThat(connection.getCatalog()).isEqualTo("chatdb");
            log.info("Connection --> {}", connection.getCatalog());
        } catch (SQLException throwables) {
            log.info("Exception occurred while connecting to the database --> {}",
                    throwables.getMessage());

        }
    }
}
