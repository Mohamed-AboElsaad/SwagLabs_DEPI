package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

//**Methods are put here**//
public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;



    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilElementIsVisible(By by,int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitUntilElementIsClickable(By by,int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void waitUntilUrlToBe(String url){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void setText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    public void clickOn(By by){
        driver.findElement(by).click();
    }
    public void clear(By by){
        driver.findElement(by).clear();
    }
    public String getText(By by){
        return driver.findElement(by).getText();
    }
    public String GetTitle(){
        return driver.getTitle();
    }
    public void select(By by,int index){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Select dropDown = new Select(driver.findElement(by));
        dropDown.selectByIndex(index);
//        dropDown.selectByValue(value);
//        dropDown.selectByVisibleText(value);
    }
    public boolean checkingDisplay(By by){
        return driver.findElement(by).isDisplayed();
    }
    public void elementsList(By by,int i){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        List <WebElement> elements= driver.findElements(by);
        elements.get(i).click();
    }
    public int getElementsListSize(By by) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        List<WebElement> elements = driver.findElements(by);
        return elements.size();
    }
}
