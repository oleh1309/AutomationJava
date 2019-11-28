package ua.com.epam.entity.genre;

import java.util.Objects;

public class Genre {

  private Long genreId;
  private String genreName;
  private String genreDescription;

  public Genre(Long genreId, String genreName, String genreDescription) {
    this.genreId = genreId;
    this.genreName = genreName;
    this.genreDescription = genreDescription;
  }

  public Long getGenreId() {
    return genreId;
  }

  public void setGenreId(Long genreId) {
    this.genreId = genreId;
  }

  public String getGenreName() {
    return genreName;
  }

  public void setGenreName(String genreName) {
    this.genreName = genreName;
  }

  public String getGenreDescription() {
    return genreDescription;
  }

  public void setGenreDescription(String genreDescription) {
    this.genreDescription = genreDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Genre genre = (Genre) o;
    return Objects.equals(genreId, genre.genreId) &&
        Objects.equals(genreName, genre.genreName) &&
        Objects.equals(genreDescription, genre.genreDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(genreId, genreName, genreDescription);
  }
}
