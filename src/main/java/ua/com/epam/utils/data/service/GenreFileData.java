package ua.com.epam.utils.data.service;

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
import ua.com.epam.entity.book.Book;
import ua.com.epam.entity.exception.FileIsEmptyException;
import ua.com.epam.entity.genre.Genre;
import ua.com.epam.utils.data.GenreData;
import ua.com.epam.utils.helpers.LocalDateAdapter;

public class GenreFileData implements GenreData {

  private static Logger log = Logger.getLogger(GenreFileData.class);
  private String filePath = "src/test/resources/test-data/genres";
  private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

  @Override
  public Genre getRandomOne() {
    log.info("Try to find one random Book...\n");

    List<Genre> genres = new ArrayList<>();

    try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
      genres = lines.map(s -> gson.fromJson(s, Genre.class)).collect(Collectors.toList());
      if (genres.isEmpty()) {
        log.error("File by path " + filePath + " is empty!");
        throw new FileIsEmptyException();
      }
    } catch (IOException e) {
      log.error(e.getMessage());
      e.printStackTrace();
    }

    Genre genre = genres.get(new Random().nextInt(genres.size()));
    log.info("Author with authorId = '" + genre.getGenreId() + "' was found!");

    return genre;
  }

  @Override
  public List<Genre> getDefaultGenre() {
    log.info("Try to find first 10 books...\n");

    List<Genre> genres = new ArrayList<>();

    try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
      genres = lines.map(s -> gson.fromJson(s, Genre.class)).collect(Collectors.toList());
      if (genres.isEmpty()) {
        log.error("File by path " + filePath + " is empty!");
        throw new FileIsEmptyException();
      }

      if (genres.size() < 10) {
        log.warn("There are only " + genres.size() + " authors found!");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return genres;
  }
}
