package vod.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import vod.model.Book;
import vod.model.Library;
import vod.service.BookService;
import vod.service.LibraryService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class LibraryRest {

    private final LibraryService libraryService;
    private final BookService bookService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/libraries")
    List<Library> getLibraries(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie
    ) {
        log.info("about to retrieve libraries list");
        log.info("phrase param: {}", phrase);
        log.info("custom header param: {}", customHeader);
        log.info("some cookie value: {}", someCookie);
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
    ResponseEntity<?> addLibrary(@Validated @RequestBody Library library, Errors errors, HttpServletRequest request) {
        log.info("about to add new library {}", library);

        if(errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu, oe)->accu + oe + "\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }

        library = libraryService.addLibrary(library);
        log.info("new library add {}", library);
        return ResponseEntity.status(HttpStatus.CREATED).body(library);
    }
}
