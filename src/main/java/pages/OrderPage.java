package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class OrderPage {



    private WebDriver driver;

    private final String templForSubSt1 = ".//*[text() = '";
    private final String templForSubSt2 = "']/parent::*/parent::*";
    private final String templForCalendar1 = ".//div[not(contains(@class,'outside-month')) and (text() = '";
    private final String templForCalendar2 = "')]";
    private final String templForPeriod1 = ".//div[contains(text(),'";
    private final String templForPeriod2 =  "')]";


    // локатор для имя
    private By name = By.xpath(".//input[@placeholder='* Имя']");

    // локатор для фамилия

    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");

    // локатор для адреса
    private By adress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // локатор для станция метро

    private By subwayStation = By.xpath(".//input[@placeholder='* Станция метро']");

    // локатор для телефона

    private By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор для кнопки далее

    private By nextButton = By.xpath(".//div[2]//div[3]/button");


    // локатор для даты
    private By fromdateto = By.xpath(".//input[@placeholder='* Когда привезти самокат']");


    // локаторы для цвета самоката
    private By colourGrey = By.xpath(".//div[3]/label[2]");
    private By colourWhite = By.xpath(".//div[3]/label[1]");

    // локатор для срок
    private By days = By.className("Dropdown-placeholder");

    // локатор для комментарий
    private By comment = By.xpath(".//div[4]/input");

    // локатор для кнопки далее

    private By next2Button = By.xpath(".//div[2]/div[3]/button[2]");
    // локатор для кнопки да

    private By yesButton = By.xpath(".//div[5]/div[2]/button[2]");
    //локатор для финального сообщения
    private By orderFinished = By.className("Order_ModalHeader__3FDaJ");

    private By listOfMetroEnd = By.xpath(".//li[225]");



    //методы
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    // заполнение имени
    public void fillName(String imya){
        driver.findElement(name).sendKeys(imya);
    }
    // заполнение фамилии
    public void fillSurname(String familia){
        driver.findElement(surname).sendKeys(familia);
    }
    //заполнение адреса
    public void fillAdress(String address){
        driver.findElement(adress).sendKeys(address);
    }
    //заполнение станции метро
    public void fillSubway(String subSt){
        driver.findElement(subwayStation).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement element3 = driver.findElement(subSt(subSt));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element3);
        driver.findElement(subSt(subSt)).click();
    }

    //заполнение номера телефона
    public void fillPhone(String telefon){
        driver.findElement(phone).sendKeys(telefon);
    }

    //нажатие на далее 1ый раз
    public void pressNextButton(){
        WebElement element5 = driver.findElement(nextButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element5);
        driver.findElement(nextButton).click();
    }

    // заполнение даты когда привезти самокат
    public void fillDate(int dayNum){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(fromdateto).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(calendar(dayNum)).click();
    }

    //заполнить срок аренды
    public void fillDays(String per){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(days).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(period(per)).click();
    }
    //заполнение цвета
    public void chooseColour(int col) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (col == 1) {
            driver.findElement(colourGrey).click();
        } else {
            driver.findElement(colourWhite).click();
        }
    }
    //заполнение комментария
    public void fillComment(String com){
        driver.findElement(comment).sendKeys(com);
    }

    //нажатие второй конпки далее
    public void pressNext2Button(){
        WebElement element4 = driver.findElement(next2Button);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element4);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(next2Button).click();
    }

    // нажатие кнопки да
    public void pressYesButton(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(yesButton).click();
    }
    // проверка что заказ создан
    public void orderFinishedCheck(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(orderFinished, "Заказ оформлен"));
    }

    public By subSt(String subStation){
        String station = String.format(templForSubSt1 + "%s" + templForSubSt2, subStation);
        return By.xpath(station);
    }

    public By calendar(int day){
        String cal = String.format(templForCalendar1 + "%s"  + templForCalendar2, day);
        return By.xpath(cal);
    }

    public By period (String peri){
        String perio = String.format(templForPeriod1 + "%s" + templForPeriod2, peri);
        return By.xpath(perio);
    }
}