package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestUtils;

import java.util.List;

public class AppointmentPage extends TestUtils {

    public AppointmentPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='themed-component themed-component--color']")
    public WebElement leftHeaderLocation;

    @FindBy(xpath = "//section[@class='service']/fieldset/label[4]")
    public WebElement serviceLeftMenu;

    @FindBy(xpath = "//section[@class='staff-member']/fieldset/label[13]")
    public WebElement staffMemberLeftMenu;

    @FindBy(xpath = "//*[@id='react-select-8--value']/div[1]")
    public WebElement chosenStaffDropDownMenu;

    @FindBy(xpath = "//section[@class='service-category']")
    private WebElement service;

    @FindBy(xpath = "//div[@class='cart-wrapper vertical-line-between-children']")
    public WebElement cardModal;

    public List<WebElement> get15minConsultationSection() {
        return service.findElements(
                By.xpath("//div[@class='panel service-variations responsive-padding']/div[3]"));
    }

    public WebElement get45minCurlingIronSubmitButton() {

        WebElement curlingSection =  service.findElement(
                By.xpath("//div[@class='panel service-variations responsive-padding']/div[6]"));

        return curlingSection.findElement(By.xpath("//button[@aria-label='Book Service Curling Iron']"));
    }

    public List<WebElement> get45minCurlingIronSection() {
        return service.findElements(
                By.xpath("//div[@class='panel service-variations responsive-padding']/div[6]"));
    }

    public List<WebElement> cartContent() {
        return cardModal.findElements(
                By.xpath("//li[@class='variation-item flex-row center-items']"));
    }

}
