package com.example.app;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToDoListTests {

	private User user;
	private EmailSenderService emailSenderService;
	private Item item1;
	private Item item2;
	private Item item3;
	private Item item4;
	private Item item5;
	private Item item6;
	private Item item7;
	private Item item8;
	private Item item9;
	private Item item10;
	private Item item11;
	private ToDoList toDoList;
	private ToDoList toDoListMock;
	private Item itemNameTaken;

	@BeforeEach
	public void setUp() {
		this.emailSenderService = mock(EmailSenderService.class);
		this.user = User.builder()
				.email("user@email.com")
				.firstname("firstname")
				.lastname("lastname")
				.birthdate(LocalDate.now().minusYears(18))
				.password("Abcdefghij0")
				.build();
		this.item1 = Item.builder()
				.name("Item 1")
				.content("1 content")
				.build();
		this.item2 = Item.builder()
				.name("Item 2")
				.content("2 content")
				.build();
		this.item3 = Item.builder()
				.name("Item 3")
				.content("3 content")
				.build();

		this.item4 = Item.builder()
				.name("Item 4")
				.content("4 content")
				.build();
		this.item5 = Item.builder()
				.name("Item 5")
				.content("5 content")
				.build();
		this.item6 = Item.builder()
				.name("Item 6")
				.content("6 content")
				.build();
		this.item7 = Item.builder()
				.name("Item 7")
				.content("7 content")
				.build();

		this.item8 = Item.builder()
				.name("Item 8")
				.content("8 content")
				.build();

		this.item9 = Item.builder()
				.name("Item 9")
				.content("9 content")
				.build();
		this.item10 = Item.builder()
				.name("Item 10")
				.content("10 content")
				.build();
		this.item11 = Item.builder()
				.name("Item 11")
				.content("11 content")
				.build();
		this.toDoList = new ToDoList(user);
		this.toDoListMock = spy(toDoList);
		doNothing().when(toDoListMock).save();
		this.toDoList.add(item1);

		this.itemNameTaken = Item.builder()
				.name("Item 4")
				.content("already taken content")
				.build();

	}

	@Test
	public void toDoListNominalTest() {
		assertTrue(this.toDoList.listItem[0].getName() == "Item 1");
	}

	@Test
	public void nameAlreadyTaken() {
		assertThrows(ArithmeticException.class, () -> toDoList.add(itemNameTaken));
	}

	@Test
	public void excede10Items() {
		toDoListMock.add(item2);
		toDoListMock.add(item3);
		toDoListMock.add(item4);
		toDoListMock.add(item5);
		toDoListMock.add(item6);
		toDoListMock.add(item7);
		toDoListMock.add(item8);
		toDoListMock.add(item9);
		toDoListMock.add(item10);
		assertThrows(ArithmeticException.class, () -> toDoListMock.add(item11));
	}

	@Test
	public void add2ItemsNominalTest() {
		this.toDoListMock.add(item1);
		this.item1.setAddDate(LocalDateTime.now().minusMinutes(30));
		assertDoesNotThrow(() -> toDoListMock.add(item2));
	}

	@Test
	public void addTooQuickly() {
		this.item1.setAddDate(LocalDateTime.now());
		assertThrows(ArithmeticException.class, () -> toDoListMock.add(item2));
	}

}
