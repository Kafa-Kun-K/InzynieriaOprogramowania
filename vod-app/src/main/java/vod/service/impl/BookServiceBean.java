package vod.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vod.repository.LibraryDao;
import vod.repository.AuthorDao;
import vod.repository.BookDao;
import vod.model.Library;
import vod.model.Author;
import vod.model.Book;
import vod.service.BookService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookServiceBean implements BookService {

    private static final Logger log = Logger.getLogger(BookService.class.getName());

    @Autowired
    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    private AuthorDao authorDao;
    private LibraryDao libraryDao;
    private BookDao bookDao;

    public BookServiceBean(AuthorDao authorDao, LibraryDao libraryDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.libraryDao = libraryDao;
        this.bookDao = bookDao;
    }

    public List<Book> getAllBooks() {
        log.info("searching books by author...");
        return bookDao.findAll();
    }

    public List<Book> getBooksByAuthor(Author a) {
        log.info("serching books by author " + a.getId());
        return bookDao.findByAuthor(a);
    }

    public List<Book> getBooksInLibrary(Library l) {
        log.info("searching books available in library " + l.getId());
        return bookDao.findByLibrary(l);
    }

    public Book getBookById(int id) {
        log.info("searching book by id " + id);
        return bookDao.findById(id);
    }

    public List<Library> getAllLibraries() {
        log.info("searching all libraries");
        return libraryDao.findAll();
    }

    public List<Library> getLibrariesByBook(Book b) {
        log.info("searching libraries by book " + b.getId());
        return libraryDao.findByBook(b);
    }

    public Library getLibraryById(int id) {
        log.info("searching library by id " + id);
        return libraryDao.findById(id);
    }

    public List<Author> getAllAuthors() {
        log.info("searching all authors");
        return authorDao.findAll();
    }

    public Author getAuthorById(int id) {
        log.info("searching authors by id " + id);
        return authorDao.findById(id);
    }

    @Override
    public Book addBook(Book b) {
        log.info("about to add book " + b);
        return bookDao.add(b);
    }

    @Override
    public Author addAuthor(Author a) {
        log.info("about to add author " + a);
        return authorDao.add(a);
    }

}
