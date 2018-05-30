package com.qantas.test.pagefactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;

import java.util.List;

public class QFFPageFactory {

    @FindBy(css="div.formHeading_3h3gx>h1")
    public WebElement qFFPageHeading;

    @FindBy(name = "countryOfResidence")
    public WebElement qFFPageCountryOfResidenceDropdown;

    @FindBy(name = "nameDetailsTitle")
    public WebElement qFFPagenameDetailsTitle;


    @FindBy(name = "nameDetailsGender")
    public WebElement qFFPagenameDetailsGender;


    @FindBy(name = "nameDetailsFirstName")
    public WebElement qFFPagenameDetailsFirstName;


    @FindBy(name = "nameDetailsLastName")
    public WebElement qFFPagenameDetailsLastName;

    @FindBy(name = "phoneDetailsPhoneType")
    public WebElement qFFPagephoneDetailsPhoneType;


    @FindBy(name = "phoneDetailsAreaCode")
    public WebElement qFFPagephoneDetailsAreaCode;


    @FindBy(name = "phoneDetailsNumber")
    public WebElement qFFPagephoneDetailsNumber;

    @FindBy(name = "streetAddressDetailsAddressType")
    public WebElement qFFPagestreetAddressDetailsAddressType;

    @FindBy(name = "streetAddressDetailsAddressLineOne")
    public WebElement qFFPagestreetAddressDetailsAddressLineOne;

    @FindBy(name = "streetAddressDetailsAddressLineTwo")
    public WebElement qFFPagestreetAddressDetailsAddressLineTwo;


    @FindBy(name = "streetAddressDetailsSuburb")
    public WebElement qFFPagestreetAddressDetailsSuburb;


    @FindBy(name = "streetAddressDetailsState")
    public WebElement qFFPagestreetAddressDetailsState;


    @FindBy(name = "streetAddressDetailsPostCode")
    public WebElement qFFPagestreetAddressDetailsPostCode;


    @FindBy(name = "email")
    public WebElement qFFPageemail;


    @FindBy(name = "emailVerification")
    public WebElement qFFPageemailVerification;


    @FindBy(name = "birthDay")
    public WebElement qFFPagebirthDay;


    @FindBy(name = "birthMonth")
    public WebElement qFFPagebirthMonth;


    @FindBy(name = "birthYear")
    public WebElement qFFPagebirthYear;


    @FindBy(name = "securityMotherMaidenName")
    public WebElement qFFPagesecurityMotherMaidenName;


    @FindBy(name = "pin")
    public WebElement qFFPagepin;


    @FindBy(name = "confirmedPin")
    public WebElement qFFPageconfirmedPin;

    @FindBy(css = "label[for='termsAndConditions']")
    public WebElement qFFTermsAndConditionsCheckBox;


    @FindBy(id = "card-name")
    public  WebElement qFFCardName;

    @FindBy(css = "iframe.gw-proxy-number")
    public WebElement qFFiFrameforCardNumber;

    //index 0 for card numnber
    //index 2 for security number
    @FindBy(css = "html>body>input")
    public List<WebElement> qFFCardNumberAndSecurityCode;

    @FindBy(id = "expiry-month")
    public  WebElement qFFCardExpiryMonth;

    @FindBy(id = "expiry-year")
    public  WebElement qFFCardExpiryYear;

    @FindBy(css = "iframe.gw-proxy-securityCode")
    public WebElement qFFiFrameforSecurityCode;

    //index 1 for recaptcha checkbox
    @FindBy(css = "iframe[role='presentation']")
    public WebElement qFFiFrameforRecapchaCheckbox;

    @FindBy(css = "div.recaptcha-checkbox-checkmark")
    public WebElement qFFRecapchaCheckbox;

    @FindBy(css = "button.submit_dLGQF")
    public WebElement qFFPayButton;


}
