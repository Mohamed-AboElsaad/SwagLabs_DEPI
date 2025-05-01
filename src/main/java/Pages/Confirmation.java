package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Confirmation extends BasePage{
    public Confirmation(WebDriver driver) {
        super(driver);
    }
    By confirmationPageTitle = By.xpath("//span[@class='title']");
    By finishButton = By.id("finish");

    public void finishButtonClick(){
        waitUntilElementIsClickable(finishButton,5);
        clickOn(finishButton);
    }

    public boolean confirmationPageTitleDisplayed(){
        waitUntilElementIsVisible(confirmationPageTitle,5);
        return checkingDisplay(confirmationPageTitle);
    }
    public String confirmationPageTitleValue(){
        waitUntilElementIsVisible(confirmationPageTitle,5);
        return getText(confirmationPageTitle);
    }

}

