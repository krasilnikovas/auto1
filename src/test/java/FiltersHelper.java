import com.codeborne.selenide.ElementsCollection;
import org.junit.Assert;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class FiltersHelper {

    public static void verifyCarsFilteredBySingleCarBrand(String carBrand) {
        ElementsCollection totalCarsCount = $$("#car-list .car-item");
        ElementsCollection specificBrandCar = $$(byXpath("//ul[@id='car-list']//div[@class='car-name' and contains(text(),'" + carBrand + "')]"));
        Assert.assertEquals(totalCarsCount.size(), specificBrandCar.size());
    }

    public static void verifyAllCarsInTheListHavePicture() {
        ElementsCollection pictures = $$("#car-list .car-img img");
        pictures.forEach(picture -> Assert.assertTrue("Picture " + picture.getAttribute("src") + " is not visible", picture.isImage()));
    }

    public static void verifyAllCarsInTheListHaveCompleteInformation() {
        ElementsCollection tables = $$(".car-info table");
        tables.forEach(table -> table.$$("tr").forEach(tr -> {
            ElementsCollection td = tr.$$("td");
            String val = td.get(1).text();
            Assert.assertNotEquals(tr.text(), val, "");
        }));
    }

}
