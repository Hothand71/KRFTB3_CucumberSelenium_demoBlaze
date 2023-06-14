package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(id = "nameofuser")
    public WebElement welcomeUsername;

    public void verifyWelcomeMessage(){
        BrowserUtils.waitForVisibility(welcomeUsername,7);
        String actualMessage=welcomeUsername.getText();
        String expectedMessage="Welcome "+ ConfigurationReader.get("username");
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    public void verifyWelcomeMessage(String expectedMessage){
        BrowserUtils.waitForVisibility(welcomeUsername,7);
        String actualMessage=welcomeUsername.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
