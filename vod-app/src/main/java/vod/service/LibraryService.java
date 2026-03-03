package vod.service;

import vod.model.Library;
import vod.model.Book;

import java.util.List;

public interface LibraryService {
//api zwraca nam wszystkie kina
    Library getLibraryById(int id);

    List<Library> getAllLibraries();

    List<Library> getLibrariesByBook(Book b);

    List<Book> getBooksInLibrary(Library l);

}
