package com.opensource.zt.steps;

import com.opensource.zt.actions.TestSetup;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class TestSteps {

    TestSetup testSetup;

    @Before
    public void initializeTest() {
        testSetup = new TestSetup();
        testSetup.selectBrowser("chrome");
    }

    @Given("^User is on google page$")
    public void user_is_on_google_page() throws Throwable {
        TestSetup.driver.navigate().to("https://www.google.com");
    }

    @When("^User clicks on login link$")
    public void user_clicks_on_login_link() throws Throwable {
        Thread.sleep(3000);
        TestSetup.driver.findElement(By.id("gb_70")).click();
    }

    @Then("^Login link is displayed$")
    public void login_link_is_displayed() throws Throwable {
        Thread.sleep(3000);
        TestSetup.driver.findElement(By.id("identifierId")).isDisplayed();
    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) {

            try {

                final byte[] screenshot = ((TakesScreenshot) TestSetup.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png"); // ... and embed it in
            } catch (WebDriverException e) {
                e.printStackTrace();
            }

        } else {
            try {
                System.out.println(scenario.getName() + " is pass");
                scenario.embed(((TakesScreenshot) TestSetup.driver).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        TestSetup.driver.quit();
    }

}
