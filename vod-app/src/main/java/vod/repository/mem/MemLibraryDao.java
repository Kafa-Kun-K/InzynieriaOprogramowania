package vod.repository.mem;

import org.springframework.stereotype.Repository;
import vod.repository.LibraryDao;
import vod.model.Library;
import vod.model.Book;

import java.util.List;
import java.util.stream.Collectors;

@Repository("libraryDao")
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

    @Override
    public Library save(Library library) {
        int maxId = SampleData.libraries.stream()
                .sorted((c1,c2)->c2.getId())
                .findFirst()
                .map(c->c.getId())
                .orElse(0);
        library.setId(maxId+1);
        SampleData.libraries.add(library);
        return library;
    }
}
