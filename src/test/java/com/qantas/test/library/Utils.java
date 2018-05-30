package com.qantas.test.library;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utils {
    private static String currentBrowser;

    public static void setCurrentBrowser(WebDriver driver) {
        currentBrowser = System.getProperty("runEnv");

        if (currentBrowser == null) {
            currentBrowser = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        }
        System.out.println("Current Browser Is :: " + currentBrowser);
    }

    public static String getCurrentBrowser() {
        return currentBrowser;
    }


    public static void doClick(Actions actions, WebElement clickObject) {
        Utils.doWait(2000);
        if(isCurrentRunEnv("Chrome") || isCurrentRunEnv("Firefox")) {
            System.out.println("trying to click...");
            actions.moveToElement(clickObject).click().build().perform();
        }
        else{
            clickObject.click();
        }
    }


    public static void doJSClick(WebDriver driver, WebElement clickObject) {
        Utils.doWait(2000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].scrollIntoView()", clickObject);
        executor.executeScript("arguments[0].click()", clickObject);
    }


    public static void doMouseHover(Actions actions, WebElement element) {
        Utils.doWait(2000);
        if(isCurrentRunEnv("Chrome")) {
            System.out.println("hovering on chrome");
            actions.moveToElement(element).build().perform();
        }
        else{
            actions.moveToElement(element);
        }
    }

    public static boolean isCurrentRunEnv(String browserName) {
        return StringUtils.containsIgnoreCase(currentBrowser, browserName);
    }

    public static boolean isIE() {
        return "IE".equals(currentBrowser) || isCurrentRunEnv("Internet") || isCurrentRunEnv("Explorer");
    }


    public static String getElementText(WebElement element) {
        if (isCurrentRunEnv("Firefox")) {
            return element.getAttribute("textContent").trim();
        }

        return element.getAttribute("innerText").trim();
    }

    public static boolean isDisplayed(WebElement element) {
        if (isCurrentRunEnv("Safari")) {
            return element.getCssValue("visibility").equals("visible");
        }

        return element.isDisplayed();
    }

    public static void navigateBack(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("history.go(-1)");
    }

    public static void doWait(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void sendKeys(WebElement textFfield, String keysToSend) {

        if (keysToSend.equals(null) || keysToSend.equals("")) {
            System.out.println("Cell is empty. Ignore an element.");
        }
        else {

            textFfield.sendKeys(keysToSend);
        }
    }

    public static void setAttribute(WebDriver driver,WebElement ele,String inputValue){
        JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
        myExecutor.executeScript("arguments[0].value='"+inputValue+"';", ele);
    }

    public static void selectValue(Actions actions, WebElement dropdownMenu, List<WebElement> dropDownOptions, String dropdownValue) {
        if (dropdownValue.toString().equals(null) || dropdownValue.toString().equals("")) {
            System.out.println("Cell is empty. Ignore current drop-down.");
        }
        else {
            Utils.doClick(actions, dropdownMenu);
            Utils.doWait(500);

            for (WebElement option : dropDownOptions) {
                if(Utils.getElementText(option).equals(dropdownValue)) {
                    Utils.doClick(actions, option);
                    return;
                }
            }
        }
    }

    public static void selectValue(WebElement dropdown, String dropdownValue) {
        if (dropdownValue.toString().equals(null) || dropdownValue.toString().equals("")) {
            System.out.println("Cell is empty. Ignore current drop-down.");
        }
        else {
            Select select = new Select(dropdown);
            select.selectByVisibleText(dropdownValue);
        }
    }

    public static void rBtnClick(Actions actions, WebElement radioBtnYes, WebElement radioBtnNo, String radioBtnValue) {
        if(radioBtnValue.equalsIgnoreCase("Yes"))
            actions.click(radioBtnYes).build().perform();
        else
            actions.click(radioBtnNo).build().perform();

    }

    public static String removeAllSpaces(String str) {
        return str.trim().replaceAll("\\s+", "");
    }
}
