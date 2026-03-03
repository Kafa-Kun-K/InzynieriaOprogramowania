package vod.service;

import vod.model.Author;
import vod.model.Book;

import java.util.List;

public interface BookService {


    List<Book> getAllBooks();

    List<Book> getBooksByAuthor(Author a);

    Book getBookById(int id);

    Book addBook(Book b);


    List<Author> getAllAuthors();

    Author getAuthorById(int id);

    Author addAuthor(Author a);
}
