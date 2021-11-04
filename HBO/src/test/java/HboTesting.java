import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HboTesting {
    public WebDriver driver;

    @Before
    @Test
    public void Upset() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hira Khan\\IdeaProjects\\web-automation-framework\\Generic\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.HBO.com/");
        driver.manage().window().maximize();
       // driver.close();
    }
   /* @After
    public void after () {
        driver.quit();*/
    }
