import Pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class PageTest extends BaseTest{

Login login;
ProductPage productPage;
Cart cart;
Checkout checkout;
Confirmation confirmation;
ThanksPage thanksPage;

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

    }

    @Test(priority = 1)
    public void shopping(){
        productPage = new ProductPage(driver);
        cart = new Cart(driver);

        Assert.assertTrue(productPage.ckeckProductsTitle());
        Assert.assertEquals(productPage.checkingTitleValue(),"Products");
        productPage.clickAddToCart();
//        productPage.clickOneButton();
//        productPage.clickOneButton();
        productPage.clickOnCartIcon();
    }

     @Test(priority = 2)
    public void cartPage(){
         cart = new Cart(driver);
         SoftAssert softAssert = new SoftAssert();

         Assert.assertTrue(cart.checkCartTitle());
         softAssert.assertEquals(cart.checkCartTitleValue(),"Your Cart");
         softAssert.assertAll();

         cart.clickOnCheckoutButton();

     }
     @Test(priority = 3)
    public void checkingout(){
         checkout = new Checkout(driver);
         SoftAssert softAssert = new SoftAssert();

         softAssert.assertTrue(checkout.checkCheckoutTitle());
         softAssert.assertEquals(checkout.checkCheckoutTitleValue(),"Checkout: Your Information");
        softAssert.assertAll();

        checkout.setFnameField();
        checkout.setLnameField();
        checkout.setZipCode();
        checkout.clickOnContinueButton();
     }

    @Test(priority = 4)
    public void confirmation(){
    confirmation = new Confirmation(driver);
    SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(confirmation.confirmationPageTitleDisplayed());
        softAssert.assertEquals(confirmation.confirmationPageTitleValue(),"Checkout: Overview");
        softAssert.assertAll();

    confirmation.finishButtonClick();
    }
    @Test(priority = 5)
    public void thanksPage(){
    thanksPage = new ThanksPage(driver);
    SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(thanksPage.messageDisplayed());
        softAssert.assertEquals(thanksPage.messageValue(),"Thank you for your order!");


    thanksPage.goBackButton();

    softAssert.assertEquals(productPage.checkingTitleValue(),"Products");
    softAssert.assertAll();
    }

}




