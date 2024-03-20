import org.openqa.selenium.WebDriver;

public class ThirdPage {
    public int PageThreeResults(WebDriver driver){
        RelatedActions relatedActions = new RelatedActions();
        return relatedActions.results(driver).size();
    }
}
