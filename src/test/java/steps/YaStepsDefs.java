package steps;

import Pages.YaPage;
import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;



public class YaStepsDefs {

    WebDriver driver;
    YaPage yaPage;


    public YaStepsDefs(Hooks hooks)  {
        driver = hooks.StartDriver();
    }

    @Допустим("я захожу на сайт")
    public void язахожунасайт() {


        yaPage = new YaPage(driver);
//        yaPage.loadpage();
        yaPage.OpenSite();
    }
    @И("нажимаю кнопку Войти")
    public void нажимаюкнопкуВойти() {
        yaPage.Enter();
    }
    @Когда("я ввожу логин и неправильный пароль")
    public void яввожулогининеправильныйпароль() {
        yaPage.authorization();

    }




    @Тогда("я получаю сообщение об ошибке")
    public void япроверяюналичиессылки()
    {

        Assert.assertTrue(yaPage.CheckNeg());
    }


}