package vod.repository.mem;

import org.springframework.stereotype.Component;
import vod.repository.AuthorDao;
import vod.model.Author;

import java.util.List;

@Component
public class MemAuthorDao implements AuthorDao {
    @Override
    public List<Author> findAll() {
        return SampleData.authors;
    }

    @Override
    public Author findById(int id) {
        return SampleData.authors.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Author add(Author a) {
        int max = SampleData.authors.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        a.setId(++max);
        SampleData.authors.add(a);
        return a;
    }
}
