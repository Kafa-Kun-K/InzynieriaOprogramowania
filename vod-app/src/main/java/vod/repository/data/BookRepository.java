package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
