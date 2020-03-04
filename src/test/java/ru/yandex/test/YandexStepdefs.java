package ru.yandex.test;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YandexStepdefs extends Steps {

    @Given("Открыть Браузер")
    public void открытьБраузер() {
        openChrome();
    }

    @Then("Перейти на сайт '(.*)'")
    public void перейтиНаСайт( String site ){
        chromeDriver.get(site);
    }

    @Then("Ввести в строку поиска слово '(.*)', нажать на кнопку Поиск")
    public void ввестиВСтрокуПоискаСловоНажатьНаКнопкуПоиск( String word ) {
       WebElement searchField = chromeDriver.findElement(By.xpath("//*[@id=\"text\"]"));
       // //*[@id="text"]
        WebElement searchButton = chromeDriver.findElement(By.xpath("//div[@class='search2__button']"));
        // //div[@class='search2__button']

        searchField.click();
        searchField.sendKeys(word);
        searchButton.click();

    }

    @Then("В выборке есть ссылка на '(.*)'")
    public void вВыборкеЕстьСсылкаНаRuWikipediaOrg(String wiki) {
        List<WebElement>   listOfWebElement = chromeDriver.findElements(By.xpath("//a[contains(@class,'link')]//b"));
        // //a[contains(@class,'link')]//b
        boolean check = false;
        for (WebElement wb : listOfWebElement) {
            if (wb.getText().contains(wiki)) {
                check = true;
            }
        }
        Assert.assertTrue(check);
    }

    @Then("Закрыть браузер")
    public void закрытьБраузер() {
        closeChrome();
    }

}
