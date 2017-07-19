import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;


public class TestScenarios {

    @BeforeClass
    public static void beforeClass(){
        System.setProperty("selenide.browser", "chrome");
        ChromeDriverManager.getInstance().setup();
    }
    @Test
    public void filteringBMW (){
        //Open https://auto1.com/en/our-cars
        Selenide.open("https://www.auto1.com/en/our-cars");
        //Filter by manufacture by clicking checkbox(BMW)
        $(byXpath("//span[contains(text(),'BMW')]")).click();
        //Verify filter was selected
        $(byXpath("//span[contains(text(),'BMW')]//parent::li")).shouldHave(attribute("class", "checked"));
        $("div.loading-ticker").isDisplayed();
        $("div.loading-ticker").waitUntil(disappears,60000);
        $$(".select2-selection__rendered .select2-selection__choice").shouldHaveSize(1);
        $(byXpath("//li[@class='select2-selection__choice']")).shouldHave(attribute("title", "BMW"));
        //Verify all cars are BMW’s on the page
        FiltersHelper.verifyCarsFilteredBySingleCarBrand("BMW");
        //Verify each car has picture
        FiltersHelper.verifyAllCarsInTheListHavePicture();
        //Verify each car has complete information (Mileage, Registration is not empty etc.)
        FiltersHelper.verifyAllCarsInTheListHaveCompleteInformation();

    }

}
