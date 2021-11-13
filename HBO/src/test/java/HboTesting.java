import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HboTesting {
    public WebDriver driver;

    @Before
    @Test
    public void Upset() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\asifr\\IdeaProjects\\Final-Project-Team-5\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.HBO.com/");
        driver.manage().window().maximize();

    }

    @Test
    public void test1() throws InterruptedException {
        String title = driver.getTitle();
        Assert.assertEquals(title, "HBO: Home to Groundbreaking Series, Movies, Comedies & Documentaries", title);
    }

    @Test
    public void test2() throws InterruptedException {
        List<WebElement> aTags = driver.findElements(By.tagName("a"));
        Assert.assertEquals(93, aTags.size());
    }

    @Test
    public void test3() throws InterruptedException {
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.hbo.com/", url);
    }

    @Test
    public void test4() throws InterruptedException {
        List<WebElement> aTags = driver.findElements(By.tagName("a"));
        String watchStr = aTags.get(0).getText();
        Assert.assertEquals(watchStr, "");
    }

    @Test
    public void test5() throws InterruptedException {
        List<WebElement> imgs = driver.findElements(By.tagName("img"));
        boolean isDisp = imgs.get(1).isDisplayed();
        Assert.assertTrue(isDisp);
    }

    @Test
    public void test6() throws InterruptedException {
        WebElement docsLink = driver.findElement(By.linkText("DOCS"));
        docsLink.click();
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.hbo.com/documentaries", expectedUrl);
    }

    @Test
    public void test7() throws InterruptedException {
        List<WebElement> strongEls = driver.findElements(By.tagName("strong"));
        Assert.assertEquals("Insecure", strongEls.get(0).getText());
        Assert.assertEquals("New on HBO", strongEls.get(1).getText());
    }

    @Test
    public void test8() throws InterruptedException {
        List<WebElement> sections = driver.findElements(By.tagName("section"));
        Assert.assertEquals(17, sections.size());
        boolean isDisp = sections.get(4).isDisplayed();
        Assert.assertTrue(isDisp);
    }

    @Test
    public void test9() throws InterruptedException {
        List<WebElement> aTags = driver.findElements(By.tagName("a"));
        String href = aTags.get(0).getAttribute("href");
        Assert.assertEquals("https://www.hbo.com/", href);
    }

    @Test
    public void test10() throws InterruptedException {
        List<WebElement> scheduleLink = driver.findElements(By.xpath("//a[@class='scheduleRibbonCtaLink']/span"));
        Assert.assertEquals("SEE FULL SCHEDULE", scheduleLink.get(0).getText());
    }

    @Test
    public void test11() throws InterruptedException {
        driver.get("https://www.hbo.com/documentaries");
        List<WebElement> link = driver.findElements(By.xpath("//a[@id='page-band-Sublink111734']"));
        Assert.assertEquals("", link.get(0).getText());
    }

    //@After
    //public void after() {
    //driver.quit();
}
