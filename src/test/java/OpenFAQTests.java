import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class OpenFAQTests {
private final int numberOfBox;
private final String textInTheBox;

public OpenFAQTests (int numberOfBox, String textInTheBox){
    this.numberOfBox = numberOfBox;
    this.textInTheBox = textInTheBox;

}
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] get() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    WebDriver driver;

    @Before
    public void driverSetup(){

        //System.setProperty("webdriver.gecko.driver", "C:/WebDriver/bin/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(HomePage.getURL());
    }
    @Test
    public void checkActivity() {


        HomePage hPage = new HomePage(driver);

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        hPage.waitForLoadHeader();
        hPage.checkBoxValue(numberOfBox, textInTheBox);

    }

    @After
    public void teardown() {
        driver.quit();
    }
}