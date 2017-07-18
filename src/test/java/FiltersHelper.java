import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FiltersHelper {

    public static void verifyCarsFilteredBySingleCarBrand (String carBrand){
        Assert.assertEquals(countListOfAllCarsInTheResultOfFiltering(),countListOfFilteredCarsByBrand(carBrand));
    }

    public static int countListOfAllCarsInTheResultOfFiltering (){
        List<SelenideElement> totalCarsCount = $(byXpath("//ul[@id='car-list']")).findAll(byXpath("//li[@class = 'car-item']"));
        return totalCarsCount.size();
    }

    public static int countListOfFilteredCarsByBrand (String carBrand){
        List<SelenideElement> countBrandCars = $(byXpath("//ul[@id='car-list']")).findAll(byXpath("//div[@class = 'car-name' and contains(text(),'" + carBrand + "')]"));
        return countBrandCars.size();
    }

    public static void verifyAllCarsInTheListHavePicture (){
        List<SelenideElement> pictures = $(byXpath("//ul[@id='car-list']")).findAll(byXpath("//div[@class = 'car-img']//img"));
        for (SelenideElement selenideElement : pictures) {
            Assert.assertTrue("Picture "+ selenideElement.getAttribute("src") +" is not visible", $(selenideElement).isImage());
        }
    }

    public static void verifyAllCarsInTheListHaveCompleteInformation() {
        List<SelenideElement> information = $(byXpath("//ul[@id='car-list']")).findAll(byXpath("//div[@class='car-info']//table"));
        HashMap<String,String> carParameters = new HashMap();
        carParameters.put("asdasd", null);

//        for (int i = 0; i < information.size(); i++) {
//            List<SelenideElement> informationForOneCar = information.get(i).findAll("tr");
//            for (int j = 0; j < informationForOneCar.size(); j++) {
//                carParameters.put(informationForOneCar.get(j).find("td",0).getText(),informationForOneCar.get(j).find("td",1).getText());
//            }
//        }
//
//        System.out.println(Arrays.asList(carParameters));
//        System.out.println("");
    }

}
