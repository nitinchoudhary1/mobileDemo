import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.example.*;

@CucumberOptions(
        features = "src/test/java/mobile",
        glue = {"mobile"},
        tags = "@test",
        plugin = {"pretty", "html:testResults/cucumber-report.html", "json:testResults/cucumber.json"})

public class TestRunner extends AbstractTestNGCucumberTests {

    TestNGCucumberRunner testNGCucumberRunner;
    Utilities main = new Utilities();

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        main.startServer();
        main.setPreparation();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        main.stopServer();
    }


}
