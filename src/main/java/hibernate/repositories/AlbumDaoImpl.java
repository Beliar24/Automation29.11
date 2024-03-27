package hibernate.repositories;

import hibernate.dao.AlbumDao;
import hibernate.entity.Album;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("albumDao")
@Transactional
public class AlbumDaoImpl implements AlbumDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Album> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Album a").list();
    }

    @Override
    public List<Album> findAllWithUser() {
        return sessionFactory.getCurrentSession().createQuery("select distinct s from Album s left join fetch s.Singer a")
                .list();
    }

    @Override
    public Album findById(Long id) {
        return (Album) sessionFactory.getCurrentSession().createQuery("select s from Album s where s.id= :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public void save(Album album) {
        sessionFactory.getCurrentSession().save(album);
    }

    @Override
    public void update(Album album) {
        sessionFactory.getCurrentSession().update(album);
    }

    @Override
    public void delete(Album album) {
        sessionFactory.getCurrentSession().delete(album);
    }
}
