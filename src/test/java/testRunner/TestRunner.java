package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		           // features= {".//Features"},
		            features= {".//Features/LoginN.feature"},
		           //features= {".//Features/LoginDDTExcelN.feature"},
		           //features= {".//Features/AccountRegistration.feature"},
		           //features= {".//Features/AccountRegistration.feature",".//Features/LoginN.feature"},
		            
		           // features= {"@target/reryn.txt"}
		            
		            glue="stepDefinations",
		            plugin= {
		            		  "pretty", "html:reports/myreport.html", 
		            		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		            		  //"rerun:target/rerun.txt",
		                    },
		            dryRun=false,
		            monochrome=true,
		            publish=true
		            
		           // tags="@sanity"
		           // tags="@regression"
		           // tags="@sanity and @regression"
		           // tags="@sanity and not @regression"
		           // tags="@sanity or @regression"
		
		        )
public class TestRunner {

}
