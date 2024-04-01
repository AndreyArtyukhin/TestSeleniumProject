package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public abstract class PageObject  {
    protected WebDriver driver;
    public PageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

//    public GismeteoPage loadpage(){
//        return new GismeteoPage(driver);
//    }
}
