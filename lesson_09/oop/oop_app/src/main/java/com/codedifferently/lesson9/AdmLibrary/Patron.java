package com.codedifferently.lesson9.AdmLibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a patron of the library. A patron has a name and a list of books they have checked
 * out. This class provides methods to access the patron's name and checked-out books, as well as to
 * check out and return books.
 */
public class Patron {
  private String name;
  private List<Book> checkedOutBooks;

  /**
   * Constructs a new Patron with the specified name. Initially, the patron has no books checked
   * out.
   *
   * @param name the name of the patron
   */
  public Patron(String name) {
    this.name = name;
    this.checkedOutBooks = new ArrayList<>();
  }

  /**
   * Returns the name of the patron.
   *
   * @return the name of the patron
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the list of books the patron has checked out.
   *
   * @return the list of books the patron has checked out
   */
  public List<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  /**
   * Adds a book to the patron's list of checked-out books.
   *
   * @param book the book to check out
   */
  public void checkOutBook(Book book) {
    checkedOutBooks.add(book);
  }

  /**
   * Removes a book from the patron's list of checked-out books.
   *
   * @param book the book to return
   */
  public void returnBook(Book book) {
    checkedOutBooks.remove(book);
  }
}
