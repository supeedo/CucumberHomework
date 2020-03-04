package ru.yandex.test;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver chromeDriver;

    @Step
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/ChesenFew/Documents/MyIdeaProject/CucumberHomework/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Step
    public void closeChrome(){
        chromeDriver.quit();
    }
}
