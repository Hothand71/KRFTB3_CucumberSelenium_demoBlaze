package com.demoblaze.step_defs;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.Map;

public class Login_StepDefs {
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
    @Given("The User is on the Login Page")
    public void the_User_is_on_the_Login_Page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("The user is enter valid credentials")
    public void the_user_is_enter_valid_credentials() {
        loginPage.login();
        }

    @Then("The user verify that Welcome username is displayed")
    public void the_user_verify_that_Welcome_username_is_displayed() {
    homePage.verifyWelcomeMessage();
    }

    @When("The user is enters with {string} and {string} credentials")
    public void the_user_is_enters_with_and_credentials(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("The user verify that {string} is displayed")
    public void the_user_verify_that_is_displayed(String expectedMessage) {
      homePage.verifyWelcomeMessage(expectedMessage);
    }

    @When("The user is enters valid username and password credentials")
    public void the_user_is_enters_valid_username_and_password_credentials(Map<String,String> userInfo) {
        loginPage.login(userInfo.get("username"),userInfo.get("password"));
    }

    @Then("The user verify that should be invalid credentials {string}")
    public void theUserVerifyThatShouldBeInvalidCredentials(String expectedMessage) {
        BrowserUtils.waitFor(1);
        Alert alert=Driver.get().switchTo().alert();
        String actualMessage = alert.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);

    }
}
