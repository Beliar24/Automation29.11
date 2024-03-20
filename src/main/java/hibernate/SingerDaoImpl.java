package hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Transactional(readOnly = true)
    public List<Singer> findAllWithAlbums() {
        return sessionFactory.getCurrentSession()
                .createQuery("select distinct s from Singer s left join fetch s.albums a " +
                        "left join fetch s.instruments i").list();
    }

    @Override
    public Singer findById(Long id) {
        return null;
    }

    @Override
    public Singer save(Singer singer) {
        return null;
    }

    public void update(Singer singer) {

    }

    @Override
    public void delete(Singer singer) {

    }
}
