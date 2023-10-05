package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By mainLogo = By.xpath("//a[@href=\"//mail.ru\"]");
    private By nameField = By.xpath("//input[@name=\"fname\"]");
    private By surnameField = By.xpath("//input[@name=\"lname\"]");
    private By radioButtonMale = By.xpath("(//div[@class=\"border-0-2-148\"])[1]");
    private By radioButtonFemale = By.xpath("(//div[@class=\"border-0-2-148\"])[2]");
    private By usernameBoxField = By.xpath("//input[@name=\"username\"]");
    private By domainList = By.xpath("(//div[@class=\"Select__control css-0\"])[4]");
    private By passField = By.xpath("//input[@name=\"password\"]");
    private By generationPass = By.xpath("(//a[@tabindex=\"0\"])[1]");
    private By telephoneNumberField = By.xpath("//input[@type=\"tel\"]");
    private By reservMail = By.xpath("//a[text() = 'Указать резервную почту']");
    private By reservMailText = By.xpath("//*[text() = 'Резервная почта']");
    private By reservMailField = By.xpath("//input[@name=\"email\"]");
    private By createButton = By.xpath("(//*[text()='Создать'])[2]");
    private By kidsMail = By.xpath("//div[@class=\"_2F1k-ReGugy8-wThA3uvT-\"]");
    private By spanDay = By.xpath("//span[text()='День']");
    private By spanDay2 = By.xpath("//span[text()='1']");
    private By spanMonth = By.xpath("//span[text()='Месяц']");
    private By spanMonth2 = By.xpath("//span[text()='Январь']");
    private By spanYear = By.xpath("//span[text()='Год']");
    private By spanYear2 = By.xpath("//span[text()='2023']");
    private By error = By.xpath("//small[@class=\"base-0-2-6 small-0-2-15 error-0-2-21\"]"
    );

    //Метод клика по логотипу mail.ru
    public MainPage clickMainLogo(){
        driver.findElement(mainLogo).click();
        return new MainPage(driver);
    }
    //Метод заполнения поля "Имя"
    public RegistrationPage nameText(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    //Метод заполнения поля "Фамилия"
    public RegistrationPage surnameText(String surname){
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }
    //Метод выбора дня рождения
    public RegistrationPage dayDates(String numberDay){
        Actions actions = new Actions(driver);
        driver.findElement(spanDay).click();
        actions.sendKeys(Keys.ENTER).perform();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].innerText = '" + numberDay + "';", driver.findElement(spanDay2));
        return this;
    }
    //Метод выбора месяца рождения
    public RegistrationPage monthDates(String month){
        Actions action = new Actions(driver);
        driver.findElement(spanMonth).click();
        action.sendKeys(Keys.ENTER).perform();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].innerText = '" + month + "';", driver.findElement(spanMonth2));
        return this;
    }
    //Метод выбора года рождения
    public RegistrationPage yearDates(String year){
        Actions actions = new Actions(driver);
        driver.findElement(spanYear).click();
        actions.sendKeys(Keys.ENTER).perform();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].innerText = '" + year + "';", driver.findElement(spanYear2));
        return this;
    }
    //Метод выбора пола(1 - мужской, 2 - женский)
    public RegistrationPage clickMale(char male){
        if(male == 'm' || male == 'M')
            driver.findElement(radioButtonMale).click();
        else if(male == 'f' || male == 'F')
            driver.findElement(radioButtonFemale).click();
        return this;
    }
    //Метод заполнения поля "Имя ящика"
    public RegistrationPage nameMail(String mailName){
        driver.findElement(usernameBoxField).sendKeys(mailName);
        return this;
    }
    //Метод выбора домена
    public RegistrationPage domain(String domain){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].innerText = '@" + domain + ".ru';", driver.findElement(domainList));
        return this;
    }
    //Метод заполнения поля "Пароль"
    public RegistrationPage passMail(String pass){
        driver.findElement(passField).sendKeys(pass);
        return this;
    }
    //Метод клика по кнопке "Сгенерировать надежный пароль"
    public RegistrationPage generationPass(){
        driver.findElement(generationPass).click();
        return this;
    }
    //Метод заполнения номера телефона
    public RegistrationPage telNumber(String num){
        driver.findElement(telephoneNumberField).sendKeys(num);
        return this;
    }
    //Метод клика по "Указать резервную почту" и заполнение резервной почты
    public RegistrationPage reservEMail(String email){
        driver.findElement(reservMail).click();
        driver.findElement(reservMail).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(reservMailText)));
        driver.findElement(reservMailField).sendKeys(email);
        return this;
    }
    //Метод клика по кнопке "Создать" с корректными данными
    public MyNewMailPageCaptcha clickCreate(){
        driver.findElement(createButton).click();
        return new MyNewMailPageCaptcha(driver);
    }
    //Метод клика по кнопке "Создать" с некорректными данными
    public RegistrationPage incorrectClickCreate(){
        driver.findElement(createButton).click();
        return this;
    }
    //Метод получения ошибки при вводе некорректных данных(последовательно)
    public String getError(){
        List<WebElement> errorList = driver.findElements(error);
        int i = 0;
        while (i <= errorList.size()) {
            if (i < errorList.size()) {
                return errorList.get(i).getText();
            }
            i++;
        }
        return "Ошибок не найдено";
    }
    //Метод паузы
    public void pause(int mls){
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Метод заполнения всех полей и клика по кнопке "Создать"
    //String name - Имя, String surname - Фамилия, int numberDay - день рождения, String month - Месяц рождения,
    // String year - год рождения, char male - пол(m-мужской, f-женский), String mailName - имя ящика, String domain - домен(mail.ru),
    // String pass - пароль, String email - дополнительный ящик.
    public MyNewMailPageCaptcha createCorrectMail(String name, String surname, String numberDay, String month, String year, char male, String mailName, String domain, String pass, String email){
        this.nameText(name);
        this.surnameText(surname);
        this.dayDates(numberDay);
        this.monthDates(month);
        this.yearDates(year);
        this.clickMale(male);
        this.nameMail(mailName);
        this.domain(domain);
        this.passMail(pass);
        this.generationPass();
        this.reservEMail(email);
        pause(2000);
        this.clickCreate();
        return new MyNewMailPageCaptcha(driver);
    }
}
