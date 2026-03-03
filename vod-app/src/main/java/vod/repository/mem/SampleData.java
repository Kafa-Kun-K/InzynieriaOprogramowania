package vod.repository.mem;

import vod.model.Library;
import vod.model.Author;
import vod.model.Book;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Library> libraries = new ArrayList<>();

    static List<Author> authors = new ArrayList<>();

    static List<Book> books = new ArrayList<>();

    static {
        Author tolkien = new Author(1, "J.R.R.", "Tolkien");
        Author sapkowski = new Author(2, "Andrzej", "Sapkowski");
        Author king = new Author(3, "Stephen", "King");

        Book hobbit = new Book(1, "Hobbit", "url_cover_1", tolkien, 4.9f);
        Book lotr = new Book(2, "Lord of the Rings", "url_cover_2", tolkien, 5.0f);
        Book wiedzmin = new Book(3, "Ostatnie Życzenie", "url_cover_3", sapkowski, 4.8f);

        bind(hobbit, tolkien);
        bind(lotr, tolkien);
        bind(wiedzmin, sapkowski);

        Library narodowa = new Library(1, "Biblioteka Narodowa", "https://www.bn.org.pl/");
        Library jagiellonska = new Library(2, "Biblioteka Jagiellońska", "https://bj.uj.edu.pl/pl_PL/start");

        bind(narodowa, hobbit);
        bind(narodowa, wiedzmin);
        bind(jagiellonska, lotr);
        bind(jagiellonska, wiedzmin);

        authors.addAll(List.of(tolkien, sapkowski, king));
        books.addAll(List.of(hobbit, lotr, wiedzmin));
        libraries.addAll(List.of(narodowa, jagiellonska));
    }

    private static void bind(Library l, Book b) {
        l.addBook(b);
        b.addLibrary(l);
    }

    private static void bind(Book b, Author a) {
        a.addBook(b);
        b.setAuthor(a);
    }

}
