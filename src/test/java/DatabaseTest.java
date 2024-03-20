import db.repository.UserRepositoryImpl;
import org.testng.annotations.Test;

public class DatabaseTest extends BaseTest {
    @Test
    void checkSqlQuery() {

        new UserRepositoryImpl().deleteUserById(1L);

        System.out.println(new UserRepositoryImpl().getAllUsers());
    }
}
