import db.config.StatementInit;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    @AfterSuite
    void closeDriver() {
        StatementInit.closeJDBCDriver();
    }
}
