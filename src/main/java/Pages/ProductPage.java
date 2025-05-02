package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By productPageTitle = By.xpath("//span[@class='title']");
    By addTocartButtons = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
    By cartIcon = By.xpath("//a[@class='shopping_cart_link']");


    public void clickAddToCart() {
        waitUntilElementIsClickable(addTocartButtons,5);
        int j = getElementsListSize(addTocartButtons);
        int counter = 0;

        for (int i = 0; i < j; i++) {
        int random = (int) (Math.random() * j);
            if (counter != 2) {
                elementsList(addTocartButtons, random);
                counter++;
            }
        }
    }

    public void clickOneButton() {
        waitUntilElementIsClickable(addTocartButtons,5);
        clickOn(addTocartButtons);
    }

    public void clickOnCartIcon() {
        waitUntilElementIsClickable(cartIcon,10);
        clickOn(cartIcon);
    }


    public boolean ckeckProductsTitle() {
        waitUntilElementIsVisible(productPageTitle, 5);
        return checkingDisplay(productPageTitle);
    }

    public String checkingTitleValue() {
        waitUntilElementIsVisible(productPageTitle,5);
        return getText(productPageTitle);
    }
}