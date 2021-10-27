package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.AppointmentPage;
import utils.TestUtils;

import java.util.List;

public class AppointmentTabSteps extends TestUtils {

    String serviceType;
    String serviceDuration;
    String price;

    @Then("user sees same location he chosen in first place")
    public void userSeesSameLocationHeChosenInFirstPlace() {
        AppointmentPage appointmentPage = new AppointmentPage();
        Assert.assertEquals(appointmentPage.leftHeaderLocation.getText(), "123 Somewhere");
    }

    @When("user filters by Service - Hair Styling")
    public void userFiltersByServiceHairStyling() {
        AppointmentPage appointmentPage = new AppointmentPage();
        jsClick(appointmentPage.serviceLeftMenu); // Hair Styling
    }

    @And("user filters by By Staff Member - Rajat")
    public void userFiltersByByStaffMemberRajat() {
        AppointmentPage appointmentPage = new AppointmentPage();
        jsClick(appointmentPage.staffMemberLeftMenu); // Rajat
    }

    @Then("Rajat is the staff selected in the staff dropdown from top right")
    public void rajatIsTheStaffSelectedInTheStaffDropdownFromTopRight() {
        AppointmentPage appointmentPage = new AppointmentPage();
        Assert.assertEquals("Rajat", appointmentPage.chosenStaffDropDownMenu.getText());
    }

    @And("Consultation has 15 min service duration and price between $12.10-$13.20")
    public void minConsultationServiceDurationPriceBetween() {
        AppointmentPage appointmentPage = new AppointmentPage();

        prepareServiceLineVars(appointmentPage.get15minConsultationSection());

        Assert.assertEquals("Consultation", serviceType);
        Assert.assertEquals("15 min", serviceDuration);
        Assert.assertEquals("$12.10-$13.20", price);
    }

    @Then("user press book button for service Curling Iron")
    public void userPressBookButtonForServiceCurlingIron() {
        AppointmentPage appointmentPage = new AppointmentPage();
        jsClick(appointmentPage.get45minCurlingIronSubmitButton());

        prepareServiceLineVars(appointmentPage.get45minCurlingIronSection());
    }

    private void prepareServiceLineVars(List<WebElement> values) {
        String rowValues = "";

        for (WebElement el : values)
        {
            rowValues = el.getText();
        }

        String[] rowValuesArray = rowValues.split("\n");
        this.serviceType = rowValuesArray[0];
        this.serviceDuration = rowValuesArray[1];
        this.price = rowValuesArray[2];
    }

    @And("variation modal is displayed")
    public void variationModalIsDisplayed() {
        AppointmentPage appointmentPage = new AppointmentPage();
        Assert.assertTrue(appointmentPage.cardModal.isDisplayed());
    }

    @And("Curling Iron price in cart modal is the same as in the services list")
    public void curlingIronPriceInCartModalIsTheSameAsInTheServicesList() {
        AppointmentPage appointmentPage = new AppointmentPage();
        String rowValues = "";
        rowValues = appointmentPage.cartContent().get(0).getText();
        String[] rowValuesArray = rowValues.split("\n");
        String serviceType = rowValuesArray[0];
        String price = rowValuesArray[1];

        Assert.assertEquals(this.serviceType, serviceType);
        Assert.assertEquals(this.price, price);
    }
}
