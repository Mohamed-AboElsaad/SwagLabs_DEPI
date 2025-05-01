package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver){
        super(driver);
    }
    By productPageTitle = By.xpath("//span[@class='title']");









    public boolean ckeckProductsTitle(){
        return checkingDisplay(productPageTitle);
    }
    public String  checkingTitleValue(){
        return getText(productPageTitle);
    }
}
