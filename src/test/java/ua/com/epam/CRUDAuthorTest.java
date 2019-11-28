package ua.com.epam;

import org.testng.annotations.Test;
import ua.com.epam.entity.author.Author;
import java.util.List;
import ua.com.epam.entity.book.Book;
import ua.com.epam.entity.genre.Genre;
import static ua.com.epam.config.URI.*;

@org.testng.annotations.Listeners(ua.com.epam.Listeners.class)
public class CRUDAuthorTest extends BaseTest {

    private Genre genre = testData.genres().getRandomOne();
    private Book exBook = testData.books().getRandomOne();
    private Book exBook1 = testData.books().getRandomOne();
    private Author expAuthor = testData.authors().getRandomOne();
    private List<Author> authorList1 = testData.authors().getDefaultAuthors();

    @Test(priority = 0, description = "Post single Author obj")
    public void postAuthor() {
        client.post(POST_AUTHOR_SINGLE_OBJ, expAuthor);
        testValidation.getAuthorValidation().get_assertPostAuthor(expAuthor);
        clean.authors();
    }

    @Test(priority = 1, description = "Post list of Authors obj")
    public void postAuthorsList() {
        authorService.postListOfAuthors(authorList1, client);
        testValidation.getAuthorValidation().get_assertPostListAuthors(authorList1);
    }

    @Test(priority = 2, description = "Get Author by id", dependsOnMethods = "postAuthorsList")
    public void getAuthorById() {
        authorService.getAuthorById(client);
        testValidation.getAuthorValidation().get_assertGetAuthorId();
    }

    @Test(priority = 3, description = "Get all Authors", dependsOnMethods = "postAuthorsList")
    public void getAllAuthor() {
        authorService.getAllAuthors(client);
        testValidation.getAuthorValidation().get_assertGetAllAuthor(authorList1.size());
    }

    @Test(priority = 4, description = "Search Author by name", dependsOnMethods = "postAuthorsList")
    public void get_SearchAuthor() {
        authorService.searchAuthor(client);
        testValidation.getAuthorValidation().get_assertSearchAuthor();
    }

    @Test(priority = 5, description = "Get Author of special Book", dependsOnMethods = "postAuthorsList")
    public void getAuthorByBook() {
        client.post(POST_GENRE_SINGLE_OBJ,genre);
        client.post(String.format(POST_BOOK_SINGLE_OBJ,VALUE_AUTHOR_ID_1,genre.getGenreId().toString()),exBook);
        client.get(String.format(GET_AUTHOR_OF_BOOK_OBJ,exBook.getBookId().toString()));
        testValidation.getAuthorValidation().get_assertGetAuthorByBook(VALUE_AUTHOR_ID_1);
    }

    @Test(priority = 6, description = "Get all Authors in special Genre", dependsOnMethods = "getAuthorByBook")
    public void getListAuthorsByGenre() {
        client.post(String.format(POST_BOOK_SINGLE_OBJ,VALUE_AUTHOR_ID_2, genre.getGenreId().toString()),exBook1);
        client.get(String.format(GET_ALL_AUTHORS_IN_GENRE_ARR, genre.getGenreId().toString()));
        testValidation.getAuthorValidation().get_assertAuthorsByGenre();
    }
    @Test(priority = 7, description = "Update existed Author", dependsOnMethods = "postAuthorsList")
    public void updateAuthor() {
        client.get(String.format(GET_AUTHOR_SINGLE_OBJ,expAuthor.getAuthorId().toString()));
        Author beforeUpdate = gson.fromJson(client.getResponse().getBody(),Author.class);
        authorService.updateAuthor(client,gson,expAuthor);
        testValidation.getAuthorValidation().get_assertUpdateAuthor(beforeUpdate.getAuthorName());
    }

    @Test(priority = 8, description = "Delete existed Author", dependsOnMethods = "postAuthorsList")
    public void deleteAuthor() {
        authorService.deleteAuthor(client,expAuthor);
        testValidation.getAuthorValidation().get_assertDeleteAuthor();
    }


}
