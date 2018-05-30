package com.qantas.test.library;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitTime{

        public void waits(WebDriver driver, WebElement element)
        {
            (new WebDriverWait(driver, 35)).until(ExpectedConditions.visibilityOf(element));
        }

        public void waits(WebDriver driver, List<WebElement> elements)
        {
            (new WebDriverWait(driver, 30)).until(ExpectedConditions .visibilityOfAllElements(elements));
        }

        public void waits(WebDriver driver, By by)
        {
            (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(by));
        }

        public void waitUntilVisible(WebDriver driver, By by)
        {
            (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(by));
        }

        public void waitUntilInVisible(WebDriver driver, By by)
        {
            (new WebDriverWait(driver, 30)).until(ExpectedConditions.invisibilityOfElementLocated(by));
        }

        public void waitVisibilityOf(WebDriver driver, WebElement element)
        {
            (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(element));
        }

        public void waitToBeClickable(WebDriver driver, WebElement webElement)
        {
            (new WebDriverWait(driver, 120)).until(ExpectedConditions.elementToBeClickable(webElement));
        }

        public void sleep(long millis)
        {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }}

        public void chromeWait(WebDriver driver, WebElement element)
        {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", element);
        }

        public void presenceOfElementLocated(WebDriver driver, WebElement webElement) {
            (new WebDriverWait(driver, 120)).until(ExpectedConditions.visibilityOf(webElement));

        }

}
