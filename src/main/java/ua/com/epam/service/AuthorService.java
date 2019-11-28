package ua.com.epam.service;

import static ua.com.epam.config.URI.*;
import static ua.com.epam.utils.JsonKeys.*;

import com.google.gson.Gson;
import java.util.List;
import ua.com.epam.core.rest.RestClient;
import ua.com.epam.entity.author.Author;
import ua.com.epam.entity.author.nested.Name;

public class AuthorService {
    //you are the painter, so paint something here))
  public AuthorService getAuthorListVsParams(RestClient client) {
    Query_Params.put("orderType",ASCENDING);
    Query_Params.put("page","1");
    Query_Params.put("pagination","true");
    Query_Params.put("size","5");
    Query_Params.put("sortBy",AUTHOR_ID);
    client.get(RestClient.withParameters(GET_ALL_AUTHORS_ARR,Query_Params));
    return this;
  }

  public AuthorService getAuthorById(RestClient client){
    client.get(String.format(GET_AUTHOR_SINGLE_OBJ , VALUE_AUTHOR_ID_1));
    return this;
  }

  public AuthorService postListOfAuthors(List<Author>authorList, RestClient client){
    for(
        Author a : authorList) {
      client.post(POST_AUTHOR_SINGLE_OBJ, a);
    }
    return this;
  }

  public AuthorService getAllAuthors(RestClient client){
    client.get(GET_ALL_AUTHORS_ARR);
    return this;
  }

  public AuthorService searchAuthor(RestClient client){
    Query_Params.put("query","Tar");
    client.get(RestClient.withParameters(SEARCH_FOR_EXISTED_AUTHORS_ARR,Query_Params));
    return this;
  }

  public AuthorService updateAuthor(RestClient client, Gson gson, Author getAuthor){
    //Author getAuthor = gson.fromJson(client.getResponse().getBody(),Author.class);
    getAuthor.setAuthorName(new Name("Olia","Olia"));
    client.put(String.format(PUT_AUTHOR_SINGLE_OBJ,getAuthor.getAuthorId().toString()), getAuthor);
    return this;
  }

  public AuthorService deleteAuthor(RestClient client,Author getAuthor) {
    client.delete(String.format(DELETE_AUTHOR_SINGLE_OBJ, getAuthor.getAuthorId().toString()));
    client.get(String.format(GET_AUTHOR_SINGLE_OBJ,getAuthor.getAuthorId().toString()));
    return this;
  }
}
