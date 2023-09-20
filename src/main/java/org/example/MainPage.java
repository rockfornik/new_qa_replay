package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
    private By searchField = By.xpath("//div[@class=\"search-arrow__border-inset mffeadi__1ljar7y\"]]");
    private By searchButton = By.xpath("//button[@class=\"search-arrow__button mffeadi__1ljar7y\"]");

    //Методы работы с элементами
    public MainPage clickMainLogo(){
        driver.findElement(mainLogo).click();
        return this;
    }

    public RegistrationPage clickRegButton(){
        driver.findElement(registrationButton).click();
        return new RegistrationPage(driver);
    }

    public MainPage clickSignIn(){
        driver.findElement(signInButton).click();
        return this;
    }

    public MainPage clickSettings(){
        driver.findElement(settingsButton).click();
        return this;
    }

    public MainPage clickSignIn2(){
        driver.findElement(signInButton2).click();
        return this;
    }

    public CreateMailPage clickCreateMail(){
        driver.findElement(createMail).click();
        return new CreateMailPage(driver);
    }

    public MainPage searchText(String searchText){
        driver.findElement(searchField).sendKeys(searchText);
        return this;
    }

    public MainPage clickSearch(){
        driver.findElement(searchButton).click();
        return this;
    }

    public SearchPage enterSearch(String searchText){
        this.searchText(searchText);
        this.clickSearch();
        return new SearchPage(driver);
    }
}
