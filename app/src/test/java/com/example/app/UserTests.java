package com.example.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTests {

	private User user;

	@BeforeEach
	public void setup() {
		this.user = User.builder()
				.email("user@email.com")
				.firstname("firstname")
				.lastname("lastname")
				.birthdate(LocalDate.now().minusYears(18))
				.password("Abcdefghij0")
				.build();
	}

	@Test
	public void userNominalTest() {
		assertTrue(user.isValid());
	}

	@Test
	public void badEmailTest() {
		user.setEmail("test");
		assertFalse(user.isValid());
	}

	@Test
	public void badFirstnameTest() {
		user.setFirstname("");
		assertFalse(user.isValid());
	}

	@Test
	public void userPasswordNominalTest() {
		assertTrue(user.isValid());
	}

	@Test
	public void badBirthdateTest() {
		this.user.setBirthdate(LocalDate.now().plusYears(1));
		assertFalse(user.isValid());
	}

	@Test
	public void badPasswordTooShortTest() {
		this.user.setPassword("aA1");
		assertFalse(user.isValid());
	}

	@Test
	public void badPasswordTooLongTest() {
		this.user.setPassword("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaA0");
		assertFalse(user.isValid());
	}

	@Test
	public void badPasswordNoUpperCaseTest() {
		this.user.setPassword("aaaaaaa0");
		assertFalse(user.isValid());
	}

	@Test
	public void badPasswordNoLowerCaseTest() {
		this.user.setPassword("AAAAAAA0");
		assertFalse(user.isValid());
	}

	@Test
	public void badPasswordNoDigitCaseTest() {
		this.user.setPassword("aaaaaaaA");
		assertFalse(user.isValid());
	}

}
