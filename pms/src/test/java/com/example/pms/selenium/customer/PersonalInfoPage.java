package com.example.pms.selenium.customer;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PersonalInfoPage {

    protected WebDriver driver;

    public PersonalInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "name")
    private WebElement name;
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(name = "phone")
    private WebElement phone;
    @FindBy(name = "street")
    private WebElement street;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "zip")
    private WebElement zip;

    @FindBy(name = "submitCustomer")
    private WebElement submitButton;

    public void open() {
        driver.get("http://localhost:3000/personalInfo");
    }

    public PaymentInfoPage clickNext(){
        submitButton.click();
        return new PaymentInfoPage(driver);
    }

    public void enterData(String name, String email, String phone, String street, String city, String zip){
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.zip.sendKeys(zip);
    }
}
