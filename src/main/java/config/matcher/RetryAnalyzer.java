package config.matcher;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private final int limit = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < limit) {
            count++;
            return true;
        }
        return false;
    }
}
