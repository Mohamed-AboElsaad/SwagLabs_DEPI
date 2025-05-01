import Pages.Login;
import Pages.ProductPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class PageTest extends BaseTest{

Login login;
ProductPage productPage;


@DataProvider(name="ValidData")
    public static Object [][] credentials() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelData();
    }

    @Test(priority = 0,dataProvider="ValidData")
    public void loginWithValidData(String username,String password){
        login = new Login(driver);
        productPage = new ProductPage(driver);

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    login.checkTitleIsDisplayed();
     Assert.assertEquals(login.getLoginTitle(),"Swag Labs");
    login.addUsername(username);
    login.addPassword(password);
    login.clickOnLoginButton();
    Assert.assertTrue(productPage.ckeckProductsTitle());
    Assert.assertEquals(productPage.checkingTitleValue(),"Products");
    }

    @Test
    public void dropDownList(){
    login = new Login(driver);
    login.select(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//p//select"),2);

    }

}


