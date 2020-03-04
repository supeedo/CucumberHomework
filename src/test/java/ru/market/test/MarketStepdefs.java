package ru.market.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MarketStepdefs extends Steps {

    @Given("2 Запустить Chrome")
    public void запуститьChrome() {
        openChrome();
    }

    @Then("2 Открыть '(.*)'")
    public void открытьЯндексМаркет( String site ) {
        chromeDriver.get(site);
    }

    @Then("2 Перейти в раздел мобильные телефоны")
    public void перейтиВРазделМобильныеТелефоны() {
        WebElement electronic = chromeDriver.findElement(By.xpath("//a[@href='/catalog--elektronika/54440']//span[1]"));
        // //div[@class='_3Lwc_UVFq4']   раздел меню "Электроника"
        electronic.click();
        WebElement mobilePhone = chromeDriver.findElement(By.xpath("(//a[contains(@class,'_2qvOOvezty _2x2zBaVN-3')])[1]"));
        // (//a[contains(@class,'_2qvOOvezty _2x2zBaVN-3')])[1]  Раздел меню "Мобильные телефоны"
        mobilePhone.click();
    }

    @Then("2 Установить фильтр по производителю Apple")
    public void установитьФильтрПоПроизводителюApple() {
        WebElement appleManufactured = chromeDriver.findElement(By.xpath("(//div[@class='LhMupC0dLR'])[1]"));
        //(//div[@class='LhMupC0dLR'])[1]  флаг фильтра "Apple'
        appleManufactured.click();
    }

    @Then("2 Убедиться, что в полученной выборке телефоны '(.*)'")
    public void убедитьсяЧтоВПолученнойВыборкеТелефоныApple(String manufacture) {
        while (true) {
            try {
                new WebDriverWait(chromeDriver, 3).until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//a[contains(@class,'button button_size_m')]"))).click();
            } catch (TimeoutException e) {
                break;
            }
        }
        List<String>stringList = new ArrayList<>();
        List<WebElement> tempList = chromeDriver.findElements(By.xpath("//div[@class='n-snippet-cell2__brand-name']"));
        if (tempList.size() > 0) {
            for (int i = 0; i < tempList.size(); i++) {
                String temp = tempList.get(i).getText();
                stringList.add(temp);
            }
        }
        boolean flag = true;
        for (int i = 0; i < stringList.size(); i++) {
                if (!stringList.get(i).equals(manufacture)) {
                    break;
                }
        }
        Assert.assertTrue(flag);
    }

    @Then("2 Закрыть Chrome")
    public void закрытьChrome() {
        closeChrome();
    }
}
