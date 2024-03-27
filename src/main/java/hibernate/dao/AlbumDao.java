package hibernate.dao;

import hibernate.entity.Album;

import java.util.List;

public interface AlbumDao {

    List<Album> findAll();
    List<Album> findAllWithUser();
    Album findById(Long id);
    void save(Album album);
    void update(Album album);
    void delete(Album album);

}
