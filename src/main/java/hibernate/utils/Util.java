package hibernate.utils;

import hibernate.entity.Album;
import hibernate.entity.Instrument;
import hibernate.entity.Singer;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@UtilityClass
public class Util {

    private static final Logger logger = LogManager.getLogger();

    public static void listAlbums(List<Album> albums) {
        logger.info("------ Albums ------");
        for (Album album : albums) {
            logger.info(album);
        }
    }

    public static void listAlbumWithUser(List<Album> albums) {
        logger.info("------ Albums ------");
        for (Album album : albums) {
            logger.info(album);
            if (album.getSinger() != null) {
                logger.info(album.getSinger());
            }
        }
    }

    public static void listSingers(List<Singer> singerList) {
        logger.info("----- Singers ------");
        for (Singer singer: singerList) {
            logger.info(singer);
        }
    }

    public static void listSingersWithAlbums(List<Singer> singerList) {
        logger.info("------Singers with albums ------");
        for (Singer singer : singerList) {
            logger.info(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    logger.info(album);
                }
            }
            if (singer.getInstruments() != null) {
                for (Instrument instrument: singer.getInstruments()) {
                    logger.info(instrument);
                }
            }
        }
    }
}
