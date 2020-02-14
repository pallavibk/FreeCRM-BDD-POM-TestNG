package TestRunner;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;



@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(//jsonReport="target/cucumber.json",
retryCount=3
//,detailedReport=true,
//detailedAggregatedReport=true,
//overviewReport=true,
//coverageReport=true,
//jsonUsageReport="target/cucumber-usage.json",
//usageReport=true
//,toPDF=true,
//excludeCoverageTags={""},
//includeCoverageTags= {"@chrome"},
//outputFolder="target"
)



@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"stepDefinitions"},monochrome=true,
        
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
               // "json:target/cucumber-reports/CucumberTestReport.json",
                //"rerun:target/cucumber-reports/rerun.txt"
        },
        plugin= {//"pretty:STDOUT",
        		//"json:target/cucumber.json",
        		//"usage:target/cucumber-usage.json",
        		//"junit:target/cucumber-results.xml",
        		"rerun:target/rerun.txt"})

public class Runner {
    private TestNGCucumberRunner testNGCucumberRunner;
 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}

