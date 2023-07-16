import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

public class openFAQTests {


    WebDriver driver;
    @Test
    public void checkActivity() {
// подключаем драйвер
        System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");
        driver =new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage hPage = new HomePage(driver);

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//перемотка страницы
        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/div[2]/div/div[8]/div[1]/div"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);


        hPage.faqButton1Click();
        hPage.answerToBeVisible1();
        hPage.answerToBeAsExpected1();

        hPage.faqButton2Click();
        hPage.answerToBeVisible2();
        hPage.answerToBeAsExpected2();

        hPage.faqButton3Click();
        hPage.answerToBeVisible3();
        hPage.answerToBeAsExpected3();

        hPage.faqButton4Click();
        hPage.answerToBeVisible4();
        hPage.answerToBeAsExpected4();

        hPage.faqButton5Click();
        hPage.answerToBeVisible5();
        hPage.answerToBeAsExpected5();

        hPage.faqButton6Click();
        hPage.answerToBeVisible6();
        hPage.answerToBeAsExpected6();

        hPage.faqButton7Click();
        hPage.answerToBeVisible7();
        hPage.answerToBeAsExpected7();
// еще промотка(из-за кнопки куки)

        WebElement element1 = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/div[2]/div/div[8]/div[1]/div"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element1);

        hPage.faqButton8Click();
        hPage.answerToBeVisible8();
        hPage.answerToBeAsExpected8();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}