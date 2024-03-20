import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class RelatedActions {

    public String readFile(int row, int column) throws Exception {
        File src = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");
        FileInputStream testData = new FileInputStream(src);
        XSSFWorkbook x = new XSSFWorkbook(testData);
        XSSFSheet sheet = x.getSheetAt(0);
        String testDataInput = sheet.getRow(row).getCell(column).getStringCellValue();
        return testDataInput;
    }
    public void action(WebElement pageNumber){
        pageNumber.sendKeys(Keys.PAGE_DOWN);
        pageNumber.click();

    }

    public List<WebElement> results(WebDriver driver){
        By results = By.className("tpcn");
        List<WebElement> pageResults = driver.findElements(results);
        return pageResults;
    }

    public WebElement pageNumber(WebDriver driver, int page){
        By Page = By.xpath("//a[text()=" + page + "]");
        WebElement PageElement = driver.findElement(Page);
        return PageElement;
    }

    public void screenShots(WebDriver driver, String browser) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File(".//Screen_shots//"+browser+" Test.jpg"));
    }
}
