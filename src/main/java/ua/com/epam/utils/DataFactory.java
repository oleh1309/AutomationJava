package ua.com.epam.utils;

import ua.com.epam.entity.genre.Genre;
import ua.com.epam.utils.data.AuthorData;
import ua.com.epam.utils.data.BookData;
import ua.com.epam.utils.data.GenreData;
import ua.com.epam.utils.data.service.AuthorFileData;
import ua.com.epam.utils.data.service.BookFileData;
import ua.com.epam.utils.data.service.GenreFileData;

public class DataFactory {

    public AuthorData authors() {
        return new AuthorFileData();
    }

    public BookData books() {
        return new BookFileData();
    }

    public GenreData genres() {
        return new GenreFileData();
    }
}