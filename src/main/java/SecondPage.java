import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondPage {
    public int PageTwoResults(WebDriver driver){
       RelatedActions relatedActions = new RelatedActions();
        return relatedActions.results(driver).size();
    }



}
