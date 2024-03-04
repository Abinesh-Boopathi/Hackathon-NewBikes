package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features= {".//Features/"},
                  glue="stepDefinition",
                  plugin= {"pretty","html:Reports/Cucumber-test-Report.html",
                		  //"com.avenstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                  },
                  dryRun=false,     //mapping and execution
                  monochrome=true,  //removes junk
                  publish=true      //report generation and published the report at cucumber server
                		  )
public class TestRunnerclass {

}
