package com.softland.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.softland.demo.model.User;
import com.softland.demo.repository.UserRepository;


@SpringBootTest
public class UserRepositoryTest {

	@Autowired
    private UserRepository userRepository;
	
	@DisplayName("Test UserRepository Integration...")
	@Test
	public void testUser() {
		Optional<User> user = userRepository.findByUserName("user");
		System.out.println("==================["+ user.get().toString() +"]=======================");
		assertThat(user).isNotNull();
		assertThat(user.get().getUserName()).isEqualTo("user");
	}
	
}
