package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vod.model.Book;
import vod.model.Library;
import vod.service.BookService;
import vod.service.LibraryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class LibraryRest {

    private final LibraryService libraryService;
    private final BookService bookService;

    @GetMapping("/libraries")
    List<Library> getLibraries(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie
    ) {
        log.info("about to retrieve libraries list");
        List<Library> libraries = libraryService.getAllLibraries();
        log.info("{} libraries found", libraries.size());
        return libraries;
    }

    @GetMapping("/libraries/{id}")
    ResponseEntity<Library> getLibrary(@PathVariable("id") int id) {
        log.info("about to retrieve library {}", id);
        Library library = libraryService.getLibraryById(id);
        log.info("library found: {}", library);
        if(library!=null) {
            return ResponseEntity.status(200).body(library);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/books/{bookId}/libraries")
    ResponseEntity<List<Library>> getLibrariesAvailableInBook(@PathVariable("bookId") int bookId) {
        log.info("about to retrieve libraries available in book {}", bookId);
        Book book = bookService.getBookById(bookId);
        if(book==null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Library> libraries = libraryService.getLibrariesByBook(book);
            log.info("there's {} libraries available in book {}", libraries.size(), book.getTitle());
            return ResponseEntity.ok(libraries);
        }
    }

    @PostMapping("/libraries")
    ResponseEntity<Library> addLibrary(@RequestBody Library library) {
        log.info("about to add new library {}", library);
        library = libraryService.addLibrary(library);
        log.info("new library add {}", library);
        return ResponseEntity.status(HttpStatus.CREATED).body(library);
    }
}
