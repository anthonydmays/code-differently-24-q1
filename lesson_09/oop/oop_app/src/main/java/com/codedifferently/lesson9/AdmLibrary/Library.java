package com.codedifferently.lesson9.AdmLibrary;

import java.util.ArrayList;
import java.util.List;

/** Represents a library. */
public class Library {
  private List<Book> books;
  private List<Patron> patrons;

  public Library() {
    this.books = new ArrayList<>();
    this.patrons = new ArrayList<>();
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void removeBook(Book book) {
    books.remove(book);
  }

  public void registerPatron(Patron patron) {
    patrons.add(patron);
  }

  public void checkOutBook(Patron patron, Book book) {
    if (books.contains(book) && !book.isCheckedOut()) {
      book.checkOut();
      patron.checkOutBook(book);
    } else {
      System.out.println("Book is not available for checkout.");
    }
  }

  public void returnBook(Patron patron, Book book) {
    if (patron.getCheckedOutBooks().contains(book)) {
      book.returnBook();
      patron.returnBook(book);
    } else {
      System.out.println("This book was not checked out by this patron.");
    }
  }

  public List<Book> getBooks() {
    return books;
  }

  public List<Patron> getPatrons() {
    return patrons;
  }
}
