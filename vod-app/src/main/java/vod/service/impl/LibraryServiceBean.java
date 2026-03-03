package vod.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vod.model.Library;
import vod.model.Book;
import vod.repository.LibraryDao;
import vod.repository.BookDao;
import vod.service.LibraryService;

import java.util.List;
import java.util.logging.Logger;

@Component
@Scope("prototype")
public class LibraryServiceBean implements LibraryService {

    private static final Logger log = Logger.getLogger(LibraryService.class.getName());

    private LibraryDao libraryDao;
    private BookDao bookDao;

    public LibraryServiceBean(LibraryDao libraryDao, BookDao bookDao) {
        log.info("creating library service bean");
        this.libraryDao = libraryDao;
        this.bookDao = bookDao;
    }

    @Override
    public Library getLibraryById(int id) {
        log.info("searching library by id " + id);
        return libraryDao.findById(id);
    }

    @Override
    public List<Book> getBooksInLibrary(Library l) {
        log.info("searching books available in library " + l.getId());
        return bookDao.findByLibrary(l);
    }

    @Override
    public List<Library> getAllLibraries() {
        log.info("searching all libraries");
        return libraryDao.findAll();
    }

    @Override
    public List<Library> getLibrariesByBook(Book b) {
        log.info("searching libraries by book " + b.getId());
        return libraryDao.findByBook(b);
    }

}
