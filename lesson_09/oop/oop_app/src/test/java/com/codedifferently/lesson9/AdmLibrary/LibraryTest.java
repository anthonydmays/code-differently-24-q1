package com.codedifferently.lesson9.AdmLibrary;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link Library} class.
 * This class provides tests to verify the functionality of the Library class methods.
 */
public class LibraryTest {

  /**
   * Tests the {@link Library#addBook(Book)} method.
   * Verifies that a book is correctly added to the library's collection.
   */
  @Test
  public void testAddBook() {
    Library library = new Library();
    Book book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 416);
    library.addBook(book);
    assertTrue(library.getBooks().contains(book));
  }

  /**
   * Tests the {@link Library#removeBook(Book)} method.
   * Verifies that a book is correctly removed from the library's collection.
   */
  @Test
  public void testRemoveBook() {
    Library library = new Library();
    Book book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 416);
    library.addBook(book);
    library.removeBook(book);
    assertFalse(library.getBooks().contains(book));
  }

  /**
   * Tests the {@link Library#registerPatron(Patron)} method.
   * Verifies that a patron is correctly registered with the library.
   */
  @Test
  public void testRegisterPatron() {
    Library library = new Library();
    Patron patron = new Patron("John Doe");
    library.registerPatron(patron);
    assertTrue(library.getPatrons().contains(patron));
  }

  /**
   * Tests the {@link Library#checkOutBook(Patron, Book)} method.
   * Verifies that a book is correctly checked out to a patron, and the book's status is updated.
   */
  @Test
  public void testCheckOutBook() {
    Library library = new Library();
    Book book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 416);
    Patron patron = new Patron("John Doe");
    library.addBook(book);
    library.registerPatron(patron);
    library.checkOutBook(patron, book);
    assertTrue(book.isCheckedOut());
    assertTrue(patron.getCheckedOutBooks().contains(book));
  }

  /**
   * Tests the {@link Library#returnBook(Patron, Book)} method.
   * Verifies that a book is correctly returned by a patron, and the book's status is updated.
   */
  @Test
  public void testReturnBook() {
    Library library = new Library();
    Book book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 416);
    Patron patron = new Patron("John Doe");
    library.addBook(book);
    library.registerPatron(patron);
    library.checkOutBook(patron, book);
    library.returnBook(patron, book);
    assertFalse(book.isCheckedOut());
    assertFalse(patron.getCheckedOutBooks().contains(book));
  }
}
