package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    public WebElement homeBtn;

    @FindBy(xpath = "//a[contains(text(),'Contact')]")
    public WebElement contactBtn;

    @FindBy(xpath = "//a[contains(text(),'About us')]")
    public WebElement aboutUsBtn;

    @FindBy(id = "cartur")
    public WebElement cartBtn;

    @FindBy(id = "login2")
    public WebElement loginBtn;

    @FindBy(id = "signin2")
    public WebElement siginBtn;



}
