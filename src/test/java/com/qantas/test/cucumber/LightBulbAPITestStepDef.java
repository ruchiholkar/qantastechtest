package com.qantas.test.cucumber;

import com.qantas.test.library.ReadPropertiesFile;
import com.qantas.test.steps.LightBulbAPITestSteps;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import org.mockito.internal.matchers.Matches;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Properties;


public class LightBulbAPITestStepDef {
    private Properties prop;

    @Steps
    LightBulbAPITestSteps lightBulbAPITestSteps;

    @Before
    public void doBefore() {
        prop = ReadPropertiesFile.getProperty();
        //RestAssured.baseURI = prop.getProperty("lightBulbApiURI");

    }

    @When("^I send POST request with ON$")
    public void i_send_POST_request_with_ON(){

        lightBulbAPITestSteps.sendPostRequestwith("on");
    }

    @Then("^I verify that it returns (\\d+)$")
    public void i_verify_that_it_returns(int expectedStatusCode){
        assertThat("Wrong response status code", lightBulbAPITestSteps.getStatusCode() , Matchers.equalTo(expectedStatusCode));
    }

    @When("^I send POST request with OFF$")
    public void i_send_POST_request_with_OFF() {
        lightBulbAPITestSteps.sendPostRequestwith("off");
    }

    @When("^I set (\\d+) setting$")
    public void i_set_setting(int power) {
        lightBulbAPITestSteps.setPower(power);
    }

    @When("^I send POST request with All methods$")
    public void i_send_POST_request_with_All_methods() {
        lightBulbAPITestSteps.sendPostRequestWithAllMethods();
    }

    @Then("^I verify that it returns all methods$")
    public void i_verify_that_it_returns_all_methods()  {
        assertThat("Failed to return all methods",lightBulbAPITestSteps.verifyItReturnsAllMethods(), Matchers.is(true));
    }

    @When("^I send POST request with <state>$")
    public void i_send_POST_request_with_state()  {
    }

    @When("^I set invalid header$")
    public void i_set_invalid_header()  {
    }

}
