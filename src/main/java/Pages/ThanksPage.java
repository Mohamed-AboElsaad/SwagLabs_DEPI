package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThanksPage extends BasePage{
    public ThanksPage(WebDriver driver) {
        super(driver);
    }
    By thanksMessage = By.xpath("//h2[@class='complete-header']");
    By goBackButton = By.id("back-to-products");

    public void goBackButton(){
        waitUntilElementIsClickable(goBackButton,5);
        clickOn(goBackButton);
    }
    public boolean messageDisplayed(){
        waitUntilElementIsVisible(thanksMessage,5);
        return checkingDisplay(thanksMessage);
    }
    public String messageValue(){
        waitUntilElementIsVisible(thanksMessage,5);
        return getText(thanksMessage);
    }
}
