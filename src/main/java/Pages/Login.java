package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage{
    public Login(WebDriver driver){
        super(driver);
    }

   private By homepagetitle = By.xpath("//div[@class='login_logo']");
   private By usernameField = By.id("user-name");
   private By passwordField = By.id("password");
   private By loginCTA = By.id("login-button");


    public void addUsername(String username){
        waitUntilElementIsVisible(usernameField,5);
        setText(usernameField,username);
    }
    public void addPassword(String pass){
        waitUntilElementIsVisible(passwordField,5);
        setText(passwordField,pass);
    }
    public void clickOnLoginButton(){
        waitUntilElementIsVisible(loginCTA,2);
        clickOn(loginCTA);
    }
    public boolean checkTitleIsDisplayed(){
        return checkingDisplay(homepagetitle);
    }
    public String getLoginTitle(){
         return getText(homepagetitle);
    }
}
