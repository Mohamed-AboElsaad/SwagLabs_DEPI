import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

//Main Class and the rest inherit from this//
public class BaseTest {
    WebDriver driver;


    @BeforeClass
    public void testSetUp(){
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //To wait all Elements
    }
    @AfterClass
    public void tearDownTest(){
//        driver.quit();
}
}
