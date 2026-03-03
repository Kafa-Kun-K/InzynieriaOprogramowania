package vod.repository.dummy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import vod.model.Cinema;
import vod.model.Movie;
import vod.repository.CinemaDao;

import java.util.List;

@Component
public class DummyCinemaDao implements CinemaDao {

    @Override
    public List<Cinema> findAll() {
        return List.of();
    }

    @Override
    public Cinema findById(int id) {
        return null;
    }

    @Override
    public List<Cinema> findByMovie(Movie m) {
        return List.of();
    }
}
