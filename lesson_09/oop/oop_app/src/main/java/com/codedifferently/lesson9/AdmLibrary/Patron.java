package com.codedifferently.lesson9.AdmLibrary;

import java.util.ArrayList;
import java.util.List;

/** Represents a patron of the library. */
public class Patron {
  private String name;
  private List<Book> checkedOutBooks;

  public Patron(String name) {
    this.name = name;
    this.checkedOutBooks = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  public void checkOutBook(Book book) {
    checkedOutBooks.add(book);
  }

  public void returnBook(Book book) {
    checkedOutBooks.remove(book);
  }
}
