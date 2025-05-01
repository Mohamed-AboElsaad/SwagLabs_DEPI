import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

//Main Class and the rest inherit from this//
public class BaseTest {
    WebDriver driver;


    @BeforeClass
    public void testSetUp(){
        driver = new EdgeDriver();
//        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //To wait all Elements
    }
    @AfterClass
    public void tearDownTest(){
        driver.quit();
}
}
