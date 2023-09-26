package org.example;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class Main {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://account.mail.ru/signup?from=navi&lang=ru_RU&siteid=169&app_id_mytracker=58519");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"Select__control css-0\"])[1]")));
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.createCorrectMail("Ник", "Кипиш", "13", "Май", "1994", 'm', "nub14131516", "mail", "Q1w2e3r4t5y6", "nek@mail.ru");

    }
}