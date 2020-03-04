package ru.open.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenBankStepdefs extends Steps {


    @Given("1 Открыть Браузер")
    public void открытьБраузер() {
        openChrome();
    }

    @Then("1 Перейти на сайт '(.*)'")
    public void перейтиНаСайтыHttpsWwwGoogleCom(String site) {
        chromeDriver.get(site);
    }

    @Then("1 Написать в строке поиска '(.*)', нажать на кнопку поиска")
    public void написатьВСтрокеПоискаОткрытиеНажатьНаКнопкуПоиска(String word) {
        WebElement searchField = chromeDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        // //input[@class='gLFyf gsfi']
        WebElement searchButton = chromeDriver.findElement(By.xpath("(//input[@name='btnK'])"));
        //  (//input[@name='btnK'])[2]

        searchField.click();
        searchField.sendKeys(word);
        searchButton.click();
    }

    @Then("1 Проверить, что результатах поиска есть '(.*)'")
    public void проверитьЧтоРезультатахПоискаЕстьHttpsWwwOpenRu(String site) {
        List<WebElement> listOfWebelement = chromeDriver.findElements(By.xpath("//cite[contains(@class,'iUh30')]"));
        // (//cite[contains(@class,'iUh30')])
        boolean flag = false;
        for (WebElement wb : listOfWebelement) {
            if (wb.getText().contains(site)) {
               flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @Then("1 Перейти на '(.*)'")
    public void перейтиНаHttpsWwwOpenRu(String site) {
        chromeDriver.get(site);
    }

    @Then("1 Проверить в блоке «Курс обмена в интернет-банке», что курс продажи больше курса покупки, для USD и для EUR")
    public void проверитьВБлокеКурсОбменаВИнтернетБанкеЧтоКурсПродажиБольшеКурсаПокупкиДляUSDИДляEUR() {
        WebElement dollarPurchanseTemp = chromeDriver.findElement(By.xpath("(//span[@class='main-page-exchange__rate'])[1]"));
        // (//span[@class='main-page-exchange__rate'])[1]
        Double dollarPurchanse = Double.parseDouble(dollarPurchanseTemp.getText().replace(',','.'));

        WebElement dollarSaleTemp = chromeDriver.findElement(By.xpath("(//span[@class='main-page-exchange__rate'])[2]"));
        // (//span[@class='main-page-exchange__rate'])[2]
        Double dollarSale = Double.parseDouble(dollarSaleTemp.getText().replace(',','.'));

        WebElement euroPurchanseTemp = chromeDriver.findElement(By.xpath("(//span[@class='main-page-exchange__rate'])[3]"));
        // (//span[@class='main-page-exchange__rate'])[3]
        Double euroPurchanse = Double.parseDouble(euroPurchanseTemp.getText().replace(',','.'));

        WebElement euroSaleTemp = chromeDriver.findElement(By.xpath("(//span[@class='main-page-exchange__rate'])[4] "));
        // (//span[@class='main-page-exchange__rate'])[4]
        Double euroSale = Double.parseDouble(euroSaleTemp.getText().replace(',','.'));

        Boolean check = false;
        if (dollarPurchanse < dollarSale
                && euroPurchanse < euroSale) {
            check = true;
        }
        Assert.assertTrue(check);
    }

    @Then("1 Закрыть браузер")
    public void закрытьБраузеры() {
        closeChrome();
    }




}
