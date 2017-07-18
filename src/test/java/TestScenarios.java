/**
 * Created by Krasilnikov on 18.07.2017.
 */
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.sleep;


public class TestScenarios {

    @BeforeClass
    public static void beforeClass(){
        System.setProperty("selenide.browser", "chrome");
        ChromeDriverManager.getInstance().setup();
    }
    @Test
    public void filteringBMW (){
        Selenide.open("https://www.auto1.com/en/our-cars");
        $(byXpath("//span[contains(text(),'BMW')]")).click();
        $(byXpath("//span[contains(text(),'BMW')]//parent::li")).shouldHave(attribute("class", "checked"));
        $("div.loading-ticker").isDisplayed();
        $("div.loading-ticker").waitUntil(disappears,60000);
        $(byXpath("//ul[@class='select2-selection__rendered']")).findAll(By.xpath("//li[@class='select2-selection__choice']")).shouldHaveSize(1);
        $(byXpath("//li[@class='select2-selection__choice']")).shouldHave(attribute("title", "BMW"));
        FiltersHelper.verifyCarsFilteredBySingleCarBrand("BMW");
     //   FiltersHelper.verifyAllCarsInTheListHavePicture();
        FiltersHelper.verifyAllCarsInTheListHaveCompleteInformation();


        sleep(123);
    }

}
