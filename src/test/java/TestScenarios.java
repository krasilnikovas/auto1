/**
 * Created by Krasilnikov on 18.07.2017.
 */
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestScenarios {

    @BeforeClass
    public static void beforeClass(){
        System.setProperty("selenide.browser", "chrome");
        ChromeDriverManager.getInstance().setup();
    }
    @Test
    public void filteringBMW (){
        Selenide.open("https://www.auto1.com/en/our-cars");


    }

}
