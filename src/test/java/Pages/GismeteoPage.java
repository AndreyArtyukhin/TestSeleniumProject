package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GismeteoPage extends PageObject {

@FindBy(xpath = "//a[text()='Сегодня']")
private WebElement DayToFind;

    @FindBy(xpath = "//input[@type=\"search\"]")
    private WebElement SearchField;

    @FindBy(xpath = "//div[@class='widget-row-chart widget-row-chart-temperature']/div/div/div[5]")
    private WebElement TemperatureOfTimeTwelve;

    @FindBy(xpath = "//div[@class=\"widget-row-chart widget-row-chart-temperature\"]/div/div/div[6]")
    private WebElement TemperatureOfTime15;

    public GismeteoPage(WebDriver driver){
        super(driver);
    }

    public void OpenSite(){
        driver.get("https://www.gismeteo.ru/");
    }
    public boolean CheckDay(String day)  {
        WebElement element= driver.findElement(By.xpath("//a[text()='"+day+"']" )) ;

        if (element.isDisplayed()  )
            return true;
            else return false;

        //String par= element.getAttribute("text");
        //System.out.println(par);
    }
public void waitForLoad(Long timetowait)  {
        try {
            Thread.sleep(timetowait);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
}
    public String GetTemperature(String time, String CurrentDay, String city) throws InterruptedException {
        String TemperatureOfTime=null;
        switch (time) {
            case  ("12"):
                waitForLoad(3000L);
                TemperatureOfTime=TemperatureOfTimeTwelve.getText();
                System.out.println("Температура воздуха " +city+" "+ CurrentDay+  " на 12 часов "+TemperatureOfTime+ " ");

                return TemperatureOfTime;
            case ("15"):
                waitForLoad(3000L);
                TemperatureOfTime=TemperatureOfTime15.getText();
                System.out.println("Температура воздуха " +city+" "+ CurrentDay+  " на 15 часов "+TemperatureOfTime);

                return TemperatureOfTime;

            default:
                System.out.println("Время не найдено");
                return null;
        }

    }
    public void OpenCity(String city){
        SearchField.sendKeys(city);
        SearchField.sendKeys(Keys.RETURN);
        waitForLoad(3000L);
        WebElement element= driver.findElement(By.xpath("//div[text()='"+city+"']" ));

        element.click();
    }
    public void OpenDay(String day) {
        waitForLoad(3000L);
        WebElement element= driver.findElement(By.xpath("//*[text()='"+day+"']" ));

        element.click();
    //    DayToFind.click();
    }
}
