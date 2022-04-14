package steps;

import cucumber.api.java.ru.Допустим;
import Pages.GismeteoPage;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class GismeteoStepsDefs {
private static String CurrentDay=null;
    private static String CurrentCity=null;
    WebDriver driver;
    GismeteoPage gismeteopage;

    public GismeteoStepsDefs(Hooks hooks) throws IOException {
        driver = hooks.StartDriver();
    }

    @Допустим("переход")
    public void переход() {

        // GismeteoPage gismeteoPage = new GismeteoPage(driver);
        gismeteopage = new GismeteoPage(driver);
//        gismeteopage = initPage.loadpage();

        gismeteopage.loadpage();
        gismeteopage.OpenSite();
    }

    @Допустим("я захожу на сайт Гисметео")
    public void яЗахожуНаСайтГисметео() {

        переход();
    }

    @И("открываю прогноз погоды на {string}")
    public void открываюпрогнозпогодына(String day) {
        CurrentDay=day;
        переход();
        gismeteopage.OpenDay(day);
    }

    @И("открываю прогноз погоды в {string} на {string}")
    public void открываюпрогнозпогодывгородена(String city, String day) {
        CurrentCity=city;
        CurrentDay=day;
        переход();
        gismeteopage.OpenCity(city);
        gismeteopage.OpenDay(day);
    }

    @Тогда("я проверяю наличие прогноза температуры на {string}")
    public void япроверяюналичиепрогнозатемпературына(String time) throws InterruptedException {
       // gismeteopage.GetTemperature(time);
        Assert.assertNotNull(gismeteopage.GetTemperature(time, CurrentDay,CurrentCity));
//        Assert.assertTrue(gismeteopage.CheckDay(time));
    }

    @Тогда("я проверяю наличие ссылки {string}")
    public void япроверяюналичиессылки(String day) {
        Assert.assertTrue(gismeteopage.CheckDay(day));
    }


}