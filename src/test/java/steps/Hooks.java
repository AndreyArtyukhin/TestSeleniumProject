package steps;
import static Pages.MyConstants.CURRENT_TIME_DATE;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Hooks {
    WebDriver driver = null;
    @Before
    public WebDriver StartDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Soft\\chromedriver_win32\\chromedriver100.exe");
        ChromeOptions options = new ChromeOptions();
        if (driver==null){
             driver=new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    @After
    public void AfterSteps(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("target/screenshots/" + scenario.getName() + "/" + CURRENT_TIME_DATE + ".png"));
//                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                Allure.addAttachment("Screenshot", FileUtils.openInputStream(scrFile));
//                scenario.embed(screenshot, "image/png");
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
//                scenario.attach(screenshot, "image/png", scenario.getName());

            } catch (Exception e) {
                System.out.println("event:Не удалось сохранить скриншот" + e);
            }
        }


//        driver.close(); закрывает окно, но не сервисы и ресурсы
        driver.quit();

        driver = null;
    }
}
