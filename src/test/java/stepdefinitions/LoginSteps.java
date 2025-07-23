package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;

    @Given("user is on the login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("user inputs valid username and password")
    public void userInputsCredentials() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
    }

    @And("user clicks login button")
    public void userClicksLogin() {
        loginPage.clickLogin();
    }

    @Then("user is redirected to the inventory page")
    public void userIsRedirectedToInventory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }
}