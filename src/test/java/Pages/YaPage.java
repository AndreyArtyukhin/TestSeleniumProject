package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class YaPage extends PageObject {

    @FindBy(xpath = "//*[text()='Войти']")
    private WebElement Enter;

@FindBy(xpath = "//*/span[text()='Продолжить']/..")
private WebElement Continue;
    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement InputField;
    @FindBy(xpath = "//*[@id='passp-field-passwd']")
    private WebElement InputPass;

    @FindBy(xpath = "//div[contains(.,'Неверный пароль')]")
    private WebElement ErrorMess;
    @FindBy(xpath = "//button[@id=\"passp:sign-in\"]")
    private WebElement ButtonSubmit;
    public void waitForLoad(Long timetowait) {
        try {
            Thread.sleep(timetowait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public YaPage(WebDriver driver) {
        super(driver);
    }

    public void OpenSite() {
        driver.get("https://ya.ru/");
        waitForLoad(3000L);
        driver.manage().deleteAllCookies();

    }

    public void Enter() {

        Enter.click();
        waitForLoad(1000L);

    }

    public void submit() {

        ButtonSubmit.click();
        waitForLoad(1000L);

    }
    public void authorization() {

        InputField.sendKeys("abcd");
        submit();
        waitForLoad(1000L);
        InputPass.clear();
        InputPass.sendKeys("pass");
        waitForLoad(1000L);
        Continue.click();

    }

    public boolean CheckNeg() {
        try {
//            driver.findElement(By.xpath("//div[contains(.,'Неверный пароль')]")).isDisplayed();
            ErrorMess.isDisplayed();
            return true;
//            Assert.assertTrue(true);

        } catch (Throwable t) {
            return false;
//            Assert.fail();
        }
    }
}