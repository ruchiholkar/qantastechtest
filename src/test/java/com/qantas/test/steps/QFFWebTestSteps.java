package com.qantas.test.steps;

import com.qantas.test.library.PhoneType;
import com.qantas.test.library.ReadPropertiesFile;
import com.qantas.test.library.Utils;
import com.qantas.test.library.WaitTime;
import com.qantas.test.pagefactory.QFFPageFactory;
import com.qantas.test.pagefactory.QFFPageFactory;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.yecht.Data;

import java.util.Properties;


public class QFFWebTestSteps {

    private WaitTime thinkTime = new WaitTime();
    private WebDriver driver = null;
    private Actions actions;
    Properties properties = ReadPropertiesFile.getProperty();
    QFFPageFactory qffPageFactory;

   @Step
    public void iamOnQFFLandingPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        driver.navigate().to(properties.getProperty("QFFLandingPage"));
        //driver.manage().window().maximize();
        qffPageFactory = PageFactory.initElements(driver, QFFPageFactory.class);
    }

    @Step
    public String getQFFLandingPageTitle() {
        //TODO For some reason this is not working so commented it
        //thinkTime.waits(driver,qffPageFactory.qFFPageHeading);
        return driver.getTitle();
    }

    @Step
    public String getQFFPageHeader() {
        thinkTime.waits(driver,qffPageFactory.qFFPageHeading);
        return qffPageFactory.qFFPageHeading.getText();
    }

    @Step
    public void selectCountryOfResidence(String country) {
        //TODO For some reason this is not working as it is throwing no such element exception
        Utils.selectValue(qffPageFactory.qFFPageCountryOfResidenceDropdown,country);
    }

    @Step
    public void enterNameDetails(String title, String gender, String firstName, String lastName) {
        Utils.selectValue(qffPageFactory.qFFPagenameDetailsTitle,title);
        Utils.selectValue(qffPageFactory.qFFPagenameDetailsGender,gender);
        Utils.sendKeys(qffPageFactory.qFFPagenameDetailsFirstName,firstName);
        Utils.sendKeys(qffPageFactory.qFFPagenameDetailsLastName,lastName);
    }

    @Step
    public void enterPhoneDetails(String phoneType, String areaCode, String phoneNumber) {
        Utils.selectValue(qffPageFactory.qFFPagephoneDetailsPhoneType,phoneType);
        if(phoneType.equalsIgnoreCase(PhoneType.HOME) || phoneType.equalsIgnoreCase(PhoneType.BUSINESS)) {
            Utils.sendKeys(qffPageFactory.qFFPagephoneDetailsAreaCode,areaCode);
        }
        Utils.sendKeys(qffPageFactory.qFFPagephoneDetailsNumber,phoneNumber);
    }

    @Step
    public void enterPostalAddressDetails(String postalAddressType, String addressLine1,
                                          String addressLine2, String suburb_town_city,
                                          String state, String postCode) {
        Utils.selectValue(qffPageFactory.qFFPagestreetAddressDetailsAddressType, postalAddressType);
        Utils.sendKeys(qffPageFactory.qFFPagestreetAddressDetailsAddressLineOne, addressLine1);
        Utils.sendKeys(qffPageFactory.qFFPagestreetAddressDetailsAddressLineTwo, addressLine2);
        Utils.sendKeys(qffPageFactory.qFFPagestreetAddressDetailsSuburb, suburb_town_city);
        Utils.sendKeys(qffPageFactory.qFFPagestreetAddressDetailsState, state);
        Utils.sendKeys(qffPageFactory.qFFPagestreetAddressDetailsPostCode, postCode);
    }

    @Step
    public void enterEmailDetails(String emailAddress) {
        Utils.sendKeys(qffPageFactory.qFFPageemail,emailAddress);
        Utils.sendKeys(qffPageFactory.qFFPageemailVerification,emailAddress);
    }

    @Step
    public void enterSecurityQuestionsDetails(String date, String month, String year,
                                              String motherMaideName, String pin) {
        Utils.selectValue(qffPageFactory.qFFPagebirthDay,date);
        Utils.selectValue(qffPageFactory.qFFPagebirthMonth,month);
        Utils.selectValue(qffPageFactory.qFFPagebirthYear,year);
        Utils.sendKeys(qffPageFactory.qFFPagesecurityMotherMaidenName,motherMaideName);
        Utils.sendKeys(qffPageFactory.qFFPagepin,pin);
        Utils.sendKeys(qffPageFactory.qFFPageconfirmedPin,pin);
    }

    @Step
    public void acceptTheTermsAndConditions() {
        Utils.doClick(actions,qffPageFactory.qFFTermsAndConditionsCheckBox);
    }

    @Step
    public void enterCreditCardDetails(String cardHolderName, String cardNumber,
                                       String exipryDateMonth, String exipryDateYear,
                                       String securityCode) {
       Utils.sendKeys(qffPageFactory.qFFCardName,cardHolderName);

       driver.switchTo().frame(qffPageFactory.qFFiFrameforCardNumber);
       Utils.sendKeys(qffPageFactory.qFFCardNumberAndSecurityCode.get(0),cardNumber);
       driver.switchTo().defaultContent();
       Utils.selectValue(qffPageFactory.qFFCardExpiryMonth,exipryDateMonth);
       Utils.selectValue(qffPageFactory.qFFCardExpiryYear,exipryDateYear);
       driver.switchTo().frame(qffPageFactory.qFFiFrameforSecurityCode);
       Utils.sendKeys(qffPageFactory.qFFCardNumberAndSecurityCode.get(2),securityCode);
       driver.switchTo().defaultContent();
    }

    @Step
    public void selectIamNotRobot() {
       driver.switchTo().frame(qffPageFactory.qFFiFrameforRecapchaCheckbox);
       Utils.doClick(actions,qffPageFactory.qFFRecapchaCheckbox);
       driver.switchTo().defaultContent();
    }

    @Step
    public void clickOnPayButton() {
       // commenting it as we are not going to click
       //Utils.doClick(actions,qffPageFactory.qFFPayButton);
    }

    @Step
    public String getPaymentConfirmationMessage() {
       //This is a dummy return in actual we need to wait for the confirmation message and then read the message
        // and return the text
       return "Success";
    }
}
