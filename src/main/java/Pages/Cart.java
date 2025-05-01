package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends BasePage{
    public Cart(WebDriver driver) {
        super(driver);
    }
    By cartPageTitle = By.xpath("//span[@class='title']");
    By checkoutButton = By.id("checkout");




    public void clickOnCheckoutButton(){
        waitUntilElementIsClickable(checkoutButton,5);
        clickOn(checkoutButton);
    }

    public boolean checkCartTitle(){
        waitUntilElementIsVisible(cartPageTitle,5);
        return checkingDisplay(cartPageTitle);
    }
    public String checkCartTitleValue(){
        waitUntilElementIsVisible(cartPageTitle,5);
        return getText(cartPageTitle);
    }


}
