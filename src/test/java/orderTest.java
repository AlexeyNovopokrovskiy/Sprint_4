import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import Pages.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.concurrent.TimeUnit;



@RunWith(Parameterized.class)
public class orderTest {

    private final String name;
    private final String surname;
    private final String adress;
    private final int metroStation;
    private final String phone;
    private final int weekOfTheMonth;
    private final int dayOfTheWeek;
    private final int period;
    private final int colour;
    private final String comment;


    public orderTest(String name, String surname, String adress, int metroStation, String phone, int weekOfTheMonth, int dayOfTheWeek, int period, int colour, String comment) {

        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metroStation = metroStation;
        this.phone = phone;
        this.weekOfTheMonth = weekOfTheMonth;
        this.dayOfTheWeek = dayOfTheWeek;
        this.period = period;
        this.colour = colour;
        this.comment = comment;


    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Иван", "Иванов", "Лермонтова 10", 60, "79168457896", 4, 3, 2, 1, "тест"},
                {"Петр", "Петров", "Пушкина 12", 35, "79258457897", 3, 4, 1, 0, "тест2"},
        };
    }

    WebDriver driver;

    @Test
    public void checkOrderMiddle() {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage hPage = new HomePage(driver);

        hPage.waitForLoadHeader();
        // скролл до средней кнопки
        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/div[2]/div/div[8]/div[1]/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        hPage.orderButtonMiddleClick();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        OrderPage oPage = new OrderPage(driver);


        oPage.fillName(name);
        oPage.fillSurname(surname);
        oPage.fillAdress(adress);
        oPage.fillSubway(metroStation);
        oPage.fillPhone(phone);
        oPage.pressNextButton();
        oPage.fillDate(weekOfTheMonth, dayOfTheWeek);
        oPage.fillDays(period);
        oPage.chooseColour(colour);
        oPage.fillComment(comment);
        oPage.pressNext2Button();
        oPage.pressYesButton();
        oPage.orderFinishedCheck();
    }
    @Test
    public void checkOrderTop () {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage hPage = new HomePage(driver);


        hPage.waitForLoadHeader();
        hPage.orderButtonTopClick();
        // ожидание перехода на дугую страницу
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        OrderPage oPage = new OrderPage(driver);


        oPage.fillName(name);
        oPage.fillSurname(surname);
        oPage.fillAdress(adress);
        oPage.fillSubway(metroStation);
        oPage.fillPhone(phone);
        oPage.pressNextButton();
        oPage.fillDate(weekOfTheMonth, dayOfTheWeek);
        oPage.fillDays(period);
        oPage.chooseColour(colour);
        oPage.fillComment(comment);
        oPage.pressNext2Button();
        oPage.pressYesButton();
        oPage.orderFinishedCheck();
    }

    @After
    public void teardown () {
        driver.quit();
    }
}