package cucumberSteps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumberFeatures",
        glue = "cucumberSteps"
//        tags = "@verifyLogoAndButton"
        )
public class RunCucumberTest {
}
