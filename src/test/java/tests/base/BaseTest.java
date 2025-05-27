package tests.base;

import config.ConfigManager;
import config.TestConfig;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test(groups = {"all"})
public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setupSuite() {
        TestConfig.configure();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        // any cleanup logic here
    }

    protected void onlyRunIn(String... environments) {
        String currentEnv = ConfigManager.getEnv();
        for (String env : environments) {
            if (env.equalsIgnoreCase(currentEnv)) {
                return;
            }
        }
        throw new SkipException("Test not applicable to environment: " + currentEnv);
    }

    protected void skipIn(String... environments) {
        String currentEnv = ConfigManager.getEnv();
        for (String env : environments) {
            if (env.equalsIgnoreCase(currentEnv)) {
                throw new SkipException("Test skipped in environment: " + currentEnv);
            }
        }
    }
}
