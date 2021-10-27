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




/*    @And("user enters valid e-mail or phone number")
    public void userEntersValidLogin() {
        LoginPage loginpage = new LoginPage();
        sendText(loginpage.emailInput, ConfigReader.getPropertyValue("username"));
    }

    @And("user clicks on Continue button")
    public void userClicksOnContinueButton() {
        LoginPage loginpage = new LoginPage();
        click(loginpage.continueButton);
    }

   @When("user enters correct password")
    public void userEnterCorrectPassword() {
       LoginPage loginpage = new LoginPage();
       sendText(loginpage.passwordInput, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        LoginPage loginpage = new LoginPage();
        click(loginpage.signInButton);
    }

    @When("user is successfully logged in")
    public void userSuccessuflyLoggedIn() {
        PickLocation mainPage = new PickLocation();
        Assert.assertFalse(mainPage.loginNavigationPanel.getText().contains("Hello, Sign in"));
    }*/

/*    @When("user logged in the system")
    public void userLoggedInSystem() {
        userGoesToALoginPage();
        userEntersValidLogin();
        userClicksOnContinueButton();
        userEnterCorrectPassword();
        userClicksOnLoginButton();
    }*/
}
