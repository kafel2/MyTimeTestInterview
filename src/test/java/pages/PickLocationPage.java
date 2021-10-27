package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestUtils;

public class PickLocationPage extends TestUtils {

    public PickLocationPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='my-input']")
    public WebElement searchBar;

    @FindBy(linkText = "123 Somewhere")
    public WebElement searchResult;
}
