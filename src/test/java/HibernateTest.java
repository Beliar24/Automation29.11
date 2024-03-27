import hibernate.config.AppConfig;
import hibernate.dao.AlbumDao;
import hibernate.dao.SingerDao;
import hibernate.entity.Album;
import hibernate.entity.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HibernateTest {

    private SingerDao singerDao = null;
    private AlbumDao albumDao = null;
    private GenericApplicationContext ctx = null;

    @BeforeSuite
    void setUpContext() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        singerDao = ctx.getBean(SingerDao.class);
        albumDao = ctx.getBean(AlbumDao.class);
    }

    @Test
    void shouldBeVisibleSingerWithAlbum() {
        Singer singer = singerDao.findById(6L);

        assertThat(singer.getFirstName()).isEqualTo("Eric");
        assertThat(singer.getAlbums().stream().map(Album::getTitle).findFirst()
                .orElseThrow(() -> new RuntimeException("The album is not found"))).isEqualTo("From the way");
    }


    @AfterSuite
    void closeContext() {
        ctx.close();
    }
}
