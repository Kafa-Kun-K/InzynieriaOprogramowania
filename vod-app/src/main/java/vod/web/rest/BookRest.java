package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Book;
import vod.model.Library;
import vod.service.BookService;
import vod.service.LibraryService;
import vod.web.rest.dto.BookDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class BookRest {

    private final LibraryService libraryService;
    private final BookService bookService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/books")
    List<Book> getBooks() {
        log.info("about to retrieve books list");
        List<Book> books = bookService.getAllBooks();
        log.info("{} books found", books.size());
        return books;
    }

    @GetMapping("/books/{id}")
    ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        log.info("about to retrieve book {}", id);
        Book book = bookService.getBookById(id);
        log.info("book found: {}", book);
        if(book!=null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/libraries/{libraryId}/books")
    ResponseEntity<List<Book>> getBooksAvailableInLibrary(@PathVariable("libraryId") int libraryId) {
        log.info("about to retrieve books available in library", libraryId);
        Library library = libraryService.getLibraryById(libraryId);
        if(library==null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Book> books = libraryService.getBooksInLibrary(library);
            log.info("there's {} movies available in library {}", books.size(), library.getName());
            return ResponseEntity.ok(books);
        }
    }

    @PostMapping("/books")
    ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO) {
        log.info("about to add new book {}", bookDTO);
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setCover(bookDTO.getCover());
        book.setRating(bookDTO.getRating());
        book.setAuthor(bookService.getAuthorById(bookDTO.getAuthorId()));

        book = bookService.addBook(book);
        log.info("new book added: {}", book);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/" + book.getId())
                                .build()
                                .toUri())
                .body(book);
    }
}
