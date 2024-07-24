package com.codedifferently.lesson9.AdmLibrary;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link Book} class.
 * This class provides tests to verify the functionality of the Book class methods.
 */
public class BookTest {

  /**
   * Tests the creation of a {@link Book} object.
   * Verifies that the book's properties are correctly initialized and that the book is not checked out.
   */
  @Test
  public void testBookCreation() {
    Book book = new Book("Test", "1234567891", List.of("John Doe"), 416);
    assertEquals("Test", book.getTitle());
    assertEquals("1234567891", book.getIsbn());
    assertEquals(List.of("John Doe"), book.getAuthors());
    assertEquals(416, book.getNumberOfPages());
    assertFalse(book.isCheckedOut());
  }

  /**
   * Tests the {@link Book#checkOut()} method.
   * Verifies that the book's checked-out status is updated correctly when the book is checked out.
   */
  @Test
  public void testCheckOut() {
    Book book = new Book("Test", "1234567891", List.of("John Doe"), 416);
    book.checkOut();
    assertTrue(book.isCheckedOut());
  }

  /**
   * Tests the {@link Book#returnBook()} method.
   * Verifies that the book's checked-out status is updated correctly when the book is returned.
   */
  @Test
  public void testReturnBook() {
    Book book = new Book("Test", "1234567891", List.of("John Doe"), 416);
    book.checkOut();
    book.returnBook();
    assertFalse(book.isCheckedOut());
  }
}
