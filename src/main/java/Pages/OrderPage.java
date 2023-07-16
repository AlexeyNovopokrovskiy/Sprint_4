package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class OrderPage {



    private WebDriver driver;

    // локатор для имя
    private By name = By.xpath("html/body/div/div/div[2]/div[2]/div[1]/input[@placeholder='* Имя']");

    // локатор для фамилия

    private By surname = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input[@placeholder='* Фамилия']");

    // локатор для адреса
    private By adress = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input[@placeholder='* Адрес: куда привезти заказ']");

    // локатор для станция метро

    private By subwayStation = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input[@placeholder='* Станция метро']");

    // локатор для телефона

    private By phone = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");

    // локатор для кнопки далее

    private By nextButton = By.xpath("/html/body/div/div/div[2]/div[3]/button");

    // локатор для даты
    private By fromdateto = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/input");


    // локаторы для цвета самоката
    private By colourGrey = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[2]");
    private By colourWhite = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[1]");

    // локатор для срок
    private By days = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div");

    // локатор для комментарий
    private By comment = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");

    // локатор для кнопки далее

    private By next2Button = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    // локатор для кнопки да

    private By yesButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    //локатор для финального сообщения
    private By orderFinished = By.className("Order_ModalHeader__3FDaJ");


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
    public void fillSubway(int subSt){
        driver.findElement(subwayStation).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement element3 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[225]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element3);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li["+ subSt +"]/button")).click();
    }

    //заполнение номера телефона
    public void fillPhone(String telefon){
        driver.findElement(phone).sendKeys(telefon);
    }
    //нажатие на далее 1ый раз
    public void pressNextButton(){
        driver.findElement(nextButton).click();
    }
    // заполнение даты когда привести самокат
    public void fillDate(int weekNu, int dayNum){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(fromdateto).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div["+ weekNu + "]/div["+ dayNum +"]")).click();
    }
    //заполнить срок аренды
    public void fillDays(int per){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(days).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[" + per + "]")).click();
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
                .until(ExpectedConditions.textToBe(orderFinished, "Заказ оформлен"));
    }
}