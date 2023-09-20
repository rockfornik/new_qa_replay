package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

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
    private By regesstrationButton = By.xpath("//*[text()='Регистрация']");
    private By signInButton = By.xpath("(//*[text()='Войти'])[1]");
    private By settingsButton = By.xpath("//div[@class=\"ph-settings svelte-1ke9xx5\"]");
    private By signInButton2 = By.xpath("(//*[text()='Войти'])[2]");
    private By createMail = By.xpath("//*[text()='Создать почту']");
    private By searchField = By.xpath("//div[@class=\"search-arrow__border-inset mffeadi__1ljar7y\"]]");
    private By searchButton = By.xpath("//button[@class=\"search-arrow__button mffeadi__1ljar7y\"]");

    //Методы работы с элементами
    public void clickMainLogo(){
        driver.findElement(mainLogo).click();
    }

    public void clickRegButton(){
        driver.findElement(regesstrationButton).click();
    }

    public void clickSignIn(){
        driver.findElement(signInButton).click();
    }

    public void clickSettings(){
        driver.findElement(settingsButton).click();
    }

    public void clickSignIn2(){
        driver.findElement(signInButton2).click();
    }

    public void clickCreateMail(){
        driver.findElement(createMail).click();
    }

    public void clickSearch(){
        driver.findElement(searchButton).click();
    }

    public void enterSearch(String searchText){
        driver.findElement(searchField).sendKeys(searchText);
    }
}
