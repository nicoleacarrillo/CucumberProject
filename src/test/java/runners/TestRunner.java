package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //FEATURES keyword: provides the path of feature package file
        features = "src/test/resources/features/",

        //GLUE keyword: stick two things together. Provide name of package where steps are available
        glue = "steps",

        //dryRun false: starts execution
        //dryRun true: stop execution
        dryRun=false,

        //provide tag name from code and it will be executed
        tags = "@loginValidation or @addEmployee",

        //pretty keyword: print steps on console
        //cucumber.html: prints html report
        //cucumber.json: prints report
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
)


public class TestRunner {
}
