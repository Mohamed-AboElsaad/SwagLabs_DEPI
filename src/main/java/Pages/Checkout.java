package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout extends BasePage{
    public Checkout(WebDriver driver) {
        super(driver);
    }
    By checkoutPageTitle = By.xpath("//span[@class='title']");
    By continueButton = By.id("continue");
    By fnameField = By.id("first-name");
    By lnameField = By.id("last-name");
    By zipCode = By.id("postal-code");


    public void setFnameField(){
        waitUntilElementIsVisible(fnameField,5);
        setText(fnameField,"Mohamed");
    }
    public void setLnameField(){
        waitUntilElementIsVisible(fnameField,5);
        setText(lnameField,"Talaat");
    }
    public void setZipCode(){
        waitUntilElementIsVisible(zipCode,5);
        setText(zipCode,"22512");
    }


    public void clickOnContinueButton(){
        waitUntilElementIsClickable(continueButton,5);
        clickOn(continueButton);
    }

    public boolean checkCheckoutTitle(){
        waitUntilElementIsVisible(checkoutPageTitle,5);
        return checkingDisplay(checkoutPageTitle);
    }
    public String checkCheckoutTitleValue(){
        waitUntilElementIsVisible(checkoutPageTitle,5);
        return getText(checkoutPageTitle);
    }




}
