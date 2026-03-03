package vod.repository.mem;

import org.springframework.stereotype.Component;
import vod.repository.LibraryDao;
import vod.model.Library;
import vod.model.Book;

import java.util.List;
import java.util.stream.Collectors;

@Component("libraryDao")
//@Component
public class MemLibraryDao implements LibraryDao {

    @Override
    public List<Library> findAll() {
        return SampleData.libraries;
    }

    @Override
    public Library findById(int id) {
        return SampleData.libraries.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Library> findByBook(Book b) {
        return SampleData.libraries.stream().filter(l -> l.getBooks().contains(b)).collect(Collectors.toList());
    }
}
