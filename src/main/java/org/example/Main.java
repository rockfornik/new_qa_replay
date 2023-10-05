package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://account.mail.ru/login/?mode=simple&v=2.10.0&account_host=account.mail.ru&type=login&allow_external=1&app_id_mytracker=58519&success_redirect=https%3A%2F%2Fe.mail.ru%2Fmessages%2Finbox%3Fback%3D1&project=home&source=mailbox&from=navi&parent_url=https%3A%2F%2Fmail.ru%2F&responsive=compact");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        SignInPage signIn = new SignInPage(driver);
        System.out.println(signIn.rememberPass("kolobok"));


        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.pause(3000);

        driver.quit();
    }
}