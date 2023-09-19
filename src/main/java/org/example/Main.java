package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Main {

    static WebDriver driver;
    public static void main(String[] args) {

        System.setProperty("webdriver.chromedriver.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://mail.ru");
        wait("(//*[text()='Войти'])[2]");
        String buttonLogIn = driver.findElement(By.xpath("//*[text()='Войти'])[2]")).getCssValue("display");
        System.out.println(buttonLogIn);

    }

    public static void wait(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}