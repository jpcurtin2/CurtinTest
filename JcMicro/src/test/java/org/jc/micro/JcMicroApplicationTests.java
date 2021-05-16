package org.jc.micro;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class JcMicroApplicationTests {

	Logger logger = LoggerFactory.getLogger(JcMicroApplicationTests.class);
	
	@Inject
	private UserRepository userRepository;
	
	@Test
	void testCreateUser() {
		User user = new User("John Curtin");
		logger.info("Saving user: " + user.toString());
		User newUser = this.userRepository.save(user);
		logger.info("Created user: " + newUser.toString());
		
		assertEquals("John Curtin", newUser.getName());
		logger.info(newUser.toString());
	}

}
