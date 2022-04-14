import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/Features"},
        glue = {"steps."},
        tags = {"@test2"},
//        snippets = SnippetType.CAMELCASE,
        monochrome = true
)
public class RunCucumberTest {
}
