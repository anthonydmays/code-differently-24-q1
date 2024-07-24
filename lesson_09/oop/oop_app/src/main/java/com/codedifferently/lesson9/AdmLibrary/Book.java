package com.codedifferently.lesson9.AdmLibrary;

import java.util.List;

/**
 * Represents a book in the library. A book has a title, an ISBN, a list of authors, a number of
 * pages, and a checked-out status. This class provides methods to access these properties and to
 * check out or return the book.
 */
public class Book {
  private String title;
  private String isbn;
  private List<String> authors;
  private int numberOfPages;
  private boolean isCheckedOut;

  /**
   * Constructs a new Book with the specified title, ISBN, authors, and number of pages. Initially,
   * the book is not checked out.
   *
   * @param title the title of the book
   * @param isbn the ISBN of the book
   * @param authors the list of authors of the book
   * @param numberOfPages the number of pages in the book
   */
  public Book(String title, String isbn, List<String> authors, int numberOfPages) {
    this.title = title;
    this.isbn = isbn;
    this.authors = authors;
    this.numberOfPages = numberOfPages;
    this.isCheckedOut = false;
  }

  /**
   * Returns the title of the book.
   *
   * @return the title of the book
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the ISBN of the book.
   *
   * @return the ISBN of the book
   */
  public String getIsbn() {
    return isbn;
  }

  /**
   * Returns the list of authors of the book.
   *
   * @return the list of authors of the book
   */
  public List<String> getAuthors() {
    return authors;
  }

  /**
   * Returns the number of pages in the book.
   *
   * @return the number of pages in the book
   */
  public int getNumberOfPages() {
    return numberOfPages;
  }

  /**
   * Returns whether the book is currently checked out.
   *
   * @return {@code true} if the book is checked out, {@code false} otherwise
   */
  public boolean isCheckedOut() {
    return isCheckedOut;
  }

  /** Marks the book as checked out. */
  public void checkOut() {
    isCheckedOut = true;
  }

  /** Marks the book as returned. */
  public void returnBook() {
    isCheckedOut = false;
  }
}
