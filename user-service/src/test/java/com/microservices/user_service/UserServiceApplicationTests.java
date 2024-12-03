package com.microservices.user_service;

import com.microservices.user_service.user.DTOs.UserRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;
import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer mysqlContainer = new MySQLContainer("mysql:8.3.0");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mysqlContainer.start();
	}

	@Test
	void contextLoads() {

		var user = getUserRequest();
		var userResponse = RestAssured.given()
				.contentType("application/json")
				.body(user)
				.when()
				.post("/api/users")
				.then()
				.log().all()
				.statusCode(201);
	}

	private UserRequestDTO getUserRequest(){
		return new UserRequestDTO("shampun333", "vityaDen325@gmail.com", "viktor", "denus", "male", "vitilivka", "+380331231555");
	}
}
