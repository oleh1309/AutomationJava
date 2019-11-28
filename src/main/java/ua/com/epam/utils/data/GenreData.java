package ua.com.epam.utils.data;

import java.util.List;
import ua.com.epam.entity.genre.Genre;

public interface GenreData {

  Genre getRandomOne();

  List<Genre> getDefaultGenre();

}
