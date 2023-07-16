package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class HomePage {


    private WebDriver driver;

    // локатор для кнопки заказа верхний
    private By orderButtonTop = By.className("Button_Button__ra12g");

    // локатор для кнопки заказа средний
    private By orderButtonMiddle = By.xpath("/html/body/div/div/div[1]/div[4]/div[2]/div[5]/button");

    // локаторы для раскрывающегося списка 8-15
    private By faqButton1 = By.xpath(".//div[@id='accordion__heading-0']");
    private By faqButton2 = By.id("accordion__heading-1");
    private By faqButton3 = By.id("accordion__heading-2");
    private By faqButton4 = By.id("accordion__heading-3");
    private By faqButton5 = By.id("accordion__heading-4");
    private By faqButton6 = By.id("accordion__heading-5");
    private By faqButton7 = By.id("accordion__heading-6");
    private By faqButton8 = By.id("accordion__heading-7");

    // локаторы для результата раскрытия списка 8-15
    private By response1 = By.id("accordion__panel-0");
    private By response2 = By.id("accordion__panel-1");
    private By response3 = By.id("accordion__panel-2");
    private By response4 = By.id("accordion__panel-3");
    private By response5 = By.id("accordion__panel-4");
    private By response6 = By.id("accordion__panel-5");
    private By response7 = By.id("accordion__panel-6");
    private By response8 = By.id("accordion__panel-7");

    //методы старницы

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    // нажать на кнопку заказа центр со скроллом
    public void orderButtonMiddleClick() {
        WebElement element1 = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/div[2]/div/div[1]/div[1]/div"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element1);
        driver.findElement(orderButtonMiddle).click();
    }

    // ожидание загрузки страницы

    public void waitForLoadHeader(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_SubHeader__zwi_E")));
    }


    // нажать на кнопку orderButtonTop
    public void orderButtonTopClick() {
        driver.findElement(orderButtonTop).click();
    }
    // нажать на кнопку faq 1
    public void faqButton1Click() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(faqButton1));
        driver.findElement(faqButton1).click();
    }

    // проверить что фак1 раскрылся
    public void answerToBeVisible1() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(faqButton1, "aria-expanded", "true"));
    }
    // проверить что фак1 соответствует ответ соотвествует ожиданиям
    public void answerToBeAsExpected1() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBe(response1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
    }
    //-----------------------------------------------------------------------------------------------------------------
// нажать на кнопку faq 2
    public void faqButton2Click() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(faqButton2));
        driver.findElement(faqButton2).click();
    }

    // проверить что фак2 раскрылся
    public void answerToBeVisible2() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(faqButton2, "aria-expanded", "true"));
    }
    // проверить что фак2 соответствует ответ соотвествует ожиданиям
    public void answerToBeAsExpected2() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBe(response2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));
    }
    //---------------------------------------------------------------------------------------------------------
    // нажать на кнопку faq 3
    public void faqButton3Click() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(faqButton3));
        driver.findElement(faqButton3).click();
    }

    // проверить что фак3 раскрылся
    public void answerToBeVisible3() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(faqButton3, "aria-expanded", "true"));
    }
    // проверить что фак3 соответствует ответ соотвествует ожиданиям
    public void answerToBeAsExpected3() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBe(response3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));
    }
    //------------------------------------------------------------------------------------------------------------
// нажать на кнопку faq 4
    public void faqButton4Click() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(faqButton4));
        driver.findElement(faqButton4).click();
    }

    // проверить что фак4 раскрылся
    public void answerToBeVisible4() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(faqButton4, "aria-expanded", "true"));
    }
    // проверить что фак4 соответствует ответ соотвествует ожиданиям
    public void answerToBeAsExpected4() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBe(response4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."));
    }
    //----------------------------------------------------------------------------------------------------------------
    // нажать на кнопку faq 5
    public void faqButton5Click() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(faqButton5));
        driver.findElement(faqButton5).click();
    }

    // проверить что фак5 раскрылся
    public void answerToBeVisible5() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(faqButton5, "aria-expanded", "true"));
    }
    // проверить что фак5 соответствует ответ соотвествует ожиданиям
    public void answerToBeAsExpected5() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBe(response5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));
    }
    //----------------------------------------------------------------------------------------------------------------
    // нажать на кнопку faq 6
    public void faqButton6Click() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(faqButton6));
        driver.findElement(faqButton6).click();
    }

    // проверить что фак6 раскрылся
    public void answerToBeVisible6() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(faqButton6, "aria-expanded", "true"));
    }
    // проверить что фак6 соответствует ответ соотвествует ожиданиям
    public void answerToBeAsExpected6() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBe(response6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));
    }
    //----------------------------------------------------------------------------------------------------------------
    // нажать на кнопку faq 7
    public void faqButton7Click() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(faqButton7));
        driver.findElement(faqButton7).click();
    }

    // проверить что фак7 раскрылся
    public void answerToBeVisible7() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(faqButton7, "aria-expanded", "true"));
    }
    // проверить что фак7 соответствует ответ соотвествует ожиданиям
    public void answerToBeAsExpected7() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBe(response7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));
    }
    //----------------------------------------------------------------------------------------------------------------
    // нажать на кнопку faq 8
    public void faqButton8Click() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(faqButton8));
        driver.findElement(faqButton8).click();
    }

    // проверить что фак8 раскрылся
    public void answerToBeVisible8() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(faqButton8, "aria-expanded", "true"));
    }
    // проверить что фак8 соответствует ответ соотвествует ожиданиям
    public void answerToBeAsExpected8() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBe(response8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."));
    }
}