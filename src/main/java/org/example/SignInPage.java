package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SignInPage {
    WebDriver driver;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        //driver.get("https://account.mail.ru/login/?mode=simple&v=2.10.0&account_host=account.mail.ru&type=login&allow_external=1&app_id_mytracker=58519&success_redirect=https%3A%2F%2Fe.mail.ru%2Fmessages%2Finbox%3Fback%3D1&project=home&source=mailbox&from=navi&parent_url=https%3A%2F%2Fmail.ru%2F&responsive=compact\"");
    }


    private By accTitle = By.xpath("//h1[@data-test-id=\"header-text\"]");
    private By domainList = By.xpath("//div[@class=\"ProvidersList\"]/div");
    private By nameAcc = By.xpath("//input[@name=\"username\"]");
    private By domain = By.xpath("//span[@data-test-id=\"domain-select-value\"]");
    private By errorClearName = By.xpath("//div[@data-test-id=\"error-footer-text\"]");
    private By passButton = By.xpath("//span[text()='Ввести пароль']");
    private By passField = By.xpath("//input[@name=\"password\"]");
    private By eyeButton = By.xpath("//div[@data-test-id=\"toggle-password-mask\"]");
    private By checkBoxRemember = By.xpath("//div[@class=\"submit-right-block\"]/div");
    private By vkButton = By.xpath("//button[@data-test-id=\"social-vk\"]");
    private By esiaButton = By.xpath("//button[@data-test-id=\"esia\"]");
    private By restore = By.xpath("//a[@data-test-id=\"remind\"]");
    private By createAcc = By.xpath("//a[@data-test-id=\"signup-link\"]");
    private By close = By.xpath("(//*[@class=\"base-0-2-23\"])[1]");

    //Метод получения текста заголовка формы входа
    public String signInTitleText(){
        return driver.findElement(accTitle).getText();
    }
    //Метод выбора домена по номеру в списке
    public SignInPage domainClick(int num){
        List<WebElement> domainList = driver.findElements(this.domainList);
        if(num <= domainList.size())
            domainList.get(num - 1).click();
        return this;
    }
    //Метод ввода имени аккаунта в поле Имя аккаунта
    public SignInPage nameAcc(String name){
        driver.findElement(nameAcc).sendKeys(name);
        return this;
    }
    //Метод чтения выбранного домена
    public String readDomain(){
        if(driver.findElement(domain).isDisplayed())
            return driver.findElement(domain).getText();
        else return "Выбран способ ввода другого домена";
    }
    //Метод получения текста ошибки, если поле "Имя аккаунта" пустое
    public String errorName(){
        return driver.findElement(errorClearName).getText();
    }
    //Метод клика по кнопке "Ввести пароль"
    public SignInPage clickPass(){
        driver.findElement(passButton).click();
        return this;
    }
    //Метод ввода пароля в поле "Пароль"
    public SignInPage passAcc(String name, String pass){
        this.nameAcc(name);
        this.clickPass();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passField));
        driver.findElement(passField).sendKeys(pass);
        return this;
    }
    //Метод клика по значку показа символов поля "Пароль"
    public Boolean getTextPass(String name, String pass){
        this.passAcc(name, pass);
        driver.findElement(eyeButton).click();
        return driver.findElement(passField).getAttribute("type").equals("text");//проверка на показ символов(в дальнейшем убрать)
    }
    //Метод включения чек-бокса "Запомнить"
    public Boolean rememberPass(String name){
        this.nameAcc(name);
        this.clickPass();
        //Если бокс отключен, то кликаем по нему
        if(driver.findElement(checkBoxRemember).getAttribute("data-checked").equals("false"))
            driver.findElement(checkBoxRemember).click();
        return driver.findElement(checkBoxRemember).getAttribute("data-checked").equals("true");//вернул boolean значения чек-бокса(в дальнейшем убрать)
    }
    //Метод клика "Восстановить доступ"
    public RestorePage clickRestore(){
        driver.findElement(restore).click();
        return new RestorePage(driver);
    }
    //Метод клика по "Создать аккаунт"
    public CreateMailPage clickCreateMail() {
        driver.findElement(createAcc).click();
        return new CreateMailPage(driver);
    }

}
