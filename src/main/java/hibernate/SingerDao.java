package hibernate;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();
    List<Singer> findAllWithAlbums();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);
    void update(Singer singer);
}
