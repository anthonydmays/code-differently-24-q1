package com.codedifferently.lesson9.AdmLibrary;

import java.util.List;

/** Represents a book in the library. */
public class Book {
  private String title;
  private String isbn;
  private List<String> authors;
  private int numberOfPages;
  private boolean isCheckedOut;

  public Book(String title, String isbn, List<String> authors, int numberOfPages) {
    this.title = title;
    this.isbn = isbn;
    this.authors = authors;
    this.numberOfPages = numberOfPages;
    this.isCheckedOut = false;
  }

  public String getTitle() {
    return title;
  }

  public String getIsbn() {
    return isbn;
  }

  public List<String> getAuthors() {
    return authors;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  public boolean isCheckedOut() {
    return isCheckedOut;
  }

  public void checkOut() {
    isCheckedOut = true;
  }

  public void returnBook() {
    isCheckedOut = false;
  }
}
