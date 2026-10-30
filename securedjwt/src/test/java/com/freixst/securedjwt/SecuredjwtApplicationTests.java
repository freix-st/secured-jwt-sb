package com.freixst.securedjwt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers 
class SecuredjwtApplicationTests {
	
	@SuppressWarnings("resource")
	@Container
	static MySQLContainer<?> testDB = new MySQLContainer<>("mysql:8.0")
		.withDatabaseName("test_db")
		.withUsername("test")
		.withPassword("test");

	@DynamicPropertySource 
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", testDB::getJdbcUrl);
		registry.add("spring.datasource.username", testDB::getUsername);
		registry.add("spring.datasource.password", testDB::getPassword);
	}

	@Test
	void contextLoads() {
	}

}
