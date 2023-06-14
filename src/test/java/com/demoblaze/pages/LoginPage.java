package com.demoblaze.pages;

import com.demoblaze.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

@FindBy(id = "loginusername")
    public WebElement usernameInput;
@FindBy(id = "loginpassword")
    public WebElement passwordInput;
@FindBy(css = "[onclick=\"logIn()\"]")
    public WebElement submitBtn;


public void login(){

    String username= ConfigurationReader.get("username");
    String password= ConfigurationReader.get("password");
    loginBtn.click();
    usernameInput.sendKeys(username);
    passwordInput.sendKeys(password);
    submitBtn.click();
}
    public void login(String username,String password){

        loginBtn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitBtn.click();
    }
}
