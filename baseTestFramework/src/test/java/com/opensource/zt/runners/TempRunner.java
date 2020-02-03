package com.opensource.zt.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@Sanity"}, features = {"src/test/java/com/opensource/zt/"}, format = {"pretty",
        "html:target/html/baseTestProject/"}, glue = {"com.opensource.zt"})
public class TempRunner {

}