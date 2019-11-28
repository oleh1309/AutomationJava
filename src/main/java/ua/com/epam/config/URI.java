package ua.com.epam.config;

import java.util.HashMap;
import java.util.Map;

public interface URI {
    DataProp dp = new DataProp();
    String BASE_URI = dp.apiProtocol() + "://" + dp.apiHost() + ":" + dp.apiPort();
    //
    Map<String,String> Query_Params = new HashMap<String, String>();
    String VALUE_AUTHOR_ID_1 = "6381";
    String VALUE_AUTHOR_ID_2 = "9713";

    //Author
    String GET_AUTHOR_SINGLE_OBJ = "/api/library/author/%s";
    String GET_AUTHOR_OF_BOOK_OBJ = "/api/library/book/%s/author";
    String GET_ALL_AUTHORS_ARR = "/api/library/authors";
    String SEARCH_FOR_EXISTED_AUTHORS_ARR = "/api/library/authors/search";
    String GET_ALL_AUTHORS_IN_GENRE_ARR = "/api/library/genre/%s/authors";
    String POST_AUTHOR_SINGLE_OBJ = "/api/library/author";
    String PUT_AUTHOR_SINGLE_OBJ = "/api/library/author/%s";
    String DELETE_AUTHOR_SINGLE_OBJ = "/api/library/author/%s";

    //Book
    String POST_BOOK_SINGLE_OBJ = "/api/library/book/%s/%s";
    String GET_ALL_BOOKS_ARR ="/api/library/books";
    String DELETE_BOOK_SINGLE_OBJ = "/api/library/book/%s";

    //Geners
    String POST_GENRE_SINGLE_OBJ = "/api/library/genre";
    String GET_ALL_GENRES_ARR ="/api/library/genres";
    String DELETE_GENRE_SINGLE_OBJ = "/api/library/genre/%s";

}
