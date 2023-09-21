package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By nameField = By.xpath("//input[@name=\"fname\"]");
    By surnameField = By.xpath("//input[@name=\"lname\"]");
    By dayDate = By.xpath("(//div[@class=\"Select__control css-0\"])[1]");
    By monthDate = By.xpath("(//div[@class=\"Select__control css-0\"])[2]");
    By yearDate = By.xpath("(//div[@class=\"Select__control css-0\"])[3]");
    By radioButtonMale = By.xpath("(//div[@class=\"border-0-2-148\"])[1]");
    By radioButtonFemale = By.xpath("(//div[@class=\"border-0-2-148\"])[2]");
    By usernameBoxField = By.xpath("//input[@name=\"username\"]");
    By domainList = By.xpath("(//div[@class=\"Select__control css-0\"])[4]");
    By passField = By.xpath("//input[@name=\"password\"]");
    By generationPassButton = By.xpath("(//a[@tabindex=\"0\"])[1]");
    By countryList = By.xpath("(//div[@class=\"Select__control css-0\"])[5]");
    By telephoneNumberField = By.xpath("//input[@name=\"lname\"]");
    By reservMail = By.xpath("(//a[@tabindex=\"0\"])[2]");
    By createButton = By.xpath("(//*[text()='Создать'])[2]");
    By kidsMail = By.xpath("//div[@class=\"_2F1k-ReGugy8-wThA3uvT-\"]");
}
