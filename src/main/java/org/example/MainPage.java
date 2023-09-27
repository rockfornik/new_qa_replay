package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


//Класс с элементами главной страницы mail.ru и взаимодействия с ними
public class MainPage {
    //Переменная с драйвером
    private WebDriver driver;

    //Конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Элементы взаимодействия
    private By mainLogo = By.xpath("//a[@href=\"//mail.ru\"]");
    private By registrationButton = By.xpath("//*[text()='Регистрация']");
    private By signInButton = By.xpath("(//*[text()='Войти'])[1]");
    private By settingsButton = By.xpath("//div[@class=\"ph-settings svelte-1ke9xx5\"]");
    private By signInButton2 = By.xpath("(//*[text()='Войти'])[2]");
    private By createMail = By.xpath("//*[text()='Создать почту']");
    private By searchField = By.xpath("//*[text()='Поиск Яндекса']");
    private By searchButton = By.xpath("//button[text()='Найти']");

    //Методы работы с элементами
    //Метод клика по лого
    public MainPage clickMainLogo(){
        driver.findElement(mainLogo).click();
        return this;
    }
    //Метод клика по кнопки "Регистрация"
    public RegistrationPage clickRegButton(){
        driver.findElement(registrationButton).click();
        return new RegistrationPage(driver);
    }
    //Метод клика по кнопке "Войти"
    public MainPage clickSignIn(){
        driver.findElement(signInButton).click();
        return this;
    }
    //Метод клика по кнопке настроек
    public MainPage clickSettings(){
        driver.findElement(settingsButton).click();
        return this;
    }
    //Метод клика по кнопке слева "Войти"
    public MainPage clickSignIn2(){
        driver.findElement(signInButton2).click();
        return this;
    }
    //Метод клика по кнопке "Создать почту"
    public CreateMailPage clickCreateMail(){
        driver.findElement(createMail).click();
        return new CreateMailPage(driver);
    }
    //Метод ввода текста в поле поиска
    public MainPage searchText(String searchText){
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(searchField), searchText).perform();
        return this;
    }
    //Метод кика по кнопке "Найти"
    public MainPage clickSearch(){
        driver.findElement(searchButton).click();
        return this;
    }
    //Метод ввода текста в поле поиска и клика "Найти"
    public SearchPage enterSearch(String text){
        this.searchText(text);
        this.clickSearch();
        return new SearchPage(driver);
    }
    //Метод получения текста заголовка главной страницы "mail.ru"
    public String titlePage(){
        return driver.findElement(mainLogo).getText();
    }
}
