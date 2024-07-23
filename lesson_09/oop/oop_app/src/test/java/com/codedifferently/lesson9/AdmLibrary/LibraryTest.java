package com.codedifferently.lesson9.AdmLibrary;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LibraryTest {

  @Test
  public void testAddBook() {
    Library library = new Library();
    Book book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 416);
    library.addBook(book);
    assertTrue(library.getBooks().contains(book));
  }

  @Test
  public void testRemoveBook() {
    Library library = new Library();
    Book book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 416);
    library.addBook(book);
    library.removeBook(book);
    assertFalse(library.getBooks().contains(book));
  }

  @Test
  public void testRegisterPatron() {
    Library library = new Library();
    Patron patron = new Patron("John Doe");
    library.registerPatron(patron);
    assertTrue(library.getPatrons().contains(patron));
  }

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
