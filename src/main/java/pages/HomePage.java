package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;


public class HomePage {


    private WebDriver driver;

    // сайт
    private final static String url = "https://qa-scooter.praktikum-services.ru/";
    // шаблоны для локаторов кнопок faq и ответа
    private String locatorTemplateForFAQ = "accordion__heading-";
    private String locatorTemplateForResponse = "accordion__panel-";

    // локатор для кнопки заказа верхний
    private By orderButtonTop = By.className("Button_Button__ra12g");

    // локатор для кнопки заказа средний
    private By orderButtonMiddle = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    private By endOfPage = By.id("accordion__heading-7" );

    private By coockie = By.xpath("//*[@id='rcc-confirm-button']");

    private By headerToWait = By.className("Home_SubHeader__zwi_E");

    //методы старницы

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    // нажать на кнопку заказа центр со скроллом
    public void orderButtonMiddleClick() {
        driver.findElement(coockie).click();
        WebElement element1 = driver.findElement(orderButtonMiddle);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element1);
        driver.findElement(orderButtonMiddle).click();
    }

    // ожидание загрузки страницы

    public void waitForLoadHeader(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(headerToWait));
    }

    // нажать на кнопку orderButtonTop
    public void orderButtonTopClick() {
        driver.findElement(coockie).click();
        driver.findElement(orderButtonTop).click();
    }

    public void checkBoxValue(int boxNumber, String textInTheBoxNumbered){

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //перемотка страницы
        WebElement element = driver.findElement(faqButton(boxNumber));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

//ожидание кликабельности
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(faqButton(boxNumber)));
//клик
        driver.findElement(faqButton(boxNumber)).click();

//проверка раскрытия бокса
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(faqButton(boxNumber), "aria-expanded", "true"));
//проверка текста в боксе
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBe(response(boxNumber), textInTheBoxNumbered));
    }

    public void scrollingToBottomOfAPage() {
            driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
            //перемотка страницы
            WebElement element = driver.findElement(endOfPage);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    private By faqButton(int numberOfFAQBox){
        String ltFAQ = String.format(locatorTemplateForFAQ + "%s", numberOfFAQBox);
        return By.id(ltFAQ);
    }

    private By response(int numberOfResponse){
        String ltResponse = String.format(locatorTemplateForResponse + "%s", numberOfResponse);
        return By.id(ltResponse);
    }
    //геттер сайта

    public static String getURL(){
        return url;
    }

}