package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PickLocationPage;
import utils.TestUtils;

public class PickLocationStep extends TestUtils {

    @When("user clicks on a location filter bar")
    public void userClicksOnALocationFilterBar() {
        PickLocationPage pickLocationPage = new PickLocationPage();
        click(pickLocationPage.searchBar);
    }

    @And("user enters required location")
    public void userEntersRequiredLocation() {
        PickLocationPage pickLocationPage = new PickLocationPage();
        sendText(pickLocationPage.searchBar, "123");
    }

    @Then("user sees required location")
    public void userSeesRequiredLocation() {
        PickLocationPage pickLocationPage = new PickLocationPage();
        Assert.assertEquals("123 Somewhere", pickLocationPage.searchResult.getText());
    }

    @When("user go to appointment page via search filter")
    public void userGoToAppointmentPageViaSearchFilter() {
        PickLocationPage pickLocationPage = new PickLocationPage();
        userClicksOnALocationFilterBar();
        userEntersRequiredLocation();
        userSeesRequiredLocation();
        click(pickLocationPage.searchResult);
    }
}
