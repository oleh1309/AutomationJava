package ua.com.epam.utils.data;
import java.util.List;
import ua.com.epam.entity.book.Book;

public interface BookData {

  Book getRandomOne();

  List<Book> getDefaultBooks();

}
