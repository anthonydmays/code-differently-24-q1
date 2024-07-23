package com.codedifferently.lesson9.AdmLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BookTest {

  @Test
  public void testBookCreation() {
    Book book = new Book("Test", "1234567891", List.of("John Doe"), 416);
    assertEquals("Test", book.getTitle());
    assertEquals("1234567891", book.getIsbn());
    assertEquals(List.of("John Doe"), book.getAuthors());
    assertEquals(416, book.getNumberOfPages());
    assertFalse(book.isCheckedOut());
  }

  @Test
  public void testCheckOut() {
    Book book = new Book("Test", "1234567891", List.of("John Doe"), 416);
    book.checkOut();
    assertTrue(book.isCheckedOut());
  }

  @Test
  public void testReturnBook() {
    Book book = new Book("Test", "1234567891", List.of("John Doe"), 416);
    book.checkOut();
    book.returnBook();
    assertFalse(book.isCheckedOut());
  }
}
