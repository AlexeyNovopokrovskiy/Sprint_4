import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.concurrent.TimeUnit;



//@RunWith(Parameterized.class)
public class OrderTest {
/*
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


    public OrderTest(String name, String surname, String adress, int metroStation, String phone, int weekOfTheMonth, int dayOfTheWeek, int period, int colour, String comment) {

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
                {"Иван", "Иванов", "Лермонтова 10", 60, "79168457896", 4, 3, 1, 0, "тест"},
            //    {"Петр", "Петров", "Пушкина 12", 35, "79258457897", 3, 4, 1, 0, "тест2"},
        };
    }
*/

    WebDriver driver;
    @Before
    public void driverSetup(){

        //System.setProperty("webdriver.gecko.driver", "C:/WebDriver/bin/geckodriver.exe");
          System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");
          driver =new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(HomePage.getURL());
    }
    //WebDriver driver;

    @Test
    public void checkOrderMiddle() {

        HomePage hPage = new HomePage(driver);
        hPage.waitForLoadHeader();
        hPage.scrollingToBottomOfAPage();
        hPage.orderButtonMiddleClick();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        OrderPage oPage = new OrderPage(driver);


        oPage.fillName("Иван");
        oPage.fillSurname("Иванов");
        oPage.fillAdress("Лермонтова 10");
        oPage.fillSubway("Фили");
        oPage.fillPhone("79168457896");
        oPage.pressNextButton();
        oPage.fillDate( 5);
        oPage.fillDays("трое суток");
        oPage.chooseColour(1);
        oPage.fillComment("Хочется поговорить, пусть и с самокатом.");
        oPage.pressNext2Button();
        oPage.pressYesButton();
        oPage.orderFinishedCheck();
    }
    @Test
    public void checkOrderTop () {

        HomePage hPage = new HomePage(driver);
        hPage.waitForLoadHeader();
        hPage.orderButtonTopClick();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        OrderPage oPage = new OrderPage(driver);


        oPage.fillName("Петр");
        oPage.fillSurname("Петров");
        oPage.fillAdress("Дубинина 15");
        oPage.fillSubway("Красногвардейская");
        oPage.fillPhone("89168457896");
        oPage.pressNextButton();
        oPage.fillDate( 29);
        oPage.fillDays("сутки");
        oPage.chooseColour(0);
        oPage.fillComment("Расхотелось");
        oPage.pressNext2Button();
        oPage.pressYesButton();
        oPage.orderFinishedCheck();
    }

    @After
    public void teardown () {
        driver.quit();
    }
}