package vod.repository.dummy;

import org.springframework.stereotype.Component;
import vod.model.Library;
import vod.model.Book;
import vod.repository.LibraryDao;

import java.util.List;

@Component
public class DummyLibraryDao implements LibraryDao {

    @Override
    public List<Library> findAll() {
        return List.of();
    }

    @Override
    public Library findById(int id) {
        return null;
    }

    @Override
    public List<Library> findByBook(Book b) {
        return List.of();
    }
}
