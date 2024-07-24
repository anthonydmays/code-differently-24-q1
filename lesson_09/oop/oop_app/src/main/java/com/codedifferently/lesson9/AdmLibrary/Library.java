package com.codedifferently.lesson9.AdmLibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library. A library contains a collection of books and a list of patrons. This class
 * provides methods to add and remove books, register patrons, check out books, and return books.
 */
public class Library {
  private List<Book> books;
  private List<Patron> patrons;

  /** Constructs a new Library. Initially, the library contains no books or patrons. */
  public Library() {
    this.books = new ArrayList<>();
    this.patrons = new ArrayList<>();
  }

  /**
   * Adds a book to the library's collection.
   *
   * @param book the book to add
   */
  public void addBook(Book book) {
    books.add(book);
  }

  /**
   * Removes a book from the library's collection.
   *
   * @param book the book to remove
   */
  public void removeBook(Book book) {
    books.remove(book);
  }

  /**
   * Registers a new patron with the library.
   *
   * @param patron the patron to register
   */
  public void registerPatron(Patron patron) {
    patrons.add(patron);
  }

  /**
   * Checks out a book to a patron. If the book is available and not already checked out, it is
   * marked as checked out and added to the patron's list of checked-out books. Otherwise, a message
   * is printed indicating the book is not available for checkout.
   *
   * @param patron the patron checking out the book
   * @param book the book to check out
   */
  public void checkOutBook(Patron patron, Book book) {
    if (books.contains(book) && !book.isCheckedOut()) {
      book.checkOut();
      patron.checkOutBook(book);
    } else {
      System.out.println("Book is not available for checkout.");
    }
  }

  /**
   * Returns a book that was checked out by a patron. If the book is in the patron's list of
   * checked-out books, it is marked as returned and removed from the patron's list of checked-out
   * books. Otherwise, a message is printed indicating the book was not checked out by this patron.
   *
   * @param patron the patron returning the book
   * @param book the book to return
   */
  public void returnBook(Patron patron, Book book) {
    if (patron.getCheckedOutBooks().contains(book)) {
      book.returnBook();
      patron.returnBook(book);
    } else {
      System.out.println("This book was not checked out by this patron.");
    }
  }

  /**
   * Returns the list of books in the library.
   *
   * @return the list of books in the library
   */
  public List<Book> getBooks() {
    return books;
  }

  /**
   * Returns the list of patrons registered with the library.
   *
   * @return the list of patrons registered with the library
   */
  public List<Patron> getPatrons() {
    return patrons;
  }
}
