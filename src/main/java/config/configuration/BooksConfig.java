package config.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({"classpath:books.properties"})
public interface BooksConfig extends BaseConfig {
    String getAllBooks();
    String getBook();
    String addBook();
    String deleteBook();
}
