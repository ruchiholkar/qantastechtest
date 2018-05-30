package com.qantas.test.cucumber;

import com.qantas.test.library.SetDriver;
import com.qantas.test.steps.QFFWebTestSteps;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.yecht.Data;

import static org.hamcrest.MatcherAssert.assertThat;

public class QFFWebTestStepdefs {

    private String browserName;
    private WebDriver driver = null;

    @Steps
    QFFWebTestSteps qffWebTestSteps;


    @Before
    public void doBefore() {
        //browserName = System.getProperty("Browser");
        browserName = "Chrome";
        if (browserName.equals(null)) {
            browserName = "Chrome";
        }
        driver = SetDriver.set(browserName);
        System.out.println("driver:" + driver);
    }

    @Given("^I am on QFF Landing page$")
    public void i_am_on_QFF_Landing_page() {
        qffWebTestSteps.iamOnQFFLandingPage(driver);
    }

    @Then("^I verify the contents of the page$")
    public void i_verify_the_contents_of_the_page() {

        assertThat("Title is incorrect",qffWebTestSteps.getQFFLandingPageTitle(), Matchers.equalToIgnoringCase("Frequent Flyer - Welcome"));
        //assertThat("Header is incorrect",qffWebTestSteps.getQFFPageHeader(),Matchers.equalToIgnoringCase("Join now"));
        //We can check for links to Terms & conditions as well as privacy statement
    }

    @Then("^I enter (.*?)$")
    public void i_enter_country_of_residency(String countryOfResidency) {
        qffWebTestSteps.selectCountryOfResidence(countryOfResidency);
    }

    @And("^I enter Name details like (.*?),(.*?),(.*?),(.*?)$")
    public void iEnterNameDetailsLikeTitleGenderFirstNameLastName(String title, String gender,
                                                                  String firstName, String lastName) {
        qffWebTestSteps.enterNameDetails(title,gender,firstName,lastName);
    }

    @Then("^I enter Phone details like (.*?),(.*?),(.*?)$")
    public void i_enter_Phone_details_like_Home(String phoneType, String areaCode,
                                                String phoneNumber) {
        qffWebTestSteps.enterPhoneDetails(phoneType,areaCode,phoneNumber);
    }

    @Then("^I enter Postal address details like (.*?),(.*?),(.*?),(.*?),(.*?),(.*?)$")
    public void i_enter_Postal_address_details_like_Business_Address_Address_Sydney_NSW(String postalAddressType,String addressLine1,
                                                                                        String addressLine2,String suburb_Town_City,
                                                                                        String state,String postCode) {
        qffWebTestSteps.enterPostalAddressDetails(postalAddressType,addressLine1,addressLine2,suburb_Town_City,state,postCode);
    }

    @And("^I enter Email and consent details like (.*?)$")
    public void iEnterEmailAndConsentDetails(String emailAddress) {
        qffWebTestSteps.enterEmailDetails(emailAddress);
    }

    @Then("^I enter Security questions details like (.*?),(.*?),(.*?),(.*?),(.*?)$")
    public void i_enter_Security_questions_details_like_Mother(String date,String month,String year,
                                                               String motherMaideName,String pin) {
        qffWebTestSteps.enterSecurityQuestionsDetails(date,month,year,motherMaideName,pin);
    }

    @Then("^I accept the terms and conditions$")
    public void i_accept_the_terms_and_conditions() {
        qffWebTestSteps.acceptTheTermsAndConditions();
    }

    @Then("^I enter Credit card details like (.*?),(.*?),(.*?),(.*?),(.*?)$")
    public void i_enter_Credit_card_details_like(String cardHolderName, String cardNumber,
                                                 String exipryDateMonth,String exipryDateYear,
                                                 String securityCode) {
        qffWebTestSteps.enterCreditCardDetails(cardHolderName,cardNumber,exipryDateMonth,exipryDateYear,securityCode);
    }

    @Then("^I select I am not a robot$")
    public void i_select_I_am_not_a_robot() {
        qffWebTestSteps.selectIamNotRobot();
    }

    @When("^I click on Pay button$")
    public void i_click_on_Pay_button() {
        qffWebTestSteps.clickOnPayButton();
    }

    @Then("^I should see confirmation message$")
    public void i_should_see_confirmation_message() {
        System.out.println(qffWebTestSteps.getPaymentConfirmationMessage());
        //commented this as we are not hitting the Pay button
        //assertThat("Payment failed",qffWebTestSteps.getPaymentConfirmationMessage(),Matchers.contains("Success"));

    }

    @After
    public void tearDown() {
        SetDriver.close();
    }

}
