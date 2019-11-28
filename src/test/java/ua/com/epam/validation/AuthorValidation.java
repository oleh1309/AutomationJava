package ua.com.epam.validation;

import static ua.com.epam.config.URI.Query_Params;
import static ua.com.epam.config.URI.VALUE_AUTHOR_ID_1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDate;
import java.util.List;
import org.json.JSONArray;
import org.apache.log4j.Logger;
import org.testng.Assert;
import ua.com.epam.core.rest.RestClient;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.author.nested.Name;
import ua.com.epam.utils.helpers.LocalDateAdapter;

public class AuthorValidation {

  private  RestClient client;
  private static Logger log = Logger.getLogger(RestClient.class);
  private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

  public AuthorValidation(RestClient client) {
    this.client = client;
  }

  public void get_assertPostAuthor(Author author) {
    Author actAuthor = gson.fromJson(client.getResponse().getBody(), Author.class);
    Assert.assertEquals(client.getResponse().getStatusCode(), 201, "Failed");
    Assert.assertEquals(author, actAuthor);
  }

  public void get_assertPostListAuthors(List<Author> authors) {
    Assert.assertEquals(client.getResponse().getStatusCode(), 201, "Failed");
  }

  public void get_assertGetAuthorId() {
    Author actAuthor = gson.fromJson(client.getResponse().getBody(), Author.class);
    Assert.assertEquals(actAuthor.getAuthorId().toString(), VALUE_AUTHOR_ID_1, "Failed");
    log.info("responce return author with id = " + actAuthor.getAuthorId().toString());
  }

  public void get_assertGetAllAuthor(int listSize) {
    JSONArray actAuthor = new JSONArray(client.getResponse().getBody());
    Assert.assertEquals(actAuthor.length(), listSize, "Failed");
    log.info("responce return  array with length = " + actAuthor.length());
  }

  public void get_assertSearchAuthor() {
    JSONArray actAuthor = new JSONArray(client.getResponse().getBody());
    actAuthor.forEach(elem ->
        Assert.assertTrue(gson.fromJson(elem.toString(), Author.class)
            .getAuthorName().getSecond().contains(Query_Params.get("query")), "Failed"));
    actAuthor.forEach(elem -> log.info(" " + gson.fromJson(elem.toString(), Author.class)
        .getAuthorName().getSecond() + " "));

  }

  public void get_assertGetAuthorByBook(String authorId) {
    Author actAuthor = gson.fromJson(client.getResponse().getBody(), Author.class);
    Assert.assertEquals(client.getResponse().getStatusCode(), 200, "Failed");
    Assert.assertEquals(authorId, actAuthor.getAuthorId().toString());
    log.info(
        " " + actAuthor.getAuthorName().getFirst() + " " + actAuthor.getAuthorName().getSecond());
  }

  public void get_assertAuthorsByGenre() {
    JSONArray array = new JSONArray(client.getResponse().getBody());
    Assert.assertEquals(client.getResponse().getStatusCode(), 200, "Failed");
    Assert.assertEquals(array.length(), 2, "Failed");
    array.forEach(elem -> log.info(" " + elem.toString() + " "));
  }

  public void get_assertUpdateAuthor(Name name) {
    Author actAuthor = gson.fromJson(client.getResponse().getBody(), Author.class);
    Assert.assertEquals(client.getResponse().getStatusCode(), 200, "Failed");
    Assert.assertFalse(actAuthor.getAuthorName().getFirst().equals(name.getFirst()) &&
        actAuthor.getAuthorName().getSecond().equals(name.getSecond()), "Failed");
    log.info("New name: " + actAuthor.getAuthorName().getFirst() + "  " + actAuthor.getAuthorName()
        .getSecond()
        + " -  Last name: " + name.getFirst() + " " + name.getSecond());
  }

  public void get_assertDeleteAuthor() {
    Assert.assertEquals(client.getResponse().getStatusCode(), 404, "Failed");
  }

}
