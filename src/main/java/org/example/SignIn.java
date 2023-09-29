package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignIn extends MainPage {
    WebDriver driver;
    public SignIn(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By accTitle = By.xpath("//h1[@data-test-id=\"header-text\"]");
    private By domainList = By.xpath("//div[@class=\"ProvidersList\"]/div");
    private By nameAcc = By.xpath("//input[@name=\"username\"]");
    private By domain = By.xpath("//span[@data-test-id=\"domain-select-value:mail.ru\"]");
    private By errorClearName = By.xpath("//div[@data-test-id=\"error-footer-text\"]");
    private By passButton = By.xpath("//button[@data-test-id=\"next-button\"]");
    private By passField = By.xpath("//input[@name=\"password\"]");
    private By eyeButton = By.xpath("//div[@data-test-id=\"toggle-password-mask\"]");
    private By checkBoxRemember = By.xpath("//div[@class=\"box-0-2-111 activeBox-0-2-116\"]");
    private By vkButton = By.xpath("//button[@data-test-id=\"social-vk\"]");
    private By esiaButton = By.xpath("//button[@data-test-id=\"esia\"]");
    private By restore = By.xpath("//a[@data-test-id=\"remind\"]");
    private By createAcc = By.xpath("//a[@data-test-id=\"signup-link\"]");
    private By close = By.xpath("(//*[@class=\"base-0-2-23\"])[1]");

    //Метод получения текста заголовка формы входа
    public String signInTitleText(){
        clickSignIn();
        return driver.findElement(accTitle).getText();
    }
    //Метод выбора домена по номеру в списке
    public SignIn domainClick(int num){
        clickSignIn();
        List<WebElement> domainList = driver.findElements(this.domainList);
        domainList.get(num).click();
        return this;
    }
    //Метод ввода имени аккаунта в поле Имя аккаунта
    public SignIn nameAcc(String name){
        clickSignIn();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerText = '" + name + "';", driver.findElement(nameAcc));
        return this;
    }
    //Метод чтения выбранного домена
    public String readDomain(){
        clickSignIn();
        return driver.findElement(domain).getText();
    }
    //Метод получения текста ошибки, если поле "Имя аккаунта" пустое
    public String errorName(){
        clickSignIn();
        return driver.findElement(errorClearName).getText();
    }
    //Метод клика по кнопке "Ввести пароль"
    public SignIn clickPass(){
        clickSignIn();
        driver.findElement(passButton).click();
        return this;
    }
    //Метод ввода пароля в поле "Пароль"
    public SignIn passAcc(String pass){
        clickSignIn();
        this.clickPass();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerText = '" + pass + "';", driver.findElement(passField));
        return this;
    }
    //Метод клика по значку показа символов поля "Пароль"
    public String getTextPass(String pass){
        clickSignIn();
        this.clickPass();
        this.passAcc(pass);
        driver.findElement(eyeButton).click();
        return driver.findElement(passField).getText();//????
    }
}
