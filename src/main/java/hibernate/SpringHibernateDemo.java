package hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class SpringHibernateDemo {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        SingerDao singerDao = ctx.getBean(SingerDao.class);


        ctx.close();
    }

    private static void listSingers(List<Singer> singerList) {
        logger.info("----- Singers ------");
        for (Singer singer: singerList) {
            logger.info(singer);
        }
    }

}
