package com.codedifferently.lesson9.AdmLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link Patron} class.
 * This class provides tests to verify the functionality of the Patron class methods.
 */
public class PatronTest {

  /**
   * Tests the creation of a {@link Patron} object.
   * Verifies that the patron's name is correctly initialized and that the patron has no books checked out initially.
   */
  @Test
  public void testPatronCreation() {
    Patron patron = new Patron("John Doe");
    assertEquals("John Doe", patron.getName());
    assertTrue(patron.getCheckedOutBooks().isEmpty());
  }

  /**
   * Tests the {@link Patron#checkOutBook(Book)} method.
   * Verifies that a book is correctly added to the patron's list of checked-out books.
   */
  @Test
  public void testCheckOutBook() {
    Patron patron = new Patron("John Doe");
    Book book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 416);
    patron.checkOutBook(book);
    assertTrue(patron.getCheckedOutBooks().contains(book));
  }

  /**
   * Tests the {@link Patron#returnBook(Book)} method.
   * Verifies that a book is correctly removed from the patron's list of checked-out books.
   */
  @Test
  public void testReturnBook() {
    Patron patron = new Patron("John Doe");
    Book book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 416);
    patron.checkOutBook(book);
    patron.returnBook(book);
    assertFalse(patron.getCheckedOutBooks().contains(book));
  }
}
