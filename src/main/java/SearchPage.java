import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    public WebElement SearchInput(WebDriver driver){
        By searchinput = By.id("sb_form_q");
        WebElement searchInputElement = driver.findElement(searchinput);
        return searchInputElement;
    }

    public void SearchText(WebDriver driver, String text){
        SearchInput(driver).sendKeys(text);
    }

    public WebElement SearchIcon(WebDriver driver){
        By searchIcon = By.id("search_icon");
        WebElement searchIconElement = driver.findElement(searchIcon);
        return searchIconElement;
    }

    public void clickSearchIcon(WebDriver driver){
        SearchIcon(driver).click();
    }


}
