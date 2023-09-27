package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyNewMailPageCaptcha {
    private WebDriver driver;
    public MyNewMailPageCaptcha(WebDriver driver) {
        this.driver = driver;
    }

    private By titleText = By.xpath("//form[@class=\"vgHAw08-M1fiKiNUvFJiL\"]");
    private By titleText2 = By.xpath("//p[@class=\"base-0-2-6 base-0-2-6\"]");
    private By codeField = By.xpath("//input[@placeholder=\"Код\"]");
    private By notCodeButton= By.xpath("//a[@class=\"base-0-2-170\"]");
    private By nextButton= By.xpath("//button[@class=\"base-0-2-32 primary-0-2-46\"]");
    private By backButton= By.xpath("//button[@class=\"base-0-2-32\"]");
    private By imgCode= By.xpath("//img[@alt=\"Код\"]");
    private By registrationButton = By.xpath("//*[text()='Регистрация']");
    private By signInButton = By.xpath("//*[text()='Войти']");
    private By mainLogo = By.xpath("//img[@alt=\"Mail.ru\"]");

    
}
