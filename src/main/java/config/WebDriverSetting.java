package config;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSetting {
    public WebDriver chromeDriver;

    @Before
    public void открытьХром(){
        System.out.println("Before");
        System.setProperty("webdriver.chrome.driver", "/Users/ChesenFew/Documents/MyIdeaProject/CucumberHomework/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void закрытьХром(){
        System.out.println("After");
        chromeDriver.quit();
    }
}
