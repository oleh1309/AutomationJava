package ua.com.epam.entity.book;

import java.util.Objects;
import ua.com.epam.entity.book.nested.Additional;

public class Book {
  private Long bookId;
  private String bookName;
  private String bookLanguage;
  private String bookDescription;
  private Additional additional;
  private int publicationYear;

  public Book(Long bookId, String bookName, String bookLanguage, String bookDescription,
      Additional additional,int publicationYear) {
    this.bookId = bookId;
    this.bookName = bookName;
    this.bookLanguage = bookLanguage;
    this.bookDescription = bookDescription;
    this.additional = additional;
    this.publicationYear = publicationYear;
  }

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getBookLanguage() {
    return bookLanguage;
  }

  public void setBookLanguage(String bookLanguage) {
    this.bookLanguage = bookLanguage;
  }

  public String getBookDescription() {
    return bookDescription;
  }

  public void setBookDescription(String bookDescription) {
    this.bookDescription = bookDescription;
  }

  public Additional getAdditional() {
    return additional;
  }

  public void setAdditional(Additional additional) {
    this.additional = additional;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(int publicationYear) {
    this.publicationYear = publicationYear;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(bookId, book.bookId) &&
        Objects.equals(bookName, book.bookName) &&
        Objects.equals(bookLanguage, book.bookLanguage) &&
        Objects.equals(bookDescription, book.bookDescription) &&
        Objects.equals(additional, book.additional) &&
        Objects.equals(publicationYear, book.publicationYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookId, bookName, bookLanguage, bookDescription, additional, publicationYear);
  }
}
