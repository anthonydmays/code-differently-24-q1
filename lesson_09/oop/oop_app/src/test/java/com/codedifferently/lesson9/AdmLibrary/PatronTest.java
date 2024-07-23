package com.codedifferently.lesson9.AdmLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PatronTest {

  @Test
  public void testPatronCreation() {
    Patron patron = new Patron("John Doe");
    assertEquals("John Doe", patron.getName());
    assertTrue(patron.getCheckedOutBooks().isEmpty());
  }

  @Test
  public void testCheckOutBook() {
    Patron patron = new Patron("John Doe");
    Book book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 416);
    patron.checkOutBook(book);
    assertTrue(patron.getCheckedOutBooks().contains(book));
  }

  @Test
  public void testReturnBook() {
    Patron patron = new Patron("John Doe");
    Book book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 416);
    patron.checkOutBook(book);
    patron.returnBook(book);
    assertFalse(patron.getCheckedOutBooks().contains(book));
  }
}
