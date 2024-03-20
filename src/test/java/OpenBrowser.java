import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class OpenBrowser extends SetUp{
    SecondPage secondPage = new SecondPage();
    ThirdPage thirdPage = new ThirdPage();
    RelatedActions relatedActions = new RelatedActions();
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void ValidScenario() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        relatedActions.action(relatedActions.pageNumber(driver,2));
        softAssert.assertEquals(secondPage.PageTwoResults(driver), 10);

        try {
            wait.until(ExpectedConditions.visibilityOf(relatedActions.pageNumber(driver, 3)));
        }catch (StaleElementReferenceException e){}

        softAssert.assertEquals(relatedActions.pageNumber(driver,2).getCssValue("border-color"), "rgb(23, 74, 228)");
        relatedActions.action(relatedActions.pageNumber(driver, 3));
        softAssert.assertEquals(thirdPage.PageThreeResults(driver), 10);
        softAssert.assertEquals(relatedActions.pageNumber(driver,3).getCssValue("border-color"), "rgb(23, 74, 228)");
        softAssert.assertEquals(secondPage.PageTwoResults(driver), thirdPage.PageThreeResults(driver));
        softAssert.assertAll();
    }

}
