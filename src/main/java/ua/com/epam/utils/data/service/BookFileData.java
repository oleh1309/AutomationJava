package ua.com.epam.utils.data.service;

import static ua.com.epam.utils.JsonKeys.ASCENDING;
import static ua.com.epam.utils.JsonKeys.AUTHOR_ID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.book.Book;
import ua.com.epam.entity.exception.FileIsEmptyException;
import ua.com.epam.utils.data.BookData;
import ua.com.epam.utils.helpers.LocalDateAdapter;

public class BookFileData implements BookData {

  private static Logger log = Logger.getLogger(BookFileData.class);
  private String filePath = "src/test/resources/test-data/books";
  private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();


  @Override
  public Book getRandomOne() {
    log.info("Try to find one random Book...\n");

    List<Book> books = new ArrayList<>();

    try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
      books = lines.map(s -> gson.fromJson(s, Book.class)).collect(Collectors.toList());
      if (books.isEmpty()) {
        log.error("File by path " + filePath + " is empty!");
        throw new FileIsEmptyException();
      }
    } catch (IOException e) {
      log.error(e.getMessage());
      e.printStackTrace();
    }

    Book book = books.get(new Random().nextInt(books.size()));
    log.info("Author with authorId = '" + book.getBookId() + "' was found!");

    return book;
  }

  @Override
  public List<Book> getDefaultBooks() {
    log.info("Try to find first 10 books...\n");

    List<Book> books = new ArrayList<>();

    try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
      books = lines.map(s -> gson.fromJson(s, Book.class)).collect(Collectors.toList());
      if (books.isEmpty()) {
        log.error("File by path " + filePath + " is empty!");
        throw new FileIsEmptyException();
      }

      if (books.size() < 10) {
        log.warn("There are only " + books.size() + " authors found!");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    //books = sort(books, AUTHOR_ID, ASCENDING, 10);
   // log.info(books.size() + " authors found!");

    return books;
  }
}
